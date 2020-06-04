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

public class CustomerController implements Initializable {

    MasterController tempCustomer = new MasterController();

    // CustomerScene Bilgileri
    @FXML
    TextField customer;

    private final ObservableList<model.Customer> customerList = FXCollections.observableArrayList();

    // Table
    @FXML
    TableView<model.Customer> customerTable = new TableView();
    @FXML
    TableColumn<String, model.Customer> customerTCNo = new TableColumn();
    @FXML
    TableColumn<String, model.Customer> customerName = new TableColumn();
    @FXML
    TableColumn<String, model.Customer> customerSurname = new TableColumn();
    @FXML
    TableColumn<String, model.Customer> customerPhone = new TableColumn();

    public void customer() throws SQLException {
        customerList.clear();

        customerTCNo.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("isim"));
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("telefon"));

        customerList.addAll(tempCustomer.getCustomer());
        customerTable.setItems(customerList);
        FilteredList<model.Customer> filteredCustomer = new FilteredList<>(customerList, b -> true);
        customer.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredCustomer.setPredicate(customer -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getTcNo().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (customer.getIsim().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (customer.getSoyisim().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;
                else if (customer.getTelefon().toLowerCase().indexOf(lowerCaseFilter) != -1)
                    return true;

                else
                    return false; // Does not match.
            });
        });
        SortedList<model.Customer> sortedCustomer = new SortedList<>(filteredCustomer);
        sortedCustomer.comparatorProperty().bind(customerTable.comparatorProperty());
        customerTable.setItems(sortedCustomer);


    }

    public void backMain(ActionEvent event) throws IOException {
        Stage mainStage = Main.parentWindow;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/resources/mainScene.fxml")));
        mainStage.setScene(scene);
    }


    public void clear(ActionEvent event) throws Exception {
        customer.clear();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        try {
            customerList.clear();
            customerList.addAll(tempCustomer.getCustomer());
            customerTable.setItems(customerList);
            customerTCNo.setCellValueFactory(new PropertyValueFactory<>("tcNo"));
            customerName.setCellValueFactory(new PropertyValueFactory<>("isim"));
            customerSurname.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
            customerPhone.setCellValueFactory(new PropertyValueFactory<>("telefon"));


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void email(ActionEvent event) throws Exception {

        JOptionPane.showMessageDialog(null, "                    oculuspro@outlook.com \nAdresi üzerinden bizimle iletişime geçebilirsiniz.",
                "İletişim", JOptionPane.INFORMATION_MESSAGE);
    }

}
