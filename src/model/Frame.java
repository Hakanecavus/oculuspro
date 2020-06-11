package model;

public class Frame {
	
	private int id;
	private String barcode;
	private double alisFiyati;
	private double satisFiyati;
	private String renk;
	private String marka;
	private String model;
	private String ozelAdi;
	private String ekartman;
	private String eklemeTarihi;
	private int quantity;
	private int saleId;

	
	public Frame() {
		// TODO Auto-generated constructor stub
	}


	public Frame(String barcode, double alisFiyati, double satisFiyati, String renk, String marka, String model,
			String ozelAdi, String ekartman, int quantity) {
		super();
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.renk = renk;
		this.marka = marka;
		this.model = model;
		this.ozelAdi = ozelAdi;
		this.ekartman = ekartman;
		this.quantity = quantity;
	}


	public Frame(int id, String barcode, double alisFiyati, double satisFiyati, String renk, String marka, String model,
			String ozelAdi, String ekartman, String eklemeTarihi, int quantity) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.renk = renk;
		this.marka = marka;
		this.model = model;
		this.ozelAdi = ozelAdi;
		this.ekartman = ekartman;
		this.eklemeTarihi = eklemeTarihi;
		this.quantity = quantity;
	}


	public Frame(int id, String barcode, double alisFiyati, double satisFiyati, String renk, String marka, String model,
			String ozelAdi, String ekartman, String eklemeTarihi, int quantity, int saleId) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.renk = renk;
		this.marka = marka;
		this.model = model;
		this.ozelAdi = ozelAdi;
		this.ekartman = ekartman;
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

	public String getOzelAdi() {
		return ozelAdi;
	}

	public void setOzelAdi(String ozelAdi) {
		this.ozelAdi = ozelAdi;
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

	public String getRenk() {
		return renk;
	}

	public void setRenk(String renk) {
		this.renk = renk;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEkartman() {
		return ekartman;
	}

	public void setEkartman(String ekartman) {
		this.ekartman = ekartman;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	@Override
	public String toString() {
		return "Frame{" +
				"id=" + id +
				", barcode='" + barcode + '\'' +
				", alisFiyati=" + alisFiyati +
				", satisFiyati=" + satisFiyati +
				", renk='" + renk + '\'' +
				", marka='" + marka + '\'' +
				", model='" + model + '\'' +
				", ozelAdi='" + ozelAdi + '\'' +
				", ekartman='" + ekartman + '\'' +
				", eklemeTarihi='" + eklemeTarihi + '\'' +
				", quantity=" + quantity +
				", saleId=" + saleId +
				'}';
	}
}
