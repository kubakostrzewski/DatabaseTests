package model;

public class Product extends Table{

    private int quantity;
    private int productGroupId;

    public Product() {
    }

    public Product(String name, int quantity, int productGroupId) {
        this.name = name;
        this.quantity = quantity;
        this.productGroupId = productGroupId;
    }

    public Product(int id, String name, int quantity, int productGroupId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.productGroupId = productGroupId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(int productGroupId) {
        this.productGroupId = productGroupId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Product) {
            Product otherProduct = (Product) obj;
            return name.equals(otherProduct.name) && productGroupId==otherProduct.productGroupId
                    && quantity==otherProduct.quantity;
        }
        return false;
    }
}
