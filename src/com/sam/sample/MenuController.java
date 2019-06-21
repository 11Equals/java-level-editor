package com.sam.sample;

import com.sam.sample.level.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class MenuController {

    @FXML
    public void exit(ActionEvent event) {
        System.out.println("Exiting level editor");
        System.exit(0);
    }

    @FXML
    public void open(ActionEvent event) {
        System.out.println("Menu option selected: Open");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open level editor file");
        com.sam.sample.level.File file = new com.sam.sample.level.File(fileChooser.showOpenDialog(null), File.Action.OPEN);

        if (file.raw != null) {
            Main.eventBus.post(file);
        }
    }

    @FXML
    public void makeNew(ActionEvent event) {
        System.out.println("Menu option selected: New");
    }

    @FXML
    public void save(ActionEvent event) {
        System.out.println("Menu option selected: Save");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save level editor file");
        com.sam.sample.level.File file = new com.sam.sample.level.File(fileChooser.showSaveDialog(null), File.Action.SAVE);
        fileChooser.setInitialDirectory();

        if (file.raw != null) {
            Main.eventBus.post(file);
        }
    }
}
