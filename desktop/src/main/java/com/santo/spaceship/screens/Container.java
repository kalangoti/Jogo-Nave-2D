package com.santo.spaceship.screens;

import java.io.IOException;

public interface Container {

    void initialize() throws IOException;

    void showScreen();

    void hideScreen();

}
