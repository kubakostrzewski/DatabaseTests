package dao;

public enum TableColumn {

    CLIENT_ID("CLIENT.ID"),
    CLIENT_NAME("CLIENT.NAME"),
    CLIENT_CITY("CLIENT.CITY"),
    CLIENT_COUNTRY("CLIENT.COUNTRY"),
    PRODUCT_ID("PRODUCT.ID"),
    PRODUCT_NAME("PRODUCT.NAME"),
    PRODUCT_QUANTITY("PRODUCT.QUANTITY"),
    CLIENT_GROUP_ID("CLIENT_GROUP.ID"),
    CLIENT_GROUP_NAME("CLIENT_GROUP.NAME"),
    PRODUCT_GROUP_ID("PRODUCT_GROUP.ID"),
    PRODUCT_GROUP_NAME("PRODUCT_GROUP.NAME"),
    ORDERS_ID("ORDERS.ID"),
    ORDERS_PAYMENT("ORDERS.PAYMENT");

    private String sort;

    TableColumn(String sortBy) {
        this.sort = sortBy;
    }

    public String getName() {
        return sort;
    }

}
