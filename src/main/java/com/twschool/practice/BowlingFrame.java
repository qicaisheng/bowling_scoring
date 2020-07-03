package com.twschool.practice;

import java.util.List;

import static com.twschool.practice.BallsFactory.buildBalls;

public class BowlingFrame {
    private List<Ball> balls;
    
    public BowlingFrame(String frameScoreString) {
        balls = buildBalls(frameScoreString);
    }


    public List<Ball> getBalls() {
        return balls;
    }
}
