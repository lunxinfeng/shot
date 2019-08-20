package com.lxf;

import com.lxf.home.HomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet("base.css");
        stage.setScene(HomeScene.newInstance());
        stage.setTitle("JavaFX截图");
        stage.setWidth(400);
        stage.setHeight(300);
        stage.setResizable(false);
        stage.show();
    }
}
