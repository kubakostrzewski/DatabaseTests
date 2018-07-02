package model;

public class Orders extends Table{

    private int clientId;
    private int productId;
    private int payment;

    public Orders() {
    }

    public Orders(int clientId, int productId, int payment) {
        this.clientId = clientId;
        this.productId = productId;
        this.payment = payment;
    }

    public Orders(int id, int clientId, int productId, int payment) {
        this.id = id;
        this.clientId = clientId;
        this.productId = productId;
        this.payment = payment;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Orders) {
            Orders otherOrders = (Orders) obj;
            return clientId==otherOrders.clientId && productId==otherOrders.productId && payment==otherOrders.payment ;
        }
        return false;
    }
}
