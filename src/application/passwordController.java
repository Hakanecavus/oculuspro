package application;

import controller.MasterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class passwordController {
    @FXML
    TextField eskiKullaniciAdi;
    @FXML
    TextField eskiSifre;
    @FXML
    TextField yeniKullaniciAdi;
    @FXML
    TextField yeniSifre;
    @FXML
    TextField yeniSifreTekrar;
    MasterController mc = new MasterController();

    public void clear(ActionEvent event) throws Exception {
        eskiKullaniciAdi.clear();
        eskiSifre.clear();
        yeniKullaniciAdi.clear();
        yeniSifre.clear();
        yeniSifreTekrar.clear();

    }

    public void backMain(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
        mainStage.setScene(scene);

    }

    public void save(ActionEvent event) throws Exception {
        if (yeniSifre.getText().equals(yeniSifreTekrar.getText())) {
            if (mc.changeLoginInfo(eskiKullaniciAdi.getText(), yeniKullaniciAdi.getText(), eskiSifre.getText(), yeniSifre.getText())) {
                JOptionPane.showMessageDialog(null, "Kullanıcı adı ve şifreniz değiştirildi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Girdiğiniz şifreler birbiri ile uyuşmuyor.", "Şifre değiştirilemedi.", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void email(ActionEvent event) throws Exception {

        JOptionPane.showMessageDialog(null, "   " +
                        "                 oculuspro@outlook.com \nAdresi üzerinden bizimle iletşime geçebilirsiniz.",
                "İletişim",JOptionPane.INFORMATION_MESSAGE);
    }


}
