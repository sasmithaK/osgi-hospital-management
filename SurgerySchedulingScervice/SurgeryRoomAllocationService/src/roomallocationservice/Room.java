package roomallocationservice;

public class Room {

	private String roomNumber;
    private String surgeryType;
    private boolean available;
    private String availableDateTime;

    public Room (String roomNumber, String surgeryType, boolean available, String availableDateTime) {
        this.roomNumber = roomNumber;
        this.surgeryType = surgeryType;
        this.available = available;
        this.availableDateTime = availableDateTime;
    }

   
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getAvailableDateTime() {
        return availableDateTime;
    }
	
	
}
