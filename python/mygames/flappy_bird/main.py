import pygame
from display import screen_update, screen_create, screen_draw_background, controll_scroll
from user_interrupt import check_user_interrupt
from clock import set_fps
from player import Player, draw_update_sprite_group
from score import display_score
from time_played import display_time_played


def main():

    # player sprite definition
    player_sprite = pygame.sprite.Group()
    player = Player()
    player_sprite.add(player)

    # all main variables 
    start = False
    start_time = 0
    gameOver = False
    scroll = 0
    score = 0
    screen = screen_create()

    while not gameOver:
        set_fps()

        screen_draw_background(scroll)

        display_score(score, screen)
        if start:
            display_time_played(start_time, screen)

        for event in pygame.event.get():
            check_user_interrupt(event)

            # check for key pressed
            if event.type == pygame.KEYDOWN:

                # determine when the game starts
                if event.key == pygame.K_SPACE and start == False:
                    start_time = pygame.time.get_ticks()
                    start = True
                
                # check for and play jump sound
                if event.key == pygame.K_SPACE:
                    player.play_jump_sound()


        if start:
            scroll = controll_scroll(scroll)
        
        draw_update_sprite_group(player_sprite, screen)

        screen_update()



if __name__ == "__main__":
    main()