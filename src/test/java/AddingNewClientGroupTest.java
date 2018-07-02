import dao.DatabaseManager;
import model.ClientGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.ClientGroupDAO.*;

public class AddingNewClientGroupTest extends DatabaseManager {
    @Test
    public void sendQuery(){

        List<ClientGroup> clientGroups = new ArrayList<>();
        clientGroups.add(new ClientGroup("Fundacja"));
        clientGroups.add(new ClientGroup("Klient zagraniczny"));

        clientGroups.forEach(cg -> {
            createClientGroup(cg);
            Assert.assertTrue(getClientGroupTable().contains(cg));
        });

    }
}
