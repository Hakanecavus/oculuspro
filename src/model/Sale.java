package model;

public class Sale {
	private int id;
	private double toplamFiyat;
	private double indirim;
	private String eklemeTarihi;
	private String tcNo;
	private String receteNo;

	
	public Sale(double toplamFiyat, double indirim, String tcNo, String receteNo) {
		super();
		this.toplamFiyat = toplamFiyat;
		this.indirim = indirim;
		this.tcNo = tcNo;
		this.receteNo = receteNo;
	}

	public Sale(int id, double toplamFiyat, double indirim, String eklemeTarihi, String tcNo, String receteNo) {
		super();
		this.id = id;
		this.toplamFiyat = toplamFiyat;
		this.indirim = indirim;
		this.eklemeTarihi = eklemeTarihi;
		this.tcNo = tcNo;
		this.receteNo = receteNo;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getRecete_no() {
		return receteNo;
	}

	public void setRecete_no(String recete_no) {
		this.receteNo = recete_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getToplamFiyat() {
		return toplamFiyat;
	}

	public void setToplamFiyat(double toplamFiyat) {
		this.toplamFiyat = toplamFiyat;
	}

	public double getIndirim() {
		return indirim;
	}

	public void setIndirim(double indirim) {
		this.indirim = indirim;
	}

}
