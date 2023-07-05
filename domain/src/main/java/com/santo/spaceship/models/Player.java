package com.santo.spaceship.models;

public abstract class Player<T> {

    private int x;

    private int y;

    private int axisX;

    private int axisY;

    private int height;

    private int width;

    private T shipImage;

    public abstract void initialize(byte[] imageFile);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public T getShipImage() {
        return shipImage;
    }

    public void setShipImage(T shipImage) {
        this.shipImage = shipImage;
    }

}
