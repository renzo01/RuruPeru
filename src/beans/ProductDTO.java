package beans;

public class ProductDTO {
	
	private String idProd, idCat, nomProd, descProd;
	private double precProd;
	private int stockProd;
	private String imgProd;
	
	@Override
	public String toString() {
		return "ProductDTO [idProd=" + idProd + ", idCat=" + idCat + ", nomProd=" + nomProd + ", descProd=" + descProd
				+ ", precProd=" + precProd + ", stockProd=" + stockProd + ", imgProd=" + imgProd + "]";
	}
	
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getIdCat() {
		return idCat;
	}
	public void setIdCat(String idCat) {
		this.idCat = idCat;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public String getDescProd() {
		return descProd;
	}
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	public double getPrecProd() {
		return precProd;
	}
	public void setPrecProd(double precProd) {
		this.precProd = precProd;
	}
	public int getStockProd() {
		return stockProd;
	}
	public void setStockProd(int stockProd) {
		this.stockProd = stockProd;
	}
	public String getImgProd() {
		return imgProd;
	}
	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}
}
