package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.*;

public class DatabaseManager {

    protected static Connection con;
    protected static ResultSet resultSet = null;
    protected static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public void setConnection() throws ClassNotFoundException {
        try {
            String connection = "jdbc:sqlserver://localhost:1433;instanceName=SQLExpress;user=sa;password=Kostrzewski1;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connection);
            jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(con, true));

        }catch (SQLException e){
            Assert.fail("Connection is not established");
        }
    }


    @AfterClass
    public void closeConnection() throws SQLException {

        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
