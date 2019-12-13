package pl.edu.ug.tent.springmvcdemo.domain;

public class Item {

    private int itemID;
    private String name;
    private String manufacturer;
    private String model;
    private float price;
    private int quantity;

    public Item(int itemID, String name, String manufacturer, String model, float price, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(){

    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
