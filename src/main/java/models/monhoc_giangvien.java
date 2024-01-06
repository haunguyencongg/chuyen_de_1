package models;


public class monhoc_giangvien {

	monhoc monhoc;
	giangvien giangvien;
	public monhoc getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(monhoc monhoc) {
		this.monhoc = monhoc;
	}
	public giangvien getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(giangvien giangvien) {
		this.giangvien = giangvien;
	}
	public monhoc_giangvien(models.monhoc monhoc, models.giangvien giangvien) {
		super();
		this.monhoc = monhoc;
		this.giangvien = giangvien;
	}
	
	
	
}
