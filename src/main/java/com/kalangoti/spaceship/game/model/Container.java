package com.kalangoti.spaceship.game.model;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Container extends JFrame {
    public Container() {
        add(new Stage());
        setTitle("Meu Jogo");
        setSize(1024, 728);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
//        pack();
    }
}
