package com.twschool.practice;

public class BonusBalls {
    private int firstHitBottles;

    public BonusBalls(String bonusScoreString) {
        String[] extraScoreStringArray = bonusScoreString.split("");
        firstHitBottles = Integer.parseInt(extraScoreStringArray[0]);
    }

    public int getFirstHitBottles() {
        return firstHitBottles;
    }

    public void setFirstHitBottles(int firstHitBottles) {
        this.firstHitBottles = firstHitBottles;
    }
}
