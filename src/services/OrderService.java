package services;

import java.util.ArrayList;

import beans.DetailOrderDTO;
import beans.OrderDTO;
import beans.ShopDTO;
import dao.DAOFactory;
import interfaces.OrderDAO;

public class OrderService {
	DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	OrderDAO od = df.getOrderDAO();
	
	public int registerOrder(OrderDTO o) {
		return od.registerOrder(o);
	}
	
	public String lastIdOrder() {
		return od.lastIdOrder();
	}
	
	public ArrayList<OrderDTO> listAll() {
		return od.listAll();
	}
	
	public int registerDetailOrder(DetailOrderDTO d) {
		return od.registerDetailOrder(d);
	}
	
	public ArrayList<ShopDTO> getDetailOrderByClient(String xidClient) {
		return od.getDetailOrderByClient(xidClient);
	}
	public int deleteByOrdNum(String numOrd) {
		return od.deleteByOrdNum(numOrd);
	}
	
}
