package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BowlingScoringTest {

    @Test
    public void should_return_the_sum_of_hit_bottle_when_ten_frame_does_not_hit_all_and_with_missed() {
        
        BowlingScoring bowlingScoring = new BowlingScoring("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-");

        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(90, score);
    }

    @Test
    public void should_return_the_sum_of_hit_bottle_when_ten_frame_does_not_hit_all() {

        BowlingScoring bowlingScoring = new BowlingScoring("9-|9-|9-|9-|81|9-|9-|9-|9-|9-");

        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(90, score);
    }

    @Test
    public void should_parse_frames_and_extra_hit_bottles_given_last_try_spare_and_one_extra_try() {

        BowlingScoring bowlingScoring = new BowlingScoring("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
        
        Assert.assertEquals(10, bowlingScoring.allBowlingFrames.getTenBowlingFrames().size());
        Assert.assertNotNull(bowlingScoring.allBowlingFrames.getBonusFrame());
    }

    @Test
    public void should_parse_frames_and_extra_hit_bottles_given_last_try_strike_and_two_extra_try() {

        BowlingScoring bowlingScoring = new BowlingScoring("5/|5/|5/|5/|5/|5/|5/|5/|5/|X||51");

        Assert.assertEquals(10, bowlingScoring.allBowlingFrames.getTenBowlingFrames().size());
        Assert.assertNotNull(bowlingScoring.allBowlingFrames.getBonusFrame());
    }

    @Test
    public void should_return_sum_of_hit_bottles_and_bonus_ball_score_given_all_spare_and_extra_try() {

        BowlingScoring bowlingScoring = new BowlingScoring("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
        
        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(150, score);
    }

    @Test
    public void should_return_sum_of_hit_bottles_and_bonus_ball_score_given_spare_and_last_is_strike_and_extra_two_try() {

        BowlingScoring bowlingScoring = new BowlingScoring("5/|5/|5/|5/|5/|5/|5/|5/|5/|X||51");

        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(156, score);
    }

    @Test
    public void should_return_sum_of_hit_bottles_and_bonus_ball_score_given_all_strike() {

        BowlingScoring bowlingScoring = new BowlingScoring("X|X|X|X|X|X|X|X|X|X||XX");

        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(300, score);
    }

    @Test
    public void should_return_sum_of_hit_bottles_and_bonus_ball_score_given_strike_spare_and_missed_case() {

        BowlingScoring bowlingScoring = new BowlingScoring("X|7/|9-|X|-8|8/|-6|X|X|X||81");

        int score = bowlingScoring.getSumScores();

        Assert.assertEquals(167, score);
    }
}
