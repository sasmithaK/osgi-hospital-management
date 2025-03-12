package surgeonavailabilityservice;

// Doctor model 
public class Surgeon {

	private String docID;
	private String docName;
    private String surgeryType;
    private boolean isAvailable;

    // Constructor
    public Surgeon(String docID, String docName, String surgeryType, boolean isAvailable) {
    	this.docID = docID;
        this.docName = docName;
        this.surgeryType = surgeryType;
        this.isAvailable = isAvailable;
    }

    
    // Getters and Setters
    public String getDocID() {
    	return docID;
    }
    
    public String getName() {
        return docName;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
	
}
