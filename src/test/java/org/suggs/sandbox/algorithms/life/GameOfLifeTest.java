package org.suggs.sandbox.algorithms.life;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GameOfLifeTest {

    private static int GRID_SIZE = 5;

    @Test
    public void resurrectsCellsWithThreeNeighbours(){
        Grid gridBefore = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid("...@.\n" +
                                ".....\n" +
                                ".@@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                "..@..\n" +
                                ".....\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        GameOfLife game = new GameOfLife(gridBefore);
        assertThat(game.iterate(), equalTo(gridAfter));
    }

    @Test
    public void retainsAliveCellsWithTwoLiveNeighbours(){
        Grid gridBefore = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                "...@.\n" +
                                "..@..\n" +
                                ".@...\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                ".....\n" +
                                "..@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        GameOfLife game = new GameOfLife(gridBefore);
        assertThat(game.iterate(), equalTo(gridAfter));
    }

    @Test
    public void retainsAliveCellsWithThreeNeighbours(){
        Grid gridBefore = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                ".@.@.\n" +
                                "..@..\n" +
                                ".@...\n" +
                                ".....\n"
                ).build();
        Grid gridAfter = aGrid()
                .withSquareSizeOf(GRID_SIZE)
                .fromStringGrid(".....\n" +
                                "..@..\n" +
                                ".@@..\n" +
                                ".....\n" +
                                ".....\n"
                ).build();
        GameOfLife game = new GameOfLife(gridBefore);
        assertThat(game.iterate(), equalTo(gridAfter));
    }




}