package service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Order;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    static   Scanner scannerS = new Scanner(System.in);
    private ArrayList<DeliveryCompany> deliveryCompanies;


    Scanner scannerN = new Scanner(System.in);

    public void acceptOrder(Order order, String companyName, String customerName) {
        Optional<DeliveryCompany> optionalDeliveryCompany = deliveryCompanies.stream().filter(x -> x.equals(companyName))
                .findFirst();

        if (order.getLoad().getHeight() * order.getLoad().getWidth() > DeliveryCompany.MAXCAPACITYPERCUBESANTIMETER) {
            optionalDeliveryCompany.ifPresent(x -> x.getCustomers().stream().filter(c -> c.getCustomerName()
                    .equals(customerName)).findFirst().ifPresent(v -> v.addOrder(order)));
        } else {
            System.out.println("limit exhausted!!!");
        }
    }
    public void createDeliveryCompany(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write companyname: ");
        deliveryCompanies.add(new DeliveryCompany(scanner.nextLine()));
    }

    public double getTotalFee( Customer customerName) {
        double totalFee = 0.0;
        for (DeliveryCompany company : deliveryCompanies) {
            for (Customer cust : company.getCustomers()) {
                if (customerName.equals(cust.getCustomerName())) {
                    totalFee = cust.getOrder().stream().map(Order::getOrderFee).reduce(0.0, Double::sum);
                }

            }
        }
        return totalFee;
    }

    public double getCompanyProfit(String companyName){
        double profit=0.0;
        for (DeliveryCompany com:deliveryCompanies) {
            if(companyName.equals(com.getDeliveryCompanyName())){
                for (Customer c: com.getCustomers()) {
                    profit= c.getOrder().stream().map(Order::getOrderFee).reduce(0.0,Double::sum);
                }
            }
        }

        return profit;
    }
}
