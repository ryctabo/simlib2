/*
 * Copyright 2015 Gustavo Pacheco.
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

import static org.junit.Assert.*;

import org.junit.Test;


/**
 *
 * @author Gustavo Pacheco
 * @version 0.2
 */
public class MathTest {
    
    @Test
    public void average() {
        assertEquals(19, Math.average(10, 12, 36));
        assertEquals(19.3333d, Math.average(10d, 12d, 36d), 1e-4d);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void fact() {
        long expected = 2432902008176640000L;
        assertEquals(expected, Math.fact(20));
        //The next line should throw an error
        Math.fact(-1);
    }
    
    @Test
    public void gcd() {
        assertEquals(14, Math.gcd(42, -56));
    }
    
    @Test
    public void isCoprime() {
        assertTrue(Math.isCoprime(6, 35));
        assertFalse(Math.isCoprime(6, 27));
    }
    
    @Test
    public void isPrime() {
        assertTrue(Math.isPrime(524287));
        assertFalse(Math.isPrime(561435134));
        assertFalse(Math.isPrime(-1));
    }
    
    @Test
    public void plusWithDecimal() {
        assertEquals(6.3f, Math.plus(1.5f, 1.6f, 3.2f), 0f);
        assertEquals(6.3d, Math.plus(1.5d, 1.6d, 3.2d), 0.000001d);
    }
    
}
