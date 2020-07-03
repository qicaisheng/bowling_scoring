package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {
    private int firstHitBottles;
    private int secondHitBottles;
    private boolean spare;
    private boolean strike;
    private List<Ball> balls = new ArrayList<>();

    public BowlingFrame(String frameScoreString) {
        String[] frameScoreArray = frameScoreString.split("");
        if (frameScoreArray[0].equals("X")) {
            firstHitBottles = 10;
            strike = true;
            balls.add(new StrikeBall());
        } else {
            firstHitBottles = Integer.parseInt(frameScoreArray[0]);
            balls.add(new NormalBall(firstHitBottles));
            if (frameScoreArray[1].equals("/")) {
                secondHitBottles = 10 - firstHitBottles;
                spare = true;
                balls.add(new SpareBall(secondHitBottles));
            }
            if (frameScoreArray[1].matches("\\d")) {
                secondHitBottles = Integer.parseInt(frameScoreArray[1]);
                balls.add(new NormalBall(secondHitBottles));
            }
            if (frameScoreArray[1].equals("-")) {
                balls.add(new NormalBall(0));
            }
        }
    }

    public int getFrameHitBottles() {
        return firstHitBottles + secondHitBottles;
    }

    public boolean isSpare() {
        return spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public int getFirstHitBottles() {
        return firstHitBottles;
    }

    public int getSecondHitBottles() {
        return secondHitBottles;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
