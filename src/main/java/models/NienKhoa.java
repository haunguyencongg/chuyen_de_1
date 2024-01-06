package models;

public class NienKhoa {
	
	private String maNK;
	private String tenNK;
	public String getMaNK() {
		return maNK;
	}
	public void setMaNK(String maNK) {
		this.maNK = maNK;
	}
	public String getTenNK() {
		return tenNK;
	}
	public void setTenNK(String tenNK) {
		this.tenNK = tenNK;
	}
	public NienKhoa(String maNK, String tenNK) {
		super();
		this.maNK = maNK;
		this.tenNK = tenNK;
	}
	
	
}
