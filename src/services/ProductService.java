package services;

import java.util.ArrayList;

import beans.BenefitDTO;
import beans.CategoryDTO;
import beans.ProductDTO;
import dao.DAOFactory;
import interfaces.ProductDAO;

public class ProductService {
	
	DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProductDAO pd = df.getProductDAO();
	
	public int add(ProductDTO p) {
		return pd.add(p);
	}
	
	public int update(ProductDTO p) {
		return pd.update(p);
	}
	
	public int delete(String codProd) {
		return pd.delete(codProd);
	}
	
	public ProductDTO getProductById(String xidProd) {
		return pd.getProductById(xidProd);
	}
	
	/*public String lastIdProd() {
		return pd.lastIdProd();
	}*/
	
	public ArrayList<ProductDTO> getProductsByCondition(String xnomProd, String xidCat, double xpremin, double xpremax) {
		return pd.listByCondition(xnomProd, xidCat, xpremin, xpremax);
	}
	
	public ArrayList<ProductDTO> listAll() {
		return pd.listAll();
	}
	
	public ArrayList<BenefitDTO> listBenefits() {
		return pd.listBenefits();
	}
	
	public ArrayList<BenefitDTO> listBenefitsByProduct(String xidProd) {
		return pd.listBenefitsByProduct(xidProd);
	}
	
	public ArrayList<CategoryDTO> listCategories() {
		return pd.listCategories();
	}
	
}
