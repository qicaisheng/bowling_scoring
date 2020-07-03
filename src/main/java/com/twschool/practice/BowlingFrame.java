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
            strike = true;
        } else {
            firstHitBottles = Integer.parseInt(frameScoreArray[0]);
            if (frameScoreArray[1].equals("/")) {
                secondHitBottles = 10 - firstHitBottles;
                spare = true;
            }
            if (frameScoreArray[1].matches("\\d")) {
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

    public int getFirstHitBottles() {
        return firstHitBottles;
    }

    public int getSecondHitBottles() {
        return secondHitBottles;
    }

}
