package com.twschool.practice;

public class BonusBalls {
    private int firstHitBottles;
    private int secondHitBottles;

    public BonusBalls(String bonusScoreString) {
        String[] extraScoreStringArray = bonusScoreString.split("");
        firstHitBottles = Integer.parseInt(extraScoreStringArray[0]);
        boolean withExtraTwoTry = extraScoreStringArray.length == 2;
        secondHitBottles = withExtraTwoTry ? Integer.parseInt(extraScoreStringArray[1]) : 0;

    }

    public int getFirstHitBottles() {
        return firstHitBottles;
    }

    public void setFirstHitBottles(int firstHitBottles) {
        this.firstHitBottles = firstHitBottles;
    }

    public int getSecondHitBottles() {
        return secondHitBottles;
    }

    public void setSecondHitBottles(int secondHitBottles) {
        this.secondHitBottles = secondHitBottles;
    }
}
