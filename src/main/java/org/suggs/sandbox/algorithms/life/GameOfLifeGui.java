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


public class GameOfLifeGui extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(GameOfLifeGui.class);
    private static final int SIZE = 320;
    private static final int HEIGHT = 10;
    private static final int WIDTH = 10;
    private final Timeline timeline;
    private static final Duration PAUSE_LENGTH = Duration.millis(100);

    public GameOfLifeGui() {
        KeyFrame pauseKeryFrame = new KeyFrame(PAUSE_LENGTH);
        KeyFrame changeKeyFrame = new KeyFrame(Duration.ZERO, event -> iterateBoard());
        timeline = new Timeline(changeKeyFrame, pauseKeryFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        LOG.debug("Creating a grid sized: {}x{}", SIZE/HEIGHT, SIZE/WIDTH);
        Pane rootPane = new Pane();
        Scene scene = new Scene(rootPane, SIZE, SIZE);
        scene.getStylesheets().add("gameoflife.css");

        for (int y = 0; y < SIZE; y = y + HEIGHT) {
            for (int x = 0; x < SIZE; x = x + WIDTH) {
                rootPane.getChildren().add(createDeadCell(x, y));
            }
        }

        rootPane.getChildren().add(createAliveCell(10,0));

        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }

    private void iterateBoard() {
    }


    private StackPane createDeadCell(int x, int y) {
        StackPane stackPane = new StackPane();
        stackPane.setLayoutX(x);
        stackPane.setLayoutY(y);
        stackPane.setPrefHeight(HEIGHT);
        stackPane.setPrefWidth(WIDTH);
        stackPane.setId("dead-cell");
        return stackPane;
    }

    private StackPane createAliveCell(int x, int y) {
        StackPane stackPane = new StackPane();
        stackPane.setLayoutX(x);
        stackPane.setLayoutY(y);
        stackPane.setPrefHeight(HEIGHT);
        stackPane.setPrefWidth(WIDTH);
        stackPane.setId("alive-cell");
        return stackPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
