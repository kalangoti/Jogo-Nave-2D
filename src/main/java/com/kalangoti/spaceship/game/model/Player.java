package com.kalangoti.spaceship.game.model;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Player {
    private int x;
    private int y;
    private int axisX;
    private int axisY;
    private Image spaceshipImage;
    private int height;
    private int width;

    public Player() {
        this.x = 100;
        this.y = 100;
    }

    public void load() {
        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\spaceship.png");
        spaceshipImage = reference.getImage();
        height = spaceshipImage.getHeight(null);
        width = spaceshipImage.getWidth(null);
    }

    public void update() {
        x += axisX;
        y += axisY;
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_UP) {
            axisY = -3;
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            axisY = 3;
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            axisX = -3;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            axisX = 3;
        }
    }

    public void keyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
            axisY = 0;
        }

        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            axisX = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getSpaceshipImage() {
        return spaceshipImage;
    }
}
