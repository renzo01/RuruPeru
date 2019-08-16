package services;

import java.util.ArrayList;

import beans.ClientDTO;
import dao.DAOFactory;
import interfaces.ClientDAO;

public class ClientService {
	
	DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ClientDAO cd = df.getClientDAO();
	
	public int add(ClientDTO c) {
		return cd.add(c);
	}
	
	public int update(ClientDTO c) {
		return cd.update(c);
	}
	
	public int delete(String idClient) {
		return cd.delete(idClient);
	}
	
	public int addUpdate(int xoption, ClientDTO c) {
		return cd.addUpdate(xoption, c);
	}
	
	public ClientDTO searchByUser(int xidUsu) {
		return cd.searchByUser(xidUsu);
	}
	
	public String lastIdCliente() {
		return cd.lastIdCliente();
	}

	public ArrayList<ClientDTO> listAll() {
		return cd.listAll();
	}
	public ArrayList<ClientDTO> listAllForAdmin(){
		return cd.listAllForAdmin();
	}
	public int updateClientByAdmin(ClientDTO c) {
		return cd.updateClientByAdmin(c);
	}
}
