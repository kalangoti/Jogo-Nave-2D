package com.santo.spaceship.screens;

import java.io.IOException;

public interface Container {

    void initialize(String title, int width, int height) throws IOException;

    void showScreen();

    void hideScreen();

}
