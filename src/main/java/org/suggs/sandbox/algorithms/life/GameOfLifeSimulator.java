package org.suggs.sandbox.algorithms.life;

import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GameOfLifeSimulator {

    public static void main(String[] args) {
        Grid startingGrid = aGrid()
                .withSquareSizeOf(10)
                .fromStringGrid(buildStartingGridExample())
                .build();

        GameOfLife game = new GameOfLife(startingGrid);
        int i = 0;
        do {
            Grid nextLife = game.iterate();
            System.out.println("--------------------");
            System.out.println("Iteration: " + ++i);
            System.out.println(nextLife);
            pause(1);
        } while (true);
    }

    private static String buildStartingGridExample() {
        StringBuilder grid = new StringBuilder();
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..........\n");
        grid.append("..@.......\n");
        grid.append("..@@......\n");
        grid.append(".@.@......\n");
        return grid.toString();
    }

    private static void pause(int i) {
        try {
            Thread.sleep(i*100);
        } catch (InterruptedException e) {
            // nadda
        }
    }
}