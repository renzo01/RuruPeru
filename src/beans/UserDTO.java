package beans;

public class UserDTO {
	
	private int idUsu, idDepa;
	private String username, password, email, telephone, fotoUsu;
	
	@Override
	public String toString() {
		return "UserDTO [code=" + idUsu + ", idDepa=" + idDepa + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", telephone=" + telephone + ", fotoUsu=" + fotoUsu + "]";
	}
	
	public int getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public int getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(int idDist) {
		this.idDepa = idDist;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFotoUsu() {
		return fotoUsu;
	}
	public void setFotoUsu(String fotoUsu) {
		this.fotoUsu = fotoUsu;
	}
	
}
