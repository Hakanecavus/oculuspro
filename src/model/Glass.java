package model;

public class Glass {

	private int id;
	private String barcode;
	private double alisFiyati;
	private double satisFiyati;
	private double silendirik;
	private double sferik;
	private String tur;
	private String marka;
	private String tip;
	private int aks;
	private String eklemeTarihi;
	private int quantity;
	private int saleId;

	public Glass() {
		// TODO Auto-generated constructor stub
	}

	

	public Glass(String barcode, double alisFiyati, double satisFiyati, double silendirik, double sferik, String tur,
			String marka, String tip, int aks, int quantity) {
		super();
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.silendirik = silendirik;
		this.sferik = sferik;
		this.tur = tur;
		this.marka = marka;
		this.tip = tip;
		this.aks = aks;
		this.quantity = quantity;
	}



	public Glass(int id, String barcode, double alisFiyati, double satisFiyati, double silendirik, double sferik,
			String tur, String marka, String tip, int aks, String eklemeTarihi, int quantity) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.silendirik = silendirik;
		this.sferik = sferik;
		this.tur = tur;
		this.marka = marka;
		this.tip = tip;
		this.aks = aks;
		this.eklemeTarihi = eklemeTarihi;
		this.quantity = quantity;
	}


	public Glass(int id, String barcode, double alisFiyati, double satisFiyati, double silendirik, double sferik,
			String tur, String marka, String tip, int aks, String eklemeTarihi, int quantity, int saleId) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.silendirik = silendirik;
		this.sferik = sferik;
		this.tur = tur;
		this.marka = marka;
		this.tip = tip;
		this.aks = aks;
		this.eklemeTarihi = eklemeTarihi;
		this.quantity = quantity;
		this.saleId = saleId;
	}



	public int getSaleId() {
		return saleId;
	}


	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public double getSilendirik() {
		return silendirik;
	}

	public void setSilendirik(double silendirik) {
		this.silendirik = silendirik;
	}

	public double getSferik() {
		return sferik;
	}

	public void setSferik(double sferik) {
		this.sferik = sferik;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getAks() {
		return aks;
	}

	public void setAks(int aks) {
		this.aks = aks;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

}
