package org.suggs.sandbox.algorithms.unionfind;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public abstract class AbstractUnionFindTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractUnionFindTest.class);
    private UnionFind unionFind;

    @Before
    public void setup() {
        unionFind = createUnionFindVariant();
    }

    abstract UnionFind createUnionFindVariant();

    @Test
    public void hasNoConnectionsOnInitialisation() {
        assertThat(unionFind.connected(0, 1), is(not(true)));
        LOG.debug("Union Find with no connections: {}", unionFind.toString());
    }

    @Test
    public void hasConnectionsAfterUnion() {
        unionFind.union(0, 1);
        assertThat(unionFind.connected(0, 1), is(true));
        LOG.debug("UnionFind with a single connection: {}", unionFind.toString());
    }

}
