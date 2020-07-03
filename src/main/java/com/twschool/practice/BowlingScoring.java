package com.twschool.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;

    public BowlingScoring(String scoreString) {
        List<String> frameScores = Arrays.asList(scoreString.split("\\|"));
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
    }

    public int getSumScores() {
        return bowlingFrames.stream().mapToInt(BowlingFrame::getFrameHitBottles).sum();
    }

}
