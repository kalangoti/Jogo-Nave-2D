package com.kalangoti.spaceship.game;

import com.kalangoti.spaceship.game.model.Container;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("When initialize the Container")
class ContainerTest {
    private final Container container = new Container();

    @Test
    @DisplayName("It should return the size of 1024x728")
    void testContainerSize() {
        assertEquals(new Dimension(1024, 728), container.getSize());
    }
}
