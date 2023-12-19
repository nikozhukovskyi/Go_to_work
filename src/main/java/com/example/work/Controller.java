package com.example.work;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

   @FXML
    void close(MouseEvent event){
       final Node source = (Node) event.getSource();
       final Stage stage = (Stage) source.getScene().getWindow();
       stage.close();
    }

    @FXML
    void StartANY() {
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("C:/Program Files (x86)/AnyDesk/AnyDesk.exe");
        } catch (IOException e) {
            System.out.println(e+" \\ "+" Nima");
        }
    }

    @FXML
    void StartRDS() {
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("cmd.exe /C C:/Users/Nico/Documents/festRDS.rdp");
        } catch (IOException e) {
            System.out.println(e+" \\ "+" Nima");
        }
    }

    @FXML
    void StartSkype() {
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("C:/Program Files (x86)/Microsoft/Skype for Desktop/Skype.exe");
        } catch (IOException e) {
            System.out.println(e+" \\ "+" Nima");
        }
    }
    @FXML
    void StartTG() {
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("C:/Users/Nico/AppData/Roaming/Telegram Desktop/Telegram.exe");
        } catch (IOException e) {
            System.out.println(e+" \\ "+" Nima");
        }
    }

    @FXML
    void StartTeamView() {
        Runtime rs = Runtime.getRuntime();
        try {
            rs.exec("C:/Program Files/TeamViewer/TeamViewer.exe");
        } catch (IOException e) {
            System.out.println(e+" \\ "+" Nima");
        }
    }

}