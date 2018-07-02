import dao.DatabaseManager;
import model.ProductGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static dao.ProductGroupDAO.*;

public class AddingAndRemovingDataFromProductGroupTest extends DatabaseManager {

    private List<ProductGroup> productGroupTable;

    @Test
    public void sendQuery() {

        productGroupTable = getProductGroupTable();
        ProductGroup newProductGroup = new ProductGroup("Zabawki");
        printProductGroupTable(productGroupTable, "PRODUCT GROUP TABLE BEFORE TEST");
        Assert.assertFalse(productGroupTable.contains(newProductGroup));

        createProductGroup(newProductGroup);
        productGroupTable = getProductGroupTable();
        printProductGroupTable(productGroupTable, "PRODUCT GROUP TABLE AFTER CREATING KOSMETYKI");
        Assert.assertTrue(productGroupTable.contains(newProductGroup));

        deleteProductGroup(newProductGroup);
        productGroupTable = getProductGroupTable();
        printProductGroupTable(productGroupTable, "PRODUCT GROUP TABLE AFTER DELETING KOSMETYKI");
        Assert.assertFalse(productGroupTable.contains(newProductGroup));
    }
}
