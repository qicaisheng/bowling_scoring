package com.twschool.practice;

public abstract class Ball {
    private int hitBattles;

    public Ball(int hitBattles) {
        this.hitBattles = hitBattles;
    }

    public int getHitBattles() {
        return hitBattles;
    }
}
