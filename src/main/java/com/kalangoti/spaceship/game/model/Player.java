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
    private final List<Gunshot> gunshots;
    private boolean visible;

    private static final int SPEED = 3;

    public Player() {
        this.x = 100;
        this.y = 100;
        this.visible =true;
        this.gunshots = new ArrayList<>();

        load();
    }

    private void load() {
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

    private void simpleGunshot() {
        Gunshot newGunshot = new Gunshot(x + width, y + (height / 2));
        if (!checkCollisions(newGunshot)) {
            this.gunshots.add(newGunshot);
        }
    }

    private boolean checkCollisions(Gunshot newGunshot) {
        Rectangle gunshotBounds;

        for (Gunshot gunshot : gunshots) {
            gunshotBounds = gunshot.getBounds();

            if (gunshotBounds.intersects(newGunshot.getBounds())) {
                return true;
            }
        }

        return false;
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE) {
            simpleGunshot();
        }

        if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            axisY = -SPEED;
        }

        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
            axisY = SPEED;
        }

        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            axisX = -SPEED;
        }

        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            axisX = SPEED;
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

    public List<Gunshot> getGunshots() {
        return gunshots;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeed() {
        return SPEED;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
