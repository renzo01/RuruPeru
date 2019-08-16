package interfaces;

import java.util.ArrayList;

import beans.DepartamentDTO;
import beans.DistrictDTO;
import beans.ProvinceDTO;

public interface AddressDAO {
	
	public ArrayList<DepartamentDTO> listDepartaments();
	public ArrayList<ProvinceDTO> listPrivinces();
	public ArrayList<DistrictDTO> listDistricts();

}
