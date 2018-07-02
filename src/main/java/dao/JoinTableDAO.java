package dao;

import org.testng.SkipException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JoinTableDAO extends DatabaseManager {

    public static List<List<Object>> getJoinedTable(List<TableColumn> labels){

        String sqlQuery;
        StringBuilder queryBuilder = new StringBuilder("SELECT ");
        labels.stream().filter(l -> labels.indexOf(l)!=labels.size()-1).forEach(l-> queryBuilder.
                append(l.getName() + ", "));
        queryBuilder.append(labels.get(labels.size()-1).getName());
        queryBuilder.append(" FROM CSHOOL.dbo.ORDERS " +
                "LEFT JOIN CSHOOL.dbo.CLIENT ON ORDERS.CLIENT_ID = CLIENT.ID " +
                "LEFT JOIN CSHOOL.dbo.CLIENT_GROUP ON CLIENT.CLIENT_GROUP_ID=CLIENT_GROUP.ID " +
                "LEFT JOIN CSHOOL.dbo.PRODUCT ON ORDERS.PRODUCT_ID = PRODUCT.ID;");
        sqlQuery = queryBuilder.toString();
        return jdbcTemplate.query(sqlQuery, new JoinedTabletRowMapper());

    }
    private static class JoinedTabletRowMapper implements org.springframework.jdbc.core.RowMapper<List<Object>> {

        @Override
        public List<Object> mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            List<Object> table = new ArrayList<>();
            IntStream.range(0, resultSet.getMetaData().getColumnCount())
                    .boxed()
                    .forEach(i -> {
                        try {
                            table.add(resultSet.getString(i + 1));
                        } catch (SQLException e) {
                            e.printStackTrace();
                            throw new SkipException(e.getMessage());
                        }
                    });
            return table;
        }
    }
}