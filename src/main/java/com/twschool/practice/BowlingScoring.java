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
        int score = 0;
        for (int frameIndex = 0; frameIndex < bowlingFrames.size() - 1; frameIndex++) {
            score += bowlingFrames.get(frameIndex).getFrameHitBottles();
            if (bowlingFrames.get(frameIndex).isSpare()) {
                score += bowlingFrames.get(frameIndex + 1).getFirstHitBottles();
            }
        }
        score += bowlingFrames.get(9).getFrameHitBottles();
        if (bowlingFrames.get(9).isSpare()) {
            score += bonusBalls.getFirstHitBottles();
        }
        if (bowlingFrames.get(9).isStrike()) {
            score += bonusBalls.getFirstHitBottles();
            score += bonusBalls.getSecondHitBottles();
        }
        
        return score;
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }
    
    public BonusBalls getBonusBalls() {
        return bonusBalls;
    }

}
