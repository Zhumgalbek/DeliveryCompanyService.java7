package entities;

import java.util.ArrayList;
import java.util.Arrays;

public class DeliveryCompany {
    private String deliveryCompanyName;
    private ArrayList<Customer> customers;
    public static final double PRICEPERKILOGRAM = 10.0;
    public static final double MAXCAPACITYPERCUBESANTIMETER = 100.0;


    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public DeliveryCompany(String deliveryCompanyName, ArrayList<Customer> customers) {
        this.deliveryCompanyName = deliveryCompanyName;
        this.customers = customers;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }





    @Override
    public String toString() {
        return "DeliveryCompany{" +
                "deliveryCompanyName='" + deliveryCompanyName + '\'' +
                ", customers='" + customers + '\'' +
                ", pricePerKilogram=" + PRICEPERKILOGRAM +
                ", maxCapacityPerCubicCentimeter=" + MAXCAPACITYPERCUBESANTIMETER +
                '}';
    }


}
