package surgeonavailabilityservice;

import java.util.ArrayList;
import java.util.List;

public class SurgeonAvailabilityServiceImpl implements SurgeonAvailabilityService {
	
	private List<Surgeon> doctors;

    public SurgeonAvailabilityServiceImpl() {
    	
	    doctors = new ArrayList<>();
	    
	    doctors.add(new Surgeon("1", "Dr. Saman", "Cardiac Surgery", true));
	    doctors.add(new Surgeon("2", "Dr. Susantha", "Cardiac Surgery", true));
	    
	    doctors.add(new Surgeon("3", "Dr. Aberathne", "Heart Surgery", true));
	    doctors.add(new Surgeon("4", "Dr. Ranaweera", "Heart Surgery", true));
	    
	    doctors.add(new Surgeon("5", "Dr. Gunasinghe", "Neurosurgery", true));
	    doctors.add(new Surgeon("7", "Dr. Bandara", "Neurosurgery", true));
	    doctors.add(new Surgeon("8", "Dr. Nuwan", "Neurosurgery", true));
	    doctors.add(new Surgeon("9", "Dr. Gunathilaka", "Neurosurgery", true));
    }

    
    // Get available doctors
    @Override
    public List<Surgeon> getAvailableDoctors() {
        List<Surgeon> availableDoctors = new ArrayList<>();
        for (Surgeon doc : doctors) {
            if (doc.isAvailable()) {
                availableDoctors.add(doc);
            }
        }
        return availableDoctors;
    }
	
}
