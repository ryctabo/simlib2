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

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Gustavo Pacheco
 * @version 0.2
 */
public class MathTest {
    
    @Test
    public void average() {
        Assert.assertEquals(19, Math.average(10, 12, 36));
        Assert.assertEquals(19L, Math.average(10L, 12L, 36L));
        Assert.assertEquals(19.3333f, Math.average(10f, 12f, 36f), 1e-4f);
        Assert.assertEquals(19.3333d, Math.average(10d, 12d, 36d), 1e-4d);
    }
    
    @Test
    public void fact() {
        long expResult = 2432902008176640000L;
        long result = Math.fact(20);
        
        Assert.assertEquals(expResult, result);
        
        boolean exception = false;
        try {
            Math.fact(-1);
        } catch (Exception e) {
            exception = true;
        }
        Assert.assertTrue(exception);
    }
    
    @Test
    public void gcd() {
        int expResult = 14;
        int result = Math.gcd(42, -56);
        
        Assert.assertEquals(expResult, result);
    }
    
    @Test
    public void getPrimeFactors() {
        int[] expResult1 = new int[] {2, 3};
        int[] result1 = Math.getPrimeFactors(false, 6);
        
        Assert.assertArrayEquals(expResult1, result1);
        
        int[] expResult2 = new int[] {2, 2, 5, 5};
        int[] result2 = Math.getPrimeFactors(false, 100);
        
        Assert.assertArrayEquals(expResult2, result2);
        
        int[] expResult3 = new int[] {2, 5};
        int[] result3 = Math.getPrimeFactors(true, 100);
        
        Assert.assertArrayEquals(expResult3, result3);
    }
    
    @Test
    public void isCoprime() {
        Assert.assertTrue(Math.isCoprime(6, 35));
        Assert.assertFalse(Math.isCoprime(6, 27));
    }
    
    @Test
    public void isPrime() {
        Assert.assertTrue(Math.isPrime(524287));
        Assert.assertFalse(Math.isPrime(561435134));
        Assert.assertTrue(!Math.isPrime(-1));
    }
    
    @Test
    public void plus() {
        Assert.assertEquals(0, Math.plus());
        Assert.assertEquals(6, Math.plus(3, 2, 1));
        Assert.assertEquals(-1, Math.plus(3, 2, -6));
        Assert.assertEquals(6.3f, Math.plus(1.5f, 1.6f, 3.2f), 0f);
        Assert.assertEquals(6.3d, Math.plus(1.5d, 1.6d, 3.2d), 0.000001d);
    }
    
}
