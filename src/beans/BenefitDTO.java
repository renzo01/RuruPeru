package beans;

public class BenefitDTO {
	
	private int idBen;	
	private String descBen;
	
	@Override
	public String toString() {
		return "BenefitDTO [idBen=" + idBen + ", descBen=" + descBen + "]";
	}
	
	public int getIdBen() {
		return idBen;
	}
	public void setIdBen(int idBen) {
		this.idBen = idBen;
	}
	public String getDescBen() {
		return descBen;
	}
	public void setDescBen(String descBen) {
		this.descBen = descBen;
	}
	
}
