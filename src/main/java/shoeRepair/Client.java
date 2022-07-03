package shoeRepair;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(nullable = false, length = 45)
    protected String firstName;
    @Column(nullable = false, length = 45)
    protected String lastName;
    @Column(nullable = false, length = 14)
    protected String phone;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client", targetEntity = Order.class)
    protected Set<Order> orders;

    public Client(int id,String firstName, String lastName, String phone) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void printInformation(){
        System.out.println(getId() + " " + getFirstName() + " " + getLastName() + " " + getPhone());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

