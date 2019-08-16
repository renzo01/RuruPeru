package beans;

public class ShopDTO {
	
	private String idProd, nomProd, imgProd;
	private int cantProd;
	private double subTotalProd, preProd;
	
	@Override
	public String toString() {
		return "ShopDTO [idProd=" + idProd + ", nomProd=" + nomProd + ", imgProd=" + imgProd + ", cantProd=" + cantProd
				+ ", preProd=" + preProd + ", subTotalProd=" + subTotalProd + "]";
	}
	
	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public String getImgProd() {
		return imgProd;
	}
	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}
	public int getCantProd() {
		return cantProd;
	}
	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}
	public double getPreProd() {
		return preProd;
	}
	public void setPreProd(double preProd) {
		this.preProd = preProd;
	}
	public double getSubTotalProd() {
		return subTotalProd;
	}
	public void setSubTotalProd(double subTotalProd) {
		this.subTotalProd = subTotalProd;
	}
}
