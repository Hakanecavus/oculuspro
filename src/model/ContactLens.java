package model;

public class ContactLens {

	private int id;
	private String barcode;
	private String diyoptri;
	private String aks;
	private String silindirik;
	private String tarih;
	private double alisFiyati;
	private double satisFiyati;
	private int quantity;
	private int saleId;

	public ContactLens(String barcode, String diyoptri, String aks, String silindirik, String tarih, double alisFiyati, double satisFiyati, int quantity) {
		this.barcode = barcode;
		this.diyoptri = diyoptri;
		this.aks = aks;
		this.silindirik = silindirik;
		this.tarih = tarih;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
		this.quantity = quantity;
	}

	public ContactLens(int id, String barcode, String diyoptri, String aks, String silindirik, String tarih, double alisFiyati, double satisFiyati, int quantity) {
		this.id = id;
		this.barcode = barcode;
		this.diyoptri = diyoptri;
		this.aks = aks;
		this.silindirik = silindirik;
		this.tarih = tarih;
		this.alisFiyati = alisFiyati;
		this.satisFiyati = satisFiyati;
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

	public String getDiyoptri() {
		return diyoptri;
	}

	public void setDiyoptri(String diyoptri) {
		this.diyoptri = diyoptri;
	}

	public String getAks() {
		return aks;
	}

	public void setAks(String aks) {
		this.aks = aks;
	}

	public String getSilindirik() {
		return silindirik;
	}

	public void setSilindirik(String silindirik) {
		this.silindirik = silindirik;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
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
		return "ContactLens{" +
				"id=" + id +
				", barcode='" + barcode + '\'' +
				", diyoptri=" + diyoptri +
				", aks=" + aks +
				", silindirik=" + silindirik +
				", tarih='" + tarih + '\'' +
				", alisFiyati=" + alisFiyati +
				", satisFiyati=" + satisFiyati +
				", quantity=" + quantity +
				", saleId=" + saleId +
				'}';
	}
}
