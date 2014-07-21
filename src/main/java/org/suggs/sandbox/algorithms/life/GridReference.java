package org.suggs.sandbox.algorithms.life;

public class GridReference {

    private final int x;
    private final int y;

    private GridReference(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static GridReference referenceOf(int x, int y) {
        return new GridReference(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GridReference that = (GridReference) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
