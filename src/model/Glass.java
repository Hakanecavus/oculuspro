package model;

public class Glass {

	private int id;
	private String barcode;
	private double alisFiyati;
	private double satisFiyati;
	private String tur;
	private String marka;
	private String index;
	private String tarih;
	private int quantity;
	private int saleId;

	public Glass(String barcode, double alisFiyati, double satisFiyati, String tur, String marka, String index, String tarih, int quantity) {
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.tur = tur;
		this.marka = marka;
		this.index = index;
		this.tarih = tarih;
		this.quantity = quantity;
	}

	public Glass(int id, String barcode, double alisFiyati, double satisFiyati, String tur, String marka, String index, String tarih, int quantity) {
		this.id = id;
		this.barcode = barcode;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.tur = tur;
		this.marka = marka;
		this.index = index;
		this.tarih = tarih;
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
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

	@Override
	public String toString() {
		return "Glass{" +
				"id=" + id +
				", barcode='" + barcode + '\'' +
				", alisFiyati=" + alisFiyati +
				", satisFiyati=" + satisFiyati +
				", tur='" + tur + '\'' +
				", marka='" + marka + '\'' +
				", index='" + index + '\'' +
				", tarih='" + tarih + '\'' +
				", quantity=" + quantity +
				", saleId=" + saleId +
				'}';
	}
}
