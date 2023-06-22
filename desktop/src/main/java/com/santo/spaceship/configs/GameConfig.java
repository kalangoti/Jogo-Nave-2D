package com.santo.spaceship.configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class GameConfig {

    public static final int WIDTH = 1024;

    public static final int HEIGHT = 728;

    public static final int PLAYER_SPEED = 3;

    private GameConfig() {
        throw new IllegalStateException("Utility class");
    }

    public static byte[] loadFile(String fileName) throws IOException {
        InputStream inputStream = GameConfig.class.getClassLoader().getResourceAsStream(fileName);

        if (Objects.isNull(inputStream)) {
            throw new IllegalArgumentException("File '" + fileName + "' not found");
        }

        return inputStream.readAllBytes();
    }

}
