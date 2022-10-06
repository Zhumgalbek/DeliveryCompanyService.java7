package service;

import entities.DeliveryCompany;
import entities.Order;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    private ArrayList<DeliveryCompany> deliveryCompanies;

    Scanner scannerS = new Scanner(System.in);
    Scanner scannerN = new Scanner(System.in);

    public void acceptOrder(Order order, String companyName, String customerName) {
        Optional<DeliveryCompany> optionalDeliveryCompany = deliveryCompanies.stream().filter(x -> x.equals(companyName)).findFirst();

        if (order.getLoad().getHeight() * order.getLoad().getWidth() > DeliveryCompany.MAXCAPACITYPERCUBESANTIMETER) {
            optionalDeliveryCompany.ifPresent(x -> x.getCustomers().stream().filter(c -> c.getCustomerName().equals(customerName)).findFirst().ifPresent(v -> v.setOrder(order)));
        } else {
            System.out.println("limit exhausted!!!");
        }
    }
}
