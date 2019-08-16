package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.CategoryDTO;
import interfaces.CategoryDAO;
import utils.MySQLConexion;

public class MySqlCategoryDAO implements CategoryDAO {

	@Override
	public ArrayList<CategoryDTO> listAll() {
		
		ArrayList<CategoryDTO> lista = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "Select * from Categoria";
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			lista = new ArrayList<CategoryDTO>();
			
			while(rs.next()) {
				CategoryDTO c = new CategoryDTO();
				c.setIdCategoria(rs.getString(1));
				c.setDescCategoria(rs.getString(2));
				
				lista.add(c);
			}
			rs.close();
			
		} catch(Exception ex) {
			System.out.println("Error en la sentencia: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		
		return lista;
	}

}
