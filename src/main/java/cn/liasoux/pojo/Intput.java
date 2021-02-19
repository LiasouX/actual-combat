package cn.liasoux.pojo;

import java.util.Date;

public class Intput {
    private String category;
    private String material;
    private int quantity;
    private double money;
    private Date purse_time;
    private String purse_name;
    private Date register_time;
    private String register_name;
    private String mateName;

    @Override
    public String toString() {
        return "Intput{" +
                "category='" + category + '\'' +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", money=" + money +
                ", purse_time=" + purse_time +
                ", purse_name='" + purse_name + '\'' +
                ", register_time=" + register_time +
                ", register_name='" + register_name + '\'' +
                ", mateName='" + mateName + '\'' +
                '}';
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getPurse_time() {
        return purse_time;
    }

    public void setPurse_time(Date purse_time) {
        this.purse_time = purse_time;
    }

    public String getPurse_name() {
        return purse_name;
    }

    public void setPurse_name(String purse_name) {
        this.purse_name = purse_name;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public String getRegister_name() {
        return register_name;
    }

    public void setRegister_name(String register_name) {
        this.register_name = register_name;
    }
}
