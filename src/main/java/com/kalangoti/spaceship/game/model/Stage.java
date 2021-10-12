package com.kalangoti.spaceship.game.model;

import com.kalangoti.spaceship.game.adapter.KeyboardAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stage extends JPanel implements ActionListener {
    private final transient Image gameBackground;
    private final transient Player player;
    private transient List<Enemy1> enemies1;
    private int maxEnemies = 40;
    private final Random random = new Random();
    private boolean gameOn;

    public Stage() {
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon reference = new ImageIcon("src\\main\\resources\\img\\black-background.jpg");
        gameBackground = reference.getImage();

        player = new Player();

        addKeyListener(new KeyboardAdapter(player));

        Timer timer = new Timer(5, this);
        timer.start();

        initializeEnemies();
        gameOn = true;
    }

    public void initializeEnemies() {
        enemies1 = new ArrayList<>();
        int enemyX;
        int enemyY;

        for (int i = 0; i < maxEnemies; i++) {
            enemyX = random.nextInt((Container.WIDTH * 10) - Container.WIDTH) + Container.WIDTH;
            enemyY = random.nextInt((Container.HEIGHT - 100) - 30) + 30;
            Enemy1 newEnemy = new Enemy1(enemyX, enemyY);

            if (checkCollisions(newEnemy)) {
                maxEnemies += 1;
                continue;
            }
            enemies1.add(newEnemy);
        }
    }

    private boolean checkCollisions(Enemy1 newEnemy) {
        Rectangle enemyBounds;

        for (Enemy1 enemy : enemies1) {
            enemyBounds = enemy.getBounds();

            if (enemyBounds.intersects(newEnemy.getBounds())) {
                return true;
            }
        }

        return false;
    }

    public void checkCollisions() {
        Rectangle playerBounds = player.getBounds();
        Rectangle enemyBounds;
        Rectangle gunshotBounds;

        for (Enemy1 enemy : enemies1) {
            enemyBounds = enemy.getBounds();

            if (playerBounds.intersects(enemyBounds)) {
                gameOn = false;
                enemies1.clear();
                player.getGunshots().clear();
                player.setVisible(false);
            }
        }

        for (Gunshot gunshot : player.getGunshots()) {
            gunshotBounds = gunshot.getBounds();

            for (Enemy1 enemy : enemies1) {
                enemyBounds = enemy.getBounds();

                if (gunshotBounds.intersects(enemyBounds)) {
                    gunshot.setVisible(false);
                    enemy.setVisible(false);
                }
            }
        }

    }

    @Override
    public void paint(Graphics graph) {
        Graphics2D graph2D = (Graphics2D) graph;

        if (gameOn) {
            graph2D.drawImage(gameBackground, 0, 0, null);

            graph2D.drawImage(player.getSpaceshipImage(), player.getX(), player.getY(), this);

            for (Gunshot gunshot : player.getGunshots()) {
                graph2D.drawImage(gunshot.getImage(), gunshot.getX(), gunshot.getY(), this);
            }

            for (Enemy1 enemy : enemies1) {
                graph2D.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
            }
        } else {
            ImageIcon gameOverImage = new ImageIcon("src\\main\\resources\\img\\game-over.png");
            graph2D.drawImage(gameOverImage.getImage(), 0, 0, Container.WIDTH, Container.HEIGHT, null);
        }

        graph2D.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        player.update();

        List<Gunshot> gunshots = player.getGunshots();
        for (int i = 0; i < gunshots.size(); i++) {
            Gunshot gunshot = gunshots.get(i);
            if (gunshot.isVisible()) {
                gunshot.update();
            } else {
                gunshots.remove(gunshot);
            }
        }

        for (int i = 0; i < enemies1.size(); i++) {
            Enemy1 enemy = enemies1.get(i);
            if (enemy.isVisible()) {
                enemy.update();
            } else {
                enemies1.remove(enemy);
            }
        }

        checkCollisions();
        repaint();
    }

    protected Image getGameBackground() {
        return this.gameBackground;
    }

    public int getMaxEnemies() {
        return maxEnemies;
    }

    public void setMaxEnemies(int maxEnemies) {
        this.maxEnemies = maxEnemies;
    }
}
