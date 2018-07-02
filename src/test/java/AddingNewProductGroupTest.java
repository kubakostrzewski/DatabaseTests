import dao.DatabaseManager;
import model.ProductGroup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.ProductGroupDAO.*;

public class AddingNewProductGroupTest extends DatabaseManager {

    @Test
    public void sendQuery(){

        List<ProductGroup> productGroupList = new ArrayList<>();
        productGroupList.add(new ProductGroup("Kosmetyki"));
        productGroupList.add(new ProductGroup("Ubrania"));
        productGroupList.add(new ProductGroup("Narzedzia"));

        productGroupList.forEach(pg -> {
            createProductGroup(pg);
            Assert.assertTrue(getProductGroupTable().contains(pg));
        });

    }
}
