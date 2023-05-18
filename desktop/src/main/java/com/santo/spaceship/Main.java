package com.santo.spaceship;

import com.santo.spaceship.configs.Build;
import com.santo.spaceship.screens.Container;
import com.santo.spaceship.screens.impl.ContainerSwingImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    private static final ApplicationContext spring = new AnnotationConfigApplicationContext(Build.class);

    private static final Container frame = spring.getBean(ContainerSwingImpl.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            frame.initialize();
            frame.showScreen();
        } catch (Exception exception) {
            showMessageDialog(null,
                    "Message error: " + exception.getMessage(),
                    "Error...", ERROR_MESSAGE);
        }
    }
}
