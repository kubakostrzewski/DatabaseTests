package model;

public class ProductGroup extends Table{
    public ProductGroup() {
    }
    public ProductGroup( String name) {
        this.name = name;
    }
    public ProductGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ProductGroup) {
            ProductGroup productGroup = (ProductGroup) obj;
            return name.equals(productGroup.name);
        }
        return false;
    }
}
