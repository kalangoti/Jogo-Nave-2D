package com.kalangoti.spaceship.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When initialize the Player")
class PlayerTest {
    private final Player player = new Player();
    private final ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\spaceship.png");
    private final int speed = player.getSpeed();

    @Test
    @DisplayName("It should return the Spaceship image")
    void testWithSpaceshipImage() {
        assertEquals(reference.getImage(), player.getSpaceshipImage());
        assertEquals(reference.getImage().getWidth(null), player.getWidth());
        assertEquals(reference.getImage().getHeight(null), player.getHeight());
        assertEquals(100, player.getX());
        assertEquals(100, player.getY());
        assertTrue(player.getGunshots().isEmpty());
    }

    @Test
    @DisplayName("With wrong reference, it should not return the Spaceship image")
    void testWithoutSpaceshipImage() {
        ImageIcon newReference = new ImageIcon("resources\\img\\spaceship.png");

        assertNotEquals(newReference.getImage(), player.getSpaceshipImage());
    }

    @Test
    @DisplayName("With the up key pressed, it should move on the stage panel")
    void testPlayerWithUpKeyPressed() {
        player.keyPressed(KeyEvent.VK_UP);
        player.update();

        assertEquals(100 - speed, player.getY());

        player.keyPressed(KeyEvent.VK_W);
        player.update();

        assertEquals(100 - (speed * 2), player.getY());
        assertEquals(100, player.getX());
    }

    @Test
    @DisplayName("With the down key pressed, it should move on the stage panel")
    void testPlayerWithDownKeyPressed() {
        player.keyPressed(KeyEvent.VK_DOWN);
        player.update();

        assertEquals(100 + speed, player.getY());

        player.keyPressed(KeyEvent.VK_S);
        player.update();

        assertEquals(100 + (speed * 2), player.getY());
        assertEquals(100, player.getX());
    }

    @Test
    @DisplayName("With the left key pressed, it should move on the stage panel")
    void testPlayerWithLeftKeyPressed() {
        player.keyPressed(KeyEvent.VK_LEFT);
        player.update();

        assertEquals(100 - speed, player.getX());

        player.keyPressed(KeyEvent.VK_A);
        player.update();

        assertEquals(100 - (speed * 2), player.getX());
        assertEquals(100, player.getY());
    }

    @Test
    @DisplayName("With the right key pressed, it should move on the stage panel")
    void testPlayerWithRightKeyPressed() {
        player.keyPressed(KeyEvent.VK_RIGHT);
        player.update();

        assertEquals(100 + speed, player.getX());

        player.keyPressed(KeyEvent.VK_D);
        player.update();

        assertEquals(100 + (speed * 2), player.getX());
        assertEquals(100, player.getY());
    }

    @Test
    @DisplayName("With the key released, it should not move on the stage panel")
    void testPlayerWithKeyReleased() {
        player.keyReleased(KeyEvent.VK_UP);
        player.keyReleased(KeyEvent.VK_W);
        player.update();

        assertEquals(100, player.getX());
        assertEquals(100, player.getY());

        player.keyReleased(KeyEvent.VK_DOWN);
        player.keyReleased(KeyEvent.VK_S);
        player.update();

        assertEquals(100, player.getX());
        assertEquals(100, player.getY());

        player.keyReleased(KeyEvent.VK_LEFT);
        player.keyReleased(KeyEvent.VK_A);
        player.update();

        assertEquals(100, player.getX());
        assertEquals(100, player.getY());

        player.keyReleased(KeyEvent.VK_RIGHT);
        player.keyReleased(KeyEvent.VK_D);
        player.update();

        assertEquals(100, player.getX());
        assertEquals(100, player.getY());
    }

    @Test
    @DisplayName("With check for gunshot collisions, it should not add new gunshot")
    void testPlayerWithCheckCollisionsGunshot() {
        player.keyPressed(KeyEvent.VK_SPACE);
        player.getGunshots().get(0).update();

        assertEquals(1, player.getGunshots().size());

        player.keyPressed(KeyEvent.VK_SPACE);
        player.getGunshots().get(0).update();

        assertEquals(1, player.getGunshots().size());

        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();
        player.getGunshots().get(0).update();

        player.keyPressed(KeyEvent.VK_SPACE);

        assertEquals(2, player.getGunshots().size());
    }
}
