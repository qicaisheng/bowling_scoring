package com.twschool.practice;

public class BowlingFrame {
    private int firstHitBottles;
    private int secondHitBottles;
    private boolean spare;
    private boolean strike;

    public BowlingFrame(String frameScoreString) {
        String[] frameScoreArray = frameScoreString.split("");
        if (frameScoreArray[0].equals("X")) {
            firstHitBottles = 10;
            secondHitBottles = 0;
            strike = true;
        } else {
            firstHitBottles = Integer.parseInt(frameScoreArray[0]);
            if (frameScoreArray[1].equals("-"))  {
                secondHitBottles = 0;
            } else if (frameScoreArray[1].equals("/")) {
                secondHitBottles = 10 - firstHitBottles;
                spare = true;
            } else {
                secondHitBottles = Integer.parseInt(frameScoreArray[1]);
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
}
