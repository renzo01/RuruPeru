package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import beans.ProviderDTO;
import interfaces.ProviderDAO;
import utils.MySQLConexion;

public class MySqlProviderDAO implements ProviderDAO {

	@Override
	public ArrayList<ProviderDTO> listOfProviders() {
		ArrayList<ProviderDTO> temp = new ArrayList<ProviderDTO>();
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Select * from proveedor";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				ProviderDTO reg = new ProviderDTO();
				reg.setIdProveedor(rs.getString(1));
				reg.setIdUsu(rs.getInt(2));
				reg.setDesProveedor(rs.getString(3));
				reg.setRucProveedor(rs.getString(4));
				reg.setDirProveedor(rs.getString(5));
				temp.add(reg);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return temp;
	}

	@Override
	public int UpdateProviders(ProviderDTO p) {
		int result = 0;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "update proveedor set idProv=?,idUsu=?, desProv = ?, rucProv = ?, dirProv = ? where idProv = ?;";
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, p.getIdProveedor());
			pst.setInt(2, p.getIdUsu());
			pst.setString(3, p.getDesProveedor());
			pst.setString(4, p.getRucProveedor());
			pst.setString(5, p.getDirProveedor());
			pst.setString(6, p.getIdProveedor());
			
			result = pst.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return result;
	}

	@Override
	public int EliminarProviders(String idProveedor) {
		int result = 0;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Delete from Proveedor where idProv = ?;";
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, idProveedor);
			
			result = pst.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return result;
	}

	@Override
	public ProviderDTO getAllbyId(String idProveedor) {
		ProviderDTO p =null;
		Connection cn =null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Select * from Proveedor where idProveedor = ?";
			pst = cn.prepareStatement(sql);
			pst.setString(1, idProveedor);
			rs = pst.executeQuery();
			while(rs.next()) {
				p = new ProviderDTO();
				p.setIdProveedor(rs.getString(1));
				p.setIdUsu(rs.getInt(2));
				p.setDesProveedor(rs.getString(3));
				p.setRucProveedor(rs.getString(4));
				p.setDirProveedor(rs.getString(5));
			}
			rs.close();
		}catch (Exception e) {
		System.out.println(e.getMessage());
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return p;
	}

	@Override
	public int add(ProviderDTO p) {
		int result = 0;
		Connection cn = null;
		PreparedStatement pst = null;
		String codProv ="";
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Insert into Proveedor values (?,?,?,?,?);";
			pst  = cn.prepareStatement(sql);
			DecimalFormat df =  new DecimalFormat("0");
			codProv = "PROV"+df.format(Integer.parseInt(lastProvider().substring(5))+1);
			p.setIdProveedor(codProv);
			
			pst.setString(1, p.getIdProveedor());
			pst.setInt(2, p.getIdUsu());
			pst.setString(3, p.getDesProveedor());
			pst.setString(4, p.getRucProveedor());
			pst.setString(5, p.getDirProveedor());
			
			result = pst.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error en el MysqlDAo"+e.getMessage());
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return result;
	}

	@Override
	public String lastProvider() {
		String codProv = "";
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Select MAX(idProv) from Proveedor;";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {
				codProv = rs.getString(1);
			}
		}catch (Exception e) {
			System.err.println("Error al entonctrar el ultimo codigo");
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return codProv;
	}

}
