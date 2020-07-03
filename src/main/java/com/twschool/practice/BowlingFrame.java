package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {
    private List<Ball> balls = new ArrayList<>();

    public BowlingFrame(String frameScoreString) {
        String[] frameScoreArray = frameScoreString.split("");
        if (frameScoreArray[0].equals("X")) {
            balls.add(new StrikeBall());
        } else {
            int firstHitBottles = Integer.parseInt(frameScoreArray[0]);
            balls.add(new NormalBall(firstHitBottles));
            int secondHitBottles;
            if (frameScoreArray[1].equals("/")) {
                secondHitBottles = 10 - firstHitBottles;
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

    public List<Ball> getBalls() {
        return balls;
    }
}
