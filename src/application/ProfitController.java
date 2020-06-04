package application;

import controller.MasterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProfitController {
    MasterController tempProfit = new MasterController();
    // profitScene Bilgileri
    @FXML
    DatePicker profitTarih1;
    @FXML
    DatePicker profitTarih2;

    ObservableList<Sale> saleList = FXCollections.observableArrayList();
    ObservableList<model.Extra> extraList = FXCollections.observableArrayList();

    ArrayList<Integer> saleIds = new ArrayList<Integer>();
    ArrayList<String> barcodes = new ArrayList<String>();
    ObservableList<ContactLens> lenses = FXCollections.observableArrayList();
    ObservableList<Frame> frames = FXCollections.observableArrayList();
    ObservableList<Glass> glasses = FXCollections.observableArrayList();
    ObservableList<Special> specials = FXCollections.observableArrayList();
    ObservableList<ContactLens> tempLenses = FXCollections.observableArrayList();
    ObservableList<Frame> tempFrames = FXCollections.observableArrayList();
    ObservableList<Glass> tempGlasses = FXCollections.observableArrayList();
    ObservableList<Special> tempSpecials = FXCollections.observableArrayList();

    // Lens Tableview
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
    TableColumn<Double, model.ContactLens> lensAlisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensSatisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.ContactLens> lensSatisTarihi = new TableColumn();

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
    TableColumn<Double, model.Frame> frameAlisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Frame> frameSatisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Frame> frameSatisTarihi = new TableColumn();

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
    TableColumn<Double, model.Glass> glassAlisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Glass> glassSatisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Glass> glassSatisTarihi = new TableColumn();

    // Item Tableview
    @FXML
    TableView<model.Special> itemTable = new TableView();
    @FXML
    TableColumn<String, model.Special> itemBarkod = new TableColumn();
    @FXML
    TableColumn<String, model.Special> itemUrun = new TableColumn();
    @FXML
    TableColumn<Double, model.Special> itemAlisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Special> itemSatisFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Special> itemSatisTarihi = new TableColumn();

    // Masraf Table
    @FXML
    TableView<model.Extra> masrafTable = new TableView();
    @FXML
    TableColumn<String, model.Extra> masrafBarkod = new TableColumn();
    @FXML
    TableColumn<String, model.Extra> masrafUrun = new TableColumn();
    @FXML
    TableColumn<Double, model.Extra> masrafSatisFiyat = new TableColumn();
    @FXML
    TableColumn<String, model.Extra> masrafSatisTarihi = new TableColumn();

    @FXML
    Label toplamSatis;
    @FXML
    Label toplamAlis;
    @FXML
    Label profitNet;
    @FXML
    Label toplamMasraf;

    double toplamAlisFiyati;
    double toplamSatisFiyati;
    double toplamIndirim;
    double toplamMasrafFiyati;
    double netFiyat;

    public void profitButton(ActionEvent event) throws IOException, SQLException {

        if (profitTarih1.getValue() == null) {
            JOptionPane.showMessageDialog(null, "İlk tarih boş bırakılamaz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (profitTarih2.getValue() == null) {
                profitTarih2.setValue(LocalDate.now());
            } else {

                lenses.clear();
                frames.clear();
                glasses.clear();
                specials.clear();
                saleIds.clear();

                extraList.clear();
                saleList.clear();

                toplamAlisFiyati = 0;
                toplamMasrafFiyati = 0;
                toplamSatisFiyati = 0;
                toplamIndirim = 0;
                netFiyat = 0;
                String tarihIlk, tarihSon;

                tarihIlk = profitTarih1.getValue().toString();
                tarihSon = profitTarih2.getValue().toString();
                extraList.addAll(tempProfit.getExtraBetweenDates(tarihIlk, tarihSon));
                
                saleList.addAll(tempProfit.getSaleBetweenDates(tarihIlk, tarihSon));
                System.out.println(extraList.size());

                String tableName;
                int saleId;

                for (int i = 0; i < saleList.size(); i++) {
                    saleIds.add(saleList.get(i).getId());
                }
                for (int k = 0; k < saleIds.size(); k++) {
                    saleId = saleIds.get(k);
                    barcodes = tempProfit.findRecordsBySaleId(saleId);
                    for (int j = 0; j < barcodes.size(); j++) {
                        tableName = tempProfit.findTableName(barcodes.get(j));

                        switch (tableName) {
                            case "ContactLens":
                                tempLenses.clear();
                                tempLenses = tempProfit.findLens(barcodes.get(j));
                                for (int k2 = 0; k2 < tempLenses.size(); k2++) {
                                    tempLenses.get(k2).setSaleId(saleId);
                                    tempLenses.get(k2).setEklemeTarihi(saleList.get(k).getEklemeTarihi());
                                }
                                lenses.addAll(tempLenses);

                                break;
                            case "Frame":
                                tempFrames.clear();
                                tempFrames = tempProfit.findFrames(barcodes.get(j));
                                for (int k2 = 0; k2 < tempFrames.size(); k2++) {
                                    tempFrames.get(k2).setSaleId(saleId);
                                    tempFrames.get(k2).setEklemeTarihi(saleList.get(k).getEklemeTarihi());
                                }
                                frames.addAll(tempFrames);

                                break;
                            case "Glass":

                                tempGlasses.clear();
                                tempGlasses = tempProfit.findGlasses(barcodes.get(j));
                                for (int k2 = 0; k2 < tempGlasses.size(); k2++) {
                                    tempGlasses.get(k2).setSaleId(saleId);
                                    tempGlasses.get(k2).setEklemeTarihi(saleList.get(k).getEklemeTarihi());
                                }
                                glasses.addAll(tempGlasses);

                                break;
                            case "Special":

                                tempSpecials.clear();
                                tempSpecials = tempProfit.findSpecials(barcodes.get(j));
                                for (int k2 = 0; k2 < tempSpecials.size(); k2++) {
                                    tempSpecials.get(k2).setSaleId(saleId);
                                    tempSpecials.get(k2).setEklemeTarihi(saleList.get(k).getEklemeTarihi());
                                }
                                specials.addAll(tempSpecials);

                                break;

                            default:
                                break;
                        }
                    }
                }

                for (int i = 0; i < lenses.size(); i++) {
                    toplamAlisFiyati = toplamAlisFiyati + lenses.get(i).getAlisFiyati();
                }
                for (int i = 0; i < glasses.size(); i++) {
                    toplamAlisFiyati = toplamAlisFiyati + glasses.get(i).getAlisFiyati();
                }
                for (int i = 0; i < frames.size(); i++) {
                    toplamAlisFiyati = toplamAlisFiyati + frames.get(i).getAlisFiyati();
                }
                for (int i = 0; i < specials.size(); i++) {
                    toplamAlisFiyati = toplamAlisFiyati + specials.get(i).getAlisFiyati();
                }

                toplamAlis.setText(String.valueOf(toplamAlisFiyati));
                System.out.println(extraList.size());

                for (int i = 0; i < extraList.size(); i++) {
                    System.out.println("here");
                    toplamMasrafFiyati = toplamMasrafFiyati + extraList.get(i).getSatisFiyati();
                    System.out.println(extraList.get(i).getSatisFiyati());

                }
                System.out.println(toplamMasrafFiyati);
                toplamMasraf.setText(String.valueOf(toplamMasrafFiyati));

                for (int i = 0; i < saleList.size(); i++) {
                    toplamSatisFiyati = toplamSatisFiyati + saleList.get(i).getToplamFiyat();
                    toplamIndirim = toplamIndirim + saleList.get(i).getIndirim();

                }

                toplamSatisFiyati = toplamSatisFiyati - toplamIndirim;
                toplamSatis.setText(String.valueOf(toplamSatisFiyati));

                netFiyat = toplamSatisFiyati - toplamAlisFiyati;
                netFiyat = netFiyat - toplamMasrafFiyati;
                profitNet.setText(String.valueOf(netFiyat));

                // Lens Table
                lensBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                lensMultifokal.setCellValueFactory(new PropertyValueFactory<>("multifokal"));
                lensTemelEgri.setCellValueFactory(new PropertyValueFactory<>("temelEgri"));
                lensDiyoptri.setCellValueFactory(new PropertyValueFactory<>("diyoptri"));
                lensRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
                lensOzelAd.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                lensCyl.setCellValueFactory(new PropertyValueFactory<>("silindirik"));
                lensAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
                lensTumCap.setCellValueFactory(new PropertyValueFactory<>("tumCap"));
                lensAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
                lensSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                lensSatisTarihi.setCellValueFactory(new PropertyValueFactory<>("eklemeTarihi"));
                lensTable.setItems(lenses);

                // Glass Table
                glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                glassMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
                glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
                glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
                glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
                glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
                glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
                glassAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
                glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                glassSatisTarihi.setCellValueFactory(new PropertyValueFactory<>("eklemeTarihi"));
                glassTable.setItems(glasses);

                // Frame Table
                frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
                frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
                frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
                frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
                frameAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
                frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                frameSatisTarihi.setCellValueFactory(new PropertyValueFactory<>("eklemeTarihi"));
                frameTable.setItems(frames);

                // Item Table
                itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                itemAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
                itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                itemSatisTarihi.setCellValueFactory(new PropertyValueFactory<>("eklemeTarihi"));
                itemTable.setItems(specials);

                // Masraf Table

                masrafBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                masrafUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                masrafSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                masrafSatisTarihi.setCellValueFactory(new PropertyValueFactory<>("eklemeTarihi"));
                masrafTable.setItems(extraList);
            }
        }

    }

    public void backMain(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
        mainStage.setScene(scene);
    }

    public void clear(ActionEvent event) throws Exception {
        profitTarih1.setValue(null);
        profitTarih2.setValue(null);
        lensTable.getItems().clear();
        frameTable.getItems().clear();
        glassTable.getItems().clear();
        itemTable.getItems().clear();
        masrafTable.getItems().clear();
        lenses.clear();
        frames.clear();
        glasses.clear();
        specials.clear();
        tempLenses.clear();
        tempGlasses.clear();
        tempFrames.clear();
        tempSpecials.clear();
        saleList.clear();
        extraList.clear();
        toplamAlisFiyati = 0;
        toplamSatisFiyati = 0;
        toplamMasrafFiyati = 0;
        toplamIndirim = 0;
        netFiyat = 0;
        toplamSatis.setText("000000");
        toplamMasraf.setText("000000");
        profitNet.setText("000000");
        toplamAlis.setText("000000");
    }

    public void email(ActionEvent event) throws Exception {

        JOptionPane.showMessageDialog(null, "   " +
                        "                 oculuspro@outlook.com \nAdresi üzerinden bizimle iletşime geçebilirsiniz.",
                "İletişim", JOptionPane.INFORMATION_MESSAGE);
    }

}
