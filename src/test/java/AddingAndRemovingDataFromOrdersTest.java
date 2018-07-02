import dao.DatabaseManager;
import model.Orders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.OrdersDAO.*;

public class AddingAndRemovingDataFromOrdersTest extends DatabaseManager {

    private List<Orders> ordersTable;

    @Test
    public void sendQuery() {

        ordersTable = getOrdersTable();
        Orders newOrders = new Orders(1, 2, 255);
        printOrdersTable(ordersTable, "ORDERS TABLE BEFORE TEST");
        Assert.assertFalse(ordersTable.contains(newOrders));

        createOrders(newOrders);
        ordersTable = getOrdersTable();
        printOrdersTable(ordersTable, "ORDERS TABLE AFTER CREATING NEW ORDER");
        Assert.assertTrue(ordersTable.contains(newOrders));

        deleteOrders(newOrders);
        ordersTable = getOrdersTable();
        printOrdersTable(ordersTable, "ORDERS TABLE AFTER DELETING NEW ORDER");
        Assert.assertFalse(ordersTable.contains(newOrders));
    }
}
