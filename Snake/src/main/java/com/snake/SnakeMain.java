package com.snake;

import com.snake.objects.Apple;
import com.snake.objects.Direction;
import com.snake.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class SnakeMain extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private Snake snake;
    private Apple apple;
    private int speed = 10;
    private Timer timer = new Timer(1000 / speed, this);

    public SnakeMain() {
        snake = new Snake();
        apple = new Apple();
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);

    }

    @Override
    public void paint(Graphics g) {
        paintGameArea(g);
        paintApple(g);
        paintSnake(g);
    }

    private void paintApple(Graphics g) {

        g.setColor(Color.RED);
        g.fillOval(apple.getPosX() * SCALE+3, apple.getPosY() * SCALE+3, SCALE-4, SCALE-4);
    }

    private void paintSnake(Graphics g) {
        int[] snakeY = snake.getSnakeY();
        int[] snakeX = snake.getSnakeX();

        for (int i = 1; i < snake.getLength(); i++) {
            g.setColor(Color.GREEN);
            g.fillRect(snakeX[i] * SCALE + 2, snakeY[i] * SCALE + 2, SCALE - 2, SCALE - 2);
        }

        g.setColor(Color.DARK_GRAY);
        g.fillRect(snakeX[0] * SCALE + 2, snakeY[0] * SCALE + 2, SCALE - 2, SCALE - 2);
    }

    private void paintGameArea(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.setColor(Color.BLACK);
            g.drawLine(x, 0, x, WIDTH * SCALE);

        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.setColor(Color.BLACK);
            g.drawLine(0, y, HEIGHT * SCALE, y);

        }
    }

    public static void main(String[] args) {
        jFrame = new JFrame("Snake");
        jFrame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(new SnakeMain());
        jFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        eat();
        gameOverTest();
        repaint();
    }
    private void gameOverTest(){
        for (int i = 1; i <snake.getLength() ; i++) {
            if((snake.getSnakeX()[0]== snake.getSnakeX()[i] )&& (snake.getSnakeY()[0]== snake.getSnakeY()[i]) ){
                timer.stop();
                JOptionPane.showMessageDialog(null,"Game Over , do u want to start again? ");
                jFrame.setVisible(false);
                snake = new Snake();
                jFrame.setVisible(true);
                timer.start();
            }
    }
    }
    private void eat(){
        if(snake.getSnakeX()[0]== apple.getPosX() && snake.getSnakeY()[0]== apple.getPosY() ){
              apple.setRandomPosition();
              snake.growth();
        }
        for (int i = 1; i <snake.getLength() ; i++) {
            if(snake.getSnakeX()[i]== apple.getPosX() && snake.getSnakeY()[i]== apple.getPosY() ){
                apple.setRandomPosition();
            }
        }
    }

    private class KeyBoard extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_UP) {
                snake.changeDirection(Direction.UP);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                snake.changeDirection(Direction.DOWN);

            } else if (keyCode == KeyEvent.VK_LEFT) {
                snake.changeDirection(Direction.LEFT);

            } else if (keyCode == KeyEvent.VK_RIGHT) {
                snake.changeDirection(Direction.RIGHT);

            }

        }
    }

}
