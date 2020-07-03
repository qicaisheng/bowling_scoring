package com.twschool.practice;

import java.util.Arrays;
import java.util.List;

public class BowlingScoring {
    public int calculate(String scoreString) {
        List<String> frameScores = Arrays.asList(scoreString.split("\\|"));
        
        return frameScores.stream().mapToInt(frameScoreString -> new BowlingFrame(frameScoreString).getFrameHitBottles()).sum();
    }

}
