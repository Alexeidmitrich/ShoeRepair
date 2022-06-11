package shoeRepair;

import shoeRepair.database.*;

public class ShoeRepairRefactirung {
    private ClientDAO clientDAO = new ClientDAOImpl();

    public void addClient(String firstName, String lastName, String phone, String description){
        Client client = new Client(firstName, lastName, phone, description);
        clientDAO.save(client);
    }
}
