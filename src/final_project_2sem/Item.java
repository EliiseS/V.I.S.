
package final_project_2sem;

public class Item {
    int    id;
    String serialNo;
    String type;
    String brand;
    String model;
    String price;
    String date;
    int    fk;
    
    public Item(int id, String serialNo, String type, String brand, String model, String price, int fk) {
        this.id       = id;
        this.serialNo = serialNo;
        this.type     = type;
        this.brand    = brand;
        this.model    = model;
        this.price    = price;
        this.fk       = fk;
    } 
    
    public Item(String serialNo, String type, String brand, String model, String price, String date) {
        this.serialNo = serialNo;
        this.type     = type;
        this.brand    = brand;
        this.model    = model;
        this.price    = price;
        this.date     = date;
    } 

    public int getId() {
        return id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public int getFk() {
        return fk;
    } 

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", serialNo=" + serialNo + ", type=" + type + ", brand=" + brand + ", model=" + model + ", price=" + price + ", date=" + date + ", fk=" + fk + '}';
    }
}
