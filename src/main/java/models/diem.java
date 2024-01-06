package models;


public class diem {

	private int maBD;
	private float heso1;
	private float heso3;
	private float heso6;
	private float tongDiem;
	giangvien giangvien;
	sinhvien sinhvien;
	monhoc monhoc;
	tinchi tinchi;
	theloai theloai;
	hocky hocky;
	namhoc namhoc;
	Lop lop;
	public int getMaBD() {
		return maBD;
	}
	public void setMaBD(int maBD) {
		this.maBD = maBD;
	}
	public float getHeso1() {
		return heso1;
	}
	public void setHeso1(float heso1) {
		this.heso1 = heso1;
	}
	public float getHeso3() {
		return heso3;
	}
	public void setHeso3(float heso3) {
		this.heso3 = heso3;
	}
	public float getHeso6() {
		return heso6;
	}
	public void setHeso6(float heso6) {
		this.heso6 = heso6;
	}
	public float getTongDiem() {
		return tongDiem;
	}
	public void setTongDiem(float tongDiem) {
		this.tongDiem = tongDiem;
	}
	public giangvien getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(giangvien giangvien) {
		this.giangvien = giangvien;
	}
	public sinhvien getSinhvien() {
		return sinhvien;
	}
	public void setSinhvien(sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}
	public monhoc getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(monhoc monhoc) {
		this.monhoc = monhoc;
	}
	public tinchi getTinchi() {
		return tinchi;
	}
	public void setTinchi(tinchi tinchi) {
		this.tinchi = tinchi;
	}
	public theloai getTheloai() {
		return theloai;
	}
	public void setTheloai(theloai theloai) {
		this.theloai = theloai;
	}
	public hocky getHocky() {
		return hocky;
	}
	public void setHocky(hocky hocky) {
		this.hocky = hocky;
	}
	public namhoc getNamhoc() {
		return namhoc;
	}
	public void setNamhoc(namhoc namhoc) {
		this.namhoc = namhoc;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	public diem() {
		super();
		this.maBD = maBD;
		this.heso1 = heso1;
		this.heso3 = heso3;
		this.heso6 = heso6;
		this.tongDiem = tongDiem;
		this.giangvien = giangvien;
		this.sinhvien = sinhvien;
		this.monhoc = monhoc;
		this.tinchi = tinchi;
		this.theloai = theloai;
		this.hocky = hocky;
		this.namhoc = namhoc;
		this.lop = lop;
	}
	public diem(int maBD, float heso1, float heso3, float heso6, float tongDiem, models.giangvien giangvien,
			models.sinhvien sinhvien, models.monhoc monhoc, models.tinchi tinchi, models.theloai theloai,
			models.hocky hocky, models.namhoc namhoc, Lop lop) {
		super();
		this.maBD = maBD;
		this.heso1 = heso1;
		this.heso3 = heso3;
		this.heso6 = heso6;
		this.tongDiem = tongDiem;
		this.giangvien = giangvien;
		this.sinhvien = sinhvien;
		this.monhoc = monhoc;
		this.tinchi = tinchi;
		this.theloai = theloai;
		this.hocky = hocky;
		this.namhoc = namhoc;
		this.lop = lop;
	}
	
	
	
	
}
