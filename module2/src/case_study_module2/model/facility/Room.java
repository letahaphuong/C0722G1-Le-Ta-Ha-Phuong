package case_study_module2.model.facility;

public class Room extends Facility{
    private String freeService;

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, int usableArea, double rentalCost, int maxPerson, int rentalType, String freeService) {
        super(serviceName, usableArea, rentalCost, maxPerson, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
