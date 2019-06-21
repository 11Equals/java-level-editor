package com.sam.sample;

import com.google.common.eventbus.*;

import com.sam.sample.level.Data;
import com.sam.sample.level.Load;
import com.sam.sample.level.Save;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    private static Scene mainScene;
    //static EventBusFileListener fileListener;
    static EventBus eventBus;

    private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
    private double windowWidth = screenSize.getWidth() / 2.0;
    private double windowHeight = screenSize.getHeight() / 2.0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //EventBus eventBus = new EventBus();
        eventBus = new EventBus();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root, windowWidth, windowHeight));
        Scene scene = primaryStage.getScene();
        mainScene = scene;

        //scene.getStylesheets().add("com/sam/sample/style.xsl");
        scene.getStylesheets().add("com/sam/sample/layoutstyles.css");

        {   // grid
            final GridPane grid = (GridPane) scene.lookup("#container");
            //grid.setPrefWidth(windowWidth);
            //grid.setPrefHeight(windowHeight);
            //grid.setMinWidth(windowWidth);
            //grid.setMinHeight(windowHeight);
            grid.lookup("#button_none").getStyleClass().add("hbox");
        }

        primaryStage.show();

        EventBusFileListener fileListener = new EventBusFileListener();
        eventBus.register(fileListener);
        eventBus.post("I tried it out");
    }


    public static void main(String[] args) {
        launch(args);


    }

    class EventBusFileListener {
        @Subscribe
        public void onFileAction(com.sam.sample.level.File file) {
            System.out.println("On file: " + file.raw.getName());

            switch (file.action) {
                case OPEN: {
                    System.out.println("Opening file");
                    Load load = new Load(file);
                    break;
                }
                case SAVE: {
                    System.out.println("Saving file");
                    file.data = new Data("My other hello");
                    Save save = new Save(file);
                    break;
                }
            }
        }

        @Subscribe
        public void handleDeadEvent(DeadEvent deadEvent) {
            System.out.println("Dead event: ");
        }
    }
}
