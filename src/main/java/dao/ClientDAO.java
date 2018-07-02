package dao;

import model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static model.Table.getObjectId;

public class ClientDAO extends DAO {

    private final static String CREATE = "INSERT INTO CSHOOL.dbo.CLIENT(NAME, CLIENT_GROUP_ID, CITY, COUNTRY) " +
            "VALUES( ?, ?, ?, ?);";
    private final static String READ = "SELECT * FROM CSHOOL.dbo.CLIENT WHERE ID = ?;";
    private final static String UPDATE = "UPDATE CSHOOL.dbo.CLIENT SET NAME=?, CLIENT_GROUP_ID=?, CITY=?, COUNTRY=? " +
            "WHERE ID = ?;";
    private final static String DELETE = "DELETE FROM CSHOOL.dbo.CLIENT WHERE ID=?;";
    private final static String GET_ALL = "SELECT * FROM CSHOOL.dbo.CLIENT";

    public final static String TABLE = "CSHOOL.dbo.CLIENT";
    public final static String ID = "ID";
    public final static String NAME = "NAME";
    public final static String CLIENT_GROUP_ID = "CLIENT_GROUP_ID";
    public final static String CITY = "CITY";
    public final static String COUNTRY = "COUNTRY";

    private static ClientRowMapper rowMapper = new ClientRowMapper();

    public static void createClient(Client client) {
            jdbcTemplate.update(CREATE,client.getName(),client.getClientGroupId(),client.getCity(),client.getCountry());
    }

    public static Client readClient(int id) {
        return jdbcTemplate.queryForObject(READ, rowMapper, id);
    }

    public static void updateClient(Client client, int id) {
        jdbcTemplate.update(UPDATE, client.getName(), client.getClientGroupId(), client.getCity(),
                client.getCountry(), id);
    }
    public static void updateClient(Client client) {
            jdbcTemplate.update(UPDATE, client.getName(), client.getClientGroupId(),client.getCity(),
                    client.getCountry(),client.getId());
    }

    public static void deleteClient(int id) {
        jdbcTemplate.update(DELETE, id);
    }
    public static void deleteClient(Client client) {
        jdbcTemplate.update(DELETE, getObjectId(getClientTable(), client));
    }
    public static List <Client> getClientTable(){
        return jdbcTemplate.query(GET_ALL, rowMapper);
    }

    public static void printClientTable(List<Client> table, String description){
        System.out.println("\n" + description);
        System.out.println("ID\tNAME\tCLIENT_GROUP_ID\tCITY\tCOUNTRY");
        table.forEach(client -> System.out.println(client.getId()+"\t"+client.getName()
                +"\t"+client.getClientGroupId()+"\t"+client.getCity()+"\t"+client.getCountry()));
    }

    private static class ClientRowMapper implements org.springframework.jdbc.core.RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Client client = new Client();
            client.setId(resultSet.getInt("ID"));
            client.setName(resultSet.getString("NAME"));
            client.setClientGroupId(resultSet.getInt("CLIENT_GROUP_ID"));
            client.setCity(resultSet.getString("CITY"));
            client.setCountry(resultSet.getString("COUNTRY"));
            return client;
        }
    }
}