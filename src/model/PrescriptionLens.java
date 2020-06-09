package model;

public class PrescriptionLens {
    private int id;
    private String receteNo;
    private String receteTarihi;
    private String tarih;
    private String rlBarcode;
    private String rlTemelEgri;
    private String rlTumCap;
    private String rlTorik;
    private String rlMultifokal;
    private String rlRenk;
    private String rlOzelAd;
    private String llBarcode;
    private String llTemelEgri;
    private String llTumCap;
    private String llTorik;
    private String llMultifokal;
    private String llRenk;
    private String llOzelAd;

    public PrescriptionLens(String receteNo, String receteTarihi, String tarih, String rlBarcode, String rlTemelEgri, String rlTumCap, String rlTorik, String rlMultifokal, String rlRenk, String rlOzelAd, String llBarcode, String llTemelEgri, String llTumCap, String llTorik, String llMultifokal, String llRenk, String llOzelAd) {
        this.receteNo = receteNo;
        this.receteTarihi = receteTarihi;
        this.tarih = tarih;
        this.rlBarcode = rlBarcode;
        this.rlTemelEgri = rlTemelEgri;
        this.rlTumCap = rlTumCap;
        this.rlTorik = rlTorik;
        this.rlMultifokal = rlMultifokal;
        this.rlRenk = rlRenk;
        this.rlOzelAd = rlOzelAd;
        this.llBarcode = llBarcode;
        this.llTemelEgri = llTemelEgri;
        this.llTumCap = llTumCap;
        this.llTorik = llTorik;
        this.llMultifokal = llMultifokal;
        this.llRenk = llRenk;
        this.llOzelAd = llOzelAd;
    }

    public PrescriptionLens(int id, String receteNo, String receteTarihi, String tarih, String rlBarcode, String rlTemelEgri, String rlTumCap, String rlTorik, String rlMultifokal, String rlRenk, String rlOzelAd, String llBarcode, String llTemelEgri, String llTumCap, String llTorik, String llMultifokal, String llRenk, String llOzelAd) {
        this.id = id;
        this.receteNo = receteNo;
        this.receteTarihi = receteTarihi;
        this.tarih = tarih;
        this.rlBarcode = rlBarcode;
        this.rlTemelEgri = rlTemelEgri;
        this.rlTumCap = rlTumCap;
        this.rlTorik = rlTorik;
        this.rlMultifokal = rlMultifokal;
        this.rlRenk = rlRenk;
        this.rlOzelAd = rlOzelAd;
        this.llBarcode = llBarcode;
        this.llTemelEgri = llTemelEgri;
        this.llTumCap = llTumCap;
        this.llTorik = llTorik;
        this.llMultifokal = llMultifokal;
        this.llRenk = llRenk;
        this.llOzelAd = llOzelAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceteNo() {
        return receteNo;
    }

    public void setReceteNo(String receteNo) {
        this.receteNo = receteNo;
    }

    public String getReceteTarihi() {
        return receteTarihi;
    }

    public void setReceteTarihi(String receteTarihi) {
        this.receteTarihi = receteTarihi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getRlBarcode() {
        return rlBarcode;
    }

    public void setRlBarcode(String rlBarcode) {
        this.rlBarcode = rlBarcode;
    }

    public String getRlTemelEgri() {
        return rlTemelEgri;
    }

    public void setRlTemelEgri(String rlTemelEgri) {
        this.rlTemelEgri = rlTemelEgri;
    }

    public String getRlTumCap() {
        return rlTumCap;
    }

    public void setRlTumCap(String rlTumCap) {
        this.rlTumCap = rlTumCap;
    }

    public String getRlTorik() {
        return rlTorik;
    }

    public void setRlTorik(String rlTorik) {
        this.rlTorik = rlTorik;
    }

    public String getRlMultifokal() {
        return rlMultifokal;
    }

    public void setRlMultifokal(String rlMultifokal) {
        this.rlMultifokal = rlMultifokal;
    }

    public String getRlRenk() {
        return rlRenk;
    }

    public void setRlRenk(String rlRenk) {
        this.rlRenk = rlRenk;
    }

    public String getRlOzelAd() {
        return rlOzelAd;
    }

    public void setRlOzelAd(String rlOzelAd) {
        this.rlOzelAd = rlOzelAd;
    }

    public String getLlBarcode() {
        return llBarcode;
    }

    public void setLlBarcode(String llBarcode) {
        this.llBarcode = llBarcode;
    }

    public String getLlTemelEgri() {
        return llTemelEgri;
    }

    public void setLlTemelEgri(String llTemelEgri) {
        this.llTemelEgri = llTemelEgri;
    }

    public String getLlTumCap() {
        return llTumCap;
    }

    public void setLlTumCap(String llTumCap) {
        this.llTumCap = llTumCap;
    }

    public String getLlTorik() {
        return llTorik;
    }

    public void setLlTorik(String llTorik) {
        this.llTorik = llTorik;
    }

    public String getLlMultifokal() {
        return llMultifokal;
    }

    public void setLlMultifokal(String llMultifokal) {
        this.llMultifokal = llMultifokal;
    }

    public String getLlRenk() {
        return llRenk;
    }

    public void setLlRenk(String llRenk) {
        this.llRenk = llRenk;
    }

    public String getLlOzelAd() {
        return llOzelAd;
    }

    public void setLlOzelAd(String llOzelAd) {
        this.llOzelAd = llOzelAd;
    }

    @Override
    public String toString() {
        return "PrescriptionLens{" +
                "id=" + id +
                ", receteNo='" + receteNo + '\'' +
                ", receteTarihi='" + receteTarihi + '\'' +
                ", tarih='" + tarih + '\'' +
                ", rlBarcode='" + rlBarcode + '\'' +
                ", rlTemelEgri='" + rlTemelEgri + '\'' +
                ", rlTumCap='" + rlTumCap + '\'' +
                ", rlTorik='" + rlTorik + '\'' +
                ", rlMultifokal='" + rlMultifokal + '\'' +
                ", rlRenk='" + rlRenk + '\'' +
                ", rlOzelAd='" + rlOzelAd + '\'' +
                ", llBarcode='" + llBarcode + '\'' +
                ", llTemelEgri='" + llTemelEgri + '\'' +
                ", llTumCap='" + llTumCap + '\'' +
                ", llTorik='" + llTorik + '\'' +
                ", llMultifokal='" + llMultifokal + '\'' +
                ", llRenk='" + llRenk + '\'' +
                ", llOzelAd='" + llOzelAd + '\'' +
                '}';
    }
}
