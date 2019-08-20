package com.lxf;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenUtil {
    /**
     * 获取主屏幕尺寸
     */
    public static Rectangle2D getPrimaryBounds(){
        Screen primary = Screen.getPrimary();
        return primary.getBounds();
    }

    /**
     * 获取主屏幕视觉尺寸（除去状态栏）
     */
    public static Rectangle2D getVisualBounds(){
        Screen primary = Screen.getPrimary();
        return primary.getVisualBounds();
    }

    /**
     * 获取屏幕截图
     */
    public static WritableImage getScreenImg(Rectangle rectangle){
        //得到选区宽高
        //截图
        try {
            Robot robot =  new Robot();
            BufferedImage screenCapture = robot.createScreenCapture(rectangle);
            return SwingFXUtils.toFXImage(screenCapture, null);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return null;
    }
}
