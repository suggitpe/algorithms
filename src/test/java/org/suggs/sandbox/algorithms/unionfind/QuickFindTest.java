package org.suggs.sandbox.algorithms.unionfind;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickFindTest {

    private static final Logger LOG = LoggerFactory.getLogger(QuickFindTest.class);

    private QuickFind unionFind;

    @Before
    public void setup() {
        unionFind = new QuickFind(10);
    }

    @Test
    public void initialises() {
        LOG.info(unionFind.dumpArray());
    }

    @Test
    public void runUnion() {
        unionFind.union(4, 3);
        unionFind.union(3, 8);
        unionFind.union(6, 5);
        unionFind.union(9, 4);
        unionFind.union(2, 1);
        LOG.info(unionFind.dumpArray());

        LOG.info("" + unionFind.connected(5, 0));
    }
}
