package com.snake.objects;

public enum Direction {
    UP("DOWN"),DOWN("UP"),LEFT("RIGHT"),RIGHT("LEFT");

    Direction(String restricted) {
        this.restricted = restricted;
    }

    private final String restricted;

    public String getRestricted() {
        return restricted;
    }

    public static Direction getRestrictedDirection(Direction direction){
    return Direction.valueOf(direction.getRestricted());
}
}
