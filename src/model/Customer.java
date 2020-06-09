package model;

public class Customer {

	private int id;
	private String tcNo;
	private String eklemeTarihi;
	private String isim;
	private String soyisim;
	private String telefon;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	


	public Customer(String tcNo, String isim, String soyisim, String telefon) {
		super();
		this.tcNo = tcNo;
		this.isim = isim;
		this.soyisim = soyisim;
		this.telefon = telefon;
	}




	public Customer(int id, String tcNo, String eklemeTarihi, String isim, String soyisim, String telefon) {
		super();
		this.id = id;
		this.tcNo = tcNo;
		this.eklemeTarihi = eklemeTarihi;
		this.isim = isim;
		this.soyisim = soyisim;
		this.telefon = telefon;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getEklemeTarihi() {
		return eklemeTarihi;
	}

	public void setEklemeTarihi(String eklemeTarihi) {
		this.eklemeTarihi = eklemeTarihi;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", tcNo='" + tcNo + '\'' +
				", eklemeTarihi='" + eklemeTarihi + '\'' +
				", isim='" + isim + '\'' +
				", soyisim='" + soyisim + '\'' +
				", telefon='" + telefon + '\'' +
				'}';
	}
}
