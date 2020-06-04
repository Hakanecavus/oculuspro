package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainController extends AnchorPane {

	

	@FXML
	public void sellShift(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellScene.fxml")));
		mainStage.setScene(scene);

	}

	public void stockShift(ActionEvent event) throws Exception {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/stockScene.fxml")));
		mainStage.setScene(scene);


	}

	public void priceShift(ActionEvent event) throws IOException {

		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/priceScene.fxml")));
		mainStage.setScene(scene);


	}

	public void customerShift(ActionEvent event) throws IOException {

		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/customerScene.fxml")));
		mainStage.setScene(scene);


	}
	
	public void passwordShift(ActionEvent event) throws IOException {

		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/passwordScene.fxml")));
		mainStage.setScene(scene);



	}

	public void sellSearchShift(ActionEvent event) throws IOException {

		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/sellSearchScene.fxml")));
		mainStage.setScene(scene);



	}

	public void profitShift(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/profitScene.fxml")));
		mainStage.setScene(scene);


	}

	public void backMain(ActionEvent event) throws IOException {
		Stage mainStage = Main.parentWindow;
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
		mainStage.setScene(scene);

	}
	public void email(ActionEvent event) throws Exception{
		
		JOptionPane.showMessageDialog(null, "   " +
						"                 oculuspro@outlook.com \nAdresi üzerinden bizimle iletşime geçebilirsiniz.",
				"İletişim",JOptionPane.INFORMATION_MESSAGE);
	}

	
}
