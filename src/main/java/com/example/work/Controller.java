package com.example.work;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller extends Application{
    static String nameProgram;

    static void errorAlert(String Errores){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Have an Error");
        alert.setHeaderText(Errores + " ");
        alert.setContentText("Швидше за все, програма не інстальована або не вірний шлях");
        alert.showAndWait().ifPresent(wait -> {
            if (wait == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }
    static void iNFORM(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Have an INFORMATION");
        alert.setHeaderText("Дані збережено у файлі.");
        alert.showAndWait().ifPresent(wait -> {
        });
    }


    @FXML
    void minimized(MouseEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.setIconified(true);
    }

   @FXML
    void close(MouseEvent event){
       final Node source = (Node) event.getSource();
       final Stage stage = (Stage) source.getScene().getWindow();
       stage.close();
    }

    public static void saveDataToFile(String data) {

       String user = System.getProperty("user.name");

        System.out.println();
        try {
            File file = new File("C:/Users/" + user + "/Documents/" + nameProgram + ".txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);

            bufferedWriter.close();
            fileWriter.close();
            iNFORM();
        } catch (IOException e) {
            errorAlert(e.getMessage());
        }
    }


    public static String readDataFromFile() {

        String user = System.getProperty("user.name");

        StringBuilder content = new StringBuilder();
        try {
            File file = new File("C:/Users/" + user + "/Documents/" + nameProgram + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line); // Додавання рядка до змінної content
            }

                bufferedReader.close();
                fileReader.close();


        } catch (IOException e) {
            errorAlert(e.getMessage());
        }
        return content.toString();
    }

    public void chose(MouseEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        FileChooser.ExtensionFilter ex1 = new FileChooser.ExtensionFilter("*.ExE type ", "*.exe");
        FileChooser.ExtensionFilter ex2 = new FileChooser.ExtensionFilter("*.RDP type ", "*.rdp");


        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("open program");
        fileChooser.getExtensionFilters().addAll(ex1, ex2);
        fileChooser.setInitialDirectory(new File("C:\\Program Files"));

        File selectedfile = fileChooser.showOpenDialog(stage);

        String path;
        assert selectedfile != null;
        path = selectedfile.getPath();

        saveDataToFile(path); // зберігає шлях
    }
    @FXML
    public String StartANY(MouseEvent event) {
        nameProgram = "pathAnyDesk";

        String fileData = readDataFromFile(); // Отримання даних з файлу

        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  fileData + " ");
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }

return nameProgram;

    }

    @FXML
    String StartRDS(MouseEvent event) {
        nameProgram = "pathRDS";
        String fileData = readDataFromFile(); // Отримання даних з файлу
        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  "cmd.exe /C" + fileData);
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }
        return nameProgram;
    }


    @FXML
    String StartSkype(MouseEvent event) {
        nameProgram = "pathSkype";
        String fileData = readDataFromFile(); // Отримання даних з файлу

        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  fileData + " ");
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }

        return nameProgram;
       
    }
    @FXML
    String StartTG(MouseEvent event) {
        nameProgram = "pathTelegram";
        String fileData = readDataFromFile(); // Отримання даних з файлу
        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  fileData + " ");
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }
        return nameProgram;
    }

    @FXML
    String StartSteam(MouseEvent event){
        nameProgram = "pathSteam";
        String fileData = readDataFromFile(); // Отримання даних з файлу
        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  fileData + " ");
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }
        return nameProgram;
    }

    @FXML
    String StartTeamView(MouseEvent event) {
        nameProgram = "pathTeamVieW";
        String fileData = readDataFromFile(); // Отримання даних з файлу
        if (fileData.equals("")){
            chose(event);
        } else {
            Runtime rs = Runtime.getRuntime();
            try {
                rs.exec(  fileData + " ");
            } catch (IOException e) {
                errorAlert(e.getMessage());
            }
        }
        return nameProgram;
    }
}