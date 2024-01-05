package models;

public class sinhvien {

	private int maSV;
	private String tenSV;
	private String diaChi;
	private int sdt;
	private String email;
	Lop lop;
	
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	
	
	 public sinhvien(int maSV, String tenSV, String diaChi, int sdt, String email, Lop lop) {
	        this.maSV = maSV;
	        this.tenSV = tenSV;
	        this.diaChi = diaChi;
	        this.sdt = sdt;
	        this.email = email;
	        this.lop = lop;
	    }
}
