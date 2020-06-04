package model;

public class Prescription {
	private int id;
	private String receteNo;
	private String olusturmaTarihi;
	private String basvuruTarihi;
	private String teslimTarihi;
	private String sigortaDurumu;

	public Prescription() {
		// TODO Auto-generated constructor stub
	}


	public Prescription(String receteNo, String olusturmaTarihi, String basvuruTarihi, String sigortaDurumu) {
		super();
		this.receteNo = receteNo;
		this.olusturmaTarihi = olusturmaTarihi;
		this.basvuruTarihi = basvuruTarihi;
		this.sigortaDurumu = sigortaDurumu;
	}


	public Prescription(int id, String receteNo, String olusturmaTarihi, String basvuruTarihi, String teslimTarihi,
			String sigortaDurumu) {
		super();
		this.id = id;
		this.receteNo = receteNo;
		this.olusturmaTarihi = olusturmaTarihi;
		this.basvuruTarihi = basvuruTarihi;
		this.teslimTarihi = teslimTarihi;
		this.sigortaDurumu = sigortaDurumu;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceteNo() {
		return receteNo;
	}

	public void setReceteNo(String receteNo) {
		this.receteNo = receteNo;
	}

	public String getOlusturmaTarihi() {
		return olusturmaTarihi;
	}

	public void setOlusturmaTarihi(String olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}

	public String getBasvuruTarihi() {
		return basvuruTarihi;
	}

	public void setBasvuruTarihi(String basvuruTarihi) {
		this.basvuruTarihi = basvuruTarihi;
	}

	public String getTeslimTarihi() {
		return teslimTarihi;
	}

	public void setTeslimTarihi(String teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
	}

	public String getSigortaDurumu() {
		return sigortaDurumu;
	}

	public void setSigortaDurumu(String sigortaDurumu) {
		this.sigortaDurumu = sigortaDurumu;
	}

}
