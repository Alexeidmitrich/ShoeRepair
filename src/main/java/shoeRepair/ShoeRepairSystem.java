package shoeRepair;

import shoeRepair.database.*;

import java.util.List;

public class ShoeRepairSystem {
    private ClientDAO clientDAO = new ClientDAOImpl();
    private ShoeRepairDAO shoeRepairDAO = new ShoeRepairDAOImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();

    public void addShoeRepairInfo(String firstName, String lastName, String phone, String description){
        ShoeRepair shoeRepair = new ShoeRepair(firstName, lastName, phone, description);
        shoeRepairDAO.save(shoeRepair);
    }
    public void addClient(String firstName, String lastName, String phone){
        Client client = new Client(firstName, lastName, phone);
        clientDAO.save(client);
    }
    public void addOrder(String title, String description, int id_Client){
        Order order = new Order(title, description,id_Client);
        orderDAO.save(order);
    }
    public void printClientById(int id){
        ShoeRepairDAOImpl shoeRepairDAOImpl = new ShoeRepairDAOImpl();
        ShoeRepair shoe = shoeRepairDAOImpl.getShoeRepairClientById(id);
        shoe.printInformationShoeRepair();
    }
    public void printAllClientByOrder(){
        List<ShoeRepair> shoeRepairs = shoeRepairDAO.getAllInfoShoeRepairClient();
        for (int i = 0; i < shoeRepairs.size(); i++) {
          ShoeRepair shoeRepair = shoeRepairs.get(i);
          shoeRepair.printInformationShoeRepair();
        }
    }
    public static void main(String[] args) {
        ShoeRepairSystem shoeRepair = new ShoeRepairSystem();
        shoeRepair.addClient("dggaag", "vvxcvd", "ghfddh");
    }
}
