package beans;

public class ReceiptDTO {
	
	private String idRecibo, idCliente, nomCliente, apeCliente, dniCliente, idProducto, descProducto;
	private int uniProd;
	private double igvRecibo, totalRecibo;
	
	@Override
	public String toString() {
		return "Receipt [idRecibo=" + idRecibo + ", idCliente=" + idCliente + ", nomCliente=" + nomCliente
				+ ", apeCliente=" + apeCliente + ", dniCliente=" + dniCliente + ", idProducto=" + idProducto
				+ ", descProducto=" + descProducto + ", uniProd=" + uniProd + ", igvRecibo=" + igvRecibo
				+ ", totalRecibo=" + totalRecibo + "]";
	}
	
	public String getIdRecibo() {
		return idRecibo;
	}
	public void setIdRecibo(String idRecibo) {
		this.idRecibo = idRecibo;
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
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public int getUniProd() {
		return uniProd;
	}
	public void setUniProd(int uniProd) {
		this.uniProd = uniProd;
	}
	public double getIgvRecibo() {
		return igvRecibo;
	}
	public void setIgvRecibo(double igvRecibo) {
		this.igvRecibo = igvRecibo;
	}
	public double getTotalRecibo() {
		return totalRecibo;
	}
	public void setTotalRecibo(double totalRecibo) {
		this.totalRecibo = totalRecibo;
	}
	
}
