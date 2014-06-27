package org.suggs.sandbox.algorithms.life;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GridTest {

    private static final Logger LOG = LoggerFactory.getLogger(GridTest.class);
    public static final int GRID_SIZE = 5;
    private GridBuilder gridBuilder;

    @Before
    public void setup() {
        gridBuilder = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                );
    }

    @Test
    public void initialisesAsASquareGridOfDeadCells() {
        Grid grid = gridBuilder.build();
        assertThat(grid.getDeadCellCount(), is(GRID_SIZE * GRID_SIZE));
    }

    @Test
    public void canResurrectCells() {
        Grid grid = gridBuilder.build();
        grid.resurrectCellAt(0, 0);
        assertThat(grid.isAliveAt(0, 0), is(true));
    }

    @Test
    public void canKillCells() {
        Grid grid = gridBuilder.build();
        grid.resurrectCellAt(1, 2);
        grid.killCellAt(1, 2);
        assertThat(grid.isDeadAt(1, 2), is(true));
    }

    @Test
    public void killingADeadCellStaysDead() {
        Grid grid = gridBuilder.build();
        grid.killCellAt(0, 0);
        assertThat(grid.isDeadAt(0, 0), is(true));
    }

    @Test
    public void canCountAliveCellsAroundACellWhenInMiddleOfTheGrid() {
        Grid grid = gridBuilder
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                "...@.\n" +
                                "..@..\n" +
                                ".....\n"
                )
                .build();

        assertThat(grid.countSurroundingLiveCellsFrom(3, 3), is(2));
    }

    @Test
    public void canCountAliveCellsAroundACellWhenAtACornerOfTheGrid() {
        Grid grid = gridBuilder
                .fromStringGrid(".@...\n" +
                                "@@...\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                )
                .build();
        assertThat(grid.countSurroundingLiveCellsFrom(0, 0), is(3));
    }

    @Test
    public void canCountAliveCellsAroundACellWhenAtTheCloseEdgeOfTheGrid() {
        Grid grid = gridBuilder
                .fromStringGrid("..@.@\n" +
                                "..@@@\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                )
                .build();
        assertThat(grid.countSurroundingLiveCellsFrom(3, 0), is(5));
    }

    @Test
    public void canCountAliveCellsAroundACellWhenAtTheFarEdgeOfTheGrid() {
        Grid grid = gridBuilder
                .fromStringGrid("...@@\n" +
                                "...@.\n" +
                                "...@@\n" +
                                ".....\n" +
                                ".....\n"
                )
                .build();
        assertThat(grid.countSurroundingLiveCellsFrom(4, 1), is(5));
    }

    @Test
    public void dumpsTheGridToAString() {
        String gridExample = "..@.@\n" +
                "..@@@\n" +
                ".....\n" +
                ".....\n" +
                ".....\n";

        Grid grid = gridBuilder
                .fromStringGrid(gridExample)
                .build();
        LOG.debug("Grid dumped:\n" + grid.toString());
        assertThat(grid.toString(), equalTo(gridExample));
    }
}
