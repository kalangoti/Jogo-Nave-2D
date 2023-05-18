package com.santo.spaceship.screens.impl;

import com.santo.spaceship.configs.GameConfig;
import com.santo.spaceship.screens.Container;
import com.santo.spaceship.screens.Stage;

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
    public void initialize() throws IOException {
        add(stage.initialize());
        setTitle("Meu Jogo");
        setSize(GameConfig.WIDTH, GameConfig.HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
