package dao;

import model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.Table.getObjectId;

public class ProductDAO extends DAO {

    private final static String CREATE = "INSERT INTO CSHOOL.dbo.PRODUCT(NAME, QUANTITY, PRODUCT_GROUP_ID) " +
            "VALUES( ?, ?, ?);";
    private final static String READ = "SELECT * FROM CSHOOL.dbo.PRODUCT WHERE ID = ?;";
    private final static String UPDATE = "UPDATE CSHOOL.dbo.PRODUCT SET NAME=?, QUANTITY=?, PRODUCT_GROUP_ID=?" +
            " WHERE ID = ?;";
    private final static String DELETE = "DELETE FROM CSHOOL.dbo.PRODUCT WHERE ID=?;";
    private final static String GET_ALL = "SELECT * FROM CSHOOL.dbo.PRODUCT";
    private final static String GET_THREE_TIMES_BOUGHT = "SELECT NAME FROM CSHOOL.dbo.PRODUCT " +
            "WHERE PRODUCT_group_ID IN (SELECT  PRODUCT_GROUP.ID AS GROUP_ID FROM CSHOOL.dbo.ORDERS " +
            "INNER JOIN CSHOOL.dbo.PRODUCT ON CSHOOL.dbo.ORDERS.PRODUCT_ID=PRODUCT.ID " +
            "INNER JOIN CSHOOL.dbo.PRODUCT_GROUP ON PRODUCT.PRODUCT_GROUP_ID=PRODUCT_GROUP.ID " +
            "GROUP BY PRODUCT_GROUP.ID " +
            "HAVING( COUNT(PRODUCT_GROUP.ID) > 0))";

    public final static String TABLE = "CSHOOL.dbo.PRODUCT";
    public final static String ID = "ID";
    public final static String NAME = "NAME";
    public final static String QUANTITY = "QUANTITY";
    public final static String PRODUCT_GROUP_ID = "PRODUCT_GROUP_ID";

    private static ProductRowMapper rowMapper = new ProductRowMapper();

    public static void createProduct(Product product) {
        jdbcTemplate.update(CREATE, product.getName(), product.getQuantity(), product.getProductGroupId());
    }

    public static Product readProduct(int id) {
        return jdbcTemplate.queryForObject(READ, rowMapper, id);
    }

    public static void updateProduct(Product product) {
        jdbcTemplate.update(UPDATE, product.getName(), product.getQuantity(), product.getProductGroupId(),
                product.getId());
    }
    public static void updateProduct(Product product, int id) {
        jdbcTemplate.update(UPDATE, product.getName(), product.getQuantity(), product.getProductGroupId(),
                id);
    }

    public static void deleteProduct(int id) {
        jdbcTemplate.update(DELETE, id);
    }
    public static void deleteProduct(Product product) {
        jdbcTemplate.update(DELETE, getObjectId(getProductTable(), product));
    }
    public static List<Product> getProductTable(){
        return jdbcTemplate.query(GET_ALL, rowMapper);
    }

    public static void printProductTable(List<Product> table, String description){
        System.out.println("\n" + description);
        System.out.println("ID\tNAME\tQUANTITY\tPRODUCT_GROUP_ID");
        table.forEach(product -> System.out.println(product.getId()+"\t"+product.getName()
                +"\t"+product.getQuantity()+"\t"+product.getProductGroupId()));
    }
    public static List<String> getProductsWhichGroupWasBoughtMoreThanThreeTimes(){
        return jdbcTemplate.query(GET_THREE_TIMES_BOUGHT, new RowMapper<String>() {
            @Nullable
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
    }
    private static class ProductRowMapper implements org.springframework.jdbc.core.RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Product product = new Product();
            product.setId(resultSet.getInt("ID"));
            product.setName(resultSet.getString("NAME"));
            product.setProductGroupId(resultSet.getInt("PRODUCT_GROUP_ID"));
            product.setQuantity(resultSet.getInt("QUANTITY"));
            return product;
        }
    }
}
