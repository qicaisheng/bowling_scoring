package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class BonusBalls {
    private int firstHitBottles;
    private int secondHitBottles;
    private List<Ball> balls = new ArrayList<>();

    public BonusBalls(String bonusScoreString) {
        String[] extraScoreStringArray = bonusScoreString.split("");
        String firstTryScoreString = extraScoreStringArray[0];
        
        if (firstTryScoreString.equals("X")) {
            firstHitBottles = 10;
        }
        if (firstTryScoreString.equals("-")) {
            firstHitBottles = 0;
        }
        if (firstTryScoreString.matches("\\d")) {
            firstHitBottles = Integer.parseInt(firstTryScoreString);
        }
        
        balls.add(new NormalBall(firstHitBottles));
        boolean withExtraTwoTry = extraScoreStringArray.length == 2;
        if (withExtraTwoTry) {
            String secondTryScoreString = extraScoreStringArray[1];
            if (secondTryScoreString.equals("X")) {
                secondHitBottles = 10;
            }
            if (secondTryScoreString.equals("/")) {
                secondHitBottles = 10 - firstHitBottles;
            }
            if (secondTryScoreString.matches("\\d")) {
                secondHitBottles = Integer.parseInt(secondTryScoreString);
            }
            balls.add(new NormalBall(secondHitBottles));
        }

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

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}
