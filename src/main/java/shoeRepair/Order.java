package shoeRepair;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 55)
    private String  title;
    @Column(nullable = false, length = 55)
    private String description;
    @Transient
    private int id_Client;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "idClient")
    private Client client;

    public Order() {
    }

    public Order(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Order(String title, String description, int id_Client) {
        this.title = title;
        this.description = description;
        this.id_Client = id_Client;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
