package dao;

import java.util.List;

public class DAO extends DatabaseManager {

    public static List<Object> getColumn(String tableName, String columnName) {
        String sqlQuery = "SELECT " + columnName + " FROM " + tableName;
        return jdbcTemplate.queryForList(sqlQuery, Object.class);
    }
        public static void printColumn(List<Object> column){
        column.forEach(System.out::println);
    }
}
