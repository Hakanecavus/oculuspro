package model;

public class PrescriptionCam {
	private int id;
	private String receteNo;
	private String receteTarihi;
	private String tarih;
	private String rcBarcode;
	private String rcSph;
	private String rcCyl;
	private String rcAx;
	private String rcPd;
	private String rcYukseklik;
	private String lcBarcode;
	private String lcSph;
	private String lcCyl;
	private String lcAx;
	private String lcPd;
	private String lcYukseklik;

	public PrescriptionCam(String receteNo, String receteTarihi, String tarih, String rcBarcode, String rcSph, String rcCyl, String rcAx, String rcPd, String rcYukseklik, String lcBarcode, String lcSph, String lcCyl, String lcAx, String lcPd, String lcYukseklik) {
		this.receteNo = receteNo;
		this.receteTarihi = receteTarihi;
		this.tarih = tarih;
		this.rcBarcode = rcBarcode;
		this.rcSph = rcSph;
		this.rcCyl = rcCyl;
		this.rcAx = rcAx;
		this.rcPd = rcPd;
		this.rcYukseklik = rcYukseklik;
		this.lcBarcode = lcBarcode;
		this.lcSph = lcSph;
		this.lcCyl = lcCyl;
		this.lcAx = lcAx;
		this.lcPd = lcPd;
		this.lcYukseklik = lcYukseklik;
	}

	public PrescriptionCam(int id, String receteNo, String receteTarihi, String tarih, String rcBarcode, String rcSph, String rcCyl, String rcAx, String rcPd, String rcYukseklik, String lcBarcode, String lcSph, String lcCyl, String lcAx, String lcPd, String lcYukseklik) {
		this.id = id;
		this.receteNo = receteNo;
		this.receteTarihi = receteTarihi;
		this.tarih = tarih;
		this.rcBarcode = rcBarcode;
		this.rcSph = rcSph;
		this.rcCyl = rcCyl;
		this.rcAx = rcAx;
		this.rcPd = rcPd;
		this.rcYukseklik = rcYukseklik;
		this.lcBarcode = lcBarcode;
		this.lcSph = lcSph;
		this.lcCyl = lcCyl;
		this.lcAx = lcAx;
		this.lcPd = lcPd;
		this.lcYukseklik = lcYukseklik;
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

	public String getReceteTarihi() {
		return receteTarihi;
	}

	public void setReceteTarihi(String receteTarihi) {
		this.receteTarihi = receteTarihi;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getRcBarcode() {
		return rcBarcode;
	}

	public void setRcBarcode(String rcBarcode) {
		this.rcBarcode = rcBarcode;
	}

	public String getRcSph() {
		return rcSph;
	}

	public void setRcSph(String rcSph) {
		this.rcSph = rcSph;
	}

	public String getRcCyl() {
		return rcCyl;
	}

	public void setRcCyl(String rcCyl) {
		this.rcCyl = rcCyl;
	}

	public String getRcAx() {
		return rcAx;
	}

	public void setRcAx(String rcAx) {
		this.rcAx = rcAx;
	}

	public String getRcPd() {
		return rcPd;
	}

	public void setRcPd(String rcPd) {
		this.rcPd = rcPd;
	}

	public String getRcYukseklik() {
		return rcYukseklik;
	}

	public void setRcYukseklik(String rcYukseklik) {
		this.rcYukseklik = rcYukseklik;
	}

	public String getLcBarcode() {
		return lcBarcode;
	}

	public void setLcBarcode(String lcBarcode) {
		this.lcBarcode = lcBarcode;
	}

	public String getLcSph() {
		return lcSph;
	}

	public void setLcSph(String lcSph) {
		this.lcSph = lcSph;
	}

	public String getLcCyl() {
		return lcCyl;
	}

	public void setLcCyl(String lcCyl) {
		this.lcCyl = lcCyl;
	}

	public String getLcAx() {
		return lcAx;
	}

	public void setLcAx(String lcAx) {
		this.lcAx = lcAx;
	}

	public String getLcPd() {
		return lcPd;
	}

	public void setLcPd(String lcPd) {
		this.lcPd = lcPd;
	}

	public String getLcYukseklik() {
		return lcYukseklik;
	}

	public void setLcYukseklik(String lcYukseklik) {
		this.lcYukseklik = lcYukseklik;
	}

	@Override
	public String toString() {
		return "PrescriptionCam{" +
				"id=" + id +
				", receteNo='" + receteNo + '\'' +
				", receteTarihi='" + receteTarihi + '\'' +
				", tarih='" + tarih + '\'' +
				", rcBarcode='" + rcBarcode + '\'' +
				", rcSph='" + rcSph + '\'' +
				", rcCyl='" + rcCyl + '\'' +
				", rcAx='" + rcAx + '\'' +
				", rcPd='" + rcPd + '\'' +
				", rcYukseklik='" + rcYukseklik + '\'' +
				", lcBarcode='" + lcBarcode + '\'' +
				", lcSph='" + lcSph + '\'' +
				", lcCyl='" + lcCyl + '\'' +
				", lcAx='" + lcAx + '\'' +
				", lcPd='" + lcPd + '\'' +
				", lcYukseklik='" + lcYukseklik + '\'' +
				'}';
	}
}
