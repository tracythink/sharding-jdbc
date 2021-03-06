/**
 * Copyright 1999-2015 dangdang.com.
 * <p>
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
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.merger.aggregation;

import java.math.BigDecimal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class AvgAggregationUnitTest {
    
    @Test
    public void assertAvgAggregation() {
        AvgAggregationUnit avgAggregationUnit = new AvgAggregationUnit(BigDecimal.class);
        avgAggregationUnit.doMerge(10, 50);
        avgAggregationUnit.doMerge(10, 20);
        avgAggregationUnit.doMerge(5, 40);
        assertThat((BigDecimal) avgAggregationUnit.getResult(), is(new BigDecimal("4.4000")));
    }
    
    @Test
    public void assertDivideZero() {
        AvgAggregationUnit avgAggregationUnit = new AvgAggregationUnit(BigDecimal.class);
        avgAggregationUnit.doMerge(0, 50);
        avgAggregationUnit.doMerge(0, 20);
        avgAggregationUnit.doMerge(0, 40);
        assertThat((BigDecimal) avgAggregationUnit.getResult(), is(new BigDecimal(0)));
    }
}
