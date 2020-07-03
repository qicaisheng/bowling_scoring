package com.twschool.practice;

public class BowlingFrame {
    private int firstHitBottles;
    private int secondHitBottles;

    public BowlingFrame(String frameScoreString) {
        String[] frameScoreArray = frameScoreString.split("");
        firstHitBottles = Integer.parseInt(frameScoreArray[0]);
        secondHitBottles = frameScoreArray[1].equals("-") ? 0 : Integer.parseInt(frameScoreArray[1]);
    }

    public int getFrameHitBottles() {
        return firstHitBottles + secondHitBottles;
    }
}
