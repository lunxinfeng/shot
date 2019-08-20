package com.lxf.shot;

import com.lxf.ScreenUtil;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class ShotPage extends AnchorPane {
    private GraphicsContext graphics;

    ShotPage(){
        Rectangle2D visualBounds = ScreenUtil.getPrimaryBounds();
        Canvas canvas = new Canvas(visualBounds.getWidth(), visualBounds.getHeight());
        graphics = canvas.getGraphicsContext2D();
        graphics.setFill(Paint.valueOf("#00000080"));
        graphics.setStroke(Color.GREEN);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        getChildren().addAll(canvas);
    }

    public GraphicsContext getGraphics() {
        return graphics;
    }
}
