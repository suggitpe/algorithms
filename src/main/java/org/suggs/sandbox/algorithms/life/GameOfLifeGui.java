package org.suggs.sandbox.algorithms.life;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.suggs.sandbox.algorithms.life.GameOfLife.iterateGameOfLifeGrid;
import static org.suggs.sandbox.algorithms.life.GridBuilder.aGrid;
import static org.suggs.sandbox.algorithms.life.GridReference.referenceOf;


public class GameOfLifeGui extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(GameOfLifeGui.class);
    private static final int CELL_SIZE = 10;
    private static final int CELL_COUNT = 64;
    private static final int SIZE = CELL_COUNT * CELL_SIZE;
    private final Timeline timeline;
    private static final int PAUSE_LENGTH = 100;
    private Map<GridReference, StackPane> cellMap = new HashMap<GridReference, StackPane>();

    private Grid grid = aGrid()
            .withASizeOf(CELL_COUNT)
            .withAliveDensityOf(0.4)
            .build();
    private Pane rootPane;

    public GameOfLifeGui() {
        KeyFrame pauseKeyFrame = new KeyFrame(Duration.millis(PAUSE_LENGTH));
        KeyFrame changeKeyFrame = new KeyFrame(Duration.ZERO, event -> iterateBoard());
        timeline = new Timeline(changeKeyFrame, pauseKeyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        LOG.debug("Creating a grid sized: {}x{}", CELL_COUNT, CELL_COUNT);
        rootPane = new Pane();
        Scene scene = new Scene(rootPane, SIZE, SIZE);
        scene.getStylesheets().add("gameoflife.css");

        populatePaneWithGrid();

        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }

    private void populatePaneWithGrid() {
        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                StackPane cell = createDeadCellAt(x, y);
                cellMap.put(referenceOf(x, y), cell);
                rootPane.getChildren().add(cell);
            }
        }
    }

    private void iterateBoard() {
        LOG.info("Iterating");
        grid = iterateGameOfLifeGrid(grid);
        for (int y = 0; y < CELL_COUNT; y++) {
            for (int x = 0; x < CELL_COUNT; x++) {
                if (grid.isAliveAt(x, y)) {
                    cellMap.get(referenceOf(x, y)).setId("alive-cell");
                } else {
                    cellMap.get(referenceOf(x, y)).setId("dead-cell");
                }
            }
        }

    }

    private StackPane createDeadCellAt(int x, int y) {
        StackPane cell = createCellAt(x, y);
        cell.setId("dead-cell");
        return cell;
    }

    private StackPane createCellAt(int x, int y) {
        StackPane stackPane = new StackPane();
        stackPane.setLayoutX(x * CELL_SIZE);
        stackPane.setLayoutY(y * CELL_SIZE);
        stackPane.setPrefHeight(CELL_SIZE);
        stackPane.setPrefWidth(CELL_SIZE);
        stackPane.setId("dead-cell");
        return stackPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
