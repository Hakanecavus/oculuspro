package model;

public class Record {
	private int id;
	private String productBarcode;
	private int saleId;



	public Record(String productBarcode, int saleId) {
		super();
		this.productBarcode = productBarcode;
		this.saleId = saleId;
	}

	public Record(int id, String productBarcode, int saleId) {
		super();
		this.id = id;
		this.productBarcode = productBarcode;
		this.saleId = saleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	@Override
	public String toString() {
		return "Record{" +
				"id=" + id +
				", productBarcode='" + productBarcode + '\'' +
				", saleId=" + saleId +
				'}';
	}
}
