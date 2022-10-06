package entities;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private List<Order> orders=new ArrayList<>();

    public Customer(String customerName, List<Order> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
