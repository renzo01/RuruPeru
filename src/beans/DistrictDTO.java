package beans;

public class DistrictDTO {
	
	private int idDist, idProvin, idDepa;
	private String descDist;
	
	@Override
	public String toString() {
		return "DistrictDTO [idDist=" + idDist + ", idProvin=" + idProvin + ", idDepa=" + idDepa + ", descDist="
				+ descDist + "]";
	}
	
	public int getIdDist() {
		return idDist;
	}
	public void setIdDist(int idDist) {
		this.idDist = idDist;
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
	public String getDescDist() {
		return descDist;
	}
	public void setDescDist(String descDist) {
		this.descDist = descDist;
	}
	
}
