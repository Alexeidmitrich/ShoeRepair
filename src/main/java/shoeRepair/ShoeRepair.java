package shoeRepair;

import javax.persistence.*;

@Entity
public class ShoeRepair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String description;



    public ShoeRepair(String firstName, String lastName, String phone, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.description = description;
    }
    public ShoeRepair(){

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }
    public void printInformationShoeRepair(){
        System.out.println(getId() + " " + getFirstName() + " " + getLastName() + " " + getPhone() + " " + getDescription());
    }
}
