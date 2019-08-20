package com.lxf.home;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

class HomePage extends AnchorPane {
    private Button button;

    HomePage(){
        button = new Button();
        button.setText("点击截图");

        getChildren().addAll(button);
    }

    Button getButton() {
        return button;
    }
}
