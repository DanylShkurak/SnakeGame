package com.snake.objects;

import com.snake.SnakeMain;

public class Snake {
    private Direction direction;
    private int length = 2;

    public Snake() {
        this.direction = Direction.UP;
        snakeX[0] = 5;
        snakeX[1] = 5;
        snakeY[0] = 3;
        snakeY[1] = 2;
    }

    public int getLength() {
        return length;
    }

    public int[] getSnakeX() {
        return snakeX;
    }

    public int[] getSnakeY() {
        return snakeY;
    }

    private int[] snakeX = new int[300];
    private int[] snakeY = new int[300];

    public void move() {
        for (int i = length ; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        if (direction == Direction.UP) {
            snakeY[0]--;
        } else if (direction == Direction.DOWN) {
            snakeY[0]++;
        } else if (direction == Direction.RIGHT) {
            snakeX[0]++;
        } else if (direction == Direction.LEFT) {
            snakeX[0]--;
        }
        if (snakeY[0] > SnakeMain.HEIGHT - 1)
            snakeY[0] = 0;
        if (snakeY[0] < 0)
            snakeY[0] = SnakeMain.HEIGHT - 1;
        if (snakeX[0]>SnakeMain.WIDTH-1)
            snakeX[0]=0;
        if (snakeX[0]<0)
            snakeX[0]=SnakeMain.WIDTH-1;
    }

    public void changeDirection(Direction newDirection) {
        if (newDirection != Direction.getRestrictedDirection(this.direction)) {
            this.direction = newDirection;
        }
    }
    public void growth(){
        this.length++;
    }
}
