import dao.DatabaseManager;
import org.testng.annotations.Test;

import static dao.ProductDAO.getProductsWhichGroupWasBoughtMoreThanThreeTimes;

public class getProductsWhichGroupWasBoughtMoreThanThreeTimesTest extends DatabaseManager{

    @Test
    public void sendQuery(){

        getProductsWhichGroupWasBoughtMoreThanThreeTimes().forEach(System.out::println);
    }
}
