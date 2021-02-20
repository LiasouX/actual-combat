package cn.liasoux.pojo;

import java.util.Date;

public class Output {
    private String no;
    private String name;
    private String category;
    private String material;
    private int quantity;
    private Date  apply_time;
    private String apply_time_str;
    private String apply_status;
    private String mateName;

    public String getApply_time_str() {
        return apply_time_str;
    }

    public void setApply_time_str(String apply_time_str) {
        this.apply_time_str = apply_time_str;
    }

    @Override
    public String toString() {
        return "Output{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", material='" + material + '\'' +
                ", quantity=" + quantity +
                ", apply_time=" + apply_time +
                ", apply_status='" + apply_status + '\'' +
                ", mateName='" + mateName + '\'' +
                '}';
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public String getApply_status() {
        return apply_status;
    }

    public void setApply_status(String apply_status) {
        this.apply_status = apply_status;
    }
}
