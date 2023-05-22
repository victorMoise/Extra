
# functions related to the display window

import pygame
import math


screen_height = 880;
screen_width = 1280;
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption('Flappy Bird')
screen_background = pygame.image.load("images/background.png").convert()
background_width = screen_background.get_width()
tiles = math.ceil(screen_width / background_width) + 1


def screen_create():
    return screen


def screen_draw_background(scroll_speed):
    for i in range(0, tiles):
        screen.blit(screen_background, (i * background_width + scroll_speed, 0))


def controll_scroll(scroll):
    scroll -= 5
    if abs(scroll) > screen_width:
        scroll = 0  
    return scroll


def screen_update():
    pygame.display.update();