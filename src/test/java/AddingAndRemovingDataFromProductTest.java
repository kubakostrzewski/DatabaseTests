import dao.DatabaseManager;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.ProductDAO.*;

public class AddingAndRemovingDataFromProductTest extends DatabaseManager {
    private List<Product> productTable;

    @Test
    public void sendQuery(){

        productTable = getProductTable();
        Product pieczarka = new Product("PIECZARKA", 100, 1);
        printProductTable(productTable, "PRODUCT TABLE BEFORE TEST");
        Assert.assertFalse(productTable.contains(pieczarka));

        createProduct(pieczarka);
        productTable = getProductTable();
        printProductTable(productTable, "PRODUCT TABLE AFTER CREATING PIECZARKA");
        Assert.assertTrue(productTable.contains(pieczarka));

        deleteProduct(pieczarka);
        productTable = getProductTable();
        printProductTable(productTable, "PRODUCT TABLE AFTER DELETING PIECZARKA");
        Assert.assertFalse(productTable.contains(pieczarka));

    }
}
