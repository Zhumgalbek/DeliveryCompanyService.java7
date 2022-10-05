package entities;

public class DeliveryCompany {
    private String deliveryCompanyName;
    private String customers;
    private int pricePerKilogram;
    private int maxCapacityPerCubicCentimeter;

    public DeliveryCompany(String deliveryCompanyName, String customers, int pricePerKilogram, int maxCapacityPerCubicCentimeter) {
        this.deliveryCompanyName = deliveryCompanyName;
        this.customers = customers;
        this.pricePerKilogram = pricePerKilogram;
        this.maxCapacityPerCubicCentimeter = maxCapacityPerCubicCentimeter;
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public int getPricePerKilogram() {
        return pricePerKilogram;
    }

    public void setPricePerKilogram(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public int getMaxCapacityPerCubicCentimeter() {
        return maxCapacityPerCubicCentimeter;
    }

    public void setMaxCapacityPerCubicCentimeter(int maxCapacityPerCubicCentimeter) {
        this.maxCapacityPerCubicCentimeter = maxCapacityPerCubicCentimeter;
    }

    @Override
    public String toString() {
        return "DeliveryCompany{" +
                "deliveryCompanyName='" + deliveryCompanyName + '\'' +
                ", customers='" + customers + '\'' +
                ", pricePerKilogram=" + pricePerKilogram +
                ", maxCapacityPerCubicCentimeter=" + maxCapacityPerCubicCentimeter +
                '}';
    }
}
