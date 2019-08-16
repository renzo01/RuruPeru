package services;

import java.util.ArrayList;

import beans.ProviderDTO;
import dao.DAOFactory;
import interfaces.ProviderDAO;

public class ProviderService {
	DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProviderDAO pd = df.getProviderDAO();
	
	public ArrayList<ProviderDTO> listOfProviders(){
		return pd.listOfProviders();
	}
	public int UpdateProviders(ProviderDTO p) {
		return pd.UpdateProviders(p);
	}
	public int EliminarProviders(String idProveedor) {
		return pd.EliminarProviders(idProveedor);
	}
	public ProviderDTO getAllbyId(String idProveedor) {
		return pd.getAllbyId(idProveedor);
	}
	public  int add(ProviderDTO p) {
		return pd.add(p);
	}
}
