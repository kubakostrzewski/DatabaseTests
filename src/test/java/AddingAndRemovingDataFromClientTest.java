import dao.DatabaseManager;
import model.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.ClientDAO.*;
import static model.Table.getObjectId;

public class AddingAndRemovingDataFromClientTest extends DatabaseManager {

    private List<Client> clientTable;

    @Test
    public void sendQuery(){

        clientTable = getClientTable();
        Client zenek = new Client("Zenek", 1, "Bialystok", "Poland");
        printClientTable(clientTable, "CLIENT TABLE BEFORE TEST");
        Assert.assertFalse(clientTable.contains(zenek));

        createClient(zenek);
        clientTable = getClientTable();
        printClientTable(clientTable, "CLIENT TABLE AFTER CREATING ZENEK");
        Assert.assertTrue(clientTable.contains(zenek));

        deleteClient(zenek);
        clientTable = getClientTable();
        printClientTable(clientTable, "CLIENT TABLE AFTER DELETING ZENEK");
        Assert.assertFalse(clientTable.contains(zenek));

    }
}
