package shoeRepair;

public class Client {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String description;

    public Client(int id, String firstName, String lastName, String phone, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.description = description;
    }

    public Client(String firstName, String lastName, String phone, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.description = description;
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
    public void printInformation(){
        System.out.println(getId() + " " + getFirstName() + " " + getLastName() + " " + getPhone() + " " + getDescription());
    }
}
