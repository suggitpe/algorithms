package org.suggs.sandbox.algorithms.unionfind;

public class QuickFindTest extends AbstractUnionFindTest {

    @Override
    UnionFind createUnionFindVariant() {
        return new QuickFind(10);
    }
}
