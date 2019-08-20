package com.lxf.shot;

import com.lxf.ClipUtil;
import com.lxf.ScreenUtil;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.awt.*;

public class ShotScene extends Scene {
    private double startX;
    private double startY;
    private GraphicsContext graphics;

    private ShotScene(ShotPage root) {
        super(root);
        graphics = root.getGraphics();
    }

    public static ShotScene newInstance() {
        ShotPage page = new ShotPage();
        ShotScene scene = new ShotScene(page);
        scene.getStylesheets().add("shot/shot.css");
        scene.setFill(Paint.valueOf("#00000000"));

        return scene;
    }

    public void drag() {
        drag((ShotPage) getRoot());
    }

    private void drag(ShotPage page) {
        page.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                startX = mouseEvent.getSceneX();
                startY = mouseEvent.getSceneY();
            }
        });

        page.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                page.startFullDrag();
            }
        });

        page.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                //拖拽过程
                double endX = mouseDragEvent.getSceneX();
                double endY = mouseDragEvent.getSceneY();
                graphics.clearRect(0, 0, page.getWidth(), page.getHeight());
                graphics.fillRect(0, 0, page.getWidth(), page.getHeight());
                graphics.clearRect(startX, startY, endX - startX, endY - startY);
                graphics.strokeRect(startX, startY, endX - startX, endY - startY);
            }
        });

        page.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                //拖拽结束
                double endX = mouseDragEvent.getSceneX();
                double endY = mouseDragEvent.getSceneY();

                Rectangle rectangle = new Rectangle();
                rectangle.setBounds((int) startX, (int) startY, (int) (endX - startX), (int) (endY - startY));
                WritableImage image = ScreenUtil.getScreenImg(rectangle);
                if (image!=null){
                    ClipUtil.putImage(image);
                }
            }
        });
    }
}
