/*
 * Copyright 2016 Gustavo Pacheco <ryctabo@gmail.com>.
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
 * @author Gustavo Pacheco <ryctabo@gmail.com>
 * @version 1.0-SNAPSHOT
 */
public class Rank {
    
    private double max;
    
    private double min;

    /**
     * Create new rank with max and min values.
     * 
     * @param max the max value
     * @param min the min value
     */
    public Rank(double max, double min) {
        this.max = max;
        this.min = min;
    }

    /**
     * Return {@code true}, if the given value is inside rank.
     * 
     * <p>
     * The rank that checks this method is [min, max) where the min value is 
     * closed and the max value is open.
     * 
     * @param value a value
     * @return true, if the given value is inside rank.
     */
    public boolean isInsideRank(double value) {
        return value >= min && value < max;
    }
    
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

}
