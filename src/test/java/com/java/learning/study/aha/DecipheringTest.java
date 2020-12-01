package com.java.learning.study.aha;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecipheringTest {
    @Test
    public void test() {
        int[] nums = {6,3,1,7,5,8,9,2,4};
        Deciphering deciphering=new Deciphering();
        //deciphering.getNumber(nums)
        deciphering.getNumber(nums);

    }
}
