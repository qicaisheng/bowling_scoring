package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BowlingScoringTest {

    @Test
    public void should_return_the_sum_of_hit_bottle_when_ten_frame_does_not_hit_all_and_with_missed() {
        
        BowlingScoring bowlingScoring = new BowlingScoring();

        int score = bowlingScoring.calculate("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-");

        Assert.assertEquals(90, score);
    }

}
