package com.twschool.practice;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingFrames {
    private final List<BowlingFrame> bowlingFrames;

    public BowlingFrames(List<BowlingFrame> bowlingFrames) {
        this.bowlingFrames = bowlingFrames;
    }

    public List<BowlingFrame> getBowlingFrames() {
        return bowlingFrames;
    }

    public List<Ball> getAllBalls() {
        return getBowlingFrames().stream()
                .map(BowlingFrame::getBalls)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Ball> getTenFrameBalls() {
        return getTenBowlingFrames().stream().map(BowlingFrame::getBalls).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<BowlingFrame> getTenBowlingFrames() {
        return getBowlingFrames().stream().limit(10).collect(Collectors.toList());
    }

    public BowlingFrame getBonusFrame() {
        return getBowlingFrames().get(10);
    }

    public int getSumScores() {
        int score = 0;
        List<Ball> allBalls = this.getAllBalls();
        for (int ballIndex = 0; ballIndex < this.getTenFrameBalls().size(); ballIndex++) {
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

}