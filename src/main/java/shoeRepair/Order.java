package shoeRepair;

import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  title;
    private String description;
   @ManyToOne
   @JoinColumn(name="client_id")
    private Client client;

    public Order() {
    }

    public Order(int id, String title, String description, Client client) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.client = client;
    }

    public Order(String title, String description, Client client) {
        this.title = title;
        this.description = description;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
