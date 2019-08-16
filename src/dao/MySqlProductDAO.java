package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import beans.BenefitDTO;
import beans.CategoryDTO;
import beans.ProductDTO;
import interfaces.ProductDAO;
import utils.MySQLConexion;

public class MySqlProductDAO implements ProductDAO {

	@Override
	public int add(ProductDTO p) {

		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_insert_product(?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);
			String idProd = lastIdProd();
			DecimalFormat df = new DecimalFormat("000");
			idProd = "PR" + df.format(Integer.parseInt(idProd.substring(2)) + 1);
			p.setIdProd(idProd);
			pst.setString(1, p.getIdProd());
			pst.setString(2, p.getIdCat());
			pst.setString(3, p.getNomProd());
			pst.setString(4, p.getDescProd());
			pst.setDouble(5, p.getPrecProd());
			pst.setInt(6, p.getStockProd());
			pst.setString(7, p.getImgProd());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar producto: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}

		return rs;
	}

	@Override
	public int update(ProductDTO p) {

		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_update_product(?,?,?,?,?,?,?) }";
			pst = cn.prepareStatement(sql);

			pst.setString(1, p.getIdProd());
			pst.setString(2, p.getIdCat());
			pst.setString(3, p.getNomProd());
			pst.setString(4, p.getDescProd());
			pst.setDouble(5, p.getPrecProd());
			pst.setInt(6, p.getStockProd());
			pst.setString(7, p.getImgProd());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar producto: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}

		return rs;
	}

	@Override
	public int delete(String codProd) {

		int rs = 0;
		PreparedStatement pst = null;
		Connection cn = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_delete_product(?) }";
			pst = cn.prepareStatement(sql);

			pst.setString(1, codProd);

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error al registrar producto: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}

		return rs;
	}

	@Override
	public ArrayList<ProductDTO> listAll() {

		ArrayList<ProductDTO> lista = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_product_all() }";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<ProductDTO>();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setIdProd(rs.getString(1));
				p.setIdCat(rs.getString(2));
				p.setNomProd(rs.getString(3));
				p.setDescProd(rs.getString(4));
				p.setPrecProd(rs.getDouble(5));
				p.setStockProd(rs.getInt(6));
				p.setImgProd(rs.getString(7));

				lista.add(p);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener productos: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public ArrayList<ProductDTO> listByCategory(String cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductDTO> listByCondition(String xnomProd, String xidCat, double xpremin, double xpremax) {
		ArrayList<ProductDTO> lista = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_productsByCondition(?, ?, ?, ?) }";
			pst = cn.prepareStatement(sql);
			pst.setString(1, xnomProd);
			pst.setString(2, xidCat);
			pst.setDouble(3, xpremin);
			pst.setDouble(4, xpremax);
			rs = pst.executeQuery();

			lista = new ArrayList<ProductDTO>();

			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setIdProd(rs.getString(1));
				p.setIdCat(rs.getString(2));
				p.setNomProd(rs.getString(3));
				p.setDescProd(rs.getString(4));
				p.setPrecProd(rs.getDouble(5));
				p.setStockProd(rs.getInt(6));
				p.setImgProd(rs.getString(7));

				lista.add(p);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener productos por condición: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public ArrayList<BenefitDTO> listBenefits() {
		ArrayList<BenefitDTO> lista = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_benefit_all() }";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<BenefitDTO>();

			while (rs.next()) {
				BenefitDTO b = new BenefitDTO();
				b.setIdBen(rs.getInt(1));
				b.setDescBen(rs.getString(2));

				lista.add(b);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener beneficios: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public String lastIdProd() {

		String xidProd = "";
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_lastIdProd_product() }";
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				xidProd = rs.getString(1);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener último código de producto: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return xidProd;
	}

	@Override
	public ArrayList<BenefitDTO> listBenefitsByProduct(String xidProd) {

		ArrayList<BenefitDTO> lista = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_benefitsByProduct(?) }";
			pst = cn.prepareStatement(sql);
			pst.setString(1, xidProd);

			rs = pst.executeQuery();

			lista = new ArrayList<BenefitDTO>();

			while (rs.next()) {
				BenefitDTO b = new BenefitDTO();
				b.setIdBen(rs.getInt(1));
				b.setDescBen(rs.getString(2));

				lista.add(b);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener beneficios: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return lista;
	}

	@Override
	public ProductDTO getProductById(String xidProd) {

		ProductDTO p = null;
		ResultSet rs = null;
		Connection cn = null;
		PreparedStatement pst = null;

		try {

			cn = MySQLConexion.getConexion();
			String sql = "{ Call usp_get_productById(?) }";
			pst = cn.prepareStatement(sql);
			pst.setString(1, xidProd);

			rs = pst.executeQuery();

			if (rs.next()) {
				p = new ProductDTO();
				p.setIdProd(rs.getString(1));
				p.setIdCat(rs.getString(2));
				p.setNomProd(rs.getString(3));
				p.setDescProd(rs.getString(4));
				p.setPrecProd(rs.getDouble(5));
				p.setStockProd(rs.getInt(6));
				p.setImgProd(rs.getString(7));
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener Producto: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}
		return p;
	}

	@Override
	public ArrayList<CategoryDTO> listCategories() {

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

			while (rs.next()) {
				CategoryDTO c = new CategoryDTO();
				c.setIdCategoria(rs.getString(1));
				c.setDescCategoria(rs.getString(2));

				lista.add(c);
			}
			rs.close();

		} catch (Exception ex) {
			System.out.println("Error al obtener categorías: " + ex.getMessage());
		} finally {
			MySQLConexion.closeStatement(pst);
			MySQLConexion.closeConexion(cn);
		}

		return lista;
	}

}
