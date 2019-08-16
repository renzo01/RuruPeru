package dao;

import interfaces.AddressDAO;
import interfaces.CategoryDAO;
import interfaces.ClientDAO;
import interfaces.OrderDAO;
import interfaces.ProductDAO;
import interfaces.ProviderDAO;
import interfaces.UserDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() {
		return new MySqlUserDAO();
	}

	@Override
	public ProductDAO getProductDAO() {
		// TODO Auto-generated method stub
		return new MySqlProductDAO();
	}

	@Override
	public CategoryDAO getCategoryDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoryDAO();
	}

	@Override
	public ClientDAO getClientDAO() {
		// TODO Auto-generated method stub
		return new MySqlClientDAO();
	}

	@Override
	public ProviderDAO getProviderDAO() {
		// TODO Auto-generated method stub
		return new MySqlProviderDAO();
	}

	@Override
	public AddressDAO getAddressDAO() {
		// TODO Auto-generated method stub
		return new MySqlAddressDAO();
	}

	@Override
	public OrderDAO getOrderDAO() {
		// TODO Auto-generated method stub
		return new MySqlOrderDAO();
	}

}
