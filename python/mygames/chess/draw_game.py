import pygame
from mai


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