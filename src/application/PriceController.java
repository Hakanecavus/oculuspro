package application;

import controller.MasterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PriceController implements Initializable {
	MasterController tempPrice = new MasterController();

	// priceScene Bilgileri
	@FXML
	TextField priceAra;

	// Price Table
	private final ObservableList<model.ContactLens> lensList = FXCollections.observableArrayList();
	private final ObservableList<model.Glass> glassList = FXCollections.observableArrayList();
	private final ObservableList<model.Frame> frameList = FXCollections.observableArrayList();
	private final ObservableList<model.Special> itemList = FXCollections.observableArrayList();

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
	TableColumn<Double, model.ContactLens> lensStok = new TableColumn();

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
	TableColumn<Double, model.Frame> frameStok = new TableColumn();

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
	TableColumn<Double, model.Glass> glassStok = new TableColumn();

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
	TableColumn<Double, model.Special> itemStok = new TableColumn();

	public PriceController() throws SQLException {

	}

	public void initialize(URL location, ResourceBundle resources) {
		try {

			lensList.clear();
			glassList.clear();
			frameList.clear();
			itemList.clear();

			lensList.addAll(tempPrice.getContactLenses());
			glassList.addAll(tempPrice.getGlasses());
			frameList.addAll(tempPrice.getFrames());
			itemList.addAll(tempPrice.getSpecials());

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
			lensStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

			glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
			glassMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
			glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
			glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
			glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
			glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
			glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
			glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
			glassStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

			frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
			frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
			frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
			frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
			frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
			frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
			frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
			frameStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

			itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
			itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
			itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
			itemStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

			lensTable.setItems(lensList);
			glassTable.setItems(glassList);
			frameTable.setItems(frameList);
			itemTable.setItems(itemList);

		} catch (SQLException e) {
			// TODO Mettre une popup erreur base de données
			e.printStackTrace();
		}

	}


	public void price() throws Exception {
		lensList.clear();
		glassList.clear();
		frameList.clear();
		itemList.clear();

		// lens table
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
		lensStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		lensList.addAll(tempPrice.getContactLenses());
		lensTable.setItems(lensList);
		FilteredList<model.ContactLens> filteredLens = new FilteredList<>(lensList, b -> true);
		priceAra.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredLens.setPredicate(lens -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (lens.getBarcode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (lens.getEklemeTarihi().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}

				else if (String.valueOf(lens.getId()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getMultifokal()).indexOf(lowerCaseFilter) != -1)
					return true;

				else if (String.valueOf(lens.getTemelEgri()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getDiyoptri()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getAks()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getSilindirik()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getTumCap()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (lens.getRenk().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (lens.getOzelAdi().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getAlisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(lens.getSatisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else
					return false; // Does not match.
			});
		});
		SortedList<model.ContactLens> sortedLens = new SortedList<>(filteredLens);
		sortedLens.comparatorProperty().bind(lensTable.comparatorProperty());
		lensTable.setItems(sortedLens);

		// glass table
		glassBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		glassMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		glassTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
		glassTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
		glassSferik.setCellValueFactory(new PropertyValueFactory<>("sferik"));
		glassSilendirik.setCellValueFactory(new PropertyValueFactory<>("silendirik"));
		glassAks.setCellValueFactory(new PropertyValueFactory<>("aks"));
		glassAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		glassSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		glassStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		glassList.addAll(tempPrice.getGlasses());
		glassTable.setItems(glassList);
		FilteredList<model.Glass> filteredGlass = new FilteredList<>(glassList, b -> true);
		priceAra.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredGlass.setPredicate(glass -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (glass.getBarcode().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(glass.getSferik()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(glass.getSilendirik()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(glass.getAks()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (glass.getTip().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (glass.getMarka().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (glass.getTur().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(glass.getAlisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(glass.getSatisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else
					return false; // Does not match.
			});
		});
		SortedList<model.Glass> sortedGlass = new SortedList<>(filteredGlass);
		sortedGlass.comparatorProperty().bind(glassTable.comparatorProperty());
		glassTable.setItems(sortedGlass);

		// frame table

		frameBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		frameMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
		frameModel.setCellValueFactory(new PropertyValueFactory<>("model"));
		frameEkartman.setCellValueFactory(new PropertyValueFactory<>("ekartman"));
		frameOzelAdi.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
		frameRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
		frameAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		frameSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		frameStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		frameList.addAll(tempPrice.getFrames());
		frameTable.setItems(frameList);
		FilteredList<model.Frame> filteredFrame = new FilteredList<>(frameList, b -> true);
		priceAra.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredFrame.setPredicate(frame -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (frame.getBarcode().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (frame.getEkartman().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (frame.getMarka().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (frame.getModel().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (frame.getOzelAdi().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (frame.getRenk().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(frame.getAlisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(frame.getSatisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else
					return false; // Does not match.
			});
		});
		SortedList<model.Frame> sortedFrame = new SortedList<>(filteredFrame);
		sortedFrame.comparatorProperty().bind(frameTable.comparatorProperty());
		frameTable.setItems(sortedFrame);

		// item table
		itemBarkod.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		itemUrun.setCellValueFactory(new PropertyValueFactory<>("ozelAdi"));
		itemAlisFiyat.setCellValueFactory(new PropertyValueFactory<>("alisFiyati"));
		itemSatisFiyat.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
		itemStok.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		itemList.addAll(tempPrice.getSpecials());
		itemTable.setItems(itemList);
		FilteredList<model.Special> filteredItem = new FilteredList<>(itemList, b -> true);
		priceAra.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredItem.setPredicate(item -> {
				// If filter text is empty, display all persons.

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (item.getBarcode().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (item.getOzelAdi().toLowerCase().indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(item.getAlisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else if (String.valueOf(item.getSatisFiyati()).indexOf(lowerCaseFilter) != -1)
					return true;
				else
					return false; // Does not match.
			});
		});
		SortedList<model.Special> sortedItem = new SortedList<>(filteredItem);
		sortedItem.comparatorProperty().bind(itemTable.comparatorProperty());
		itemTable.setItems(sortedItem);

	}

	public void backMain(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
		mainStage.setScene(scene);

	}

	public void clear(ActionEvent event) throws Exception {
		priceAra.clear();
	}

	public void email(ActionEvent event) throws Exception {

		JOptionPane.showMessageDialog(null,
				"   " + "                 oculuspro@outlook.com \nAdresi üzerinden bizimle iletşime geçebilirsiniz.",
				"İletişim", JOptionPane.INFORMATION_MESSAGE);
	}
}
