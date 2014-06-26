package org.suggs.sandbox.algorithms.unionfind;

public class WeightedQuickUnionTest extends AbstractUnionFindTest {

    @Override
    UnionFind createUnionFindVariant() {
        return new WeightedQuickUnion(10);
    }
}
