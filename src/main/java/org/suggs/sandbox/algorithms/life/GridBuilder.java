package org.suggs.sandbox.algorithms.life;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GridBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(GridBuilder.class);
    public static final char ALIVE_CHARACTER = '@';
    private int gridSize;
    private String exampleGrid;

    private GridBuilder() {
    }

    public static GridBuilder aGrid() {
        return new GridBuilder();
    }

    public GridBuilder withSquareSizeOf(int aGridSize) {
        gridSize = aGridSize;
        return this;
    }

    public GridBuilder fromStringGrid(String aStringGrid) {
        exampleGrid = aStringGrid;
        return this;
    }

    public Grid build() {
        Grid grid = new Grid(gridSize);
        String[] lines = exampleGrid.split("\n");
        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == ALIVE_CHARACTER) {
                    grid.resurrectCellAt(x, y);
                }
            }
        }
        return grid;
    }
}
