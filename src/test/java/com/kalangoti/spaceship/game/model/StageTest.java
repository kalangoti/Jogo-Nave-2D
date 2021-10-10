package com.kalangoti.spaceship.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.ImageIcon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("When initialize the Stage")
class StageTest {
    private final Stage stage = new Stage();
    private final ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\black-background.jpg");

    @Test
    @DisplayName("It should return the game background image")
    void testWithGameBackground() {
        assertEquals(stage.getGameBackground(), reference.getImage());
    }

    @Test
    @DisplayName("With wrong reference, it should not return the background image")
    void testWithoutGameBackground() {
        ImageIcon newReference = new ImageIcon("resources\\img\\black-background.jpg");

        assertNotEquals(stage.getGameBackground(), newReference.getImage());
    }
}
