package org.suggs.sandbox.algorithms.unionfind;

public class QuickUnionTest extends AbstractUnionFindTest {

    @Override
    UnionFind createUnionFindVariant() {
        return new QuickUnion(10);
    }
}
