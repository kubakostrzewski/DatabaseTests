import dao.DatabaseManager;
import model.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.OrdersDAO.createOrders;
import static dao.OrdersDAO.getOrdersTable;

public class AddingNewOrdersTest extends DatabaseManager {

    @Test
    public void sendRequest(){
        List<Orders> arrayList = new ArrayList<>();
        arrayList.add(new Orders(4,16,16));
        arrayList.add(new Orders(5, 17, 54));
        arrayList.add(new Orders(2, 16,21));

        arrayList.forEach(o -> {
            createOrders(o);
            Assert.assertTrue(getOrdersTable().contains(o));
        });
    }
}
