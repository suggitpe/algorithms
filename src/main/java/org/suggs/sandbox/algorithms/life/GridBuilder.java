package org.suggs.sandbox.algorithms.life;

public class GridBuilder {

    public static final char ALIVE_CHARACTER = '@';
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

    public Grid build() {
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
