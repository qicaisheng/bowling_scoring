package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class FrameBallsParser {

    public static List<Ball> parse(String frameScoreString) {
        int secondHitBottles;
        List<Ball> balls = new ArrayList<>();
        String[] frameScoreArray = frameScoreString.split("");
        Ball firstBall;
        Ball secondBall;
        String firstBallScoreString = frameScoreArray[0];
        firstBall = parseFirstBall(firstBallScoreString);

        int firstHitBottles = firstBall.getHitBattles();
        balls.add(firstBall);

        if (frameScoreArray.length == 2) {
            String secondBallScoreString = frameScoreArray[1];
            secondBall = parseSecondBall(firstHitBottles, secondBallScoreString);
            balls.add(secondBall);
        }

        return balls;
    }

    private static Ball parseSecondBall(int firstHitBottles, String secondBallScoreString) {
        Ball secondBall;
        int secondHitBottles;
        if (secondBallScoreString.equals("X")) {
            secondBall = new StrikeBall();
        } else if (secondBallScoreString.equals("/")) {
            secondHitBottles = 10 - firstHitBottles;
            secondBall = new SpareBall(secondHitBottles);
        } else if (secondBallScoreString.equals("-")) {
            secondBall = new NormalBall(0);
        } else {
            secondHitBottles = Integer.parseInt(secondBallScoreString);
            secondBall = new NormalBall(secondHitBottles);
        }
        return secondBall;
    }

    private static Ball parseFirstBall(String firstBallScoreString) {
        Ball firstBall;
        if (firstBallScoreString.equals("X")) {
            firstBall = new StrikeBall();
        } else if (firstBallScoreString.equals("-")) {
            firstBall = new NormalBall(0);
        } else {
            firstBall = new NormalBall(Integer.parseInt(firstBallScoreString));
        }
        return firstBall;
    }

}
