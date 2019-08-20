package com.lxf.home;

import com.lxf.shot.ShotScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeScene extends Scene {

    private HomeScene(HomePage root) {
        super(root);
    }

    public static HomeScene newInstance() {
        HomePage page = new HomePage();
        HomeScene scene = new HomeScene(page);
        KeyCombination keyCombination = KeyCodeCombination.valueOf("ctrl + alt + A");
        Mnemonic mnemonic = new Mnemonic(page.getButton(), keyCombination);
        scene.addMnemonic(mnemonic);

        page.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                shot((Stage) scene.getWindow(), true);
            }
        });
        return scene;
    }

    private static void shot(Stage self, boolean hideSelf) {
        self.setIconified(hideSelf);

        ShotScene scene = ShotScene.newInstance();
        scene.drag();

        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.show();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ESCAPE) {
                    stage.close();
                    self.setIconified(false);
                }
            }
        });
    }
}
