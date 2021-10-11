package com.kalangoti.spaceship.game.model;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x;
    private int y;
    private int axisX;
    private int axisY;
    private Image spaceshipImage;
    private int height;
    private int width;
    private final List<Shot> shots;

    public Player() {
        this.x = 100;
        this.y = 100;
        shots = new ArrayList<>();
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void simpleShot() {
        Shot newShot = new Shot(x + width, y + (height / 2));
        if (!checkCollisions(newShot)) {
            this.shots.add(newShot);
        }
    }

    public boolean checkCollisions(Shot newShot) {
        Rectangle shotBounds;

        for (Shot shot : shots) {
            shotBounds = shot.getBounds();

            if (shotBounds.intersects(newShot.getBounds())) {
                return true;
            }
        }

        return false;
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            simpleShot();
        }

        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            axisY = -3;
        }

        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            axisY = 3;
        }

        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            axisX = -3;
        }

        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            axisX = 3;
        }
    }

    public void keyReleased(int keyCode) {
        if (keyCode == KeyEvent.VK_UP ||
                keyCode == KeyEvent.VK_DOWN ||
                keyCode == KeyEvent.VK_W ||
                keyCode == KeyEvent.VK_S) {
            axisY = 0;
        }

        if (keyCode == KeyEvent.VK_LEFT ||
                keyCode == KeyEvent.VK_RIGHT ||
                keyCode == KeyEvent.VK_A ||
                keyCode == KeyEvent.VK_D) {
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

    public List<Shot> getShots() {
        return shots;
    }
}
