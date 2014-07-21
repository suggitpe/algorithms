package org.suggs.sandbox.algorithms.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.random;

public class Grid {

    private static final Logger LOG = LoggerFactory.getLogger(Grid.class);
    private final int gridSize;
    private final boolean[][] grid;

    public Grid(int size) {
        gridSize = size;
        grid = new boolean[size][size];
    }

    public Grid(int size, double aliveDensity) {
        this(size);
        populateGridWithAliveDensity(aliveDensity);
    }

    private void populateGridWithAliveDensity(double aliveDensity) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (aliveDensity > random()) {
                    giveBirthToCellAt(x, y);
                }
            }
        }
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

    public int getAliveCellCount(){
        return (gridSize * gridSize) - getDeadCellCount();
    }

    public void giveBirthToCellAt(int x, int y) {
        grid[x][y] = true;
    }

    public void cellStaysAliveAt(int x, int y) {
        grid[x][y] = true;
    }

    public void cellIsDeadAt(int x, int y) {
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
        if (twoGridsMatch(grid)) {
            return true;
        }
        return false;
    }

    private boolean twoGridsMatch(Grid otherGrid) {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                if (grid[x][y] != otherGrid.grid[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return gridSize;
    }
}
