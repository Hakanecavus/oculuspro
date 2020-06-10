package model;

public class Special {

	private int id;
	private String barcode;
	private double alisFiyati;
	private double satisFiyati;
	private String urunAdi;
	private String eklemeTarihi;
	private int quantity;
	private int saleId;


	public Special(String barcode, double alisFiyati, double satisFiyati, String ozelAdi, int quantity) {
		super();
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.urunAdi = ozelAdi;
		this.quantity = quantity;
	}


	public Special(int id, String barcode, double alisFiyati, double satisFiyati, String ozelAdi, String eklemeTarihi,
			int quantity) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.urunAdi = ozelAdi;
		this.eklemeTarihi = eklemeTarihi;
		this.quantity = quantity;
	}


	public Special(int id, String barcode, double alisFiyati, double satisFiyati, String ozelAdi, String eklemeTarihi,
			int quantity, int saleId) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.urunAdi = ozelAdi;
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

	public String getOzelAdi() {
		return urunAdi;
	}

	public void setOzelAdi(String ozelAdi) {
		this.urunAdi = ozelAdi;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	@Override
	public String toString() {
		return "Special{" +
				"id=" + id +
				", barcode='" + barcode + '\'' +
				", alisFiyati=" + alisFiyati +
				", satisFiyati=" + satisFiyati +
				", urunAdi='" + urunAdi + '\'' +
				", eklemeTarihi='" + eklemeTarihi + '\'' +
				", quantity=" + quantity +
				", saleId=" + saleId +
				'}';
	}
}
