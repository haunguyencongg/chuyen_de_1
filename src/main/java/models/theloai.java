package models;


public class theloai {

	private String maTL;
	private String tenTL;
	public String getMaTL() {
		return maTL;
	}
	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}
	public String getTenTL() {
		return tenTL;
	}
	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}
	public theloai(String maTL, String tenTL) {
		super();
		this.maTL = maTL;
		this.tenTL = tenTL;
	}
	
	
}
