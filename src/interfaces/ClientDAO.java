package interfaces;

import java.util.ArrayList;

import beans.ClientDTO;

public interface ClientDAO {
	
	public int add(ClientDTO c);
	public int update(ClientDTO c);
	public int updateClientByAdmin(ClientDTO c);
	public int delete(String idClient);
	public int addUpdate(int xoption, ClientDTO c);
	public ClientDTO searchByUser(int xidUsu);
	public String lastIdCliente();
	
	public ArrayList<ClientDTO> listAll();
	public ArrayList<ClientDTO> listAllForAdmin();
	
}
