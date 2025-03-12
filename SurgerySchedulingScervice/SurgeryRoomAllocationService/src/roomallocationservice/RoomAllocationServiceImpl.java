package roomallocationservice;

import java.util.ArrayList;
import java.util.List;

public class RoomAllocationServiceImpl implements RoomAllocationService {
	
	private List<Room> rooms;

    public RoomAllocationServiceImpl() {
        rooms = new ArrayList<>();
        
        // Add hard coded rooms using the correct RoomImpl class
        rooms.add(new Room("R101", "Cardiac Surgery", true, "2025-03-12 10:00 AM"));
        rooms.add(new Room("R102", "Neurosurgery", false, "2025-03-15 02:00 PM"));
        rooms.add(new Room("R103", "Orthopedic Surgery", true, "2025-03-13 09:00 AM"));
        rooms.add(new Room("R104", "General Surgery", true, "2025-03-14 11:00 AM"));
        rooms.add(new Room("R104", "Heart Surgery", true, "2025-03-14 11:00 AM"));
    }

    @Override
    public List<Room> getAvailableRooms(String surgeryType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getSurgeryType().equalsIgnoreCase(surgeryType)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
	}
}
