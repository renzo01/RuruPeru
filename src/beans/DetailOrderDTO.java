package beans;

public class DetailOrderDTO {
	
	private String nroPedido;
	private String idProducto;
	private int cantidad;
	private double preProd, descuento, subtotal;
	
	@Override
	public String toString() {
		return "DetailOrderDTO [nroPedido=" + nroPedido + ", idProducto=" + idProducto + ", cantidad=" + cantidad +
				", preProd=" + preProd + ", descuento=" + descuento + ", subtotal=" + subtotal + "]";
	}
	
	public String getNroPedido() {
		return nroPedido;
	}
	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPreProd() {
		return preProd;
	}
	public void setPreProd(double preProd) {
		this.preProd = preProd;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
