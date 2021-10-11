package com.kalangoti.spaceship.game.model;

import com.kalangoti.spaceship.game.adapter.KeyboardAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stage extends JPanel implements ActionListener {
    private final transient Image gameBackground;
    private final transient Player player;
    private final Timer timer;

    public Stage() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\black-background.jpg");
        gameBackground = reference.getImage();

        player = new Player();
        player.load();

        addKeyListener(new KeyboardAdapter(player));

        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paint(Graphics graph) {
        Graphics2D graph2D = (Graphics2D) graph;
        graph2D.drawImage(gameBackground, 0, 0, null);
        graph2D.drawImage(player.getSpaceshipImage(), player.getX(), player.getY(), this);
        graph2D.dispose();
    }

    public Image getGameBackground() {
        return this.gameBackground;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        repaint();
    }
}
