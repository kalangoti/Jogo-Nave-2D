package com.kalangoti.spaceship.game.model;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Container extends JFrame {
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 728;

    public Container() {
        add(new Stage());
        setTitle("Meu Jogo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
