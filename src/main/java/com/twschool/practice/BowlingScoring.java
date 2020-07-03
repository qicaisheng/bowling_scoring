package com.twschool.practice;

import java.util.Arrays;
import java.util.List;

public class BowlingScoring {
    public int calculate(String scoreString) {
        List<String> frameScores = Arrays.asList(scoreString.split("\\|"));
        
        return frameScores.stream().mapToInt(frameScore -> calculateFrameHitBottles(frameScore)).sum();
    }

    private int calculateFrameHitBottles(String frameScoreString) {
        String[] frameScoreArray = frameScoreString.split("");
        int firstHitBottles = Integer.parseInt(frameScoreArray[0]);
        int secondHitBottles = frameScoreArray[1].equals("-") ? 0 : Integer.parseInt(frameScoreArray[1]);
        return firstHitBottles + secondHitBottles;
    }
}
