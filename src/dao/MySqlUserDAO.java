package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DepartamentDTO;
import beans.UserDTO;
import interfaces.UserDAO;
import utils.MySQLConexion;

public class MySqlUserDAO implements UserDAO {

	@Override
	public int add(UserDTO u) {
		
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "{Call usp_insert_user(?,?,?,?,?,?)}";
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getFotoUsu());
			pst.setString(5, u.getTelephone());
			pst.setInt(6, u.getIdDepa());
			
			rs = pst.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("Error en registrar Usuario: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public int update(UserDTO u) {
		
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "{Call usp_update_user(?,?,?,?,?,?,?)}";
			pst = cn.prepareStatement(sql);
			
			pst.setInt(1, u.getIdUsu());
			pst.setString(2, u.getUsername());
			pst.setString(3, u.getPassword());
			pst.setString(4, u.getEmail());
			pst.setString(5, u.getFotoUsu());
			pst.setString(6, u.getTelephone());
			pst.setInt(7, u.getIdDepa());
			
			rs = pst.executeUpdate();
			
		} catch(Exception ex) {
			System.out.println("Error en actualizar usuario: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public int delete(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDTO getByEmailPass(String email, String pass) {

		UserDTO u = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "{Call usp_get_user(?, ?)}";
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, email);
			pst.setString(2, pass);
			
			rs = pst.executeQuery();
			
			
			if(rs.next()) {
				u = new UserDTO();
				u.setIdUsu(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setFotoUsu(rs.getString(5));
				u.setTelephone(rs.getString(6));
			}
			rs.close();
			
		} catch(Exception ex) {
			System.out.println("Error en obtener Usuario: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return u;
	}

	@Override
	public ArrayList<UserDTO> getAll() {
		ArrayList<UserDTO> list = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "{Call usp_get_user_all()}";
			pst = cn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			list = new ArrayList<UserDTO>();
			
			while(rs.next()) {
				UserDTO u = new UserDTO();
				u.setIdUsu(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setFotoUsu(rs.getString(5));
				u.setTelephone(rs.getString(6));
				
				list.add(u);
			}
			rs.close();
			
		} catch(Exception ex) {
			System.out.println("Error en obtener todos los usuarios: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return list;
	}

	@Override
	public ArrayList<DepartamentDTO> listDepas() {
		
		ArrayList<DepartamentDTO> lista = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;
		
		try {
			
			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_department_all() }";
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
			System.out.println("Error al obtener departamentos: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

}
