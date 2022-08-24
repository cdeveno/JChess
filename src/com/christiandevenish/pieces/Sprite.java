package com.christiandevenish.pieces;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    private final Image image;

    public Sprite(Image image) {
        this.image = image;
    }

    public void render(GraphicsContext gc, double x, double y) {
        gc.drawImage(image, x, y);
    }
}
