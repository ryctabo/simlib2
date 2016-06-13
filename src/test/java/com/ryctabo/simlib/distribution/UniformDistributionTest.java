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

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

/**
 *
 * @author Gustavo Pacheco <ryctabo@gmail.com>
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class UniformDistributionTest {
    
    private final int min, max;
    
    private double random;

    public UniformDistributionTest(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getValues() {
        return Arrays.asList(new Object[][] {
            {0, 10}, {15, 125}, {1232, 213854}
        });
    }
    
    /**
     * the random value.
     */
    @Before
    public void before() {
        this.random = Math.random();
    }
    
    @Test
    public void uniform() {
        assertTrue(isInsideRank(
                min, max, Distribution.uniform(min, max, random)
        ));
    }
    
    /**
     * This method return {@code true}, if {@code value} is between the min value
     * and the max value, else return {@code false}.
     * <p>
     * The range => [min, max)
     * 
     * @param a the {@code min} value
     * @param b the {@code max} value
     * @param value random value
     * @return {@code true}, if random value is between {@code min} and 
     * {@code max}.
     */
    private boolean isInsideRank(int a, int b, int value) {
        return value >= a && value < b;
    }
    
}
