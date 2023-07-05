package com.santo.spaceship.screens;

import java.io.IOException;

public interface Stage<T> {

    void initialize() throws IOException;

    void showScreen();

    void hideScreen();

    T getComponent();

}
