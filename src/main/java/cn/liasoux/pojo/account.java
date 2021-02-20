package cn.liasoux.pojo;

public class account {
    private String category;
    private String material;
    private String quantity;
    private String money;
    private String purse_name;
    private String apply_name;
    private String status;
    private String mateName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "account{" +
                "material='" + material + '\'' +
                ", quantity='" + quantity + '\'' +
                ", money='" + money + '\'' +
                ", purse_name='" + purse_name + '\'' +
                ", apply_name='" + apply_name + '\'' +
                ", status='" + status + '\'' +
                ", mateName='" + mateName + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPurse_name() {
        return purse_name;
    }

    public void setPurse_name(String purse_name) {
        this.purse_name = purse_name;
    }

    public String getApply_name() {
        return apply_name;
    }

    public void setApply_name(String apply_name) {
        this.apply_name = apply_name;
    }


    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }
}
