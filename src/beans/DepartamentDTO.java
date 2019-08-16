package beans;

public class DepartamentDTO {
	
	private int idDepa;	
	private String descDepa;
	
	@Override
	public String toString() {
		return "DepartamentDTO [idDepa=" + idDepa + ", descDepa=" + descDepa + "]";
	}
	
	public int getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(int idDepa) {
		this.idDepa = idDepa;
	}
	public String getDescDepa() {
		return descDepa;
	}
	public void setDescDepa(String descDepa) {
		this.descDepa = descDepa;
	}
	
}
