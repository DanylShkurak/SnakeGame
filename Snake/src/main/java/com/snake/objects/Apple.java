package com.snake.objects;

import com.snake.SnakeMain;

public class Apple {
    private int posX;
    private int posY;

    public Apple() {
setRandomPosition();
    }
    public void setRandomPosition(){
        posX=(int)(Math.random()* SnakeMain.WIDTH-1);
        posY=(int)(Math.random()* SnakeMain.HEIGHT-1);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
