/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph.functional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.baidu.hugegraph.driver.GraphsManager;
import com.baidu.hugegraph.structure.constant.GraphMode;
import com.baidu.hugegraph.testutil.Assert;

public class GraphModeTest extends BaseFuncTest {

    @Before
    public void setup() {
        graphs().mode(GRAPH, GraphMode.NONE);
    }

    @After
    public void teardown() throws Exception {
        graphs().mode(GRAPH, GraphMode.NONE);
    }

    @Test
    public void testGetGraphMode() {
        GraphsManager graphs = graphs();
        Assert.assertEquals(GraphMode.NONE, graphs.mode(GRAPH));
    }

    @Test
    public void testSetGraphMode() {
        GraphsManager graphs = graphs();
        graphs.mode(GRAPH, GraphMode.MERGING);
        Assert.assertEquals(GraphMode.MERGING, graphs.mode(GRAPH));
        graphs.mode(GRAPH, GraphMode.RESTORING);
        Assert.assertEquals(GraphMode.RESTORING, graphs.mode(GRAPH));
        graphs.mode(GRAPH, GraphMode.RESTORING);
        Assert.assertEquals(GraphMode.RESTORING, graphs.mode(GRAPH));
    }
}
