package test;

import model.Customer;
import model.Database;

import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();

        // write
//        db.writeContactLens("barcode1","diyoptri1","aks1","silindirik1", "tarih1",50,100,1);
//        db.writeCustomer("tckn1","isim1","soyisim1","telefon1");

        for (int i = 0; i < db.readContactLenses().size(); i++) {
            System.out.println(db.readContactLenses().get(i).toString());
        }
        for (Customer cust: db.readCustomers()) {
            System.out.println(cust.toString());
        }

    }
}
