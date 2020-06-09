package model;

public class Sale {

    private int id;
    private double toplamFiyat;
    private String tarih;
    private String tcNo;
    private String camReceteNo;
    private String lensReceteNo;
    private double sgk;
    private double kart;
    private double nakit;

    public Sale(double toplamFiyat, String tarih, String tcNo, String camReceteNo, String lensReceteNo, double sgk, double kart, double nakit) {
        this.toplamFiyat = toplamFiyat;
        this.tarih = tarih;
        this.tcNo = tcNo;
        this.camReceteNo = camReceteNo;
        this.lensReceteNo = lensReceteNo;
        this.sgk = sgk;
        this.kart = kart;
        this.nakit = nakit;
    }

    public Sale(int id, double toplamFiyat, String tarih, String tcNo, String camReceteNo, String lensReceteNo, double sgk, double kart, double nakit) {
        this.id = id;
        this.toplamFiyat = toplamFiyat;
        this.tarih = tarih;
        this.tcNo = tcNo;
        this.camReceteNo = camReceteNo;
        this.lensReceteNo = lensReceteNo;
        this.sgk = sgk;
        this.kart = kart;
        this.nakit = nakit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getCamReceteNo() {
        return camReceteNo;
    }

    public void setCamReceteNo(String camReceteNo) {
        this.camReceteNo = camReceteNo;
    }

    public String getLensReceteNo() {
        return lensReceteNo;
    }

    public void setLensReceteNo(String lensReceteNo) {
        this.lensReceteNo = lensReceteNo;
    }

    public double getSgk() {
        return sgk;
    }

    public void setSgk(double sgk) {
        this.sgk = sgk;
    }

    public double getKart() {
        return kart;
    }

    public void setKart(double kart) {
        this.kart = kart;
    }

    public double getNakit() {
        return nakit;
    }

    public void setNakit(double nakit) {
        this.nakit = nakit;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", toplamFiyat=" + toplamFiyat +
                ", tarih='" + tarih + '\'' +
                ", tcNo='" + tcNo + '\'' +
                ", camReceteNo='" + camReceteNo + '\'' +
                ", lensReceteNo='" + lensReceteNo + '\'' +
                ", sgk=" + sgk +
                ", kart=" + kart +
                ", nakit=" + nakit +
                '}';
    }
}
