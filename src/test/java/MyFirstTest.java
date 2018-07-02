import dao.ClientDAO;
import dao.DatabaseManager;
import dao.OrdersDAO;
import model.Client;
import org.testng.annotations.Test;

import static dao.ClientDAO.readClient;
import static dao.ClientDAO.updateClient;


public class MyFirstTest extends DatabaseManager{

    @Test
    public void sendQuery(){
//        ClientDAO.createClient(new Client("Zenek", 1, "Lodz", "POLAND"));

//        Client client = clientDAO.readClient(1);
//        System.out.println("ID: " + client.getId());
//        System.out.println("NAME: " + client.getName());
//        System.out.println("CLIENT_GROUP_ID: " + client.getClientGroupId());
//        System.out.println("COUNTRY: " + client.getCountry());
//        System.out.println("CITY: " + client.getCity());

//        ClientDAO.updateClient(new Client(1, "Magda", 2, "Berlin", "GERMANY"));
//for (int i =57; i <75; i++){
//
//    OrdersDAO.deleteOrders(i);
//}
        Client client = readClient(2);
        System.out.println(client.getId());
        System.out.println(client.getName());
        System.out.println(client.getClientGroupId());
        System.out.println(client.getCity());
        System.out.println(client.getCountry());

        updateClient(new Client("Orest", 2, "Otwock", "POLAND"), 2);

        System.out.println(client.getId());
        System.out.println(client.getName());
        System.out.println(client.getClientGroupId());
        System.out.println(client.getCity());
        System.out.println(client.getCountry());
//        ClientDAO.deleteClient(16);
//
//    List<Client> table = ClientDAO.getClientTable();
//        System.out.println("ID\tNAME\tCLIENT_GROUP_ID\tCITY\tCOUNTRY");
//        for (Client client:table){
//            System.out.println(client.getId()+"\t"+client.getName()+"\t"+client.getClientGroupId()+"\t"
//                    +client.getCity()+"\t"+client.getCountry());
//        }

//        insertClientData("Zenek", 1, "Bialystok", "POLAND");
//        getClientData("NAME", "ID", "CITY").forEach((k,v) -> {
//            System.out.println(k);
//            v.stream()
//                    .map(p -> p.toString().toUpperCase())
//                    .forEach(p -> System.out.println(p.toString()));
//        });




//        getClientData("NAME", "CLIENT_GROUP_ID", "CITY", "COUNTRY")
//                .forEach((k,v) -> {
//                    v.stream()
//                            .filter(p -> p.toString().equals("Zenek");
//                });
    }
}
