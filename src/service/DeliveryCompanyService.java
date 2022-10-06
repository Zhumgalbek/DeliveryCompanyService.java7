package service;

import entities.Customer;
import entities.DeliveryCompany;
import entities.Order;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class DeliveryCompanyService {
    static   Scanner scannerS = new Scanner(System.in);
    private static ArrayList<DeliveryCompany> deliveryCompanies=new ArrayList<>();


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
    public void createDeliveryCompany(String s){
        deliveryCompanies.add(new DeliveryCompany(s));
    }

    public static double getTotalFee(Customer customerName) {
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
    public void creatCustomer(Customer customer, String companyName){
        deliveryCompanies.stream().filter(x -> x.getDeliveryCompanyName().equalsIgnoreCase(companyName)).findFirst().ifPresent(x -> x.setCustomer(customer));
    }

    public static void getCompanyProfit(DeliveryCompany deliveryCompany) {
        double totalProfit = 0;
        for (Customer customer : deliveryCompany.getCustomer()) {
            totalProfit += getTotalFee(customer);
        }
        System.out.println("Company total profit: "+totalProfit);
    }
    public ArrayList<DeliveryCompany> getCompanies(){
        return deliveryCompanies;
    }
}
