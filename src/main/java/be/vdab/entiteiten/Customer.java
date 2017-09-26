package be.vdab.entiteiten;

public class Customer extends User {

    private int CustNumber;
    private String name;
    private String firstName;
    private String email;
    private String deliveryAddress;

    public Customer(String userName, String passWord, int custNumber, String name, String firstName, String email, String deliveryAddress) {
        super(userName, passWord);
        CustNumber = custNumber;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public int getCustNumber() {
        return CustNumber;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return CustNumber + " " + name + " " + firstName + " " + email + " " + deliveryAddress + " (" + super.toString() + ")";
    }
}
