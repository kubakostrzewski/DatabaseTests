package dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import model.Client;
import model.ClientGroup;
import model.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static model.Table.getObjectId;

public class OrdersDAO extends DAO {
    private final static String CREATE = "INSERT INTO CSHOOL.dbo.ORDERS(CLIENT_ID, PRODUCT_ID, PAYMENT) " +
            "VALUES( ?, ?, ?);";
    private final static String READ = "SELECT * FROM CSHOOL.dbo.ORDERS WHERE ID = ?;";
    private final static String UPDATE = "UPDATE CSHOOL.dbo.ORDERS SET NAME=?, CLIENT_ID=?, PRODUCT_ID=?, " +
            "PAYMENT=? WHERE ID = ?;";
    private final static String DELETE = "DELETE FROM CSHOOL.dbo.ORDERS WHERE ID=?;";
    private final static String GET_ALL = "SELECT * FROM CSHOOL.dbo.ORDERS";

    public final static String TABLE = "CSHOOL.dbo.ORDERS";
    public final static String ID = "ID";
    public final static String CLIENT_ID = "CLIENT_ID";
    public final static String PRODUCT_ID = "PRODUCT_ID";
    public final static String PAYMENT = "PAYMENT";

    private static OrdersRowMapper rowMapper = new OrdersRowMapper();

    public static void createOrders(Orders orders) {
        jdbcTemplate.update(CREATE, orders.getClientId(), orders.getProductId(), orders.getPayment());
    }

    public static Orders readOrders(int id) {
        return jdbcTemplate.queryForObject(READ, rowMapper, id);
    }


    public static void updateOrders(Orders orders) {
        jdbcTemplate.update(UPDATE, orders.getClientId(), orders.getProductId(), orders.getPayment(), orders.getClientId());
    }
    public static void updateOrders(Orders orders, int id) {
        jdbcTemplate.update(UPDATE, orders.getClientId(), orders.getProductId(), orders.getPayment(), id);
    }

    public static void deleteOrders(int id) {
        jdbcTemplate.update(DELETE, id);
    }
    public static void deleteOrders(Orders orders) {
        jdbcTemplate.update(DELETE, getObjectId(getOrdersTable(), orders));
    }
    public static List<Orders> getOrdersTable(){
        return jdbcTemplate.query(GET_ALL, rowMapper);
    }

    public static void printOrdersTable(List<Orders> table, String description){
        System.out.println("\n" + description);
        System.out.println("ID\tCLIENT_ID\tPRODUCT_ID\tPAYMENT");
        table.forEach(client -> System.out.println(client.getId()+"\t"+client.getClientId()
                +"\t"+client.getProductId()+"\t"+client.getPayment()));
    }
    private static class OrdersRowMapper implements org.springframework.jdbc.core.RowMapper<Orders> {

        @Override
        public Orders mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Orders orders = new Orders();
            orders.setId(resultSet.getInt("ID"));
            orders.setClientId(resultSet.getInt("CLIENT_ID"));
            orders.setProductId(resultSet.getInt("PRODUCT_ID"));
            orders.setPayment(resultSet.getInt("PAYMENT"));
            return orders;
        }
    }
}
