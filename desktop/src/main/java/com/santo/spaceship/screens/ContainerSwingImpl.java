package com.santo.spaceship.screens;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.IOException;

@Named
public class ContainerSwingImpl extends JFrame implements Container {

    @Inject
    private Stage stage;

    @Override
    public void initialize(String title, int width, int height) throws IOException {
        add(stage.initialize());
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void showScreen() {
        setVisible(true);
        stage.showScreen();
    }

    @Override
    public void hideScreen() {
        setVisible(false);
        stage.hideScreen();
    }

}
