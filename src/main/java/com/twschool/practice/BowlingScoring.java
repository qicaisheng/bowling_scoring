package com.twschool.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScoring {
    
    private List<BowlingFrame> bowlingFrames;
    private BowlingFrame bonusFrame;
    BowlingFrames allBowlingFrames;

    public BowlingScoring(String scoreString) {
        String[] bowlingScoresArray = scoreString.split("\\|\\|");
        List<String> frameScores = Arrays.asList(bowlingScoresArray[0].split("\\|"));
        bowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
        List<BowlingFrame> newBowlingFrames = frameScores.stream().map(BowlingFrame::new).collect(Collectors.toList());
        boolean withExtraTry = bowlingScoresArray.length == 2;
        if (withExtraTry) {
            bonusFrame = new BowlingFrame(bowlingScoresArray[1]);
            newBowlingFrames.add(bonusFrame);
        }
        allBowlingFrames = new BowlingFrames(newBowlingFrames);
    }

    public int getSumScores() {
        int score = 0;
        List<Ball> allBalls = allBowlingFrames.getAllBalls();
        for (int ballIndex = 0; ballIndex < allBowlingFrames.getTenFrameBalls().size(); ballIndex++) {
            Ball currentBall = allBalls.get(ballIndex);
            score += currentBall.getHitBattles();
            if (currentBall instanceof StrikeBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles() + allBalls.get(ballIndex + 2).getHitBattles();
            }
            if (currentBall instanceof SpareBall) {
                score += allBalls.get(ballIndex + 1).getHitBattles();
            }
        }
        return score;
    }

    public BowlingFrame getBonusFrame() {
        return bonusFrame;
    }

}
