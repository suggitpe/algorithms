package org.suggs.sandbox.algorithms.life;

import java.io.IOException;

import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;

public class GameOfLifeSimulator {

    public static void main(String[] args) throws IOException {
        Grid startingGrid = aGrid()
                .fromStringGrid(buildStartingGridExample())
                .build();

        GameOfLife game = new GameOfLife(startingGrid);
        int i = 0;
        do {
            Grid nextLife = game.iterate();
            Runtime.getRuntime().exec("clear");
            System.out.println("--------------------");
            System.out.println("Iteration: " + ++i);
            System.out.println(nextLife);
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
