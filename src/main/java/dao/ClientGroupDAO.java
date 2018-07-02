package dao;

import model.ClientGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.Table.getObjectId;

public class ClientGroupDAO extends DAO {

    private final static String CREATE = "INSERT INTO CSHOOL.dbo.CLIENT_GROUP(NAME) " +
            "VALUES( ?);";
    private final static String READ = "SELECT * FROM CSHOOL.dbo.CLIENT_GROUP WHERE ID = ?;";
    private final static String UPDATE = "UPDATE CSHOOL.dbo.CLIENT_GROUP SET NAME=?" +
            " WHERE ID = ?;";
    private final static String DELETE = "DELETE FROM CSHOOL.dbo.CLIENT_GROUP WHERE ID=?;";
    private final static String GET_ALL = "SELECT * FROM CSHOOL.dbo.CLIENT_GROUP";

    public final static String TABLE = "CSHOOL.dbo.CLIENT_GROUP";
    public final static String ID = "ID";
    public final static String NAME = "NAME";

    private static ClientGroupRowMapper rowMapper = new ClientGroupRowMapper();
    public static void createClientGroup(ClientGroup clientGroup) {
        jdbcTemplate.update(CREATE, clientGroup.getName());
    }

    public static ClientGroup readClientGroup(int id) {
        return jdbcTemplate.queryForObject(READ, rowMapper);
    }


    public static void updateClientGroup(ClientGroup clientGroup, int id) {
        jdbcTemplate.update(UPDATE, clientGroup.getName(), id);
    }
    public static void updateClientGroup(ClientGroup clientGroup) {
        jdbcTemplate.update(UPDATE, clientGroup.getName(), clientGroup.getId());
    }
    public static void deleteClientGroup(int id) {
        jdbcTemplate.update(DELETE, id);
    }
    public static void deleteClientGroup(ClientGroup clientGroup) {
        jdbcTemplate.update(DELETE, getObjectId(getClientGroupTable(), clientGroup));
    }
    public static List<ClientGroup> getClientGroupTable(){
        return jdbcTemplate.query(GET_ALL, rowMapper);
    }

    public static void printClientGroupTable(List<ClientGroup> table, String description){
        System.out.println("\n" + description);
        System.out.println("ID\tNAME");
        table.forEach(clientGroup -> System.out.println(clientGroup.getId()+"\t"+clientGroup.getName()));
    }
    private static class ClientGroupRowMapper implements org.springframework.jdbc.core.RowMapper<ClientGroup> {

        @Override
        public ClientGroup mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            ClientGroup clientGroup = new ClientGroup();
            clientGroup.setId(resultSet.getInt("ID"));
            clientGroup.setName(resultSet.getString("NAME"));
            return clientGroup;
        }
    }
}
