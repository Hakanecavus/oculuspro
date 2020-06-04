package application;

import controller.MasterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller extends AnchorPane implements Initializable {
    @FXML
    TextField kullaniciAdi;
    @FXML
    PasswordField sifre;
    public MasterController cnt = new MasterController();


    public void handle(ActionEvent event) throws IOException {
        String tempPass;
        String tempID;
        if (kullaniciAdi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kullanıcı adı boş olamaz", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        } else if (sifre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Şifre boş olamaz", "Hata!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            tempID = kullaniciAdi.getText();
            tempPass = sifre.getText();

            if (cnt.checkLogin(tempID, tempPass)) {
                Stage mainStage = Main.parentWindow;
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
                mainStage.setScene(scene);

            } else
                JOptionPane.showMessageDialog(null, "Kullanıcı adı veya Şifre Yanlış", "Hata!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handle2(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            String tempPass;
            String tempID;
            if (kullaniciAdi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kullanıcı adı boş olamaz", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            } else if (sifre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Şifre boş olamaz", "Hata!", JOptionPane.INFORMATION_MESSAGE);

            } else {
                tempID = kullaniciAdi.getText();
                tempPass = sifre.getText();

                if (cnt.checkLogin(tempID, tempPass)) {
                    Stage mainStage = Main.parentWindow;
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
                    mainStage.setScene(scene);

                } else
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı veya Şifre Yanlış", "Hata!", JOptionPane.ERROR_MESSAGE);
            }


        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


}
	

