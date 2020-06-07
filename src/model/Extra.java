package model;

public class Extra {

	private int id;
	private String barcode;
	private String ozelAdi;
	private String eklemeTarihi;
	private double satisFiyati;

	public Extra() {
		// TODO Auto-generated constructor stub
	}
	public Extra( String ozelAdi, double satisFiyati) {
		super();
		this.ozelAdi = ozelAdi;
		this.satisFiyati = satisFiyati;
	}
	public Extra(String barcode, String ozelAdi, double satisFiyati) {
		super();
		this.barcode = barcode;
		this.ozelAdi = ozelAdi;
		this.satisFiyati = satisFiyati;
	}

	public Extra(int id, String barcode, String ozelAdi, String eklemeTarihi, double satisFiyati) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.ozelAdi = ozelAdi;
		this.eklemeTarihi = eklemeTarihi;
		this.satisFiyati = satisFiyati;
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

	public double getSatisFiyati() {
		return satisFiyati;
	}

	public void setSatisFiyati(double satisFiyati) {
		this.satisFiyati = satisFiyati;
	}

}
