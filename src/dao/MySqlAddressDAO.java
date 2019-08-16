package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DepartamentDTO;
import beans.DistrictDTO;
import beans.ProvinceDTO;
import interfaces.AddressDAO;
import utils.MySQLConexion;

public class MySqlAddressDAO implements AddressDAO {

	@Override
	public ArrayList<DepartamentDTO> listDepartaments() {
		
		ArrayList<DepartamentDTO> lista = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "Select * from Departament";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			lista = new ArrayList<DepartamentDTO>();
			
			while(rs.next()) {
				DepartamentDTO d = new DepartamentDTO();
				d.setIdDepa(rs.getInt(1));
				d.setDescDepa(rs.getString(2));
				
				lista.add(d);
			}
			rs.close();
			
		} catch(Exception ex) {
			System.out.println("Error en la sentencia: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		
		return lista ;
	}

	@Override
	public ArrayList<ProvinceDTO> listPrivinces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DistrictDTO> listDistricts() {
		// TODO Auto-generated method stub
		return null;
	}

}
