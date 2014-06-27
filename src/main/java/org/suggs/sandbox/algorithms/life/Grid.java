package org.suggs.sandbox.algorithms.life;

public class Grid {

    private final int gridSize;
    private final boolean[][] grid;

    public Grid(int size) {
        gridSize = size;
        grid = new boolean[size][size];
    }

    public int getDeadCellCount() {
        int deadCellCount = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == false) {
                    deadCellCount++;
                }
            }
        }
        return deadCellCount;
    }

    public void resurrectCellAt(int x, int y) {
        grid[x][y] = true;
    }

    public void killCellAt(int x, int y) {
        grid[x][y] = false;
    }

    public boolean isAliveAt(int x, int y) {
        if (x < 0 || y < 0 || x >= gridSize || y >= gridSize) {
            return false;
        }
        return grid[x][y];
    }

    public boolean isDeadAt(int x, int y) {
        return !isAliveAt(x, y);
    }

    public int countSurroundingLiveCellsFrom(int x, int y) {
        int liveCells = 0;
        liveCells += isAliveAt(x - 1, y - 1) ? 1 : 0;
        liveCells += isAliveAt(x, y - 1) ? 1 : 0;
        liveCells += isAliveAt(x + 1, y - 1) ? 1 : 0;
        liveCells += isAliveAt(x - 1, y) ? 1 : 0;
        liveCells += isAliveAt(x + 1, y) ? 1 : 0;
        liveCells += isAliveAt(x - 1, y + 1) ? 1 : 0;
        liveCells += isAliveAt(x, y + 1) ? 1 : 0;
        liveCells += isAliveAt(x + 1, y + 1) ? 1 : 0;
        return liveCells;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (isAliveAt(x, y)) {
                    builder.append("@");
                } else {
                    builder.append(".");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public int getSize() {
        return gridSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Grid grid = (Grid) o;
        if (toString().equals(grid.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return gridSize;
    }
}
