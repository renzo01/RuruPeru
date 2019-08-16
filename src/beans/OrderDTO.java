package beans;

public class OrderDTO {

	private int cantTotal;
	private String nroPedido, idCliente, fecPedido, dirPedido, estPedido;
	private double total, descPedido;

	public int getCantTotal() {
		return cantTotal;
	}

	public void setCantTotal(int cantTotal) {
		this.cantTotal = cantTotal;
	}

	public String getNroPedido() {
		return nroPedido;
	}

	public void setNroPedido(String nroPedido) {
		this.nroPedido = nroPedido;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getFecPedido() {
		return fecPedido;
	}

	public void setFecPedido(String fecPedido) {
		this.fecPedido = fecPedido;
	}

	public String getDirPedido() {
		return dirPedido;
	}

	public void setDirPedido(String dirPedido) {
		this.dirPedido = dirPedido;
	}

	public String getEstPedido() {
		return estPedido;
	}

	public void setEstPedido(String estPedido) {
		this.estPedido = estPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDescPedido() {
		return descPedido;
	}

	public void setDescPedido(double descPedido) {
		this.descPedido = descPedido;
	}

	@Override
	public String toString() {
		return "OrderDTO [cantTotal=" + cantTotal + ", nroPedido=" + nroPedido + ", idCliente=" + idCliente
				+ ", fecPedido=" + fecPedido + ", dirPedido=" + dirPedido + ", estPedido=" + estPedido + ", total="
				+ total + ", descPedido=" + descPedido + "]";
	}
}
