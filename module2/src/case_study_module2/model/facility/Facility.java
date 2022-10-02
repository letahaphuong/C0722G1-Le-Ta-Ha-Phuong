package case_study_module2.model.facility;

public abstract class Facility {
    private String serviceName;
    private int usableArea;
    private double rentalCost;
    private int maxPerson;
    private int rentalType; //Theo năm ,theo tháng,theo ngày.

    public Facility() {
    }

    public Facility(String serviceName, int usableArea, double rentalCost, int maxPerson, int rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxPerson = maxPerson;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(int usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public int getRentalType() {
        return rentalType;
    }

    public void setRentalType(int rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCost=" + rentalCost +
                ", maxPerson=" + maxPerson +
                ", rentalType=" + rentalType +
                '}';
    }
    public String getInfo(){
        return String.format(getServiceName(),getUsableArea(),getRentalCost(),getMaxPerson(),getRentalType());
    }
}
