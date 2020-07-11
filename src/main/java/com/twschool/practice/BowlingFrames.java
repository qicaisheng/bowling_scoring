package com.twschool.practice;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingFrames {
    private List<BowlingFrame> bowlingFrames;

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
        return getBowlingFrames().stream().limit(10).map(BowlingFrame::getBalls).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<BowlingFrame> getBowlingFrames(BowlingScoring bowlingScoring) {
        return getBowlingFrames().stream().limit(10).collect(Collectors.toList());
    }
}
