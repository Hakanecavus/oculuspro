package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    // they store the search results
    private ObservableList<ContactLens> lenses;
    private ObservableList<Customer> customers;
    private ObservableList<Extra> extras;
    private ObservableList<Frame> frames;
    private ObservableList<Glass> glasses;
    private ObservableList<PrescriptionCam> prescriptionCams;
    private ObservableList<PrescriptionLens> prescriptionLenses;
    private ObservableList<Sale> sales;
    private ObservableList<Special> specials;
    private ObservableList<Object> objects;
    private ArrayList<String> userList;

    // Stores column names
    private ArrayList<String> contactLensColumnName;
    private ArrayList<String> customerColumnName;
    private ArrayList<String> extraColumnName;
    private ArrayList<String> frameColumnName;
    private ArrayList<String> glassColumnName;
    private ArrayList<String> prescriptionColumnName;
    private ArrayList<String> recordColumnName;
    private ArrayList<String> saleColumnName;
    private ArrayList<String> specialColumnName;

    private String url = "jdbc:sqlite:database.db";
    private Connection con = null;

    public Database() {


        contactLensColumnName = new ArrayList<String>();
        customerColumnName = new ArrayList<String>();
        extraColumnName = new ArrayList<String>();
        frameColumnName = new ArrayList<String>();
        glassColumnName = new ArrayList<String>();
        prescriptionColumnName = new ArrayList<String>();
        recordColumnName = new ArrayList<String>();
        saleColumnName = new ArrayList<String>();
        specialColumnName = new ArrayList<String>();

        lenses = FXCollections.observableArrayList();
        customers = FXCollections.observableArrayList();
        extras = FXCollections.observableArrayList();
        frames = FXCollections.observableArrayList();
        glasses = FXCollections.observableArrayList();
        prescriptionCams = FXCollections.observableArrayList();
        prescriptionLenses = FXCollections.observableArrayList();
        sales = FXCollections.observableArrayList();
        specials = FXCollections.observableArrayList();
        userList = new ArrayList<String>();

        connect();


//        createDatabaseFile(); // TODO: fill method
    }

    public void createDatabaseFile() {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("");
            ps.executeUpdate();

            ps = con.prepareStatement("");

            ps.executeUpdate();
            ps = con.prepareStatement("");
            ps.executeUpdate();

            ps = con.prepareStatement("");
            ps.executeUpdate();

            ps = con.prepareStatement("");
            ps.executeUpdate();
            ps = con.prepareStatement("");
            ps.executeUpdate();
            ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS \"record\" (\n" +
                    "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"product_barcode\"\tTEXT,\n" +
                    "\t\"sale_id\"\tINTEGER\n" +
                    ")");
            ps.executeUpdate();
            ps = con.prepareStatement("");
            ps.executeUpdate();
            ps = con.prepareStatement("");
            ps.executeUpdate();
            ps = con.prepareStatement("");
            ps.executeUpdate();
//            ps = con.prepareStatement("INSERT INTO users(username,password) \n" +
//                    "SELECT 'ceylanoptik', 'ceylan123'\n" +
//                    "WHERE NOT EXISTS(SELECT * FROM users WHERE username = 'oculuspro' AND password = '12345');\n");
//            ps.executeUpdate();

//            ps = con.prepareStatement("INSERT INTO users(username,password) \n" +
//                    "SELECT 'oculuspro', '12345'\n" +
//                    "WHERE NOT EXISTS(SELECT * FROM users WHERE username = 'oculuspro' AND password = '12345');\n");
//            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        } finally {

            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
//////////////////////////////////////// Read methods //////////////////////////////////////////////////////////////////
    public ObservableList<ContactLens> readContactLenses() throws SQLException {

        int id;
        String barcode;
        String diyoptri;
        String aks;
        String silindirik;
        String tarih;
        double alisFiyati;
        double satisFiyati;
        int quantity;

        if (con == null) {
            connect();
        }
        lenses.clear();

        PreparedStatement ps = con.prepareStatement("select * from contact_lenses");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty

            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_contact");
                barcode = rs.getString("barcode");
                diyoptri = rs.getString("diyoptri");
                aks = rs.getString("aks");
                silindirik = rs.getString("silindirik");
                tarih = rs.getString("ekleme_tarihi");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                quantity = rs.getInt("quantity");

                ContactLens contactLens = new ContactLens(id,barcode,diyoptri,aks,silindirik,tarih,alisFiyati,satisFiyati,quantity);
                lenses.add(contactLens);
            } while (rs.next());
        }
        ps.close();
        rs.close();
        return lenses;
    }

    public ObservableList<Customer> readCustomers() throws SQLException {

        int id;
        String tcNo;
        String eklemeTarihi;
        String isim;
        String soyisim;
        String telefon;

        if (con == null) {
            connect();
        }

        customers.clear();

        PreparedStatement statement = con.prepareStatement("select * from customer");
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_customer");
                tcNo = rs.getString("tckn");
                eklemeTarihi = rs.getString("tarih");
                isim = rs.getString("isim");
                soyisim = rs.getString("soyisim");
                telefon = rs.getString("telefon");

                Customer customer = new Customer(id, tcNo, eklemeTarihi, isim, soyisim, telefon);
                customers.add(customer);
            } while (rs.next());
        }
        statement.close();
        rs.close();

        return customers;
    }

    public ObservableList<Extra> readExtras() throws SQLException {

        int id;
        String barcode;
        double satisFiyati;
        String ozelAdi;
        String eklemeTarihi;

        if (con == null) {
            connect();
        }
        extras.clear();
        PreparedStatement ps = con.prepareStatement("select * from extras");

        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //  System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_extras");
                barcode = rs.getString("barcode");
                satisFiyati = rs.getDouble("satis_fiyati");
                ozelAdi = rs.getString("aciklama");
                eklemeTarihi = rs.getString("ekleme_tarihi");

                Extra extra = new Extra(id, barcode, ozelAdi, eklemeTarihi, satisFiyati);
                extras.add(extra);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return extras;
    }

    public ObservableList<Frame> readFrames() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String renk;
        String marka;
        String model;
        String ekartman;
        String eklemeTarihi;
        String ozelAdi;
        int quantity;

        if (con == null) {
            connect();
        }
        frames.clear();

        PreparedStatement ps = con.prepareStatement("select * from frames");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //   System.out.println("Empty result");
        } else {
            do {

                id = rs.getInt("id_frame");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                renk = rs.getString("renk");
                marka = rs.getString("marka");
                model = rs.getString("model");
                ekartman = rs.getString("ekartman");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                ozelAdi = rs.getString("ozel_adi");
                quantity = rs.getInt("quantity");

                Frame frame = new Frame(id, barcode, alisFiyati, satisFiyati, renk, marka, model, ozelAdi, ekartman,
                        eklemeTarihi, quantity);
                frames.add(frame);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return frames;
    }

    public ArrayList<Glass> readGlasses() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String tur;
        String marka;
        String index;
        String tarih;
        int quantity;

        if (con == null) {
            connect();
        }

        glasses.clear();

        PreparedStatement ps = con.prepareStatement("select * from glass");
        ResultSet rs = ps.executeQuery();


        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_glass");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                tur = rs.getString("tur");
                marka = rs.getString("marka");
                tarih = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");
                index = rs.getString("index");
                Glass glass = new Glass();
                glasses.add(glass);
            } while (rs.next());
        }


        ps.close();
        rs.close();

        return glasses;
    }

    public ArrayList<PrescriptionCam> readPrescriptions() throws SQLException {

        int id;
        String receteNo;
        String olusturmaTarihi;
        String basvuruTarihi;
        String teslimTarihi;
        String sigortaDurumu;

        if (con == null) {
            connect();
        }

        prescriptionList.clear();

        PreparedStatement ps = con.prepareStatement("select * from prescription");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_prescription");
                receteNo = rs.getString("recete_no");
                olusturmaTarihi = rs.getString("olusturma_tarihi");
                basvuruTarihi = rs.getString("basvuru_tarihi");
                teslimTarihi = rs.getString("teslim_tarihi");
                sigortaDurumu = rs.getString("sigorta_durumu");

                PrescriptionCam prescription = new PrescriptionCam(id, receteNo, olusturmaTarihi, basvuruTarihi, teslimTarihi,
                        sigortaDurumu);
                prescriptionList.add(prescription);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return prescriptionList;
    }

    public ArrayList<Record> readRecord() throws SQLException {

        int id;
        String productBarcode;
        int saleId;

        if (con == null) {
            connect();
        }

        recordList.clear();

        PreparedStatement ps = con.prepareStatement("select * from record");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            //System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id");
                productBarcode = rs.getString("product_barcode");
                saleId = rs.getInt("sale_id");

                Record record = new Record(id, productBarcode, saleId);
                recordList.add(record);

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return recordList;
    }

    public ArrayList<Sale> readSales() throws SQLException {

        int id;
        double toplamFiyat;
        double indirim;
        String eklemeTarihi;
        String tcNo;
        String receteNo;

        if (con == null) {
            connect();
        }

        saleList.clear();

        PreparedStatement ps = con.prepareStatement("select * from sale");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                indirim = rs.getDouble("indirim");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                tcNo = rs.getString("tc_no");
                receteNo = rs.getString("recete_no");

                Sale sale = new Sale(id, toplamFiyat, indirim, eklemeTarihi, tcNo, receteNo);
                saleList.add(sale);
            } while (rs.next());
        }

        ps.close();
        rs.close();
        return saleList;
    }

    public ArrayList<Special> readSpecials() throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String urunAdi;
        String eklemeTarihi;
        int quantity;

        if (con == null) {
            connect();
        }
        specialList.clear();
        PreparedStatement ps = con.prepareStatement("select * from special");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_special");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                urunAdi = rs.getString("urun_adi");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                Special special = new Special(id, barcode, alisFiyati, satisFiyati, urunAdi, eklemeTarihi, quantity);
                specialList.add(special);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return specialList;
    }

    public ArrayList<String> readUsers() throws SQLException {
        String userName;
        String password;

        if (con == null) {
            connect();
        }

        userList.clear();

        PreparedStatement ps = con.prepareStatement("select * from users");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                userName = rs.getString("username");
                password = rs.getString("password");

                userList.add(userName);
                userList.add(password);

            } while (rs.next());
        }


        ps.close();
        rs.close();

        return userList;
    }

    ///////////////////////////////////// Write methods ////////////////////////////////////////////////////////////////////
    public void writeContactLens(String barcode, String renk, String ozelAdi, double multifokal, double temelEgri,
                                 double diyoptri, double aks, double silindirik, double tumCap, double alisFiyat,
                                 double satisFiyat, int quantity) throws SQLException {

        if (con == null) {
            connect();
        }

        // if it is already in, then update
        if (searchContactLens(barcode).isEmpty()) {

            PreparedStatement ps = con.prepareStatement("insert into contact_lenses(barcode,renk,ozel_adi," +
                    "multifokal,temel_egri,diyoptri,aks,silindirik,tum_cap,alis_fiyati,satis_fiyati,quantity) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, barcode);
            ps.setString(2, renk);
            ps.setString(3, ozelAdi);
            ps.setDouble(4, multifokal);
            ps.setDouble(5, temelEgri);
            ps.setDouble(6, diyoptri);
            ps.setDouble(7, aks);
            ps.setDouble(8, silindirik);
            ps.setDouble(9, tumCap);
            ps.setDouble(10, alisFiyat);
            ps.setDouble(11, satisFiyat);
            ps.setInt(12, quantity);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();

            }

            ps.close();

        } else {
            updateLensQuantity(barcode, quantity);
        }

    }

    public void writeCustomer(String tcno, String isim, String soyisim, String telefon) throws SQLException {

        if (con == null) {
            connect();
        }
        if (searchCustomers(tcno).isEmpty()) {
            PreparedStatement ps = con.prepareStatement("insert into customer(tckn, isim, soyisim, telefon)" +
                    " values(?,?,?,?)");
            ps.setString(1, tcno);
            ps.setString(2, isim);
            ps.setString(3, soyisim);
            ps.setString(4, telefon);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            // TODO: customer is already in there, so deal with it
        }
    }

    public void writeExtra(String barcode, double satisFiyati, String ozelAdi) throws SQLException {
        if (con == null) {
            connect();
        }
        if (searchExtrasByBarcode(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement("insert into extras(barcode,aciklama, satis_fiyati)" +
                    " values(?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, ozelAdi);
            ps.setDouble(3, satisFiyati);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            updateExtraQuantity(barcode, 1);
        }
    }

    public void writeFrame(String barcode, String marka, String model, String ekartman, String renk, double alisFiyati,
                           double satisFiyati, String ozelAdi, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }

        if (searchFrames(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into frames(barcode,marka,model,ekartman,renk,alis_fiyati,satis_fiyati,ozel_adi," +
                            "quantity) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, marka);
            ps.setString(3, model);
            ps.setString(4, ekartman);
            ps.setString(5, renk);
            ps.setDouble(6, alisFiyati);
            ps.setDouble(7, satisFiyati);
            ps.setString(8, ozelAdi);
            ps.setInt(9, quantity);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            updateFrameQuantity(barcode, quantity);
        }

    }

    public void writeGlass(String barcode, double alisFiyati, double satisFiyati, double silendirik, double sferik,
                           String tur, String marka, String tip, int aks, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }

        if (searchGlasses(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into glass(barcode,alis_fiyati,satis_fiyati,silendirik,sferik,tur,marka,tip,aks," +
                            "quantity) values(?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, barcode);
            ps.setDouble(2, alisFiyati);
            ps.setDouble(3, satisFiyati);
            ps.setDouble(4, silendirik);
            ps.setDouble(5, sferik);
            ps.setString(6, tur);
            ps.setString(7, marka);
            ps.setString(8, tip);
            ps.setInt(9, aks);
            ps.setInt(10, quantity);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            updateGlassQuantity(barcode, quantity);
        }

    }

    public void writePrescription(String receteNo, String olusturmaTarihi, String basvuruTarihi, String sigortaDurumu)
            throws SQLException {
        if (con == null) {
            connect();
        }
        if (searchPrescriptions(receteNo).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into prescription(recete_no,olusturma_tarihi,basvuru_tarihi,sigorta_durumu)" +
                            " values(?,?,?,?)");

            ps.setString(1, receteNo);
            ps.setString(2, olusturmaTarihi);
            ps.setString(3, basvuruTarihi);
            ps.setString(4, sigortaDurumu);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            // TODO: it is already in there
        }
    }

    public void writeRecord(String productBarcode, int saleId) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("insert into record(product_barcode,sale_id) values(?,?)");
        // TODO: check record
        ps.setString(1, productBarcode);
        ps.setInt(2, saleId);

        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
    }

    public void writeSale(double toplamFiyat, double indirim, String tcNo, String receteNo) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("insert into sale(toplam_fiyat,indirim,tc_no,recete_no)" +
                " values(?,?,?,?)");

        ps.setDouble(1, toplamFiyat);
        ps.setDouble(2, indirim);
        ps.setString(3, tcNo);
        ps.setString(4, receteNo);

        try {
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ps.close();
    }

    public void writeSpecial(String barcode, String urunAdi, double alisFiyati, double satisFiyati, int quantity)
            throws SQLException {
        if (con == null) {
            connect();
        }
        if (searchSpecials(barcode).isEmpty()) {
            PreparedStatement ps = con.prepareStatement(
                    "insert into special(barcode,urun_adi,alis_fiyati,satis_fiyati,quantity) values(?,?,?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, urunAdi);
            ps.setDouble(3, alisFiyati);
            ps.setDouble(4, satisFiyati);
            ps.setInt(5, quantity);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } else {
            updateSpecialQuantity(barcode, quantity);
        }

    }

    public void writeUser(String userName, String password) throws SQLException {
        if (con == null) {
            connect();
        }

        if (searchUsers(userName).isEmpty()) {
            PreparedStatement ps = con.prepareStatement("insert into users(username, password) values(?,?)");
            ps.setString(1, userName);
            ps.setString(2, password);

            try {
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();

        } else {
            // TODO: user is already in there
        }
    }

    ///////////////////////////////////// Read column name methods /////////////////////////////////////////////////////////
    public void readContactLensColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        contactLensColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM contact_lenses");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            contactLensColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readCustomerColumnName() throws SQLException {
        if (con == null) {
            connect();
        }

        customerColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM customer");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            customerColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readExtraColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        extraColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM extras");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            extraColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readFrameColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        frameColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM frames");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            frameColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readGlassColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        glassColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM glass");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            glassColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public int readLastSaleId() throws Exception {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("SELECT max(id_sale) as id_sale FROM sale");
        ResultSet rs = ps.executeQuery();
        int result = rs.getInt("id_sale");
        ps.close();
        rs.close();

        return result;
    }

    public void readPrescriptionColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        prescriptionColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM prescription");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            prescriptionColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readRecordColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        recordColumnName.clear();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM record");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            recordColumnName.add(name);
        }
        ps.close();
        rs.close();
    }

    public void readSaleColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        saleColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            saleColumnName.add(name);

        }
        ps.close();
        rs.close();
    }

    public void readSpecialColumnName() throws SQLException {
        if (con == null) {
            connect();
        }
        specialColumnName.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM special");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String name = rsmd.getColumnName(i);
            specialColumnName.add(name);

        }
        ps.close();
        rs.close();
    }

    public boolean login(String tempID, String tempPass) {
        String dbId;
        String dbPass;
        if (con == null) {
            connect();
        }

        try {
            PreparedStatement ps = con.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                // TODO: no user in the database
            } else {
                do {
                    dbId = rs.getString("username");
                    dbPass = rs.getString("password");

                    if (tempID.equals(dbId) && tempPass.equals(dbPass)) {
                        return true;
                    }
                } while (rs.next());
            }

            ps.close();
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
///////////////////////////////////// Search methods ///////////////////////////////////////////////////////////////////

    public ObservableList<ContactLens> searchContactLens(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double multifokal;
        double temelEgri;
        double diyoptri;
        double aks;
        double silindirik;
        double tumCap;
        String renk;
        String ozelAdi;
        String eklemeTarihi;
        double alisFiyati;
        double satisFiyati;
        int quantity;

        if (con == null) {
            connect();
        }

        searchResultLens.clear();

        PreparedStatement ps = con.prepareStatement("select * from contact_lenses where barcode='" + searchBarcode
                + "'");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_contact");
                barcode = rs.getString("barcode");
                multifokal = rs.getDouble("multifokal");
                temelEgri = rs.getDouble("temel_egri");
                diyoptri = rs.getDouble("diyoptri");
                aks = rs.getDouble("aks");
                silindirik = rs.getDouble("silindirik");
                tumCap = rs.getDouble("tum_cap");
                renk = rs.getString("renk");
                ozelAdi = rs.getString("ozel_adi");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                quantity = rs.getInt("quantity");

                searchResultLens.add(new ContactLens(id, barcode, multifokal, temelEgri, diyoptri, aks, silindirik,
                        tumCap, renk, ozelAdi, eklemeTarihi, alisFiyati, satisFiyati, quantity));

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultLens;
    }

    public ObservableList<Customer> searchCustomers(String tckn) throws SQLException {

        int id;
        String tcNo;
        String eklemeTarihi;
        String isim;
        String soyisim;
        String telefon;

        if (con == null) {
            connect();
        }
        searchResultCustomer.clear();
        PreparedStatement statement = con.prepareStatement("select * from customer where tckn = ?");
        statement.setString(1, tckn);
        ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            //  System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_customer");
                tcNo = rs.getString("tckn");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                isim = rs.getString("isim");
                soyisim = rs.getString("soyisim");
                telefon = rs.getString("telefon");

                searchResultCustomer.add(new Customer(id, tcNo, eklemeTarihi, isim, soyisim, telefon));

            } while (rs.next());
        }

        statement.close();
        rs.close();

        return searchResultCustomer;
    }

    public ObservableList<Extra> searchExtrasByBarcode(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double satisFiyati;
        String ozelAdi;
        String eklemeTarihi;

        if (con == null) {
            connect();
        }
        searchResultExtra.clear();
        PreparedStatement ps = con.prepareStatement("select * from extras where barcode='" + searchBarcode + "'");

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_extras");
                barcode = rs.getString("barcode");
                satisFiyati = rs.getDouble("satis_fiyati");
                ozelAdi = rs.getString("aciklama");
                eklemeTarihi = rs.getString("ekleme_tarihi");

                extraList.add(new Extra(id, barcode, ozelAdi, eklemeTarihi, satisFiyati));

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultExtra;
    }

    public ObservableList<Frame> searchFrames(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String renk;
        String marka;
        String model;
        String ekartman;
        String eklemeTarihi;
        String ozelAdi;
        int quantity;

        if (con == null) {
            connect();
        }
        searchResultFrame.clear();
        PreparedStatement ps = con.prepareStatement("select * from frames where barcode='" + searchBarcode + "'");

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_frame");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                renk = rs.getString("renk");
                marka = rs.getString("marka");
                model = rs.getString("model");
                ozelAdi = rs.getString("ozel_adi");
                ekartman = rs.getString("ekartman");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                searchResultFrame.add(new Frame(id, barcode, alisFiyati, satisFiyati, renk, marka, model, ozelAdi,
                        ekartman, eklemeTarihi, quantity));

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return searchResultFrame;
    }

    public ObservableList<Glass> searchGlasses(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        double silendirik;
        double sferik;
        String tur;
        String marka;
        String tip;
        int aks;
        String eklemeTarihi;
        int quantity;

        if (con == null) {
            connect();
        }
        searchResultGlass.clear();
        PreparedStatement ps = con.prepareStatement("select * from glass where barcode ='" + searchBarcode + "'");

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_glass");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                silendirik = rs.getDouble("silendirik");
                sferik = rs.getDouble("sferik");
                tur = rs.getString("tur");
                marka = rs.getString("marka");
                tip = rs.getString("tip");
                aks = rs.getInt("aks");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                searchResultGlass.add(new Glass(id, barcode, alisFiyati, satisFiyati, silendirik, sferik, tur, marka,
                        tip, aks, eklemeTarihi, quantity));

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultGlass;
    }

    public ObservableList<PrescriptionCam> searchPrescriptions(String searchReceteNo) throws SQLException {

        int id;
        String receteNo;
        String olusturmaTarihi;
        String basvuruTarihi;
        String teslimTarihi;
        String sigortaDurumu;

        if (con == null) {
            connect();
        }
        searchResultPrescription.clear();
        PreparedStatement ps = con.prepareStatement("select * from prescription where recete_no = '"
                + searchReceteNo + "'");

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_prescription");
                receteNo = rs.getString("recete_no");
                olusturmaTarihi = rs.getString("olusturma_tarihi");
                basvuruTarihi = rs.getString("basvuru_tarihi");
                teslimTarihi = rs.getString("teslim_tarihi");
                sigortaDurumu = rs.getString("sigorta_durumu");

                PrescriptionCam prescription = new PrescriptionCam(id, receteNo, olusturmaTarihi, basvuruTarihi, teslimTarihi,
                        sigortaDurumu);
                searchResultPrescription.add(prescription);
            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultPrescription;
    }

    public ObservableList<Sale> searchSales(int saleId) throws SQLException {
        int id;
        double toplamFiyat;
        double indirim;
        String eklemeTarihi;
        String tcNo;
        String receteNo;

        if (con == null) {
            connect();
        }
        searchResultSale.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale WHERE id_sale =  '" + saleId + "'");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                indirim = rs.getDouble("indirim");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                tcNo = rs.getString("tc_no");
                receteNo = rs.getString("recete_no");

                Sale sale = new Sale(id, toplamFiyat, indirim, eklemeTarihi, tcNo, receteNo);
                searchResultSale.add(sale);

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultSale;
    }

    public ArrayList<Integer> searchSale(String tckn) throws SQLException {
        int barcode;
        ArrayList<Integer> resultArray = new ArrayList<Integer>();

        if (con == null) {
            connect();
        }

        PreparedStatement ps = con.prepareStatement("select id_sale from sale where tc_no = '" + tckn + "'");
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                barcode = rs.getInt("id_sale");
                resultArray.add(barcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return resultArray;
    }

    public ObservableList<Special> searchSpecials(String searchBarcode) throws SQLException {

        int id;
        String barcode;
        double alisFiyati;
        double satisFiyati;
        String urunAdi;
        String eklemeTarihi;
        int quantity;

        if (con == null) {
            connect();
        }
        searchResultSpecial.clear();
        PreparedStatement ps = con.prepareStatement("select * from special where barcode ='" + searchBarcode + "'");

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_special");
                barcode = rs.getString("barcode");
                alisFiyati = rs.getDouble("alis_fiyati");
                satisFiyati = rs.getDouble("satis_fiyati");
                urunAdi = rs.getString("urun_adi");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                quantity = rs.getInt("quantity");

                searchResultSpecial.add(new Special(id, barcode, alisFiyati, satisFiyati, urunAdi, eklemeTarihi,
                        quantity));

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return searchResultSpecial;
    }

    public ArrayList<String> searchUsers(String username) throws SQLException {

        String userName;
        String password;

        if (userList == null) {
            //System.out.println("user list is null");
            userList = new ArrayList<String>();

        } else {
            userList.clear();
        }

        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("select * from users where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            // System.out.println("Empty result");
        } else {
            do {
                userName = rs.getString("username");
                password = rs.getString("password");

                userList.add(userName);
                userList.add(password);

            } while (rs.next());
        }

        ps.close();
        rs.close();

        return userList;
    }

    public ObservableList<Object> searchAll(String searchBarcode) throws Exception {
        if (con == null) {
            connect();
        }

        searchResultAll.clear();
        if (!searchContactLens(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchContactLens(searchBarcode).size(); i++) {
                searchResultAll.add(searchResultLens.get(i));
            }
        }
        if (!searchExtrasByBarcode(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchExtrasByBarcode(searchBarcode).size(); i++) {
                searchResultAll.add(searchResultExtra.get(i));
            }
        }
        if (!searchFrames(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchFrames(searchBarcode).size(); i++) {
                searchResultAll.add(searchResultFrame.get(i));
            }
        }
        if (!searchGlasses(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchGlasses(searchBarcode).size(); i++) {
                searchResultAll.add(searchResultGlass.get(i));
            }
        }
        if (!searchSpecials(searchBarcode).isEmpty()) {
            for (int i = 0; i < searchSpecials(searchBarcode).size(); i++) {
                searchResultAll.add(searchResultSpecial.get(i));
            }
        }
        return searchResultAll;
    }

    public String searchType(String barcode) throws SQLException {
        if (con == null) {
            connect();
        }
        String tableName = "Null";
        searchResultAll.clear();

        for (int i = 0; i < searchContactLens(barcode).size(); i++) {
            searchResultAll.add(searchResultLens.get(i));
        }
        for (int i = 0; i < searchExtrasByBarcode(barcode).size(); i++) {
            searchResultAll.add(searchResultExtra.get(i));
        }
        for (int i = 0; i < searchFrames(barcode).size(); i++) {
            searchResultAll.add(searchResultFrame.get(i));
        }
        for (int i = 0; i < searchGlasses(barcode).size(); i++) {
            searchResultAll.add(searchResultGlass.get(i));
        }
        for (int i = 0; i < searchSpecials(barcode).size(); i++) {
            searchResultAll.add(searchResultSpecial.get(i));
        }
        if (!searchResultAll.isEmpty()) {
            tableName = searchResultAll.get(0).getClass().getSimpleName();
        }
        return tableName;
    }
///////////////////////////////////// Search methods ///////////////////////////////////////////////////////////////////

    public ArrayList<String> searchRecords(int saleId) throws SQLException {

        String productBarcode;
        ArrayList<String> resultArray = new ArrayList<String>();

        if (con == null) {
            connect();
        }

        searchResultAll.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM record WHERE sale_id = '" + saleId + "'");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //System.out.println("Empty result");
        } else {
            do {
                productBarcode = rs.getString("product_barcode");
                resultArray.add(productBarcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return resultArray;
    }

    public ArrayList<String> searchItemRecords(String barcode) throws SQLException {

        String productBarcode;
        ArrayList<String> resultArray = new ArrayList<String>();

        if (con == null) {
            connect();
        }

        searchResultAll.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM record WHERE product_barcode = '" + barcode + "';");
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            // TODO: empty
            //System.out.println("Empty result");
        } else {
            do {
                productBarcode = rs.getString("product_barcode");
                resultArray.add(productBarcode);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return resultArray;
    }

    public ObservableList<Extra> searchExtraBetween(String firstDate, String lastDate) throws SQLException {

        int id;
        String barcode;
        double satisFiyati;
        String ozelAdi;
        String eklemeTarihi;

        if (con == null) {
            connect();
        }

        searchResultExtra.clear();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM extras WHERE ekleme_tarihi BETWEEN ? AND ? ");
        ps.setString(1, firstDate);
        ps.setString(2, lastDate);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            //System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_extras");
                barcode = rs.getString("barcode");
                satisFiyati = rs.getDouble("satis_fiyati");
                ozelAdi = rs.getString("aciklama");
                eklemeTarihi = rs.getString("ekleme_tarihi");

                Extra extra = new Extra(id, barcode, ozelAdi, eklemeTarihi, satisFiyati);

                searchResultExtra.add(extra);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return searchResultExtra;

    }

    public ObservableList<Sale> searchSaleBetween(String firstDate, String lastDate) throws SQLException {
        int id;
        double toplamFiyat;
        double indirim;
        String eklemeTarihi;
        String tcNo;
        String receteNo;

        if (con == null) {
            connect();
        }

        searchResultSale.clear();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sale WHERE ekleme_tarihi BETWEEN ? AND ? ");
        ps.setString(1, firstDate);
        ps.setString(2, lastDate);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            // TODO: empty
            //System.out.println("Empty result");
        } else {
            do {
                id = rs.getInt("id_sale");
                toplamFiyat = rs.getDouble("toplam_fiyat");
                indirim = rs.getDouble("indirim");
                eklemeTarihi = rs.getString("ekleme_tarihi");
                tcNo = rs.getString("tc_no");
                receteNo = rs.getString("recete_no");

                Sale sale = new Sale(id, toplamFiyat, indirim, eklemeTarihi, tcNo, receteNo);
                searchResultSale.add(sale);

            } while (rs.next());
        }

        ps.close();
        rs.close();
        return searchResultSale;

    }

///////////////////////////////////// Update methods ///////////////////////////////////////////////////////////////////

    public void updateLensQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE contact_lenses SET quantity = (quantity + ?) WHERE " +
                "barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateExtraQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE extras SET quantity = (quantity + ? ) WHERE barcode = ?;");

        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateFrameQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE frames SET quantity = (quantity + ? ) WHERE barcode = ?;");

        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateGlassQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE glass SET quantity = (quantity + ? ) WHERE barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public void updateSpecialQuantity(String barcode, int quantity) throws SQLException {
        if (con == null) {
            connect();
        }
        PreparedStatement ps = con.prepareStatement("UPDATE special SET quantity = (quantity + ? ) WHERE barcode = ?;");
        ps.setInt(1, quantity);
        ps.setString(2, barcode);

        ps.executeUpdate();
        ps.close();
    }

    public int updateUserName(String oldUsername, String newUsername) throws SQLException {
        int affectedRowCnt = 0;

        if (con == null) {
            connect();
        }

        PreparedStatement ps = con.prepareStatement("UPDATE users SET username = ? WHERE username = ?;");
        ps.setString(1, newUsername);
        ps.setString(2, oldUsername);

        affectedRowCnt = ps.executeUpdate();
        ps.close();
        return affectedRowCnt;

    }

    public int updatePassword(String username, String newPass) throws SQLException {
        int affectedRowCnt = 0;

        if (con == null) {
            connect();
        }

        PreparedStatement ps = con.prepareStatement("UPDATE users SET password = ? WHERE username = ?;");
        ps.setString(1, newPass);
        ps.setString(2, username);

        affectedRowCnt = ps.executeUpdate();
        ps.close();
        return affectedRowCnt;
    }


    ///////////////////////////////////// Delete methods ///////////////////////////////////////////////////////////////////
    public int deleteLens(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchContactLens(barcode).isEmpty()) {
            // TODO: empty result
        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM contact_lenses WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteCustomer(String tckn) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchCustomers(tckn).isEmpty()) {
            // TODO: empty result

        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM customer WHERE tckn = ?");
            ps.setString(1, tckn);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteExtra(int id) throws SQLException {
        int affectedRowCnt;
        if (con == null) {
            connect();
        }

        // TODO: no method to search extra by id, so it does not check
        PreparedStatement ps = con.prepareStatement("DELETE FROM extras WHERE id_extras = ?");
        ps.setInt(1, id);
        affectedRowCnt = ps.executeUpdate();
        ps.close();
        return affectedRowCnt;
    }

    public int deleteFrame(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchFrames(barcode).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM frames WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteGlass(String barcode) throws SQLException {
        int affectedRowCnt = 0;

        if (con == null) {
            connect();
        }
        if (searchGlasses(barcode).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM glass WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deletePrescription(String receteNo) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchPrescriptions(receteNo).isEmpty()) {
            // TODO: empty result

        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM prescription WHERE recete_no = ?");
            ps.setString(1, receteNo);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteRecord(int saleId) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchRecords(saleId).isEmpty()) {
            // TODO: empty result

        } else {


            PreparedStatement ps = con.prepareStatement("DELETE FROM record WHERE sale_id = ?");
            ps.setInt(1, saleId);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteSale(int saleId) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchSales(saleId).isEmpty()) {
            // TODO: empty result
        } else {
            PreparedStatement ps = con.prepareStatement("DELETE FROM sale WHERE id_sale = ?");
            ps.setInt(1, saleId);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteSpecial(String barcode) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchSpecials(barcode).isEmpty()) {
            // TODO: empty result
        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM special WHERE barcode = ?");
            ps.setString(1, barcode);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    public int deleteUser(String username) throws SQLException {
        int affectedRowCnt = 0;
        if (con == null) {
            connect();
        }
        if (searchUsers(username).isEmpty()) {
            // TODO: empty result
        } else {

            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE username = ?");
            ps.setString(1, username);
            affectedRowCnt = ps.executeUpdate();
            ps.close();
        }
        return affectedRowCnt;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void connect() {

        try {
            con = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
