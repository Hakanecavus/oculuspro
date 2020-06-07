package controller;

import javafx.collections.ObservableList;
import model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MasterController {

    Database db = new Database();

    public MasterController() {

    }

    public void addContactLens(String barcode, String renk, String ozelAdi, double multifokal, double temelEgri,
                               double diyoptri, double aks, double silindirik, double tumCap, double alisFiyat, double satisFiyat,
                               int quantity) throws SQLException {

        db.writeContactLens(barcode, renk, ozelAdi, multifokal, temelEgri, diyoptri, aks, silindirik, tumCap,
                alisFiyat, satisFiyat, quantity);
    }

    public void addCustomer(String tcno, String isim, String soyisim, String telefon) throws SQLException {
        db.writeCustomer(tcno, isim, soyisim, telefon);
    }

    public void addExtra(String barcode, double satisFiyati, String ozelAdi) throws SQLException {
        db.writeExtra(barcode, satisFiyati, ozelAdi);

    }

    public void addFrame(String barcode, String marka, String model, String ekartman, String renk, double alisFiyati,
                         double satisFiyati, String ozelAdi, int quantity) throws SQLException {

        db.writeFrame(barcode, marka, model, ekartman, renk, alisFiyati, satisFiyati, ozelAdi, quantity);

    }

    public void addGlass(String barcode, double alisFiyati, double satisFiyati, double silendirik, double sferik,
                         String tur, String marka, String tip, int aks, int quantity) throws SQLException {
        db.writeGlass(barcode, alisFiyati, satisFiyati, silendirik, sferik, tur, marka, tip, aks, quantity);
    }

    public void addPrescription(String barcode, String olusturmaTarihi, String basvuruTarihi, String sigortaDurumu)
            throws SQLException {
        db.writePrescription(barcode, olusturmaTarihi, basvuruTarihi, sigortaDurumu);
    }

    public void addSale(double toplamFiyat, double indirim, String tcNo, String receteNo) throws SQLException {
        db.writeSale(toplamFiyat, indirim, tcNo, receteNo);
    }

    public void addSpecial(String barcode, String urunAdi, double alisFiyati, double satisFiyati, int quantity)
            throws SQLException {
        db.writeSpecial(barcode, urunAdi, alisFiyati, satisFiyati, quantity);
    }

    public void cancelSale(int saleId) throws SQLException {
// remember to delete the record!!!!!
        ArrayList<String> itemBarcodes = null; // barcodes for sold items
        int isSaleDeleted;
//		int isPrescriptionDeleted;
        int isRecordDeleted;
        String tableName;
        // get items from the sale
        itemBarcodes = db.searchRecords(saleId);

        // add items back
        for (int i = 0; i < itemBarcodes.size(); i++) {
            tableName = db.searchType(itemBarcodes.get(i));

            if (tableName.equals("ContactLens")) {
                db.updateLensQuantity(itemBarcodes.get(i), +1);
            } else if (tableName.equals("Extra")) {
                db.updateExtraQuantity(itemBarcodes.get(i), +1);

            } else if (tableName.equals("Frame")) {
                db.updateFrameQuantity(itemBarcodes.get(i), +1);

            } else if (tableName.equals("Glass")) {
                db.updateGlassQuantity(itemBarcodes.get(i), +1);

            } else if (tableName.equals("Special")) {
                db.updateSpecialQuantity(itemBarcodes.get(i), +1);

            }

        }

        // delete sale from database
        isSaleDeleted = db.deleteSale(saleId);

        // delete records
        isRecordDeleted = db.deleteRecord(saleId);

        if (isSaleDeleted != 0 && isRecordDeleted != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti!", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Belirtilen satış numarası silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public boolean checkLogin(String tempID, String tempPass) {
        boolean isLogged = false;
        isLogged = db.login(tempID, tempPass);
        return isLogged;
    }

    public ObservableList<ContactLens> findLens(String barcode) throws SQLException {
        return db.searchContactLens(barcode);
    }

    public ObservableList<Customer> findCustomer(String tckn) throws SQLException {
        return db.searchCustomers(tckn);
    }

    public ObservableList<Extra> findExtras(String barcode) throws SQLException {
        return db.searchExtrasByBarcode(barcode);
    }

    public ObservableList<Frame> findFrames(String barcode) throws SQLException {
        return db.searchFrames(barcode);
    }

    public ObservableList<Glass> findGlasses(String barcode) throws SQLException {
        return db.searchGlasses(barcode);
    }

    public ObservableList<Prescription> findPrescription(String searchReceteNo) throws Exception {
        return db.searchPrescriptions(searchReceteNo);
    }

    public ObservableList<Special> findSpecials(String barcode) throws SQLException {
        return db.searchSpecials(barcode);
    }

    public ObservableList<Object> findStock(String barcode) throws Exception {
        return db.searchAll(barcode);
    }

    public double findLensPrice(String barcode) throws SQLException {
        try {
            if (db.searchContactLens(barcode).get(0) != null) {
                return db.searchContactLens(barcode).get(0).getSatisFiyati();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;

    }

    public double findFramePrice(String barcode) throws SQLException {
        try {
            if (db.searchFrames(barcode).get(0) != null) {
                return db.searchFrames(barcode).get(0).getSatisFiyati();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;

    }

    public double findGlassPrice(String barcode) throws SQLException {
        try {
            if (db.searchGlasses(barcode).get(0) != null) {
                return db.searchGlasses(barcode).get(0).getSatisFiyati();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;

    }

    public double findSpecialPrice(String barcode) throws SQLException {
        try {
            if (db.searchSpecials(barcode).get(0) != null) {
                return db.searchSpecials(barcode).get(0).getSatisFiyati();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bulunamadı. Lütfen tekrar deneyin", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public ObservableList<Sale> findSaleBySaleId(int saleId) throws SQLException {
        ObservableList<Sale> sales = db.searchSales(saleId);
        return sales;
    }

    public String findTableName(String barcode) throws SQLException {
        return db.searchType(barcode);
    }

    public ArrayList<Object> findProductsBySaleId(int saleId) throws Exception {
        // String id;
        ArrayList<Object> resultList = new ArrayList<Object>(0);
        int size = db.searchRecords(saleId).size();

        for (int i = 0; i < size; i++) {
            String barcode = db.searchRecords(saleId).get(i);

            if (db.searchAll(barcode).size() == 0) {
                // System.out.println("zero array");
            } else {
                resultList.add(db.searchAll(barcode).get(0));
            }
        }
        return resultList;
    }

    public ArrayList<String> findRecordsBySaleId(int saleId) throws SQLException {
        return db.searchRecords(saleId);

    }

    public ArrayList<ContactLens> getContactLenses() throws SQLException {
        return db.readContactLenses();
    }

    public ArrayList<Customer> getCustomer() throws SQLException {
        return db.readCustomers();
    }

    public ArrayList<Extra> getExtras() throws SQLException {
        return db.readExtras();
    }

    public ArrayList<Frame> getFrames() throws SQLException {
        return db.readFrames();
    }

    public ArrayList<Glass> getGlasses() throws SQLException {
        return db.readGlasses();
    }

    public ArrayList<Prescription> getPrescription() throws Exception {
        return db.readPrescriptions();
    }

    public ArrayList<Sale> getSale() throws SQLException {
        return db.readSales();
    }

    public ArrayList<Special> getSpecials() throws SQLException {
        return db.readSpecials();
    }

    public void removeLens(String barcode) {
        int affectedRow = 0;

        try {
            if (!db.searchContactLens(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteLens(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Lens silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeCustomer(String tckn) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteCustomer(tckn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Müşteri silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeExtra(int id) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteExtra(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Extra silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeFrame(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchFrames(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteFrame(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Çerçeve silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeGlass(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchGlasses(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {

                affectedRow = db.deleteGlass(barcode);
                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cam silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removePrescription(String receteNo) {
        int affectedRow = 0;
        try {
            affectedRow = db.deletePrescription(receteNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Reçete silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeRecord(int saleId) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteRecord(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Kayıt silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeSale(int saleId) {
        int affectedRow = 0;
        try {
            affectedRow = db.deleteSale(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (affectedRow != 0) {
            JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Satış kaydı silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void removeSpecial(String barcode) {
        int affectedRow = 0;
        try {
            if (!db.searchSpecials(barcode).isEmpty() && db.searchItemRecords(barcode).isEmpty()) {
                affectedRow = db.deleteSpecial(barcode);

                if (affectedRow != 0) {
                    JOptionPane.showMessageDialog(null, "Silme işlemi başarıyla gerçekleşti", "Başarılı!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Özel ürün silinemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün daha önce satıldığı için silinemedi!!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean sellProducts(ArrayList<String> soldItems, double totalPrice, double discount, String tcNo,
                                String prescNumb) throws Exception {
        // Steps of sale
        // 1-Check stock for errors
        // 2-If everything is fine;
        //      I-add sale
        //      II-get sale id
        //      III-add each item
        // 3-else, show error


        boolean isSuccesfull = true;
        String tableName = "";
        int tempQuantity = 0;

        for (int i = 0; i < soldItems.size(); i++) {

            tableName = db.searchType(soldItems.get(i));
            // System.out.println(tableName);

            if (tableName.equals("ContactLens")) {

                tempQuantity = db.searchContactLens(soldItems.get(i)).get(0).getQuantity();

                if (tempQuantity <= 0) {
                    isSuccesfull = false;
                    break;
                }
            } else if (tableName.equals("Extra")) {

                // db.writeRecord(soldItems.get(i), saleId);
                // db.updateExtraQuantity(soldItems.get(i), -1);

            } else if (tableName.equals("Frame")) {

                tempQuantity = db.searchFrames(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    isSuccesfull = false;
                    break;
                }
            } else if (tableName.equals("Glass")) {

                tempQuantity = db.searchGlasses(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    isSuccesfull = false;
                    break;
                }
            } else if (tableName.equals("Special")) {

                tempQuantity = db.searchSpecials(soldItems.get(i)).get(0).getQuantity();
                if (tempQuantity <= 0) {
                    isSuccesfull = false;
                    break;
                }
            }
        }

        if (isSuccesfull) {
            db.writeSale(totalPrice, discount, tcNo, prescNumb);
            int saleId = db.readLastSaleId();

            for (int i = 0; i < soldItems.size(); i++) {


                tableName = db.searchType(soldItems.get(i));
                // System.out.println(tableName);

                if (tableName.equals("ContactLens")) {

                    db.writeRecord(soldItems.get(i), saleId);
                    db.updateLensQuantity(soldItems.get(i), -1);

                } else if (tableName.equals("Extra")) {

                    db.writeRecord(soldItems.get(i), saleId);
                    db.updateExtraQuantity(soldItems.get(i), -1);

                } else if (tableName.equals("Frame")) {


                    db.writeRecord(soldItems.get(i), saleId);
                    db.updateFrameQuantity(soldItems.get(i), -1);

                } else if (tableName.equals("Glass")) {


                    db.writeRecord(soldItems.get(i), saleId);
                    db.updateGlassQuantity(soldItems.get(i), -1);

                } else if (tableName.equals("Special")) {

                    db.writeRecord(soldItems.get(i), saleId);
                    db.updateSpecialQuantity(soldItems.get(i), -1);

                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Stok hatası. Ürün stoğu bitmiş olabilir", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

//		System.out.println("running");
        return isSuccesfull;
    }

    public ArrayList<Integer> searchByTckn(String tckn) throws SQLException {
        ArrayList<Integer> saleIds = new ArrayList<Integer>();
        // ArrayList<String> barcodes= new ArrayList<String>();

        saleIds = db.searchSale(tckn);
        return saleIds;
    }

    public ObservableList<Extra> getExtraBetweenDates(String firstDate, String lastDate) {

        try {
            return db.searchExtraBetween(firstDate, lastDate);
        } catch (SQLException e) {
            return null;
        }
    }

    public ObservableList<Sale> getSaleBetweenDates(String firstDate, String lastDate) {
        try {
            return db.searchSaleBetween(firstDate, lastDate);
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean changeLoginInfo(String oldUserName, String newUserName, String oldPass, String newPass) {
        ArrayList<String> userNameList = null;
        boolean changeUsername = true;

        if (oldUserName.equals("") || oldUserName == null) {
            JOptionPane.showMessageDialog(null, "Değiştirmek istediğiniz hesaba ait kullanıcı adı boş olamaz!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (oldPass.equals("") || oldPass == null) {
            JOptionPane.showMessageDialog(null, "Değiştirmek istediğiniz hesaba ait şifre boş olamaz!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;

        } else if (newPass.equals("") || newPass == null) {
            JOptionPane.showMessageDialog(null, "Yeni şifre boş olamaz!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        try {
            userNameList = db.searchUsers(oldUserName);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Böyle bir kullanıcı bulunamadı!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
        }

        if (newUserName.equals("") || newUserName == null) {
            changeUsername = false;        // change password only
        }

        if (userNameList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Böyle bir kullanıcı bulunamadı!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (oldUserName.equals(newUserName)) {
            JOptionPane.showMessageDialog(null, "Kullanıcı adı eskisiyle aynı olamaz!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!(userNameList.get(1).equals(oldPass))) {
            JOptionPane.showMessageDialog(null, "Eski şifre eksik ya da hatalı!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (oldPass.equals(newPass)) {
            JOptionPane.showMessageDialog(null, "Eski şifre yeni şifre ile aynı olamaz!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

        if (changeUsername) {
            try {
                db.updateUserName(oldUserName, newUserName);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kullanıcı adı değiştirilemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            try {
                db.updatePassword(newUserName, newPass);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Kullanıcı adı değiştirildi,\n ancak "
                        + "şifre değiştirilemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        } else {
            try {
                db.updatePassword(newUserName, newPass);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Şifre değiştirilemedi!", "Hata!", JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
        }


        return true;
    }

}// end class
