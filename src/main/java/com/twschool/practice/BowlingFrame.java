package com.twschool.practice;

import java.util.List;

import static com.twschool.practice.FrameBallsParser.parse;

public class BowlingFrame {
    private List<Ball> balls;
    
    public BowlingFrame(String frameScoreString) {
        balls = parse(frameScoreString).balls;
    }

    public BowlingFrame(List<Ball> balls) {
        this.balls = balls;
    }


    public List<Ball> getBalls() {
        return balls;
    }
}
