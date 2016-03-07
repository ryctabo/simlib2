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
public class MathPlusTest {
    
    private final long expected;
    
    private final long[] values;

    public MathPlusTest(long expected, long[] values) {
        this.expected = expected;
        this.values = values;
    }
    
    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][] {
            {0, new long[0]},
            {6, new long[] {3, 2, 1}},
            {-1, new long[] {3, 2, -6}},
            {15, new long[] {8, 2, 4, 1}}
        });
    }
    
    @Test
    public void test() {
        assertEquals(expected, Math.plus(values));
    }
    
}
