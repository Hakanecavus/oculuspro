package model;

public class Extra {

	private int id;
	private String barcode;
	private String aciklama;
	private String tarih;
	private double fiyat;

	public Extra(String barcode, String aciklama, String tarih, double fiyat) {
		this.barcode = barcode;
		this.aciklama = aciklama;
		this.tarih = tarih;
		this.fiyat = fiyat;
	}

	public Extra(int id, String barcode, String aciklama, String tarih, double fiyat) {
		this.id = id;
		this.barcode = barcode;
		this.aciklama = aciklama;
		this.tarih = tarih;
		this.fiyat = fiyat;
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

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public double getFiyat() {
		return fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	@Override
	public String toString() {
		return "Extra{" +
				"id=" + id +
				", barcode='" + barcode + '\'' +
				", aciklama='" + aciklama + '\'' +
				", tarih='" + tarih + '\'' +
				", fiyat=" + fiyat +
				'}';
	}

}