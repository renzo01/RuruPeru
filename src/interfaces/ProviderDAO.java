package interfaces;

import java.util.ArrayList;

import beans.ProviderDTO;

public interface ProviderDAO {

	ArrayList<ProviderDTO> listOfProviders();

	int UpdateProviders(ProviderDTO p);

	int EliminarProviders(String idProveedor);

	ProviderDTO getAllbyId(String idProveedor);
	
	int add(ProviderDTO p);
	String lastProvider();
}
