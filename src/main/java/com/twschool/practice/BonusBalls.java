package com.twschool.practice;

public class BonusBalls {
    private int firstHitBottles;
    private int secondHitBottles;

    public BonusBalls(String bonusScoreString) {
        String[] extraScoreStringArray = bonusScoreString.split("");
        String firstTryScoreString = extraScoreStringArray[0];
        firstHitBottles = firstTryScoreString.equals("X") ? 10 : Integer.parseInt(firstTryScoreString);
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
        }

    }

    public int getFirstHitBottles() {
        return firstHitBottles;
    }

    public int getSecondHitBottles() {
        return secondHitBottles;
    }

}
