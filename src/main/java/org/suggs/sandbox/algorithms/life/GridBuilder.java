package org.suggs.sandbox.algorithms.life;

public class GridBuilder {

    public static final char ALIVE_CHARACTER = '@';
    private int gridSize = 10;
    private double aliveDensity = 0.0;
    private String exampleGrid;

    private GridBuilder() {
    }

    public static GridBuilder aGrid() {
        return new GridBuilder();
    }

    public GridBuilder fromStringGrid(String aStringGrid) {
        exampleGrid = aStringGrid;
        return this;
    }

    public GridBuilder withASizeOf(int aGridSize) {
        gridSize = aGridSize;
        return this;
    }

    public GridBuilder withAliveDensityOf(double anAliveDensity) {
        aliveDensity = anAliveDensity;
        return this;
    }

    public Grid build() {
        if (exampleGrid != null) {
            return buildGridFromExampleString();
        }
        return new Grid(gridSize, aliveDensity);
    }

    private Grid buildGridFromExampleString() {
        String[] lines = exampleGrid.split("\n");
        Grid grid = new Grid(lines[0].length());
        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == ALIVE_CHARACTER) {
                    grid.giveBirthToCellAt(x, y);
                }
            }
        }
        return grid;
    }
}
