package com.twschool.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;
    private int extraFirstTryHitBottles;
    private int extraSecondTryHitBottles;

    public BowlingScoring(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        if (bowlingScoresArray.length == 2) {
            String extraScoreString = bowlingScoresArray[1];
            String[] extraScoreStringArray = extraScoreString.split("");
            extraFirstTryHitBottles = Integer.parseInt(extraScoreStringArray[0]);
            extraSecondTryHitBottles = extraScoreStringArray.length == 2 ? Integer.parseInt(extraScoreStringArray[1]) : 0;
        }
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
    }

    public int getSumScores() {
        return bowlingFrames.stream().mapToInt(BowlingFrame::getFrameHitBottles).sum();
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }

    public int getExtraFirstTryHitBottles() {
        return extraFirstTryHitBottles;
    }

    public void setExtraFirstTryHitBottles(int extraFirstTryHitBottles) {
        this.extraFirstTryHitBottles = extraFirstTryHitBottles;
    }

    public int getExtraSecondTryHitBottles() {
        return extraSecondTryHitBottles;
    }

    public void setExtraSecondTryHitBottles(int extraSecondTryHitBottles) {
        this.extraSecondTryHitBottles = extraSecondTryHitBottles;
    }
}
