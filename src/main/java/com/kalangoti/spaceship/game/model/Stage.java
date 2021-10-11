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
import java.util.List;

public class Stage extends JPanel implements ActionListener {
    private final transient Image gameBackground;
    private final transient Player player;

    public Stage() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\black-background.jpg");
        gameBackground = reference.getImage();

        player = new Player();

        addKeyListener(new KeyboardAdapter(player));

        Timer timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void paint(Graphics graph) {
        Graphics2D graph2D = (Graphics2D) graph;
        graph2D.drawImage(gameBackground, 0, 0, null);

        graph2D.drawImage(player.getSpaceshipImage(), player.getX(), player.getY(), this);

        for (Shot shot : player.getShots()) {
            graph2D.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }

        graph2D.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        player.update();

        List<Shot> shots = player.getShots();
        for (int i = 0; i < shots.size(); i++) {
            Shot shot = shots.get(i);
            if (shot.isVisible()) {
                shot.update();
            } else {
                shots.remove(shot);
            }
        }

        repaint();
    }

    protected Image getGameBackground() {
        return this.gameBackground;
    }
}
