package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.DetailOrderDTO;
import beans.OrderDTO;
import beans.ShopDTO;
import interfaces.OrderDAO;
import utils.MySQLConexion;

public class MySqlOrderDAO implements OrderDAO {

	@Override
	public int registerOrder(OrderDTO o) {

		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_insert_order(?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			pst.setString(1, o.getNroPedido());
			pst.setString(2, o.getIdCliente());
			pst.setInt(3, o.getCantTotal());
			pst.setDouble(4, o.getDescPedido());
			pst.setString(5, o.getFecPedido());
			pst.setString(6, o.getDirPedido());
			pst.setDouble(7, o.getTotal());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar Pedido: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public ArrayList<OrderDTO> listAll() {

		ArrayList<OrderDTO> lista = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "Select * from pedido;";
			pst = cn.prepareStatement(sql);

			rs = pst.executeQuery();

			lista = new ArrayList<OrderDTO>();
			while (rs.next()) {
				OrderDTO o = new OrderDTO();
				o.setNroPedido(rs.getString(1));
				o.setIdCliente(rs.getString(2));
				o.setCantTotal(rs.getInt(3));
				o.setDescPedido(rs.getDouble(4));
				o.setFecPedido(rs.getString(5));
				o.setDirPedido(rs.getString(6));
				o.setTotal(rs.getDouble(7));
				o.setEstPedido(rs.getString(8));
				lista.add(o);
			}

		} catch (Exception ex) {
			System.out.println("Error al obtener Pedidos: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public String lastIdOrder() {

		String xidOrder = "";
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_lastIdOrder_order() }";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				xidOrder = rs.getString(1);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener último código de pedido: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return xidOrder;
	}

	@Override
	public int registerDetailOrder(DetailOrderDTO d) {

		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_insert_detailOrder(?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			pst.setString(1, d.getNroPedido());
			pst.setString(2, d.getIdProducto());
			pst.setInt(3, d.getCantidad());
			pst.setDouble(4, d.getPreProd());
			pst.setDouble(5, d.getDescuento());
			pst.setDouble(6, d.getSubtotal());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar Detalle Pedido: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return rs;
	}

	@Override
	public ArrayList<ShopDTO> getDetailOrderByClient(String xidClient) {

		ArrayList<ShopDTO> lista = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{Call usp_get_detailOrderByClient(?)}";
			pst = cn.prepareStatement(sql);

			pst.setString(1, xidClient);
			rs = pst.executeQuery();

			lista = new ArrayList<ShopDTO>();
			while (rs.next()) {
				ShopDTO s = new ShopDTO();
				s.setIdProd(rs.getString(1));
				s.setNomProd(rs.getString(2));
				s.setImgProd(rs.getString(3));
				s.setCantProd(rs.getInt(4));
				s.setPreProd(rs.getDouble(5));
				s.setSubTotalProd(rs.getDouble(6));

				lista.add(s);
			}

		} catch (Exception ex) {
			System.out.println("Error al obtener DetallePedidos por Cliente: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public int deleteByOrdNum(String numOrd) {
		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;
		try {
			cn = MySQLConexion.getConexion();
			String sql = "Update Pedido set estPedido  = 'Inactivo' where nroPedido = ?;";
			pst = cn.prepareStatement(sql);
			pst.setString(1, numOrd);
			rs=  pst.executeUpdate();
		} catch (Exception e) {
			System.err.println("Error al eliminar un pedido :" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(cn);
			MySQLConexion.closeStatement(pst);
		}
		return 0;
	}
}
