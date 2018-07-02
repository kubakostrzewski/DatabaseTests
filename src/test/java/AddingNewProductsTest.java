import dao.DatabaseManager;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.ProductDAO.*;

public class AddingNewProductsTest extends DatabaseManager {

    @Test
    public void sendRequest(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Szampon", 182, 6));
        productList.add(new Product("Odzywka", 110, 6));
        productList.add(new Product("Dezodorant", 27, 6));
        productList.add(new Product("T-shirt", 102, 7));
        productList.add(new Product("Spodnie", 89, 7));
        productList.add(new Product("Kurtka", 74, 7));
        productList.add(new Product("Mlotek", 27, 8));
        productList.add(new Product("Srubokret", 64, 8));
        productList.add(new Product("Pila", 21, 8));

        productList.forEach(p -> {
            createProduct(p);
            Assert.assertTrue(getProductTable().contains(p));
        });
    }
}
