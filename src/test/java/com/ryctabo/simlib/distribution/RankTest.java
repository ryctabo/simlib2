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
 * @version 1.0-SNAPSHOT
 */
@RunWith(Parameterized.class)
public class RankTest {
    
    private final int min, max, value;
    
    private final boolean expected;
    
    private Rank rank;

    public RankTest(int min, int max, int value, boolean expected) {
        this.min = min;
        this.max = max;
        this.value = value;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getValues() {
        return Arrays.asList(new Object[][] {
            {0, 10, 5, true}, {0, 10, 10, false}, {0, 10, 0, true}
        });
    }
    
    @Before
    public void createNewInstanceOfRank() {
        this.rank = new Rank(max, min);
    }
    
    @Test
    public void isInsideRankTest() {
        assertEquals(expected, rank.isInsideRank(value));
    }
    
}
