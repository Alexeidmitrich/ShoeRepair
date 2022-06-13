package shoeRepair;

import shoeRepair.database.*;

import java.util.List;

public class ShoeRepairSystem {
    private ClientDAO clientDAO = new ClientDAOImpl();
    private ShoeRepairDAO shoeRepairDAO = new ShoeRepairDAOImpl();
    private ShoeRepairDAOImpl shoeRepairDAOImpl;
    private ClientDAOImpl clientDAOImpl;

    public void addShoeRepairInfo(String firstName, String lastName, String phone, String description){
        ShoeRepair shoeRepair = new ShoeRepair(firstName, lastName, phone, description);
        shoeRepairDAO.save(shoeRepair);
    }
    public void addClient(String firstName, String lastName, String phone){
        Client client = new Client(firstName, lastName, phone);
        clientDAO.save(client);
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
}
