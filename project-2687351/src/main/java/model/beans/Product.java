package model.beans;

public class Product {
    private static Integer product_id;
    private String product_name;
    private Integer product_value;
    private Integer fk_category_id;

    public Product() {
    }

    public Product(Integer product_id, String product_name, Integer product_value, Integer fk_category_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_value = product_value;
        this.fk_category_id = fk_category_id;
    }

    public static Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_value() {
        return product_value;
    }

    public void setProduct_value(Integer product_value) {
        this.product_value = product_value;
    }

    public Integer getFk_category_id() {
        return fk_category_id;
    }

    public void setFk_category_id(Integer fk_category_id) {
        this.fk_category_id = fk_category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_value=" + product_value +
                ", fk_category_id=" + fk_category_id +
                '}';
    }
}
