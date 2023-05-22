
# definitions for the sprites

import pygame
from display import screen_height, screen_width

pygame.init()


class Player(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = pygame.transform.scale(pygame.image.load("images/player.png"), (92, 69))
        self.rect = self.image.get_rect()
        self.rect.centerx = 0.1 * screen_width
        self.rect.centery = screen_height / 2
        self.jump = pygame.mixer.Sound("sounds/wings.mp3")
        self.scored_point = pygame.mixer.Sound("sounds/point.mp3")

    def play_jump_sound(self):
        pygame.mixer.Sound.play(self.jump)

    def play_point_scored_sound(self):
        pygame.mixer.Sound.play(self.scored_point)


def draw_update_sprite_group(group, screen):
    group.draw(screen)
    group.update()


