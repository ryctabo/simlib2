/*
 * Copyright 2016 rycta.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ryctabo.simlib.distribution;

/**
 *
 * @author Gustavo Pacheco
 * @version 0.4
 */
public class Distribution {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private Distribution() {}
    
    /**
     * This method return the random value of a pseudo-random value generated.
     * 
     * @param media mean
     * @param value pseudo-random value
     * @return the random value -media(ln(value))
     * @see java.lang.Math#log(double) 
     */
    public static double exponential(int media, double value) {
        return - media * java.lang.Math.log(value);
    }
    
    /**
     * This method return the random value of a pseudo-random value generated.
     * 
     * @param lambda lambda =  1 / mean, the lambda value can not be 0.
     * @param value pseudo-random value
     * @return random value, -(1/lambda)ln(value)
     * @throws ArithmeticException if lambda is 0
     */
    public static double exponential(double lambda, double value) {
        return - (1d / lambda) * java.lang.Math.log(value);
    }
    
    /**
     * This method return the random variable nonuniform of a pseudo-random
     * value generated.
     * 
     * @param min the min value
     * @param max the max value
     * @param value the pseudo-random value, min + value(max - min)
     * @return random value between the range [min, max)
     */
    public static double uniform(double min, double max, double value) {
        return min + (max - min) * value;
    }
    
    /**
     * This method return the random variable nonuniform of a pseudo-random
     * value generated.
     * 
     * @param min the min value
     * @param max the max value
     * @param value the pseudo-random value, min + value(max - min)
     * @return random value between the range [min, max)
     */
    public static int uniform(int min, int max, double value) {
        return (int) (min + (max - min) * value);
    }
    
}
