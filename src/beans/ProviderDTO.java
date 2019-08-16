package beans;

public class ProviderDTO extends UserDTO {
	
	private String idProveedor;
	private int idUsu;
	private String  desProveedor, rucProveedor,	 dirProveedor;
	
	
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public String getDesProveedor() {
		return desProveedor;
	}
	public void setDesProveedor(String desProveedor) {
		this.desProveedor = desProveedor;
	}
	public String getRucProveedor() {
		return rucProveedor;
	}
	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}
	public String getDirProveedor() {
		return dirProveedor;
	}
	public void setDirProveedor(String dirProveedor) {
		this.dirProveedor = dirProveedor;
	}
	@Override
	public String toString() {
		return "ProviderDTO [idProveedor=" + idProveedor + ", idUsu=" + idUsu + ", desProveedor=" + desProveedor
				+ ", rucProveedor=" + rucProveedor + ", dirProveedor=" + dirProveedor + "]";
	}
	
	
	
}
