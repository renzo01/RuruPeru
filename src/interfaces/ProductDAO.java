package interfaces;

import java.util.ArrayList;

import beans.BenefitDTO;
import beans.CategoryDTO;
import beans.ProductDTO;

public interface ProductDAO {
	
	public int add(ProductDTO p);
	public int update(ProductDTO p);
	public int delete(String codProd);
	public ProductDTO getProductById(String xidProd);
	public ArrayList<ProductDTO> listAll();
	public ArrayList<ProductDTO> listByCategory(String cat);
	public ArrayList<ProductDTO> listByCondition(String xnomProd, String xidCat, double xpremin, double xpremax);
	public ArrayList<BenefitDTO> listBenefits();
	public ArrayList<BenefitDTO> listBenefitsByProduct(String xidProd);
	public String lastIdProd();
	public ArrayList<CategoryDTO> listCategories();
	
}
