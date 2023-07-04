package com.santo.spaceship.screens;

import com.santo.spaceship.configs.GameConfig;

import javax.inject.Named;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

@Named
public class StageSwingImpl extends JPanel implements Stage {

    private static final String IMAGE_NAME = "background.jpg";

    private transient Image gameBackground;

    @Override
    public JComponent initialize() throws IOException {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon reference = new ImageIcon(GameConfig.loadFile(IMAGE_NAME), "Background");
        gameBackground = reference.getImage();

        return this;
    }

    @Override
    public void paint(Graphics graph) {
        Graphics2D graph2D = (Graphics2D) graph;

        graph2D.drawImage(gameBackground, 0, 0, null);

        graph2D.dispose();
    }

    protected Image getGameBackground() {
        return this.gameBackground;
    }

    @Override
    public void showScreen() {
        setVisible(true);
    }

    @Override
    public void hideScreen() {
        setVisible(false);
    }


}
