package application;

import controller.MasterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SellController extends BorderPane {

    ArrayList<String> lensList = new ArrayList();
    ArrayList<String> camList = new ArrayList();
    ArrayList<String> cerceveList = new ArrayList();
    ArrayList<String> ozelUrunList = new ArrayList();
    ArrayList<String> sellList = new ArrayList();
    ObservableList<model.Extra> masrafList = FXCollections.observableArrayList();

    double toplamFiyat = 0;


    @FXML
    TableView<model.ContactLens> lensTable = new TableView();
    @FXML
    TableColumn<String, model.ContactLens> lensBarkod = new TableColumn<>();
    @FXML
    TableColumn<Double, model.ContactLens> lensTemelEgri = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensDiyoptri = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensTumCap = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensCyl = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensAks = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensMultifokal = new TableColumn();
    @FXML
    TableColumn<String, model.ContactLens> lensRenk = new TableColumn();
    @FXML
    TableColumn<String, model.ContactLens> lensOzelAd = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensSatisFiyat = new TableColumn();

    // Frame Tableview
    @FXML
    TableView<model.Frame> frameTable = new TableView();
    @FXML
    TableColumn<String, model.Frame> frameBarkod = new TableColumn();
    @FXML
    TableColumn<String, model.Frame> frameMarka = new TableColumn();
    @FXML
    TableColumn<String, model.Frame> frameModel = new TableColumn();
    @FXML
    TableColumn<String, model.Frame> frameEkartman = new TableColumn();
    @FXML
    TableColumn<String, model.Frame> frameOzelAdi = new TableColumn();
    @FXML
    TableColumn<String, model.Frame> frameRenk = new TableColumn();
    @FXML
    TableColumn<Double, model.Frame> frameSatisFiyat = new TableColumn();

    // Glass Tableview
    @FXML
    TableView<model.Glass> glassTable = new TableView();
    @FXML
    TableColumn<String, model.Glass> glassBarkod = new TableColumn();
    @FXML
    TableColumn<String, model.Glass> glassMarka = new TableColumn();
    @FXML
    TableColumn<String, model.Glass> glassTur = new TableColumn();
    @FXML
    TableColumn<String, model.Glass> glassTip = new TableColumn();
    @FXML
    TableColumn<Double, model.Glass> glassSferik = new TableColumn();
    @FXML
    TableColumn<Double, model.Glass> glassSilendirik = new TableColumn();
    @FXML
    TableColumn<Integer, model.Glass> glassAks = new TableColumn();
    @FXML
    TableColumn<Double, model.Glass> glassSatisFiyat = new TableColumn();

    // Item Tableview
    @FXML
    TableView<model.Special> itemTable = new TableView();
    @FXML
    TableColumn<String, model.Special> itemBarkod = new TableColumn();
    @FXML
    TableColumn<String, model.Special> itemUrun = new TableColumn();
    @FXML
    TableColumn<Double, model.Special> itemSatisFiyat = new TableColumn();

    @FXML
    TableView<model.Extra> masrafTable = new TableView();
    @FXML
    TableColumn<String, model.Extra> masrafUrun = new TableColumn();
    @FXML
    TableColumn<Double, model.Extra> masrafFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Extra> masrafBarkod = new TableColumn();

    // sell Table
    @FXML
    TableView sellTable = new TableView();
    @FXML
    TableColumn sellBarkod = new TableColumn();
    @FXML
    TableColumn sellAciklama = new TableColumn();
    @FXML
    TableColumn<Double, ?> sellSatisFiyati = new TableColumn();

    // Mï¿½ï¿½teri Bilgileri
    @FXML
    TextField tckimlik;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField telefon;
    @FXML
    TextField receteNo;
    @FXML
    TextField indirim;
    @FXML
    TextField receteTarihi;
    @FXML
    TextField basvuruTarihi;

    // Contact Lens Barkod
    @FXML
    TextField lensBarkode;

    // ï¿½erï¿½eve Barkod
    @FXML
    TextField cerceveBarkod;

    // Cam Barkod
    @FXML
    TextField camBarkod;

    // ï¿½zel ï¿½rï¿½n Barkod
    @FXML
    TextField ozelUrunBarkod;

    // Masraf Bilgileri
    @FXML
    TextField masrafFiyati;
    @FXML
    TextField masrafAciklama;
    @FXML
    TextField masrafBarcode;

    @FXML
    Label fiyat;
    @FXML
    Label masrafLabel;

    double masrafToplam;

    public void sellGlassShift(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellGlassScene.fxml")));
        mainStage.setScene(scene);

    }

    public void sellFrameShift(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellFrameScene.fxml")));
        mainStage.setScene(scene);

    }

    public void sellContactLensShift(ActionEvent event) throws IOException {

        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellContactLensScene.fxml")));
        mainStage.setScene(scene);

    }

    public void sellItemShift(ActionEvent event) throws IOException {

        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellItemScene.fxml")));
        mainStage.setScene(scene);

    }

    public void masrafShift(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/masrafScene.fxml")));
        mainStage.setScene(scene);

    }

    public void backMain(ActionEvent event) throws IOException {

        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
        mainStage.setScene(scene);
    }

    public void backSell(ActionEvent event) throws IOException {

        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellScene.fxml")));
        mainStage.setScene(scene);
    }

    public void sellButton(ActionEvent event) throws Exception {
        if (!tckimlik.getText().isEmpty()) {
            System.out.println(lensList.size());
            if (sellList.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Satılacak ürün listesi boş olamaz.", "HATA!",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                MasterController tempSell = new MasterController();
                double dc = 0;
                String dcs = indirim.getText();
                if (!indirim.getText().equals("")) {
                    dc = Double.parseDouble(dcs);
                }
                tempSell.addCustomer(tckimlik.getText(), name.getText(), surname.getText(), telefon.getText());

                boolean isSold = tempSell.sell(sellList, toplamFiyat, dc, tckimlik.getText(),
                        receteNo.getText());

                if (!isSold) {
                    JOptionPane.showMessageDialog(null,
                            "Satış yapılamadı.Lütfen satmak istediğiniz ürünün stoğunu kontrol ediniz.", "HATA!",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Satış başarılı", "Başarılı!",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Müşteri TC kimlik numarası boş olamaz", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        }

        lensTable.getItems().clear();
        frameTable.getItems().clear();
        glassTable.getItems().clear();
        itemTable.getItems().clear();
        lensList.clear();
        camList.clear();
        cerceveList.clear();
        ozelUrunList.clear();
        sellList.clear();
        tckimlik.clear();
        name.clear();
        surname.clear();
        telefon.clear();
        receteNo.clear();
        receteTarihi.clear();
        basvuruTarihi.clear();
        lensBarkode.clear();
        camBarkod.clear();
        cerceveBarkod.clear();
        ozelUrunBarkod.clear();
        indirim.clear();
        fiyat.setText("000000");


    }

    
    public void sellContactLensButton(ActionEvent event) throws SQLException {

        MasterController tempLens = new MasterController();
        if (lensBarkode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aramak için barkod giriniz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {

            sellList.add(lensBarkode.getText());

            lensBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            lensMultifokal.setCellValueFactory(new PropertyValueFactory<>("multifokal"));
            lensTemelEgri.setCellValueFactory(new PropertyValueFactory<>("temelEgri"));
            lensDiyoptri.setCellValueFactory(new PropertyValueFactory<>("diyoptri"));
            lensRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
            lensOzelAd.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            lensCyl.setCellValueFactory(new PropertyValueFactory<>("silindirik"));
            lensAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
            lensTumCap.setCellValueFactory(new PropertyValueFactory<>("tumCap"));
            lensSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));

            lensTable.getItems().addAll(tempLens.findLens(lensBarkode.getText()));

            toplamFiyat = toplamFiyat + tempLens.findLensPrice(lensBarkode.getText());

            fiyat.setText(String.valueOf(toplamFiyat));

       
        }
    }

    public void sellFrameButton(ActionEvent event) throws SQLException {

        MasterController tempFrame = new MasterController();
        if (cerceveBarkod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aramak için barkod giriniz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {

            sellList.add(cerceveBarkod.getText());

            frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
            frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
            frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
            frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));

            frameTable.getItems().addAll(tempFrame.findFrames(cerceveBarkod.getText()));

            toplamFiyat = toplamFiyat + tempFrame.findFramePrice(cerceveBarkod.getText());

//		System.out.println(toplamFiyat);
            fiyat.setText(String.valueOf(toplamFiyat));
        }

    }

    public void sellGlassButton(ActionEvent event) throws SQLException {
        MasterController tempGlass = new MasterController();

        if (camBarkod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aramak için barkod giriniz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            sellList.add(camBarkod.getText());

            glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            glassMarka.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
            glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
            glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
            glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
            glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
            glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));

            glassTable.getItems().addAll(tempGlass.findGlasses(camBarkod.getText()));

            toplamFiyat = toplamFiyat + tempGlass.findGlassPrice(camBarkod.getText());
            fiyat.setText(String.valueOf(toplamFiyat));
        }
    }

    public void sellItemButton(ActionEvent event) throws SQLException {
        MasterController tempItem = new MasterController();
        if (itemBarkod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aramak için barkod giriniz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {

            itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));

            itemTable.getItems().addAll(tempItem.findSpecials(ozelUrunBarkod.getText()));
            sellList.add(ozelUrunBarkod.getText());

            toplamFiyat = toplamFiyat + tempItem.findSpecialPrice(ozelUrunBarkod.getText());
            fiyat.setText(String.valueOf(toplamFiyat));
        }
    }

    public void masrafButton(ActionEvent event) throws SQLException {
       
        if (masrafAciklama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Masraf açıklaması boş olamaz.", "HATA!",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (masrafFiyati.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Masraf fiyatı boş olamaz", "HATA!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {

                model.Extra tempMasraf = new model.Extra(masrafBarcode.getText(), masrafAciklama.getText(),
                        Double.parseDouble(masrafFiyati.getText()));masrafUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                masrafFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                masrafBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));

                masrafList.addAll(tempMasraf);
                masrafTable.getItems().addAll(new model.Extra(masrafBarcode.getText(), masrafAciklama.getText(),
                        Double.parseDouble(masrafFiyati.getText())));

                masrafToplam += (Double.parseDouble(masrafFiyati.getText()));
                masrafLabel.setText(String.valueOf(masrafToplam));
            }
        }

    }

    public void indirimUygula(ActionEvent event) throws SQLException {

        double indirimliFiyat;

        if (!indirim.getText().isEmpty()) {
            try {
                indirimliFiyat = toplamFiyat - Double.parseDouble(indirim.getText());
            } catch (NumberFormatException e) {
                indirimliFiyat = toplamFiyat;
            }
            fiyat.setText(String.valueOf(indirimliFiyat));

        } else {
            indirimliFiyat = toplamFiyat;
        }
    }

    public void indirimIptal(ActionEvent event) throws SQLException {
        fiyat.setText(String.valueOf(toplamFiyat));
        indirim.setText("");
    }

    public void itemDrop(ActionEvent event) throws SQLException {

        if (lensTable.getSelectionModel().isSelected(lensTable.getSelectionModel().getSelectedIndex())) {
            model.ContactLens dropLens = lensTable.getSelectionModel().getSelectedItem();
            sellList.remove(dropLens.getBarcode());
            lensTable.getItems().removeAll(dropLens);
            toplamFiyat = toplamFiyat - dropLens.getSatisFiyati();
            lensTable.getSelectionModel().clearSelection();
            fiyat.setText(String.valueOf(toplamFiyat));

        } else if (frameTable.getSelectionModel().isSelected(frameTable.getSelectionModel().getSelectedIndex())) {
            model.Frame dropFrame = frameTable.getSelectionModel().getSelectedItem();
            sellList.remove(dropFrame.getBarcode());
            frameTable.getItems().removeAll(dropFrame);
            toplamFiyat = toplamFiyat - dropFrame.getSatisFiyati();
            frameTable.getSelectionModel().clearSelection();
            fiyat.setText(String.valueOf(toplamFiyat));
        } else if (glassTable.getSelectionModel().isSelected(glassTable.getSelectionModel().getSelectedIndex())) {
            model.Glass dropGlass = glassTable.getSelectionModel().getSelectedItem();
            sellList.remove(dropGlass.getBarcode());
            glassTable.getItems().removeAll(dropGlass);
            toplamFiyat = toplamFiyat - dropGlass.getSatisFiyati();
            glassTable.getSelectionModel().clearSelection();
            fiyat.setText(String.valueOf(toplamFiyat));
        } else if (itemTable.getSelectionModel().isSelected(itemTable.getSelectionModel().getSelectedIndex())) {
            model.Special dropItem = itemTable.getSelectionModel().getSelectedItem();
            sellList.remove(dropItem.getBarcode());
            itemTable.getItems().removeAll(dropItem);
            toplamFiyat = toplamFiyat - dropItem.getSatisFiyati();
            itemTable.getSelectionModel().clearSelection();
            fiyat.setText(String.valueOf(toplamFiyat));
        } else if (masrafTable.getSelectionModel().isSelected(masrafTable.getSelectionModel().getSelectedIndex())) {
            model.Extra dropMasraf = masrafTable.getSelectionModel().getSelectedItem();
            masrafTable.getItems().removeAll(dropMasraf);
            toplamFiyat = toplamFiyat - dropMasraf.getSatisFiyati();
            masrafTable.getSelectionModel().clearSelection();
            fiyat.setText(String.valueOf(toplamFiyat));
        }

    }

    public void masrafKaydet(ActionEvent event) throws Exception {
        MasterController mc = new MasterController();
        if (masrafList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Masraf Eklemediniz.", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (int i = 0; i < masrafList.size(); i++) {
                mc.addExtra(masrafList.get(i).getBarcode(), masrafList.get(i).getSatisFiyati(),
                        masrafList.get(i).getOzelAdi());

            }
            JOptionPane.showMessageDialog(null, "Masraf Eklendi.", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        }

        masrafTable.getItems().clear();
        masrafBarcode.clear();
        masrafList.clear();
        masrafFiyati.clear();
        masrafAciklama.clear();
        masrafLabel.setText("000000");

    }

    public void clear(ActionEvent event) throws Exception {
        lensTable.getItems().clear();
        frameTable.getItems().clear();
        glassTable.getItems().clear();
        itemTable.getItems().clear();
        lensList.clear();
        camList.clear();
        cerceveList.clear();
        ozelUrunList.clear();
        sellList.clear();
        tckimlik.clear();
        name.clear();
        surname.clear();
        telefon.clear();
        receteNo.clear();
        receteTarihi.clear();
        basvuruTarihi.clear();
        lensBarkode.clear();
        camBarkod.clear();
        cerceveBarkod.clear();
        ozelUrunBarkod.clear();
        indirim.clear();
        fiyat.setText("000000");
    }

    public void masrafClear(ActionEvent event) throws Exception {
        masrafTable.getItems().clear();
        masrafBarcode.clear();
        masrafList.clear();
        masrafFiyati.clear();
        masrafAciklama.clear();
        masrafLabel.setText("000000");
    }

    public void email(ActionEvent event) throws Exception {

        JOptionPane.showMessageDialog(null,
                "                    oculuspro@outlook.com \nAdresi üzerinden bizimle iletişime geçebilirsiniz.",
                "İletişim", JOptionPane.INFORMATION_MESSAGE);
    }

}
