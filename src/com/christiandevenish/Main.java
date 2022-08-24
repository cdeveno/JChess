package com.christiandevenish;

import com.christiandevenish.board.Board;
import com.christiandevenish.game.Game;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static int WIDTH = 800, HEIGHT = 600;
    public static int boardLength = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();

        stage.setTitle("JChess");
        stage.setResizable(false);
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);

        Board board = new Board(root, boardLength);
        new Game(board);

        stage.show();
    }
}
