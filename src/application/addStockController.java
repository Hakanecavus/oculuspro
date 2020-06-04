package application;

import controller.MasterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

public class addStockController extends BorderPane {
	ArrayList<model.ContactLens> LensList=new ArrayList<model.ContactLens>();
	ArrayList<model.Frame> FrameList=new ArrayList<model.Frame>();
	ArrayList<model.Glass> GlassList=new ArrayList<model.Glass>();
	ArrayList<model.Special> ItemList=new ArrayList<model.Special>();
	
	//Lens Tableview
	@FXML TableView<model.ContactLens> lensTable=new TableView();
	@FXML TableColumn<String,model.ContactLens> lensBarkod=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensTemelEgri=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensDiyoptri=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensTumCap=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensCyl=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensAks=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensMultifokal=new TableColumn();
	@FXML TableColumn<String,model.ContactLens> lensRenk=new TableColumn<>();
	@FXML TableColumn<String,model.ContactLens> lensOzelAd=new TableColumn();
	@FXML TableColumn<Integer,model.ContactLens> lensAdet=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensAlisFiyat=new TableColumn();
	@FXML TableColumn<Double,model.ContactLens> lensSatisFiyat=new TableColumn();
	
	//Frame Tableview
	@FXML TableView<model.Frame> frameTable=new TableView();
	@FXML TableColumn<String,model.Frame> frameBarkod=new TableColumn();
	@FXML TableColumn<String,model.Frame> frameMarka=new TableColumn();
	@FXML TableColumn<String,model.Frame> frameModel=new TableColumn();
	@FXML TableColumn<String,model.Frame> frameEkartman=new TableColumn();
	@FXML TableColumn<String,model.Frame> frameOzelAdi=new TableColumn();
	@FXML TableColumn<String,model.Frame> frameRenk=new TableColumn();
	@FXML TableColumn<Integer,model.Frame> frameAdet=new TableColumn();
	@FXML TableColumn<Double,model.Frame> frameAlisFiyat=new TableColumn();
	@FXML TableColumn<Double,model.Frame> frameSatisFiyat=new TableColumn();
	
	//Glass Tableview
	@FXML TableView<model.Glass> glassTable=new TableView();
	@FXML TableColumn<String,model.Glass> glassBarkod=new TableColumn();
	@FXML TableColumn<String,model.Glass> glassMarka=new TableColumn();
	@FXML TableColumn<String,model.Glass> glassTur=new TableColumn();	
	@FXML TableColumn<String,model.Glass> glassTip=new TableColumn();
	@FXML TableColumn<Double,model.Glass> glassSferik=new TableColumn();
	@FXML TableColumn<Double,model.Glass> glassSilendirik=new TableColumn();
	@FXML TableColumn<Integer,model.Glass> glassAks=new TableColumn();
	@FXML TableColumn<Integer,model.Glass> glassAdet=new TableColumn();
	@FXML TableColumn<Double,model.Glass> glassAlisFiyat=new TableColumn();
	@FXML TableColumn<Double,model.Glass> glassSatisFiyat=new TableColumn();
	
	//Item Tableview
	@FXML TableView<model.Special> itemTable=new TableView();
	@FXML TableColumn<String,model.Special> itemBarkod=new TableColumn();
	@FXML TableColumn<String,model.Special> itemUrun=new TableColumn();
	@FXML TableColumn<Integer,model.Special> itemAdet=new TableColumn();
	@FXML TableColumn<Double,model.Special> itemAlisFiyat=new TableColumn();
	@FXML TableColumn<Double,model.Special> itemSatisFiyat=new TableColumn();
	
	
	//addLens Bilgileri
	@FXML TextField addLensBarkod;
	@FXML TextField addLensTemelEgri;
	@FXML TextField addLensDiyoptri;
	@FXML TextField addLensTumCap;
	@FXML TextField addLensCyl;
	@FXML TextField addLensAks;
	@FXML TextField addLensMultifokal;
	@FXML TextField addLensRenk;
	@FXML TextField addLensOzelAd;
	@FXML TextField addLensAlisFiyat;
	@FXML TextField addLensSatisFiyat;
	@FXML TextField addLensAdet;
	
	
	//addFrame Bilgileri
	@FXML TextField addFrameBarkod;
	@FXML TextField addFrameMarka;
	@FXML TextField addFrameModel;
	@FXML TextField addFrameEkartman;
	@FXML TextField addFrameRenk;
	@FXML TextField addFrameAdet;
	@FXML TextField addFrameAlisFiyat;
	@FXML TextField addFrameSatisFiyat;
	@FXML TextField addFrameOzelAdi;
	
	//addGlass Bilgileri
	@FXML TextField addGlassBarkod;
	@FXML TextField addGlassMarka;
	@FXML TextField addGlassTur;
	@FXML TextField addGlassTip;
	@FXML TextField addGlassSferik;
	@FXML TextField addGlassSilendirik;
	@FXML TextField addGlassAks;
	@FXML TextField addGlassAdet;
	@FXML TextField addGlassAlisFiyat;
	@FXML TextField addGlassSatisFiyat;
	
	//addItem Bilgileri
	@FXML TextField addItemBarkod;
	@FXML TextField addItemUrun;
	@FXML TextField addItemAdet;
	@FXML TextField addItemAlisFiyat;
	@FXML TextField addItemSatisFiyat;
	
	public void addContactLensShift(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/addContactLensScene.fxml")));
		mainStage.setScene(scene);

	}
	
	public void addFrameShift(ActionEvent event) throws IOException {

		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/addFrameScene.fxml")));
		mainStage.setScene(scene);

	}
	
	public void addGlassShift(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/addGlassScene.fxml")));
		mainStage.setScene(scene);

	}
	
	public void addItemShift(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/addItemScene.fxml")));
		mainStage.setScene(scene);

	}
	public void backMain(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
		mainStage.setScene(scene);

	}
	public void backStock(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/stockScene.fxml")));
		mainStage.setScene(scene);

	}
	public void backAddStock(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/addStockScene.fxml")));
		mainStage.setScene(scene);
	}
	
	public void addContactLensButton(ActionEvent event) throws SQLException{
		if(addLensBarkod.getText().equals("")) {
			addLensBarkod.setText("0");
			System.out.println("barkod ");
		}
		if(addLensAks.getText().equals("")) {
			addLensAks.setText("0");
			System.out.println("aks");
		}
		if(addLensAdet.getText().equals("")) {
			addLensAdet.setText("0");
		}
		if(addLensAlisFiyat.getText().equals("")) {
			addLensAlisFiyat.setText("0");
		}
		if(addLensCyl.getText().equals("")) {
			addLensCyl.setText("0");
		}
		if(addLensDiyoptri.getText().equals("")) {
			addLensDiyoptri.setText("0");
		}
		if(addLensMultifokal.getText().equals("")) {
			addLensMultifokal.setText("0");
		}
		if(addLensOzelAd.getText().equals("")) {
			addLensOzelAd.setText("0");
		}
		if(addLensRenk.getText().equals("")) {
			addLensRenk.setText("0");
		}
		if(addLensSatisFiyat.getText().equals("")) {
			addLensSatisFiyat.setText("0");
		}
		if(addLensTemelEgri.getText().equals("")) {
			addLensTemelEgri.setText("0");
		}
		if(addLensTumCap.getText().equals("")) {
			addLensTumCap.setText("0");
		}
		System.out.println(addLensBarkod.getText());
		
		
		
		model.ContactLens tempLens=new model.ContactLens(addLensBarkod.getText(),Double.parseDouble(addLensMultifokal.getText()),
				Double.parseDouble(addLensTemelEgri.getText()),Double.parseDouble(addLensDiyoptri.getText()),
				Double.parseDouble(addLensAks.getText()),Double.parseDouble(addLensCyl.getText()),Double.parseDouble(addLensTumCap.getText()),
				addLensRenk.getText(),addLensOzelAd.getText(),Double.parseDouble(addLensAlisFiyat.getText()),
				Double.parseDouble(addLensSatisFiyat.getText()),Integer.parseInt(addLensAdet.getText()));
		LensList.add(tempLens);
		
		lensBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		lensMultifokal.setCellValueFactory(new PropertyValueFactory<>("multifokal"));
		lensTemelEgri.setCellValueFactory(new PropertyValueFactory<>("temelEgri"));
		lensDiyoptri.setCellValueFactory(new PropertyValueFactory<>("diyoptri"));
		lensRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
		lensOzelAd.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
		lensAdet.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		lensCyl.setCellValueFactory(new PropertyValueFactory<>("silindirik"));
		lensAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
		lensTumCap.setCellValueFactory(new PropertyValueFactory<>("tumCap"));
		lensAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		lensSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		
		lensTable.getItems().add(new model.ContactLens(addLensBarkod.getText(),Double.parseDouble(addLensMultifokal.getText()),
				Double.parseDouble(addLensTemelEgri.getText()),Double.parseDouble(addLensDiyoptri.getText()),
				Double.parseDouble(addLensAks.getText()),Double.parseDouble(addLensCyl.getText()),Double.parseDouble(addLensTumCap.getText()),
				addLensRenk.getText(),addLensOzelAd.getText(),Double.parseDouble(addLensAlisFiyat.getText()),
				Double.parseDouble(addLensSatisFiyat.getText()),Integer.parseInt(addLensAdet.getText())));
		
		
	}
	
	public void addFrameButton(ActionEvent event) throws SQLException{
		
		if(addFrameBarkod.getText().equals("")) {
			addFrameBarkod.setText("0");
		}
		if(addFrameAdet.getText().equals("")) {
			addFrameAdet.setText("0");
		}
		if(addFrameAlisFiyat.getText().equals("")) {
			addFrameAlisFiyat.setText("0");
		}
		if(addFrameEkartman.getText().equals("")) {
			addFrameEkartman.setText("0");
		}
		if(addFrameMarka.getText().equals("")) {
			addFrameMarka.setText("0");
		}
		if(addFrameModel.getText().equals("")) {
			addFrameModel.setText("0");
		}
		if(addFrameOzelAdi.getText().equals("")) {
			addFrameOzelAdi.setText("0");
		}
		if(addFrameRenk.getText().equals("")) {
			addFrameRenk.setText("0");
		}
		if(addFrameSatisFiyat.getText().equals("")) {
			addFrameSatisFiyat.setText("0");
		}
		
		
		 model.Frame tempFrame=new model.Frame(addFrameBarkod.getText(), Double.parseDouble(addFrameAlisFiyat.getText()),
					Double.parseDouble(addFrameSatisFiyat.getText()),addFrameRenk.getText(), addFrameMarka.getText(), addFrameModel.getText()
					, addFrameOzelAdi.getText(), addFrameEkartman.getText(),Integer.parseInt(addFrameAdet.getText()));
		 FrameList.add(tempFrame);
		 
		 frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		 frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		 frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
		 frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
		 frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
		 frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
		 frameAdet.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		 frameAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		 frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		 
		 frameTable.getItems().add(new model.Frame(addFrameBarkod.getText(), Double.parseDouble(addFrameAlisFiyat.getText()),
					Double.parseDouble(addFrameSatisFiyat.getText()),addFrameRenk.getText(), addFrameMarka.getText(), addFrameModel.getText()
					, addFrameOzelAdi.getText(), addFrameEkartman.getText(),Integer.parseInt(addFrameAdet.getText())));
		 
	}
	
	public void addGlassButton(ActionEvent event) throws SQLException{
		
		if(addGlassBarkod.getText().equals("")) {
			addGlassBarkod.setText("0");
		}
		if(addGlassAdet.getText().equals("")) {
			addGlassAdet.setText("0");
		}
		if(addGlassAks.getText().equals("")) {
			addGlassAks.setText("0");
		}
		if(addGlassAlisFiyat.getText().equals("")) {
			addGlassAlisFiyat.setText("0");
		}
		if(addGlassMarka.getText().equals("")) {
			addGlassMarka.setText("0");
		}
		if(addGlassSatisFiyat.getText().equals("")) {
			addGlassSatisFiyat.setText("0");
		}
		if(addGlassSferik.getText().equals("")) {
			addGlassSferik.setText("0");
		}
		if(addGlassSilendirik.getText().equals("")) {
			addGlassSilendirik.setText("0");
		}
		if(addGlassTip.getText().equals("")) {
			addGlassTip.setText("0");
		}
		if(addGlassTur.getText().equals("")) {
			addGlassTur.setText("0");
		}
		
		model.Glass tempGlass=new model.Glass(addGlassBarkod.getText(), Double.parseDouble(addGlassAlisFiyat.getText()),
				Double.parseDouble(addGlassSatisFiyat.getText()), Double.parseDouble(addGlassSilendirik.getText()), Double.parseDouble(addGlassSferik.getText()), 
				addGlassTur.getText(), addGlassMarka.getText(), addGlassTip.getText(), Integer.parseInt(addGlassAks.getText()),Integer.parseInt(addGlassAdet.getText()));
		GlassList.add(tempGlass);
		glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		glassMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
		glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
		glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
		glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
		glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
		glassAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		glassAdet.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		
		
		
		glassTable.getItems().add(new model.Glass(addGlassBarkod.getText(), Double.parseDouble(addGlassAlisFiyat.getText()),
				Double.parseDouble(addGlassSatisFiyat.getText()), Double.parseDouble(addGlassSilendirik.getText()), 
				Double.parseDouble(addGlassSferik.getText()),addGlassTur.getText(), addGlassMarka.getText(), 
				addGlassTip.getText(), Integer.parseInt(addGlassAks.getText()),Integer.parseInt(addGlassAdet.getText())));
		
		
	}
	
	public void addItemButton(ActionEvent event) throws SQLException{
		
		if(addItemBarkod.getText().equals("")) {
			addItemBarkod.setText("0");
		}
		if(addItemAdet.getText().equals("")) {
			addItemAdet.setText("0");
		}
		if(addItemAlisFiyat.getText().equals("")) {
			addItemAlisFiyat.setText("0");
		}
		if(addItemSatisFiyat.getText().equals("")) {
			addItemSatisFiyat.setText("0");
		}
		if(addItemUrun.getText().equals("")) {
			addItemUrun.setText("0");
		}
		
		
		
		model.Special tempItem=new model.Special(addItemBarkod.getText(),Double.parseDouble(addItemAlisFiyat.getText()),
				Double.parseDouble(addItemSatisFiyat.getText()), addItemUrun.getText(),Integer.parseInt(addItemAdet.getText()));
		ItemList.add(tempItem);
		itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
		itemAdet.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		itemAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		
		itemTable.getItems().add(new model.Special(addItemBarkod.getText(),Double.parseDouble(addItemAlisFiyat.getText()),
				Double.parseDouble(addItemSatisFiyat.getText()), addItemUrun.getText(),Integer.parseInt(addItemAdet.getText())));
	}
	
	public void saveContactLens(ActionEvent event) throws SQLException{
		for (int i=0;i<LensList.size();i++) {
			MasterController tempLens=new MasterController();
			tempLens.addContactLens(LensList.get(i).getBarcode(), LensList.get(i).getRenk(), 
					LensList.get(i).getOzelAdi(), LensList.get(i).getMultifokal(), LensList.get(i).getTemelEgri(), 
					LensList.get(i).getDiyoptri(), LensList.get(i).getAks(), LensList.get(i).getSilindirik(), 
					LensList.get(i).getTumCap(), LensList.get(i).getAlisFiyati(), LensList.get(i).getSatisFiyati(),LensList.get(i).getMiktar());
			
		}
		LensList.clear();
	}
	
	public void saveFrame(ActionEvent event) throws SQLException{
		for(int i =0;i<FrameList.size();i++) {
			MasterController tempFrame=new MasterController();
			tempFrame.addFrame(FrameList.get(i).getBarcode(), FrameList.get(i).getMarka(), FrameList.get(i).getModel(), FrameList.get(i).getEkartman(), 
					 FrameList.get(i).getRenk(), FrameList.get(i).getAlisFiyati(), FrameList.get(i).getSatisFiyati(),FrameList.get(i).getOzelAdi(),FrameList.get(i).getQuantity());
		}
		FrameList.clear();
	}
	
	public void saveGlass(ActionEvent event) throws SQLException{
		for(int i=0;i<GlassList.size();i++) {
			MasterController tempGlass=new MasterController();
			tempGlass.addGlass(GlassList.get(i).getBarcode(), GlassList.get(i).getAlisFiyati(), GlassList.get(i).getSatisFiyati(), GlassList.get(i).getSilendirik(),
					GlassList.get(i).getSferik(), GlassList.get(i).getTur(), GlassList.get(i).getMarka(), GlassList.get(i).getTip(), GlassList.get(i).getAks(),GlassList.get(i).getQuantity());
		}
		GlassList.clear();
	}
	
	public void saveItem(ActionEvent event) throws SQLException{
		for (int i =0;i<ItemList.size();i++) {
			MasterController tempItem=new MasterController();
			tempItem.addSpecial(ItemList.get(i).getBarcode(), ItemList.get(i).getOzelAdi(), ItemList.get(i).getAlisFiyati(), ItemList.get(i).getSatisFiyati(),ItemList.get(i).getQuantity());
		}
		ItemList.clear();
	}
	
	public void lensDrop (ActionEvent event) throws SQLException{
		
		LensList.remove(lensTable.getSelectionModel().getSelectedIndex());
		lensTable.getItems().removeAll(lensTable.getSelectionModel().getSelectedItem());
		
	}
	
	public void frameDrop (ActionEvent event) throws SQLException{
		
		FrameList.remove(frameTable.getSelectionModel().getSelectedIndex());
		frameTable.getItems().removeAll(frameTable.getSelectionModel().getSelectedItem());
		
	}
	
	public void glassDrop (ActionEvent event) throws SQLException{
		
		GlassList.remove(glassTable.getSelectionModel().getSelectedIndex());
		glassTable.getItems().removeAll(glassTable.getSelectionModel().getSelectedItem());
		
	}
	public void itemDrop (ActionEvent event) throws SQLException{
		
		ItemList.remove(itemTable.getSelectionModel().getSelectedIndex());
		itemTable.getItems().removeAll(itemTable.getSelectionModel().getSelectedItem());
		
	}
	public void lensClear(ActionEvent event) throws SQLException{
		addLensBarkod.clear();
		addLensTemelEgri.clear();
		addLensDiyoptri.clear();
		addLensTumCap.clear();
		addLensCyl.clear();
		addLensAks.clear();
		addLensMultifokal.clear();
		addLensRenk.clear();
		addLensOzelAd.clear();
		addLensAlisFiyat.clear();
		addLensSatisFiyat.clear();
		addLensAdet.clear();
	}
	
	public void frameClear(ActionEvent event) throws SQLException{
		addFrameBarkod.clear();
		addFrameMarka.clear();
		addFrameModel.clear();
		addFrameEkartman.clear();
		addFrameRenk.clear();
		addFrameAlisFiyat.clear();
		addFrameSatisFiyat.clear();
		addFrameAdet.clear();
		addFrameOzelAdi.clear();
		
	}
	
	public void glassClear(ActionEvent event) throws SQLException{
		addGlassBarkod.clear();
		addGlassMarka.clear();
		addGlassTur.clear();
		addGlassTip.clear();
		addGlassSferik.clear();
		addGlassSilendirik.clear();
		addGlassAks.clear();
		addGlassAlisFiyat.clear();
		addGlassSatisFiyat.clear();
		addGlassAdet.clear();
	}
	
	public void itemClear(ActionEvent event) throws SQLException{
		addItemBarkod.clear();
		addItemUrun.clear();
		addItemAlisFiyat.clear();
		addItemSatisFiyat.clear();
		addItemAdet.clear();
	}
	
	public void email(ActionEvent event) throws Exception{

		JOptionPane.showMessageDialog(null, "                    oculuspro@outlook.com \nAdresi üzerinden bizimle iletişime geçebilirsiniz.",
				"İletişim",JOptionPane.INFORMATION_MESSAGE);
	}

}
