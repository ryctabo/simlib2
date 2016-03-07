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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Pacheco
 * @version 0.8
 */
public final class Math {
    
    /**
     * Don't let anyone instantiate this class.
     */
    private Math() {}
    
    /**
     * Returns the average of the given {@code int} values.
     * 
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see #plus(int...) 
     */
    public static int average(int... values) {
        return plus(values) / values.length;
    }
    
    /**
     * Returns the average of the given {@code long} values.
     * 
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see #plus(long...) 
     */
    public static long average(long... values) {
        return plus(values) / values.length;
    }
    
    /**
     * Returns the average of the given {@code float} values.
     * 
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see #plus(float...) 
     */
    public static float average(float... values) {
        return plus(values) / (float) values.length;
    }
    
    /**
     * Returns the average of the given {@code double} values.
     * 
     * @param values the arguments that we will average
     * @return the average of the given values
     * @see #plus(double...) 
     */
    public static double average(double... values) {
        return plus(values) / (double) values.length;
    }
    
    /**
     * Returns the factorial of the {@code value} given. For every positive 
     * integer {@code x} then, {@code fact(x) == x!}. But, if {@code x} is 
     * negative then the factorial can't be calculated.
     * <p>
     * Special cases:
     * 
     * <ul>
     * 
     * <li>If the argument is negative, then the result can't be calculated.
     * 
     * <li>If the argument is zero, then the result is 1.
     * 
     * </ul>
     * @param value a value
     * @return the factorial of {@code value}
     * @throws IllegalArgumentException if the given argument is negative
     */
    public static long fact(long value) {
        if (value < 0)
            throw new IllegalArgumentException("the value can't be negative.");
        return value == 0 ? 1 : value * fact(value - 1);
    }
    
    /**
     * Returns the greatest common divisor of {@code a} and {@code b}, the given
     * {@code int} values.
     * 
     * <p>
     * Note that it does not consider the negative arguments.
     * 
     * @param a a value
     * @param b a value
     * @return the greatest common divisor of the given values
     */
    public static int gcd(int a, int b) {
        return b == 0 ? java.lang.Math.abs(a) : gcd(b, a % b);
    }
    
    /**
     * Returns the greatest common divisor of {@code a} and {@code b}, the given
     * {@code long} values.
     * 
     * <p>
     * Note that it does not consider the negative arguments.
     * 
     * @param a a value
     * @param b a value
     * @return the greatest common divisor of the given values
     */
    public static long gcd(long a, long b) {
        return b == 0 ? java.lang.Math.abs(a) : gcd(b, a % b);
    }
    
    /**
     * 
     * @param distint 
     * @param value a value
     * @return array of the prime factors
     */
    public static int[] getPrimeFactors(boolean distint, int value) {
        List<Integer> primesList = getPrimeFactorsList(distint, value);
        int[] primes = new int[primesList.size()];
        for (int i = 0; i < primesList.size(); i++) {
            primes[i] = primesList.get(i);
        }
        return primes;
    }
    
    /**
     * 
     * @param distint
     * @param value a value
     * @return array of the prime factors
     */
    public static long[] getPrimeFactors(boolean distint, long value) {
        List<Long> primesList = getPrimeFactorsList(distint, value);
        long[] primes = new long[primesList.size()];
        for (int i = 0; i < primesList.size(); i++) {
            primes[i] = primesList.get(i);
        }
        return primes;
    }
    
    /**
     * 
     * @param distint 
     * @param value a value
     * @return list of the prime factors
     */
    public static List<Integer> getPrimeFactorsList(boolean distint, int value) {
        List<Integer> primes = new ArrayList<Integer>();
        int temp = value, div = 2;
        while (temp > 1) {
            if (temp % div == 0) {
                temp /= div;
                if (distint && primes.contains(div))
                    continue;
                primes.add(div);
            } else {
                div++;
            }
        }
        return primes;
    }
    
    /**
     * 
     * @param distint
     * @param value a value
     * @return list of the prime factors
     */
    public static List<Long> getPrimeFactorsList(boolean distint, long value) {
        List<Long> primes = new ArrayList<Long>();
        long temp = value, div = 2;
        while (temp > 1) {
            if (temp % div == 0) {
                temp /= div;
                if (distint && primes.contains(div))
                    continue;
                primes.add(div);
            } else {
                div++;
            }
        }
        return primes;
    }
    
    /**
     * Return {@code true} if {@code a} and {@code b} is relatively primes.
     * 
     * @param a a value
     * @param b a value
     * @return true, if {@code a} and {@code b} is relatively primes.
     * @see #gcd(int, int) 
     * @see #isPrime(int) 
     */
    public static boolean isCoprime(int a, int b) {
        return gcd(a, b) == 1;
    }
    
    /**
     * Return {@code true} if {@code a} and {@code b} is relatively primes.
     * 
     * @param a a value
     * @param b a value
     * @return true, if {@code a} and {@code b} is relatively primes.
     * @see #gcd(long, long) 
     * @see #isPrime(long) 
     */
    public static boolean isCoprime(long a, long b) {
        return gcd(a, b) == 1L;
    }
    
    /**
     * Returns {@code true} if the given number is prime.
     * 
     * <p>
     * This method uses primality test algorithm of Lucas-Lehmer for 
     * Mersenne numbers.
     * 
     * @param value a value
     * @return true, if number is prime.
     */
    public static boolean isPrime(int value) {
        if (value < 4)
            return value > 1;
        if (value % 2 == 0 || value % 3 == 0)
            return false;
        else {
            for (int i = 5; i * i <= value; i += 6) {
                if (value % i == 0 || value % (i + 2) == 0)
                    return false;
            }
        }
        return true;
    }
    
    /**
     * Returns {@code true} if the given number is prime.
     * 
     * <p>
     * This method uses primality test algorithm of Lucas-Lehmer for 
     * Mersenne numbers.
     * 
     * @param value a value
     * @return true, if number is prime.
     */
    public static boolean isPrime(long value) {
        if (value < 4)
            return value > 1;
        if (value % 2 == 0 || value % 3 == 0)
            return false;
        else {
            for (int i = 5; i * i <= value; i += 6) {
                if (value % i == 0 || value % (i + 2) == 0)
                    return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the sum of all {@code int} values.
     * 
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static int plus(int... values) {
        int plus = 0;
        for (int value : values) {
            plus += value;
        }
        return plus;
    }
    
    /**
     * Returns the sum of all {@code long} values.
     * 
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static long plus(long... values) {
        long plus = 0L;
        for (long value : values) {
            plus += value;
        }
        return plus;
    }
    
    /**
     * Returns the sum of all {@code float} values.
     * 
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static float plus(float... values) {
        float plus = 0f;
        for (float value : values) {
            plus += value;
        }
        return plus;
    }
    
    /**
     * Returns the sum of all {@code double} values.
     * 
     * @param values the arguments to be plus
     * @return the sum of all arguments
     */
    public static double plus(double... values) {
        double plus = 0d;
        for (double value : values) {
            plus += value;
        }
        return plus;
    }
    
}
