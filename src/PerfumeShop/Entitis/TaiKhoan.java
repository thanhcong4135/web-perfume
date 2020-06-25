package PerfumeShop.Entitis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TaiKhoan
 *
 */
@Embeddable

public class TaiKhoan implements Serializable {

	private String username;
	private String password;

	@Override
	public String toString() {
		return "TaiKhoan [username=" + username + ", password=" + password + "]";
	}

	public TaiKhoan(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TaiKhoan() {
		super();
	}

}
