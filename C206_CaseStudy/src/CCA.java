public class CCA {
    private String ccaName;
    private String description;
    private String restriction;
    private int capacity;

    // Constructor
    public CCA(String ccaName, String description, String restriction, int capacity) {
        this.ccaName = ccaName;
        this.description = description;
        this.restriction = restriction;
        this.capacity = capacity;
        
    }

    public String getCcaName() {
        return ccaName;
    }

    public void setCcaName(String ccaName) {
        this.ccaName = ccaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
    
    public int getCapacity() {
    	return capacity;
    }
    
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    }
       
}