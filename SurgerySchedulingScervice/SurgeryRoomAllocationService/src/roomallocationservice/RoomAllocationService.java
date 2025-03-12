package roomallocationservice;

import java.util.List;

public interface RoomAllocationService {
	
	List<Room> getAvailableRooms(String surgeryType);
	
}