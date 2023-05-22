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
    
    return True
                        
            
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
                        starting_board[cell_row][cell_col] = selected_piece
                        starting_board[selected_piece_position[0]][selected_piece_position[1]] = " "
                        selected_piece_position = None
                        selected_piece = None
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
                        starting_board[cell_row][cell_col] = selected_piece
                        starting_board[selected_piece_position[0]][selected_piece_position[1]] = " "
                        selected_piece_position = None
                        selected_piece = None
                        player = 1
            
            print(cell_row, cell_col)

    draw_board()
    draw_pieces()
    pygame.display.update()
