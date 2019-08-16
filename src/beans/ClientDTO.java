package beans;

public class ClientDTO extends UserDTO{
	
	private String idCliente;
	private String nomCliente, apeCliente, dniCli, dirCli, fechNacCli, genCli;
	
	@Override
	public String toString() {
		return "ClientDTO [idCliente=" + idCliente + ", nomCliente=" + nomCliente + ", apeCliente=" + apeCliente
				+ ", dniCli=" + dniCli + ", dirCli=" + dirCli + ", fechNacCli=" + fechNacCli + ", genCli=" + genCli
				+ "]";
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApeCliente() {
		return apeCliente;
	}
	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}
	public String getDniCli() {
		return dniCli;
	}
	public void setDniCli(String dniCli) {
		this.dniCli = dniCli;
	}
	public String getDirCli() {
		return dirCli;
	}
	public void setDirCli(String dirCli) {
		this.dirCli = dirCli;
	}
	public String getFechNacCli() {
		return fechNacCli;
	}
	public void setFechNacCli(String fechNacCli) {
		this.fechNacCli = fechNacCli;
	}
	public String getGenCli() {
		return genCli;
	}
	public void setGenCli(String genCli) {
		this.genCli = genCli;
	}
}
