package com.kalangoti.spaceship.game.model;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Stage extends JPanel {
    private final transient Image gameBackground;

    public Stage() {
        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\black-background.jpg");
        gameBackground = reference.getImage();
    }

    @Override
    public void paint(Graphics graph) {
        Graphics2D graph2D = (Graphics2D) graph;
        graph2D.drawImage(gameBackground, 0, 0, null);
        graph2D.dispose();
        getBackground();
    }

    public Image getGameBackground() {
        return this.gameBackground;
    }
}
