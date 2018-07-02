import dao.DatabaseManager;
import model.Client;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.ClientDAO.createClient;
import static dao.ClientDAO.getClientTable;
import static dao.ProductDAO.createProduct;
import static dao.ProductDAO.getProductTable;

public class AddingNewClientTest extends DatabaseManager {
    @Test
    public void sendRequest(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client("Andrzej", 4, "Gdansk", "POLAND"));
        clientList.add(new Client("Marian", 4, "Tokio", "JAPAN"));
        clientList.add(new Client("Ola", 4, "Zambrow", "POLAND"));
        clientList.add(new Client("Witek", 5, "Nowy Jork", "USA"));
        clientList.add(new Client("Mariola", 5, "Slupsk", "POLAND"));
        clientList.add(new Client("Jacek", 5, "Gdansk", "POLAND"));

        clientList.forEach(c -> {
            createClient(c);
            Assert.assertTrue(getClientTable().contains(c));
        });
    }
}
