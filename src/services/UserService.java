package services;

import java.util.ArrayList;

import beans.DepartamentDTO;
import beans.UserDTO;
import dao.DAOFactory;
import interfaces.UserDAO;

public class UserService {
	
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UserDAO ud = factory.getUserDAO();
	
	public UserDTO getByEmailPass(String email, String pass) {
		return ud.getByEmailPass(email, pass);
	}
	
	public int addUser(UserDTO u) {
		return ud.add(u);
	}
	
	public int updateUserByid(UserDTO u) {
		return ud.update(u);
	}
	
	public ArrayList<UserDTO> getAll() {
		return ud.getAll();
	}
	
	public ArrayList<DepartamentDTO> listDepas() {
		return ud.listDepas();
	}
}
