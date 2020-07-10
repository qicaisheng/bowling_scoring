package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class FrameBallsParser {

    public static BowlingFrame parse(String frameScoreString) {
        List<Ball> balls = new ArrayList<>();
        String[] frameScoreArray = frameScoreString.split("");
        String firstBallScoreString = frameScoreArray[0];
        Ball firstBall = parseFirstBall(firstBallScoreString);

        int firstHitBottles = firstBall.getHitBattles();
        balls.add(firstBall);

        boolean containSecondBall = frameScoreArray.length == 2;
        if (containSecondBall) {
            String secondBallScoreString = frameScoreArray[1];
            Ball secondBall = parseSecondBall(firstHitBottles, secondBallScoreString);
            balls.add(secondBall);
        }

        return new BowlingFrame(balls);
    }

    private static Ball parseSecondBall(int firstHitBottles, String secondBallScoreString) {
        int secondHitBottles;
        if (secondBallScoreString.equals("X")) {
            return new StrikeBall();
        } else if (secondBallScoreString.equals("/")) {
            secondHitBottles = 10 - firstHitBottles;
            return new SpareBall(secondHitBottles);
        } else if (secondBallScoreString.equals("-")) {
            return new NormalBall(0);
        } else {
            secondHitBottles = Integer.parseInt(secondBallScoreString);
            return new NormalBall(secondHitBottles);
        }
    }

    private static Ball parseFirstBall(String firstBallScoreString) {
        if (firstBallScoreString.equals("X")) {
            return new StrikeBall();
        } else if (firstBallScoreString.equals("-")) {
            return new NormalBall(0);
        } else {
            return new NormalBall(Integer.parseInt(firstBallScoreString));
        }
    }

}
