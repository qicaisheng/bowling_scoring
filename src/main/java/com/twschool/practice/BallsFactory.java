package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class BallsFactory {

    public static List<Ball> buildBalls(String frameScoreString) {
        int firstHitBottles;
        int secondHitBottles;
        List<Ball> balls = new ArrayList<>();
        String[] frameScoreArray = frameScoreString.split("");
        if (frameScoreArray[0].equals("X")) {
            firstHitBottles = 10;
            balls.add(new StrikeBall());
        } else if (frameScoreArray[0].equals("-")) {
            firstHitBottles = 0;
            balls.add(new NormalBall(0));
        } else {
            firstHitBottles = Integer.parseInt(frameScoreArray[0]);
            balls.add(new NormalBall(firstHitBottles));
        }

        if (frameScoreArray.length == 2) {
            if (frameScoreArray[1].equals("X")) {
                balls.add(new StrikeBall());
            }
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

        return balls;
    }

}