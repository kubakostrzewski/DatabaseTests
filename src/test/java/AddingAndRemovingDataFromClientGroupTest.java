import dao.DatabaseManager;
import model.ClientGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.ClientGroupDAO.*;
import static model.Table.getObjectId;

public class AddingAndRemovingDataFromClientGroupTest extends DatabaseManager{

    private List<ClientGroup> clientGroupTable;

    @Test
    public void sendQuery(){

        clientGroupTable = getClientGroupTable();
        ClientGroup newClientGroup = new ClientGroup("Inny" );
        printClientGroupTable(clientGroupTable, "CLIENT GROUP TABLE BEFORE TEST");
        Assert.assertFalse(clientGroupTable.contains(newClientGroup));

        createClientGroup(newClientGroup);
        clientGroupTable = getClientGroupTable();
        printClientGroupTable(clientGroupTable, "CLIENT GROUP TABLE AFTER CREATING FUNDACJA");
        Assert.assertTrue(clientGroupTable.contains(newClientGroup));

        deleteClientGroup(newClientGroup);
        clientGroupTable = getClientGroupTable();
        printClientGroupTable(clientGroupTable, "CLIENT GROUP TABLE AFTER DELETING FUNDACJA");
        Assert.assertFalse(clientGroupTable.contains(newClientGroup));

    }
}
