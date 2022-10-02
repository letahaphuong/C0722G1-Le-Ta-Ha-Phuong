package case_study_module2.model.facility;

public class House extends Facility{
    private String roomStandard;
    private int numberFloors;

    public House(String roomStandard, int numberFloors) {
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public House(String serviceName, int usableArea, double rentalCost, int maxPerson, int rentalType, String roomStandard, int numberFloors) {
        super(serviceName, usableArea, rentalCost, maxPerson, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
