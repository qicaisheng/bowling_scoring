package com.twschool.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;
    private BonusBalls bonusBalls;

    public BowlingScoring(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        boolean withExtraTry = bowlingScoresArray.length == 2;
        if (withExtraTry) {
            bonusBalls = new BonusBalls(bowlingScoresArray[1]);
        }
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
    }

    public int getSumScores() {
        return bowlingFrames.stream().mapToInt(BowlingFrame::getFrameHitBottles).sum();
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }
    
    public BonusBalls getBonusBalls() {
        return bonusBalls;
    }

}
