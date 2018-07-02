package dao;

import model.ProductGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.Table.getObjectId;

public class ProductGroupDAO extends DAO {

    private final static String CREATE = "INSERT INTO CSHOOL.dbo.PRODUCT_GROUP(NAME) " +
            "VALUES( ?);";
    private final static String READ = "SELECT * FROM CSHOOL.dbo.PRODUCT_GROUP WHERE ID = ?;";
    private final static String UPDATE = "UPDATE CSHOOL.dbo.PRODUCT_GROUP SET NAME=?" +
            " WHERE ID = ?;";
    private final static String DELETE = "DELETE FROM CSHOOL.dbo.PRODUCT_GROUP WHERE ID=?;";
    private final static String GET_ALL = "SELECT * FROM CSHOOL.dbo.PRODUCT_GROUP";

    public final static String TABLE = "CSHOOL.dbo.PRODUCT_GROUP";
    public final static String ID = "ID";
    public final static String NAME = "NAME";

    private static ProductGroupRowMapper rowMapper = new ProductGroupRowMapper();
    public static void createProductGroup(ProductGroup productGroup) {
        jdbcTemplate.update(CREATE, productGroup.getName());
    }

    public static ProductGroup readProductGroup(int id) {
        return jdbcTemplate.queryForObject(READ, rowMapper, id);
    }


    public static void updateProductGroup(ProductGroup productGroup) {
        jdbcTemplate.update(UPDATE, productGroup.getName());
    }

    public static void deleteProductGroup(int id) {
        jdbcTemplate.update(DELETE, id);
    }
    public static void deleteProductGroup(ProductGroup productGroup) {
        jdbcTemplate.update(DELETE, getObjectId(getProductGroupTable(), productGroup));
    }
    public static List<ProductGroup> getProductGroupTable(){
        return jdbcTemplate.query(GET_ALL, rowMapper);
    }

    public static void printProductGroupTable(List<ProductGroup> table, String description){
        System.out.println("\n" + description);
        System.out.println("ID\tNAME");
        table.forEach(productGroup -> System.out.println(productGroup.getId()+"\t"+productGroup.getName()));
    }
    private static class ProductGroupRowMapper implements org.springframework.jdbc.core.RowMapper<ProductGroup> {

        @Override
        public ProductGroup mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            ProductGroup productGroup = new ProductGroup();
            productGroup.setId(resultSet.getInt("ID"));
            productGroup.setName(resultSet.getString("NAME"));
            return productGroup;
        }
    }
}