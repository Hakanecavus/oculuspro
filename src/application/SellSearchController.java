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
import javafx.stage.Stage;
import model.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class SellSearchController {


    MasterController pc = new MasterController();

    ArrayList<Integer> saleIds = new ArrayList<Integer>();
    ArrayList<String> barcodes = new ArrayList<String>();
    ObservableList<Sale> sales = FXCollections.observableArrayList();
    ObservableList<ContactLens> lenses = FXCollections.observableArrayList();
    ObservableList<Frame> frames = FXCollections.observableArrayList();
    ObservableList<Glass> glasses = FXCollections.observableArrayList();
    ObservableList<Special> specials = FXCollections.observableArrayList();
    ObservableList<ContactLens> tempLenses = FXCollections.observableArrayList();
    ObservableList<Frame> tempFrames = FXCollections.observableArrayList();
    ObservableList<Glass> tempGlasses = FXCollections.observableArrayList();
    ObservableList<Special> tempSpecials = FXCollections.observableArrayList();


    // sellSearch Bilgileri

    @FXML
    TextField searchMusteriTC;
    @FXML
    TextField searchSatisNumarasi;
    @FXML
    TextField saleNumberToDelete;

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
    @FXML
    TableColumn<Double, model.ContactLens> lensSatisNo = new TableColumn();

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
    @FXML
    TableColumn<Double, model.Frame> frameSatisNo = new TableColumn();

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
    @FXML
    TableColumn<Double, model.Glass> glassSatisNo = new TableColumn();

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
    TableColumn<Double, model.Special> itemSatisNo = new TableColumn();

    @FXML
    TableView<model.Extra> masrafTable = new TableView();
    @FXML
    TableColumn<String, model.Extra> masrafUrun = new TableColumn();
    @FXML
    TableColumn<Double, model.Extra> masrafFiyat = new TableColumn();
    @FXML
    TableColumn<Double, model.Extra> masrafNo = new TableColumn();

    @FXML
    Label indirimLabel;
    @FXML
    Label fiyatLabel;
    @FXML
    Label musteriAdi;
    @FXML Label receteNo;

    double toplamFiyat=0;
    double toplamIndirim=0;


    public void sellSearchButton(ActionEvent event) throws Exception {
        if (searchMusteriTC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Müşteri TC Kimlik numarası boş bırakılamaz", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
        

            lenses.clear();
            frames.clear();
            glasses.clear();
            specials.clear();
            toplamFiyat = 0;
            toplamIndirim = 0;
            musteriAdi.setText("");
            saleIds.clear();

            fiyatLabel.setText("000000");
            indirimLabel.setText("000000");

            String tableName;
            int saleId;

            saleIds = pc.searchByTckn(searchMusteriTC.getText());

            for (int i = 0; i < saleIds.size(); i++) {
                saleId = saleIds.get(i);
                //sale.set(i, saleId);
                barcodes = pc.findRecordsBySaleId(saleId);
                for (int j = 0; j < barcodes.size(); j++) {
                    tableName = pc.findTableName(barcodes.get(j));

                    switch (tableName) {
                        case "ContactLens":
                            tempLenses.clear();
                            tempLenses = pc.findLens(barcodes.get(j));
                            for (int k2 = 0; k2 < tempLenses.size(); k2++) {
                                tempLenses.get(k2).setSaleId(saleId);
                            }
                            lenses.addAll(tempLenses);

                            break;
                        case "Frame":
                            tempFrames.clear();
                            tempFrames = pc.findFrames(barcodes.get(j));
                            for (int k2 = 0; k2 < tempFrames.size(); k2++) {
                                tempFrames.get(k2).setSaleId(saleId);
                            }
                            frames.addAll(tempFrames);

                            break;
                        case "Glass":

                            tempGlasses.clear();
                            tempGlasses = pc.findGlasses(barcodes.get(j));
                            for (int k2 = 0; k2 < tempGlasses.size(); k2++) {
                                tempGlasses.get(k2).setSaleId(saleId);
                            }
                            glasses.addAll(tempGlasses);

                            break;
                        case "Special":

                            tempSpecials.clear();
                            tempSpecials = pc.findSpecials(barcodes.get(j));
                            for (int k2 = 0; k2 < tempSpecials.size(); k2++) {
                                tempSpecials.get(k2).setSaleId(saleId);
                            }
                            specials.addAll(tempSpecials);

                            break;

                        default:
                            break;
                    }


                }

            }

            for (int i = 0; i < saleIds.size(); i++) {
                sales.addAll(pc.findSaleBySaleId(saleIds.get(i)));

            }
            for (int i = 0; i < sales.size(); i++) {
                toplamIndirim = toplamIndirim + sales.get(i).getIndirim();
            }
            indirimLabel.setText(String.valueOf(toplamIndirim));


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
            lensSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
            lensTable.setItems(lenses);

            frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
            frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
            frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
            frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
            frameSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
            frameTable.setItems(frames);

            glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            glassMarka.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
            glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
            glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
            glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
            glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
            glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
            glassSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
            // instead of this, use the line below:
            glassTable.setItems(glasses);

            itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
            itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
            itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
            itemSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
            itemTable.setItems(specials);

            for (int i = 0; i < lenses.size(); i++) {
                toplamFiyat = toplamFiyat + lenses.get(i).getSatisFiyati();

            }
            for (int i = 0; i < glasses.size(); i++) {
                toplamFiyat = toplamFiyat + glasses.get(i).getSatisFiyati();
            }
            for (int i = 0; i < frames.size(); i++) {
                toplamFiyat = toplamFiyat + frames.get(i).getSatisFiyati();
            }
            for (int i = 0; i < specials.size(); i++) {
                toplamFiyat = toplamFiyat + specials.get(i).getSatisFiyati();
            }
            fiyatLabel.setText(String.valueOf(toplamFiyat));

            if (!searchMusteriTC.getText().isEmpty()) {
                if (!pc.findCustomer(searchMusteriTC.getText()).isEmpty()) {
                    String musteriIsim = pc.findCustomer(searchMusteriTC.getText()).get(0).getIsim() + " " + pc.findCustomer(searchMusteriTC.getText()).get(0).getSoyisim();
                    musteriAdi.setText(musteriIsim);
                } else {
                    JOptionPane.showMessageDialog(null, "TC kimlik numarası bulunamadı!", "Hata!", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Aramak için TC kimlik numarası girin!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        sales.clear();

    }

    public void sellidButton(ActionEvent event) throws Exception {
        if (searchSatisNumarasi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Satış Numarası Boş Bırakılamaz", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int saleId;
            try {
                saleId = Integer.parseInt(searchSatisNumarasi.getText());
                String recete;
                recete=pc.findSaleBySaleId(saleId).get(0).getRecete_no();
                receteNo.setText("Re�ete No: "+recete);
            } catch (NumberFormatException e) {
                saleId = 0;
            }

            lensTable.getItems().clear();
            glassTable.getItems().clear();
            itemTable.getItems().clear();
            frameTable.getItems().clear();
            toplamFiyat = 0;
            toplamIndirim = 0;
            musteriAdi.setText("");

            fiyatLabel.setText("000000");
            indirimLabel.setText("000000");
            receteNo.setText("Re�ete No: ");

            String tableName;
            pc.findSaleBySaleId(saleId);
            
            if (!pc.findSaleBySaleId(saleId).isEmpty()) {


                toplamIndirim = pc.findSaleBySaleId(saleId).get(0).getIndirim();
                barcodes = pc.findRecordsBySaleId(saleId);
                for (int j = 0; j < barcodes.size(); j++) {
                    tableName = pc.findTableName(barcodes.get(j));

                    switch (tableName) {
                        case "ContactLens":
                            tempLenses.clear();
                            tempLenses = pc.findLens(barcodes.get(j));
                            for (int k2 = 0; k2 < tempLenses.size(); k2++) {
                                tempLenses.get(k2).setSaleId(saleId);
                            }
                            lenses.addAll(tempLenses);

                            break;
                        case "Frame":
                            tempFrames.clear();
                            tempFrames = pc.findFrames(barcodes.get(j));
                            for (int k2 = 0; k2 < tempFrames.size(); k2++) {
                                tempFrames.get(k2).setSaleId(saleId);
                            }
                            frames.addAll(tempFrames);

                            break;
                        case "Glass":

                            tempGlasses.clear();
                            tempGlasses = pc.findGlasses(barcodes.get(j));
                            for (int k2 = 0; k2 < tempGlasses.size(); k2++) {
                                tempGlasses.get(k2).setSaleId(saleId);
                            }
                            glasses.addAll(tempGlasses);

                            break;
                        case "Special":

                            tempSpecials.clear();
                            tempSpecials = pc.findSpecials(barcodes.get(j));
                            for (int k2 = 0; k2 < tempSpecials.size(); k2++) {
                                tempSpecials.get(k2).setSaleId(saleId);
                            }
                            specials.addAll(tempSpecials);

                            break;

                        default:
                            break;
                    }
                }

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
                lensSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
                lensTable.setItems(lenses);

                frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
                frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
                frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
                frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
                frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                frameSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
                frameTable.setItems(frames);

                glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                glassMarka.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
                glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
                glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
                glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
                glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
                glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                glassSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
                glassTable.setItems(glasses);

                itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
                itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
                itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
                itemSatisNo.setCellValueFactory(new PropertyValueFactory<>("saleId"));
                itemTable.setItems(specials);
                ;

                for (int i = 0; i < lenses.size(); i++) {
                    toplamFiyat = toplamFiyat + lenses.get(i).getSatisFiyati();

                }
                for (int i = 0; i < glasses.size(); i++) {
                    toplamFiyat = toplamFiyat + glasses.get(i).getSatisFiyati();
                }
                for (int i = 0; i < frames.size(); i++) {
                    toplamFiyat = toplamFiyat + frames.get(i).getSatisFiyati();
                }
                for (int i = 0; i < specials.size(); i++) {
                    toplamFiyat = toplamFiyat + specials.get(i).getSatisFiyati();
                }
                fiyatLabel.setText(String.valueOf(toplamFiyat));
                indirimLabel.setText(String.valueOf(toplamIndirim));

                String musteriTC = pc.findSaleBySaleId(saleId).get(0).getTcNo();
                String musteriIsim = pc.findCustomer(musteriTC).get(0).getIsim() + " " + pc.findCustomer(musteriTC).get(0).getSoyisim();
                musteriAdi.setText(musteriIsim);
            } else {
                JOptionPane.showMessageDialog(null, "Bu numaraya ait satış bulunamadı", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        }


    }

    public void sellCancelButton(ActionEvent event) throws Exception {
        if (saleNumberToDelete.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Satış numarası boş bırakılamaz.", "HATA!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int saleId;
            try {
                saleId = Integer.parseInt(saleNumberToDelete.getText());
            } catch (NumberFormatException e) {
                saleId = 0;
            }
            pc.cancelSale(saleId);
        }
    }

    public void backMain(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
        mainStage.setScene(scene);

    }


    public void clear(ActionEvent event) throws Exception {
        searchMusteriTC.clear();
        searchSatisNumarasi.clear();
        saleNumberToDelete.clear();
        saleIds.clear();
        barcodes.clear();
        lenses.clear();
        frames.clear();
        glasses.clear();
        specials.clear();
        tempLenses.clear();
        tempFrames.clear();
        tempGlasses.clear();
        tempSpecials.clear();
        fiyatLabel.setText("000000");
        indirimLabel.setText("000000");
        toplamFiyat = 0;
        toplamIndirim = 0;


    }

    public void email(ActionEvent event) throws Exception {

        JOptionPane.showMessageDialog(null, "                    oculuspro@outlook.com \nAdresi üzerinden bizimle iletişime geçebilirsiniz.",
                "İletişim",JOptionPane.INFORMATION_MESSAGE);
    }

}
