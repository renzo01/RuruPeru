package interfaces;

import java.util.ArrayList;

import beans.DepartamentDTO;
import beans.UserDTO;

public interface UserDAO {
	
	public int add(UserDTO u);
	public int update(UserDTO u);
	public int delete(int cod);
	public UserDTO getByEmailPass(String email,  String pass);
	public ArrayList<UserDTO> getAll();
	public ArrayList<DepartamentDTO> listDepas();
}
