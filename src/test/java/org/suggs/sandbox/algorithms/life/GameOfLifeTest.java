package org.suggs.sandbox.algorithms.life;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.suggs.sandbox.algorithms.life.GameOfLife.iterateGameOfLifeGrid;
import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GameOfLifeTest {

    @Test
    public void killsCellsWithNoAliveNeighbours() {
        Grid gridBefore = aGrid()
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                "..@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        assertThat(iterateGameOfLifeGrid(gridBefore), equalTo(gridAfter));
    }

    @Test
    public void killsCellsWithLessThanTwoAliveNeighbours() {
        Grid gridBefore = aGrid()
                .fromStringGrid(".....\n" +
                                ".@@..\n" +
                                ".....\n" +
                                ".@@...\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        assertThat(iterateGameOfLifeGrid(gridBefore), equalTo(gridAfter));
    }

    @Test
    public void resurrectsCellsWithThreeAliveNeighbours() {
        Grid gridBefore = aGrid()
                .fromStringGrid("...@.\n" +
                                ".....\n" +
                                ".@@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .fromStringGrid(".....\n" +
                                "..@..\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        assertThat(iterateGameOfLifeGrid(gridBefore), equalTo(gridAfter));
    }

    @Test
    public void retainsAliveCellsWithTwoLiveNeighbours() {
        Grid gridBefore = aGrid()
                .fromStringGrid(".....\n" +
                                "...@.\n" +
                                "..@..\n" +
                                ".@...\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                "..@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        assertThat(iterateGameOfLifeGrid(gridBefore), equalTo(gridAfter));
    }

    @Test
    public void retainsAliveCellsWithThreeNeighbours() {
        Grid gridBefore = aGrid()
                .fromStringGrid(".....\n" +
                                ".@.@.\n" +
                                "..@..\n" +
                                ".@...\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .fromStringGrid(".....\n" +
                                "..@..\n" +
                                ".@@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        assertThat(iterateGameOfLifeGrid(gridBefore), equalTo(gridAfter));
    }


}
