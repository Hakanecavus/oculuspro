package test;

import model.*;

public class DatabaseTest {

    public static void main(String[] args) throws Exception {
        Database db = new Database();
//
//        System.out.println("////////////////////// WRITE METHODS ////////////////////");
//        db.writeContactLens("barcode1", "diyoptri1", "aks1", "silindirik1", "tarih1"
//                , 50, 100, 1);
//        db.writeCustomer("tckn1", "isim1", "soyisim1", "telefon1");
//        db.writeExtra("extraBarcode1", 5000, "kira", "extratarih1");
//        db.writeFrame("frameBarcode1", "frameMarka1", "frameModel1", "frameEkartman1",
//                "frameRenk1", 50, 100, "frameOzelAdı1", 1);
//        db.writeGlass("glassBarcode1", 50, 100, "glassTur1", "glassMarka1",
//                "glassIndex1", "glasstarih1", 1);
//        db.writePrescriptionLens("lensReceteNo1", "lensReceteTarihi1", "lensTarih1",
//                "rlBarcode1", "rlTemelEgri1", "rlTumCap1", "rlTorik1",
//                "rlMultifokal1", "rlRenk", "rlOzelAdi1", "llBarcode1",
//                "llTemelEgri1", "llTumCap1", "llTorik", "llMultifokal1",
//                "llRenk1", "llOzelAd");
//        db.writePrescriptionCam("prescCamReceteNo1", "prescCamRecTarih1", "prescCamTarih1",
//                "rcBarcode1", "rcSph1", "rcCyl1", "rcAx1", "rcPd1", "rcYuks1",
//                "lcBarcode1", "lcSph1", "lcCyl1", "lcAx1", "lcPd1", "lcYukseklik1");
//        db.writeRecord("productBarcode1", 1);
//        db.writeSale(500000, "bugün", "tcNo1", "camReceteNo1", "lensReceteNo1", 50, 50, 50);
//        db.writeSpecial("specialBarcode1", "specUrunAdi1", "bugün", 50, 100, 1);
//        db.writeSpecial("specialBarcode2", "specUrunAdi2", "bugün", 50, 100, 1);
//        db.writeUser("admin", "ttnet");
//
//        System.out.println("////////////////////// READ METHODS ////////////////////");
//        for (int i = 0; i < db.readContactLenses().size(); i++) {
//            System.out.println(db.readContactLenses().get(i).toString());
//        }
//        for (Customer cust : db.readCustomers()) {
//            System.out.println(cust.toString());
//        }
//        for (Extra ex : db.readExtras()) {
//            System.out.println(ex.toString());
//        }
//        for (Frame fr : db.readFrames()) {
//            System.out.println(fr.toString());
//        }
//        for (Glass glass : db.readGlasses()) {
//            System.out.println(glass.toString());
//        }
//        for (PrescriptionLens pl : db.readPrescriptionLens()) {
//            System.out.println(pl.toString());
//        }
//        for (PrescriptionCam pc : db.readPrescriptionsCam()) {
//            System.out.println(pc.toString());
//        }
//        for (Record record : db.readRecord()) {
//            System.out.println(record.toString());
//        }
//        for (Sale sale : db.readSales()) {
//            System.out.println(sale.toString());
//        }
//        for (Special sp : db.readSpecials()) {
//            System.out.println(sp.toString());
//        }
//        for (int i = 0; i < (db.readUsers().size() / 2); i++) {
//            System.out.println("Username: "+db.readUsers().get(2 * i)); // prints usernames
//            System.out.println("Password: "+db.readUsers().get((2 * i) + 1)); // prints passwords
//            System.out.println("Trying to login: "+db.login(db.readUsers().get(2 * i), db.readUsers().get((2 * i) + 1))); // check if works
//            System.out.println("--------------------------------------------------");
//        }

//        System.out.println("Search all by barcode: "+db.searchAll("null").size());
//        System.out.println("Search sales by sale id: "+db.searchSales(1).size());
//        System.out.println(db.searchSale("tcNo1").isEmpty());
//        System.out.println(db.searchSale("654658315").isEmpty());
//        System.out.println("Search type: "+ db.searchType("frameBarcode1"));
//        System.out.println("Search records: "+db.searchRecords(15436).isEmpty());
//        System.out.println("Search item record: "+db.searchItemRecords("productBarcode1").isEmpty());
//        System.out.println(db.searchExtraBetween("2020-06-10 23:02:10","2020-06-12 23:02:10").get(0).toString());
//        System.out.println(db.searchSaleBetween("2020-06-10 23:02:10","2020-06-12 23:02:10").get(0).toString());
//
//        System.out.println("////////////////////////////////DELETE METHODS////////////////////////////////////////");
//        System.out.println("delete customer: "+db.deleteCustomer("tckn1"));
//        System.out.println("delete lens: "+db.deleteLens("barcode1"));
//        System.out.println("delete extras: "+db.deleteExtra(1));
//        System.out.println("delete frame: "+db.deleteFrame("frameBarcode1"));
//        System.out.println("delete glass: "+db.deleteGlass("glassBarcode1"));
//        System.out.println("delete prescription cam: "+db.deletePrescriptionCam("prescCamReceteNo1"));
//        System.out.println("delete prescription lens: "+db.deletePrescriptionLens("lensReceteNo1"));
//        System.out.println("delete prescription record: "+db.deleteRecord(1));
//        System.out.println("delete prescription sale: "+db.deleteSale(1));
//        System.out.println("delete prescription special: "+db.deleteSpecial("specialBarcode1"));
//
//        db.vacuumDatabase();
//        System.out.println(db.readLastSaleId());
    }

}
