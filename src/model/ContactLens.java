package model;

public class ContactLens {

	private int id;
	private String barcode;
	private double multifokal;
	private double temelEgri;
	private double diyoptri;
	private double aks;
	private double silindirik;
	private double tumCap;
	private String renk;
	private String ozelAdi;
	private String eklemeTarihi;
	private double alisFiyati;
	private double satisFiyati;
	private int quantity;
	private int saleId;
	
	
	
	public ContactLens() {

	}

	public ContactLens(String barcode, double multifokal, double temelEgri, double diyoptri, double aks,
			double silindirik, double tumCap, String renk, String ozelAdi, double alisFiyati,
			double satisFiyati, int quantity) {
		super();
		this.barcode = barcode;
		this.multifokal = multifokal;
		this.temelEgri = temelEgri;
		this.diyoptri = diyoptri;
		this.aks = aks;
		this.silindirik = silindirik;
		this.tumCap = tumCap;
		this.renk = renk;
		this.ozelAdi = ozelAdi;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.quantity = quantity;
	}

	public ContactLens(int id, String barcode, double multifokal, double temelEgri, double diyoptri, double aks,
			double silindirik, double tumCap, String renk, String ozelAdi, String eklemeTarihi, double alisFiyati,
			double satisFiyati, int quantity) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.multifokal = multifokal;
		this.temelEgri = temelEgri;
		this.diyoptri = diyoptri;
		this.aks = aks;
		this.silindirik = silindirik;
		this.tumCap = tumCap;
		this.renk = renk;
		this.ozelAdi = ozelAdi;
		this.eklemeTarihi = eklemeTarihi;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.quantity = quantity;
	}

	public ContactLens(int id, String barcode, double multifokal, double temelEgri, double diyoptri, double aks,
			double silindirik, double tumCap, String renk, String ozelAdi, String eklemeTarihi, double alisFiyati,
			double satisFiyati, int quantity, int saleId) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.multifokal = multifokal;
		this.temelEgri = temelEgri;
		this.diyoptri = diyoptri;
		this.aks = aks;
		this.silindirik = silindirik;
		this.tumCap = tumCap;
		this.renk = renk;
		this.ozelAdi = ozelAdi;
		this.eklemeTarihi = eklemeTarihi;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.quantity = quantity;
		this.saleId = saleId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getMiktar() {
		return quantity;
	}

	public void setMiktar(int miktar) {
		this.quantity = miktar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getMultifokal() {
		return multifokal;
	}

	public void setMultifokal(double multifokal) {
		this.multifokal = multifokal;
	}

	public double getTemelEgri() {
		return temelEgri;
	}

	public void setTemelEgri(double temelEgri) {
		this.temelEgri = temelEgri;
	}

	public double getDiyoptri() {
		return diyoptri;
	}

	public void setDiyoptri(double diyoptri) {
		this.diyoptri = diyoptri;
	}

	public double getAks() {
		return aks;
	}

	public void setAks(double aks) {
		this.aks = aks;
	}

	public double getSilindirik() {
		return silindirik;
	}

	public void setSilindirik(double silindirik) {
		this.silindirik = silindirik;
	}

	public double getTumCap() {
		return tumCap;
	}

	public void setTumCap(double tumCap) {
		this.tumCap = tumCap;
	}

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String getOzelAdi() {
		return ozelAdi;
	}

	public void setOzelAdi(String ozelAdi) {
		this.ozelAdi = ozelAdi;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	public double getAlisFiyati() {
		return alisFiyati;
	}

	public void setAlisFiyati(double alisFiyati) {
		this.alisFiyati = alisFiyati;
	}

	public double getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(double satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

}
