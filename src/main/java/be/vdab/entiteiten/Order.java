package be.vdab.entiteiten;

import java.sql.Date;

public class Order {

    private int orderId;
    private String paymentMethod;
    private int orderTotal;
    private Date date;
    private int custId;
    private int eshopId;

    public Order(int orderId, String paymentMethod, int orderTotal, Date date, int custId, int eshopId) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.custId = custId;
        this.eshopId = eshopId;
    }

    public Order(String paymentMethod, int orderTotal, Date date, int custId, int eshopId) {// orderId is auto-incremental in database
        this.paymentMethod = paymentMethod;
        this.orderTotal = orderTotal;
        this.date = date;
        this.custId = custId;
        this.eshopId = eshopId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public Date getDate() {
        return date;
    }

    public int getCustId() {
        return custId;
    }

    public int getEshopId() {
        return eshopId;
    }

    @Override
    public String toString() {
        return orderId + " " + paymentMethod + " " + orderTotal + " " + date + " " + custId + " " + eshopId;
    }
}
