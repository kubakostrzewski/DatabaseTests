import dao.ClientDAO;
import dao.DatabaseManager;
import org.testng.annotations.Test;
import static dao.ClientDAO.*;

public class TakingSpecifiedColumnTest extends DatabaseManager {

    @Test
    public void sendQuery() {

        printColumn(getColumn(ClientDAO.TABLE, ClientDAO.ID));
        printColumn(getColumn(ClientDAO.TABLE, ClientDAO.NAME));
        printColumn(getColumn(ClientDAO.TABLE, ClientDAO.CITY));
        printColumn(getColumn(ClientDAO.TABLE, ClientDAO.COUNTRY));
        printColumn(getColumn(ClientDAO.TABLE, ClientDAO.CLIENT_GROUP_ID));

    }
}

