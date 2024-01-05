package models;



public class Khoa {
	
	private String maKH;
	private String tenKH;
	private String lienheKH;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getLienheKH() {
		return lienheKH;
	}
	public void setLienheKH(String lienheKH) {
		this.lienheKH = lienheKH;
	}
	
	 public Khoa(String maKH, String tenKH, String lienheKH) {
	        this.maKH = maKH;
	        this.tenKH = tenKH;
	        this.lienheKH = lienheKH;
	    }
	
}
