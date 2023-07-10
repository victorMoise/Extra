import pygame
import pieces
import clock
import check_interrupt

pygame.init()

WIDTH, HEIGHT = 800, 800
BOARD_SIZE = 8
SQUARE_SIZE = HEIGHT // BOARD_SIZE
FPS = 60

WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
LIGHT_SQUARE = (240, 217, 181)
DARK_SQUARE = (181, 136, 99)

screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Chess Game")

moves = []
starting_board = [
    ["r", "n", "b", "q", "k", "b", "n", "r"],
    ["p", "p", "p", "p", "p", "p", "p", "p"],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    [" ", " ", " ", " ", " ", " ", " ", " "],
    ["P", "P", "P", "P", "P", "P", "P", "P"],
    ["R", "N", "B", "Q", "K", "B", "N", "R"]
]

game_over = False
player = 1
selected_piece = None
selected_piece_position = None


def draw_board():
    for row in range(BOARD_SIZE):
        for col in range(BOARD_SIZE):
            square_color = LIGHT_SQUARE if (row + col) % 2 == 0 else DARK_SQUARE
            pygame.draw.rect(screen, square_color, (col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE))


def draw_pieces():
    for row in range(BOARD_SIZE):
        for col in range(BOARD_SIZE):
            piece = starting_board[row][col]
            if piece != " ":
                match piece:
                    case "p":
                        piece_image = pieces.black_pawn
                    case "P":
                        piece_image = pieces.white_pawn
                    case "n":
                        piece_image = pieces.black_knight
                    case "N":
                        piece_image = pieces.white_knight
                    case "b":
                        piece_image = pieces.black_bishop
                    case "B":
                        piece_image = pieces.white_bishop
                    case "r":
                        piece_image = pieces.black_rook
                    case "R":
                        piece_image = pieces.white_rook
                    case "q":
                        piece_image = pieces.black_queen
                    case "Q":
                        piece_image = pieces.white_queen
                    case "k":
                        piece_image = pieces.black_king
                    case "K":
                        piece_image = pieces.white_king

                piece_image = pygame.transform.scale(piece_image, (SQUARE_SIZE, SQUARE_SIZE))
                screen.blit(piece_image, (col * SQUARE_SIZE, row * SQUARE_SIZE))


def valid_bishop_move(src_row, src_col, dest_row, dest_col):
    if abs(dest_row - src_row) == abs(dest_col - src_col):
        # Check if there are any obstructions along the diagonal path
        row_step = 1 if dest_row > src_row else -1
        col_step = 1 if dest_col > src_col else -1
            
        current_row = src_row + row_step
        current_col = src_col + col_step
            
        while current_row != dest_row and current_col != dest_col:
            # Check if there is a piece at each position along the diagonal path
            if starting_board[current_row][current_col] != " ":
                return False  # Bishop's path is obstructed
            current_row += row_step
            current_col += col_step
            
        return True  # Valid bishop move
            
    else:
        return False  # Invalid bishop move


def valid_rook_move(src_row, src_col, dest_row, dest_col):
    if src_row == dest_row:
        # check if there are any obstructions along the horizontal path
        col_step = 1 if dest_col > src_col else -1
        current_col = src_col + col_step
        
        while current_col != dest_col:
            # check if there is a piece at each position along the horizontal path
            if starting_board[src_row][current_col] != " ":
                return False  # rook's path is obstructed
            current_col += col_step
            
        return True  # valid rook move
    
    elif src_col == dest_col:
        # vheck if there are any obstructions along the vertical path
        row_step = 1 if dest_row > src_row else -1
        current_row = src_row + row_step
        
        while current_row != dest_row:
            # vheck if there is a piece at each position along the vertical path
            if starting_board[current_row][src_col] != " ":
                return False  # rook's path is obstructed
            current_row += row_step
            
        return True  # valid rook move
    
    else:
        return False  # invalid rook move


def valid_king_move(player, src_row, src_col, dest_row, dest_col):
    row_diff = abs(dest_row - src_row)
    col_diff = abs(dest_col - src_col)
    castle_direction = "right" if dest_col > src_col else "left"
    incremenent = 7 if player == 1 else 0

    # check castles and move the rook
    if col_diff == 2 and row_diff == 0:
        for move in moves:
            if move[0] == "K" and player == 1:
                return False
            if move[0] == "k" and player == 2:
                return False
            
            if castle_direction == "right":
                if move[0] == "R" and move[1] == "g" and move[2] == "7":
                    return False
                if starting_board[incremenent][6] == " " and starting_board[incremenent][5] == " ":
                    starting_board[incremenent][7] = " "
                    starting_board[incremenent][5] = "R" if player == 1 else "r"
                    return True
                
                return False
                
            if castle_direction == "left":
                if move[0] == "R" and move[1] == "a" and move[2] == "7":
                    return False
                if starting_board[incremenent][1] == " " and starting_board[incremenent][2] == " " and starting_board[incremenent][3] == " ":
                    starting_board[incremenent][0] = " "
                    starting_board[incremenent][3] = "R" if player == 1 else "r"
                    return True
                return False
            
    if row_diff <= 1 and col_diff <= 1:
        return True  # valid king move
    else:
        return False  # invalid king move


def check_move(player, piece, src_row, src_col, dest_row, dest_col):
    # check pawn move
    if piece == "P" or piece == "p":
        if player == 1:
            if src_col == dest_col:
                # first move can be 2 squares
                if src_row == 6:
                    if src_row - dest_row == 2: 
                        return starting_board[src_row - 1][src_col] == " " and starting_board[src_row - 2][src_col] == " "
                    if src_row - dest_row == 1:
                        return starting_board[src_row - 1][src_col] == " "
                    if src_row - dest_row > 2:
                        return False
                else:
                    if src_row - dest_row == 1:
                        return starting_board[src_row - 1][src_col] == " "
                    else:
                        return False
            elif src_row - dest_row == 1:
                return starting_board[dest_row][dest_col] != " "
            else:
                return False
            
        if player == 2:
            if src_col == dest_col:
                # first move can be 2 squares
                if src_row == 1:
                    if dest_row - src_row == 2:
                        return starting_board[src_row + 1][src_col] == " " and starting_board[src_row + 1][src_col] == " "
                    if dest_row - src_row == 1:
                        return starting_board[src_row + 1][src_col] == " "
                    if dest_row - src_row > 2:
                        return False
                else:
                    if dest_row - src_row == 1:
                        return starting_board[src_row + 1][src_col] == " "
                    else:
                        return False
            elif dest_row - src_row == 1:
                return starting_board[dest_row][dest_col] != " "
            else:
                return False
    
    # check knight move
    if piece == "N" or piece == "n":
        return ((dest_row == src_row - 2 and dest_col == src_col - 1) or
                (dest_row == src_row - 2 and dest_col == src_col + 1) or
                (dest_row == src_row - 1 and dest_col == src_col + 2) or
                (dest_row == src_row + 1 and dest_col == src_col + 2) or
                (dest_row == src_row + 2 and dest_col == src_col + 1) or
                (dest_row == src_row + 2 and dest_col == src_col - 1) or
                (dest_row == src_row + 1 and dest_col == src_col - 2) or
                (dest_row == src_row - 1 and dest_col == src_col - 2))
    
    # check bishop move
    if piece == "B" or piece == "b":
        # check if the number of rows moved is equal to the number of columns moved (diagonal move)
        return valid_bishop_move(src_row, src_col, dest_row, dest_col)
    
    # check rook move
    if piece == "r" or piece == "R":
        return valid_rook_move(src_row, src_col, dest_row, dest_col)

    # check queen move (moves like a rook or bishop)
    if piece == "q" or piece == "Q":
        return valid_bishop_move(src_row, src_col, dest_row, dest_col) or valid_rook_move(src_row, src_col, dest_row, dest_col)

    # check king move and move the rook if castles
    if piece == "k" or piece == "K":
        return valid_king_move(player, src_row, src_col, dest_row, dest_col)


def construct_move(piece, src_row, src_col, dest_row, dest_col):
    if piece == "K" or piece == "k":
        if abs(src_col - dest_col) == 2 and src_row - dest_row == 0:
            return "O-O" if dest_col > src_col else "O-O-O"
    move = piece + chr(src_col + 97) + str(src_row) + chr(dest_col + 97) + str(dest_row)
    return move
            
            
# main game loop
while not game_over:
    clock.set_fps(FPS)

    for event in pygame.event.get():
        check_interrupt.check_user_interrupt(event)

        if event.type == pygame.MOUSEBUTTONDOWN and event.button == 1:
            mouse_position = pygame.mouse.get_pos()
            cell_col = mouse_position[0] // SQUARE_SIZE
            cell_row = mouse_position[1] // SQUARE_SIZE

            # white pieces
            if player == 1:
                if selected_piece == None:
                    if starting_board[cell_row][cell_col].isupper() and starting_board[cell_row][cell_col] != " ":
                        selected_piece = starting_board[cell_row][cell_col]
                        selected_piece_position = (cell_row, cell_col)
                else:
                    # deselect the piece
                    if (cell_row, cell_col) == selected_piece_position:
                        selected_piece_position = None
                        selected_piece = None
                    # select another piece
                    elif starting_board[cell_row][cell_col].isupper():
                        selected_piece = starting_board[cell_row][cell_col]
                        selected_piece_position = (cell_row, cell_col)
                    # move the piece
                    elif check_move(player, selected_piece, selected_piece_position[0], selected_piece_position[1], cell_row, cell_col):
                        # append move to the list
                        moves.append(construct_move(selected_piece, selected_piece_position[0], 
                                                    selected_piece_position[1], cell_row, cell_col))
                        # move the piece
                        starting_board[cell_row][cell_col] = selected_piece
                        starting_board[selected_piece_position[0]][selected_piece_position[1]] = " "
                        selected_piece_position = None
                        selected_piece = None
                        # change the player
                        player = 2
                        
            # black pieces
            else:
                if selected_piece == None:
                    if starting_board[cell_row][cell_col].islower() and starting_board[cell_row][cell_col] != " ":
                        selected_piece = starting_board[cell_row][cell_col]
                        selected_piece_position = (cell_row, cell_col)
                else:
                    # deselect the piece
                    if (cell_row, cell_col) == selected_piece_position:
                        selected_piece_position = None
                        selected_piece = None
                    # select another piece
                    elif starting_board[cell_row][cell_col].islower():
                        selected_piece = starting_board[cell_row][cell_col]
                        selected_piece_position = (cell_row, cell_col)
                    # move the piece
                    elif check_move(player, selected_piece, selected_piece_position[0], selected_piece_position[1], cell_row, cell_col):
                        # append move to the list
                        moves.append(construct_move(selected_piece, selected_piece_position[0], 
                                                    selected_piece_position[1], cell_row, cell_col))
                        # move the piece
                        starting_board[cell_row][cell_col] = selected_piece
                        starting_board[selected_piece_position[0]][selected_piece_position[1]] = " "
                        selected_piece_position = None
                        selected_piece = None
                        # change the player
                        player = 1
                        
            print(moves)
            # print(cell_row, cell_col)

    draw_board()
    draw_pieces()
    pygame.display.update()
