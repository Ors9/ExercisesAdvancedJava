import java.io.Serializable;

public class Data2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String bNum;
	public Data2(int num, String bNum) {
		this.num = num;
		this.bNum = bNum;
	}
	public int getNum() {
		return num;
	}        
	public void setNum(int num) {
		this.num = num;
	}
	public String getBinaryNum() {
		return bNum;
	}
	public void setBinaryNum(String bNum) {
		this.bNum = bNum;
	}       
}