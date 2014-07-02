package org.suggs.sandbox.algorithms.life;

public class GameOfLife {
    private Grid grid;

    public GameOfLife(Grid aStartingGrid) {
        grid = aStartingGrid;
    }

    public Grid iterate() {
        Grid newGrid = new Grid(grid.getSize());
        for (int y = 0; y < newGrid.getSize(); y++) {
            for (int x = 0; x < newGrid.getSize(); x++) {
                int aliveCellCount = grid.countSurroundingLiveCellsFrom(x, y);
                if (grid.isDeadAt(x, y) && aliveCellCount == 3) {
                    newGrid.giveBirthToCellAt(x, y);
                } else if (grid.isAliveAt(x, y) && (aliveCellCount == 2 || aliveCellCount == 3)) {
                    newGrid.cellStaysAliveAt(x, y);
                } else {
                    newGrid.cellIsDeadAt(x, y);
                }
            }
        }
        grid = newGrid;
        return newGrid;
    }
}
