package com.santo.spaceship.models;

import javax.inject.Named;
import javax.swing.ImageIcon;
import java.awt.Image;

@Named
public class PlayerSwing extends Player<Image> {

    private Image shipImage;

    @Override
    public void initialize(byte[] imageFile) {
        ImageIcon reference = new ImageIcon(imageFile, "Spaceship");
        setShipImage(reference.getImage());

        setHeight(getShipImage().getHeight(null));
        setWidth(getShipImage().getWidth(null));
    }

    @Override
    public Image getShipImage() {
        return shipImage;
    }

    @Override
    public void setShipImage(Image shipImage) {
        this.shipImage = shipImage;
    }

}
