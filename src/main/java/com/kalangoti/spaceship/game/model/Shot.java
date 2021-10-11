package com.kalangoti.spaceship.game.model;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Rectangle;

public class Shot {
    private Image image;
    private int x;
    private final int y;
    private int height;
    private int width;
    private boolean visible;

    private int speed = 2;
    private int maxWidth;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true;

        load();
    }

    private void load() {
        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\simple-shot.png");
        image = reference.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);

        maxWidth = Container.WIDTH - (width * 2);
    }

    public void update() {
        this.x += speed;
        if (this.x >= maxWidth) {
            setVisible(false);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }
}
