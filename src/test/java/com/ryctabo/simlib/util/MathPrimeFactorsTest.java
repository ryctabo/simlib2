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
package com.ryctabo.simlib.util;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Gustavo Pacheco
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class MathPrimeFactorsTest {
    
    private final int[] expected;
    
    private final int value;
    
    private final boolean distint;

    public MathPrimeFactorsTest(int[] expected, int value, boolean distint) {
        this.expected = expected;
        this.value = value;
        this.distint = distint;
    }
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][] {
            {new int[] {2, 3}, 6, false},
            {new int[] {2, 2, 5, 5}, 100, false},
            {new int[] {2, 5}, 100, true}
        });
    }
    
    @Test
    public void test() {
        assertArrayEquals(expected, Math.getPrimeFactors(distint, value));
    }
    
}
