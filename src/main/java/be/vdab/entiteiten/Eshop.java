package be.vdab.entiteiten;

public class Eshop {

    private int shopNumber;
    private String Info;
    private String Address;
    private String Plaats;

    public Eshop(int shopNumber, String info, String address, String plaats) {
        this.shopNumber = shopNumber;
        Info = info;
        Address = address;
        Plaats = plaats;
    }

    public int getShopNumber() {
        return shopNumber;
    }

    public String getInfo() {
        return Info;
    }

    public String getAddress() {
        return Address;
    }

    public String getPlaats() {
        return Plaats;
    }

    @Override
    public String toString() {
        return shopNumber + " " + Info + " " + Address + " " + Plaats;
    }
}
