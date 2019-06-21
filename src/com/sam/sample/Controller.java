package com.sam.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {


    @FXML
    public void Exit(ActionEvent event) {
        System.out.println("Exiting level editor");
        System.exit(0);
    }

    @FXML
    public void Load(ActionEvent event) {
        System.out.println("Loading");
    }

    @FXML
    public void MakeNew(ActionEvent event) {
        System.out.println("Creating new document");
    }

    @FXML
    public void Save(ActionEvent event) {
        System.out.println("Saving");
    }
}
