package org.suggs.sandbox.algorithms.unionfind;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


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
        assertThat(unionFind.connected(0, 1)).isFalse();
        LOG.debug(getClass().getSimpleName() + " with no connections: {}", unionFind.toString());
    }

    @Test
    public void hasConnectionsAfterUnion() {
        unionFind.union(0, 1);
        LOG.debug(getClass().getSimpleName() + " with a single connection: {}", unionFind.toString());
        assertThat(unionFind.connected(0, 1)).isTrue();
    }

    @Test
    public void supportsTransitiveUnions() {
        unionFind.union(0, 1);
        unionFind.union(1, 2);
        LOG.debug(getClass().getSimpleName() + " with a transitive connection: {}", unionFind.toString());
        assertThat(unionFind.connected(0, 2)).isTrue();
    }

    @Test
    public void supportsRecuriveUnions() {
        unionFind.union(0, 1);
        unionFind.union(1, 2);
        unionFind.union(2, 3);
        unionFind.union(3, 0);
        LOG.debug(getClass().getSimpleName() + " with a recursive connection: {}", unionFind.toString());
        assertThat(unionFind.connected(1, 3)).isTrue();
    }
}
