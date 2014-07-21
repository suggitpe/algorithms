package org.suggs.sandbox.algorithms.life;

import java.io.IOException;

import static org.suggs.sandbox.algorithms.life.GameOfLife.iterateGameOfLifeGrid;
import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GameOfLifeSimulator {

    public static void main(String[] args) throws IOException {
        Grid grid = aGrid()
                .fromStringGrid(buildStartingGridExample())
                .build();

        int i = 0;
        do {
            grid = iterateGameOfLifeGrid(grid);
            Runtime.getRuntime().exec("clear");
            System.out.println("--------------------");
            System.out.println("Iteration: " + ++i);
            System.out.println(grid);
            pause(1);
        } while (true);
    }

    private static String buildStartingGridExample() {
        return "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..@.......\n" +
                "..@@......\n" +
                ".@.@......\n";
    }

    private static void pause(int i) {
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            // nadda
        }
    }
}
