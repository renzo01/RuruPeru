package interfaces;

import java.util.ArrayList;

import beans.DetailOrderDTO;
import beans.OrderDTO;
import beans.ShopDTO;

public interface OrderDAO {

	public int registerOrder(OrderDTO o);
	public String lastIdOrder();
	public ArrayList<OrderDTO> listAll();
	public int registerDetailOrder(DetailOrderDTO d);
	public ArrayList<ShopDTO> getDetailOrderByClient(String xidClient);
	public int deleteByOrdNum(String numOrd);
}
