import pygame
from display import screen_width, screen_height


pygame.font.init()

COLOR = (0, 0, 0)
font = pygame.font.Font('freesansbold.ttf', 32)


def display_score(score_value, screen):
    text_score = "Score: " + str(score_value)
    score = font.render(text_score, True, COLOR)
    score_rect = score.get_rect(center=(screen_width / 2, 0.05 * screen_height))
    screen.blit(score, score_rect)