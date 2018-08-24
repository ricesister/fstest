package cps.fs.bean;

/**
 * 
 * @description 权限表。，暂定锁定与未锁定
 * @author fs
 * @2018年8月23日
 *
 */
public class Auth {
	
	private int auth_seq;
	private String auth_name;
	public int getAuth_seq() {
		return auth_seq;
	}
	public void setAuth_seq(int auth_seq) {
		this.auth_seq = auth_seq;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	
	

}
