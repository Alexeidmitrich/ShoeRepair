package shoeRepair;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idClient;
    protected String firstName;
    protected String lastName;
    protected String phone;

    @OneToMany(mappedBy = "client")
    protected List<Order> orders;
    public Client(int idClient,String firstName, String lastName, String phone) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    public Client(String firstName, String lastName, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
}

public Client(){}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public int getIdClient() {
        return idClient;
    }

    public void printInformation(){
        System.out.println(getIdClient() + " " + getFirstName() + " " + getLastName() + " " + getPhone());
    }
}
