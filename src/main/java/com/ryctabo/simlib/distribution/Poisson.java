/*
 * Copyright 2016 Gustavo Pacheco.
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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Pacheco <ryctabo@gmail.com>
 * @version 1.0-SNAPSHOT
 */
public class Poisson {
    
    private double lambda;
    
    private final List<Rank> ranks;

    private Poisson(double lambda) {
        this.lambda = lambda;
        this.ranks = new ArrayList<>();
        createRanks();
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    /**
     * This method return the likelihood of {@code x} successes, when the
     * average number of occurrence is {@code lambda}.
     * 
     * @param lambda mean or average of successes per unit time, area or product
     * @param x variable denoting the number of successes we expected
     * @return probability of successes
     * @see com.ryctabo.simlib.util.Math#fact(long) 
     * @see Math#exp(double) 
     * @see Math#pow(double, double)
     */
    public static double probability(double lambda, int x) {
        long fact = com.ryctabo.simlib.util.Math.fact(x);
        return Math.exp(-lambda) * Math.pow(lambda, x) / fact;
    }
    
    /**
     * Create a poisson with given lambda.
     * 
     * @param lambda a lambda value, this value is decimal
     * @return new instance of poisson class
     */
    public static Poisson createPoissonForGetRandomVariable(double lambda) {
        return new Poisson(lambda);
    }
    
    /**
     * This method create the ranks for the calculation of poisson.
     * @see #probability(double, int)
     */
    private void createRanks() {
        int rankSize = (int) (lambda * 3) + 1;
        
        double min = 0d, max = 0d;
        
        for (int x = 0; x < rankSize; x++) {
            max += Poisson.probability(lambda, x);
            this.ranks.add(new Rank(max, min));
            min = max;
        }
    }
    
    /**
     * This method returns a random variable, which corresponds to the 
     * semi-random value given.
     * 
     * <p>
     * The random variable corresponds to index of rank where belong the given 
     * value. If the given value is not within range then return -1.
     * 
     * @param value a value
     * @return random variable
     * @see Rank#isInsideRank(double) 
     */
    public int getRandomValue(double value) {
        for (int index = 0; index < ranks.size(); index++)
            if (this.ranks.get(index).isInsideRank(value))
                return index;
        return -1;
    }

}
