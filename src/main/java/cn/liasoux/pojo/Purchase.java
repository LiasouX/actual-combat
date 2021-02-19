package cn.liasoux.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Purchase {
    private String category;
    private String material;
    private int quantity;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String name;
    private String mateName;

    @Override
    public String toString() {
        return "Purchase{" +
                "category=" + category +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", mateName='" + mateName + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }
}
