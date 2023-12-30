package com.example.work;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class Application extends javafx.application.Application {

    private double xOffset;
    private double yOffset;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        Image ico = new Image(String.valueOf(getClass().getResource("img/fest.png")));
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Scene scene = new Scene(root);//розміри панелі в сценБілдері
            stage.setTitle("!Fest");
            stage.setResizable(false);//не можна змінювати розміри панелі
            stage.getIcons().add(ico);
            stage.initStyle(StageStyle.UNDECORATED);//приховує віндовську панель close and mini\maxi mized
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);

            //рухає панель в будь якому місці дотику
            scene.setOnMousePressed(event -> {
                xOffset = stage.getX() - event.getScreenX();
                yOffset = stage.getY() - event.getScreenY();
            });
            //Lambda mouse event handler
            scene.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() + xOffset);
                stage.setY(event.getScreenY() + yOffset);
            });
            //тут код, всьо..

            stage.setScene(scene);
            stage.show();

        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e + "sukaa");
        }

    }
}