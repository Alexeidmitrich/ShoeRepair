package shoeRepair.database;

import shoeRepair.ShoeRepair;

import java.util.List;

public interface ShoeRepairDAO {
    List<ShoeRepair> getAllInfoShoeRepairClient();
    ShoeRepair getShoeRepairClientById(int id);

    void save(ShoeRepair shoeRepair);
}

