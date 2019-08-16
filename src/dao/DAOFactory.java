package dao;

import interfaces.AddressDAO;
import interfaces.CategoryDAO;
import interfaces.ClientDAO;
import interfaces.OrderDAO;
import interfaces.ProductDAO;
import interfaces.ProviderDAO;
import interfaces.UserDAO;

public abstract class DAOFactory {

	// Bases de datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int SQLSERVER = 3;
	public static final int XML = 4;
	
	
	// Métodos abstractos de los DAO
	public abstract UserDAO getUserDAO();
	public abstract ProductDAO getProductDAO();
	public abstract CategoryDAO getCategoryDAO();
	public abstract ClientDAO getClientDAO();
	public abstract ProviderDAO getProviderDAO();
	public abstract AddressDAO getAddressDAO();
	public abstract OrderDAO getOrderDAO();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		
		switch(whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
		case XML:
			// return new XmlDAOFactory();
		case ORACLE: 
			// return new OracleDAOFactory();
		default:
			return null;
		}
		
	}
	
}
