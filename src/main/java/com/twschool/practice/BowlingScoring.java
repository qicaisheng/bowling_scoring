package com.twschool.practice;

import java.util.Arrays;
import java.util.List;

public class BowlingScoring {
    public int calculate(String scoreString) {
        List<String> frameScores = Arrays.asList(scoreString.split("\\|"));
        
        return frameScores.stream().mapToInt(frameScore -> {
            String[] frameScoreArray = frameScore.split("");
            int firstHitBottleNumber = Integer.parseInt(frameScoreArray[0]);
            int secondHitBottleNumber = frameScoreArray[1].equals("-") ? 0 : Integer.parseInt(frameScoreArray[1]);
            return firstHitBottleNumber + secondHitBottleNumber;
        }).sum();
    }
}
