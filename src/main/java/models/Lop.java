package models;



public class Lop {
	
	private int maLop;
	private String tenLop;
	Khoa khoa;
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public Khoa getKhoa() {
		return khoa;
	}
	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}
	
	 public Lop(int maLop, String tenLop, Khoa khoa) {
	        this.maLop = maLop;
	        this.tenLop = tenLop;
	        this.khoa = khoa;
	    }
	
}
