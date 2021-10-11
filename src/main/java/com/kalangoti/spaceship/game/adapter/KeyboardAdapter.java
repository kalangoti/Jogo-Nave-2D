package com.kalangoti.spaceship.game.adapter;

import com.kalangoti.spaceship.game.model.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAdapter extends KeyAdapter {
    private final Player player;

    public KeyboardAdapter(Player player) {
        super();
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        player.keyPressed(event.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent event) {
        player.keyReleased(event.getKeyCode());
    }
}
