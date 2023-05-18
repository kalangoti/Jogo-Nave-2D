package com.santo.spaceship.screens;

import javax.swing.JComponent;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Stage {

    JComponent initialize() throws IOException;

}
