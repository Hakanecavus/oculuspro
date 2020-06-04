package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

public class Main extends Application {
    public static Stage parentWindow;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        parentWindow = stage;
        PrintStream out = new PrintStream(
                new FileOutputStream("output.txt", true), false);
        System.setOut(out);
        System.out.println("Program açıldı");
        LocalDateTime lt = LocalDateTime.now();

        System.out.println("LocalDateTime : " + lt);

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/loginPage.fxml")));
        stage.setScene(scene);
        stage.show();
        stage.setTitle("OculusPro | Optik Otomasyon Sistemi");
        stage.getIcons().add(new Image("file:oculus.png"));


    }
}
