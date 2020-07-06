package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class FrameBallsParser {

    public static List<Ball> parse(String frameScoreString) {
        int secondHitBottles;
        List<Ball> balls = new ArrayList<>();
        String[] frameScoreArray = frameScoreString.split("");
        Ball firstBall;
        String firstBallScoreString = frameScoreArray[0];
        if (firstBallScoreString.equals("X")) {
            firstBall = new StrikeBall();
        } else if (firstBallScoreString.equals("-")) {
            firstBall = new NormalBall(0);
        } else {
            firstBall = new NormalBall(Integer.parseInt(firstBallScoreString));
        }

        int firstHitBottles = firstBall.getHitBattles();
        balls.add(firstBall);

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
