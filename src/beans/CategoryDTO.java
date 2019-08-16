package beans;

public class CategoryDTO {
	
	private String idCategoria, descCategoria;

	@Override
	public String toString() {
		return "Category [idCategoria=" + idCategoria + ", descCategoria=" + descCategoria + "]";
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
}
