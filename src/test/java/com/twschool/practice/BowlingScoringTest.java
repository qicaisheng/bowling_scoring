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
        
        Assert.assertEquals(10, bowlingScoring.getBowlingFrames().size());
        Assert.assertNotNull(bowlingScoring.getBonusBalls());
        Assert.assertEquals(5, bowlingScoring.getBonusBalls().getFirstHitBottles());
    }

    @Test
    public void should_parse_frames_and_extra_hit_bottles_given_last_try_strike_and_two_extra_try() {

        BowlingScoring bowlingScoring = new BowlingScoring("5/|5/|5/|5/|5/|5/|5/|5/|5/|X||51");

        Assert.assertEquals(10, bowlingScoring.getBowlingFrames().size());
        Assert.assertNotNull(bowlingScoring.getBonusBalls());
        Assert.assertEquals(5, bowlingScoring.getBonusBalls().getFirstHitBottles());
        Assert.assertEquals(1, bowlingScoring.getBonusBalls().getSecondHitBottles());
    }

}
