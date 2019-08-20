package com.lxf;

import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class ClipUtil {
    public static void putImage(Image image){
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.putImage(image);
        clipboard.setContent(clipboardContent);
    }
}
