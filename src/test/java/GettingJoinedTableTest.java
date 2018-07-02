import dao.DatabaseManager;
import dao.TableColumn;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static dao.JoinTableDAO.getJoinedTable;

public class GettingJoinedTableTest extends DatabaseManager {

    @Test
    public void sendQuery(){
        List<TableColumn> columnList = new ArrayList<>();
        columnList.add(TableColumn.CLIENT_NAME);
        columnList.add(TableColumn.PRODUCT_NAME);
        columnList.add(TableColumn.ORDERS_PAYMENT);

        List<List<Object>> result = getJoinedTable(columnList);

        result.forEach(r -> {
            r.forEach(v -> System.out.print(v + "\t"));
            System.out.println("");

        });
    }
}
