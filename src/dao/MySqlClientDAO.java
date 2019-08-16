package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import beans.ClientDTO;
import interfaces.ClientDAO;
import utils.MySQLConexion;

public class MySqlClientDAO implements ClientDAO {

	@Override
	public int add(ClientDTO c) {
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;
		String xidCliente = "";

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_insert_client(?,?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			DecimalFormat df = new DecimalFormat("00000");
			xidCliente = "CLI" + df.format(Integer.parseInt(lastIdCliente().substring(4)) + 1);
			c.setIdCliente(xidCliente);

			pst.setString(1, c.getIdCliente());
			pst.setInt(2, c.getIdUsu());
			pst.setString(3, c.getNomCliente());
			pst.setString(4, c.getApeCliente());
			pst.setString(5, c.getDniCli());
			pst.setString(6, c.getDirCli());
			pst.setString(7, c.getFechNacCli());
			pst.setString(8, c.getGenCli());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public int update(ClientDTO c) {
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_update_client(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			pst.setInt(1, c.getIdUsu());
			pst.setString(2, c.getUsername());
			pst.setString(3, c.getPassword());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getFotoUsu());
			pst.setString(6, c.getTelephone());
			pst.setInt(7, c.getIdDepa());
			pst.setString(8, c.getIdCliente());
			pst.setString(9, c.getNomCliente());
			pst.setString(10, c.getApeCliente());
			pst.setString(11, c.getDniCli());
			pst.setString(12, c.getDirCli());
			pst.setString(13, c.getFechNacCli());
			pst.setString(14, c.getGenCli());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al actualizar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public int delete(String idClient) {
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_delete_client(?) }";
			pst = cn.prepareStatement(sql);

			pst.setString(1, idClient);

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public ArrayList<ClientDTO> listAll() {

		ArrayList<ClientDTO> lista = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_client_all() }";
			pst = cn.prepareStatement(sql);

			rs = pst.executeQuery();

			lista = new ArrayList<ClientDTO>();

			while (rs.next()) {
				ClientDTO c = new ClientDTO();
				c.setIdUsu(rs.getInt(1));
				c.setUsername(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setFotoUsu(rs.getString(5));
				c.setTelephone(rs.getString(6));
				c.setIdDepa(rs.getInt(7));
				c.setIdCliente(rs.getString(8));
				c.setNomCliente(rs.getString(9));
				c.setApeCliente(rs.getString(10));
				c.setDniCli(rs.getString(11));
				c.setDirCli(rs.getString(12));
				c.setFechNacCli(rs.getString(13));
				c.setGenCli(rs.getString(14));

				lista.add(c);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al listar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public int addUpdate(int xoption, ClientDTO c) {
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_insertUpdate_client(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			pst.setInt(1, c.getIdUsu());
			pst.setString(2, c.getUsername());
			pst.setString(3, c.getPassword());
			pst.setString(4, c.getEmail());
			pst.setString(5, c.getFotoUsu());
			pst.setString(6, c.getTelephone());
			pst.setInt(7, c.getIdDepa());
			pst.setString(8, c.getIdCliente());
			pst.setString(9, c.getNomCliente());
			pst.setString(10, c.getApeCliente());
			pst.setString(11, c.getDniCli());
			pst.setString(12, c.getDirCli());
			pst.setString(13, c.getFechNacCli());
			pst.setString(14, c.getGenCli());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al actualizar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public ClientDTO searchByUser(int xidUsu) {
		ClientDTO c = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_clientByUser(?) }";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, xidUsu);
			rs = pst.executeQuery();

			if (rs.next()) {
				c = new ClientDTO();
				c.setIdCliente(rs.getString(1));
				c.setIdUsu(rs.getInt(2));
				c.setNomCliente(rs.getString(3));
				c.setApeCliente(rs.getString(4));
				c.setDniCli(rs.getString(5));
				c.setDirCli(rs.getString(6));
				c.setFechNacCli(rs.getString(7));
				c.setGenCli(rs.getString(8));
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al buscar Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return c;
	}

	@Override
	public String lastIdCliente() {

		String xidClient = "";
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_lastIdClient_client() }";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				xidClient = rs.getString(1);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener último código de cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return xidClient;
	}

	@Override
	public ArrayList<ClientDTO> listAllForAdmin() {
		ArrayList<ClientDTO> reg = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Select idCliente,nomCliente ,apeCliente,dniCli,fecNacCli,dirCli,genCli from cliente ;";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			reg = new ArrayList<ClientDTO>();
			while (rs.next()) {
				ClientDTO p = new ClientDTO();
				p.setIdCliente(rs.getString(1));
				p.setNomCliente(rs.getString(2));
				p.setApeCliente(rs.getString(3));
				p.setDniCli(rs.getString(4));
				p.setFechNacCli(rs.getString(5));
				p.setDirCli(rs.getString(6));
				p.setGenCli(rs.getString(7));
				reg.add(p);
			}
			
		}catch (Exception e) {
			System.err.println("Error en el MysqlDAO");
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return reg;
	}

	@Override
	public int updateClientByAdmin(ClientDTO c) {
		int result = 0;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Update Cliente set nomCliente= ?, apeCliente= ?, dniCli= ?, dirCli = ?,fecNacCli = ?,genCli = ? where idCliente =?;";
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, c.getNomCliente());
			pst.setString(2, c.getApeCliente());
			pst.setString(3, c.getDniCli());
			pst.setString(4, c.getDirCli());
			pst.setString(5, c.getFechNacCli());
			pst.setString(6, c.getFechNacCli());
			pst.setString(7, c.getIdCliente());
			
			result = pst.executeUpdate();
		}catch (Exception e) {
			System.err.println("Error en el MysqlDAo 2");
		}finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return result;
	}
	
}
