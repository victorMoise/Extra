import pygame
from display import screen_width, screen_height


pygame.font.init()

COLOR = (0, 0, 0)
font = pygame.font.Font('freesansbold.ttf', 32)


def display_time_played(start, screen):
    current_time = pygame.time.get_ticks()
    text = "Time played: " + str((current_time - start) / 1000)
    time = font.render(text, True, COLOR)
    screen.blit(time, (0.05 * screen_width, 0.0325 * screen_height))