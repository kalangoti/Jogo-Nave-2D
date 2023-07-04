package com.santo.spaceship;

import com.santo.spaceship.configs.Build;
import com.santo.spaceship.configs.GameConfig;
import com.santo.spaceship.screens.Container;
import com.santo.spaceship.screens.ContainerSwingImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    private static final ApplicationContext spring = new AnnotationConfigApplicationContext(Build.class);

    private static final Container frame = spring.getBean(ContainerSwingImpl.class);

    public static void main(String[] args) {
        try {
            frame.initialize("Santo Spaceship Game", GameConfig.WIDTH, GameConfig.HEIGHT);
            frame.showScreen();
        } catch (Exception exception) {
            showMessageDialog(null,
                    "Message error: " + exception.getMessage(),
                    "Error...", ERROR_MESSAGE);
        }
    }
}
