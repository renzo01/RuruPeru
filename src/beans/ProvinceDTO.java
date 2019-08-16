package beans;

public class ProvinceDTO {
	
	private int idProvin, idDepa;
	private String descProvin;
	
	@Override
	public String toString() {
		return "ProvinceDTO [idProvin=" + idProvin + ", idDepa=" + idDepa + ", descProvin=" + descProvin + "]";
	}
	
	public int getIdProvin() {
		return idProvin;
	}
	public void setIdProvin(int idProvin) {
		this.idProvin = idProvin;
	}
	public int getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(int idDepa) {
		this.idDepa = idDepa;
	}
	public String getDescProvin() {
		return descProvin;
	}
	public void setDescProvin(String descProvin) {
		this.descProvin = descProvin;
	}
	
}
