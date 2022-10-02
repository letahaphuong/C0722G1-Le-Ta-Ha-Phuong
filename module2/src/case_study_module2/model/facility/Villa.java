package case_study_module2.model.facility;

public class Villa extends Facility{
    private String roomStandard;
    private int swimmingPoolArea;
    private int numberFloors;

    public Villa(String roomStandard, int swimmingPoolArea, int numberFloors) {
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberFloors = numberFloors;
    }

    public Villa(String serviceName, int usableArea, double rentalCost, int maxPerson, int rentalType, String roomStandard, int swimmingPoolArea, int numberFloors) {
        super(serviceName, usableArea, rentalCost, maxPerson, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(int swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }

}
