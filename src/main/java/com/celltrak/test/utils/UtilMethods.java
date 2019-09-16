package com.celltrak.test.utils;

import java.util.Random;

/**
 * Class that contains Util methods to use in all the project.
 * @author alexis.alvarez
 */
public class UtilMethods {
    /**
     * Generates a random number by a given range.
     *
     * @param min min value
     * @param max max value
     * @return a random number
     */
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max number must be greater than the min number.");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
