public class CCA {
    private String ccaName;
    private String description;
    private String restriction;
    private boolean isAvailable;

 

    // Constructor
    public CCA(String ccaName, String description, String restriction) {
        this.ccaName = ccaName;
        this.description = description;
        this.restriction = restriction;
        this.isAvailable = false; // Default to not available
    }

 

    // Getter and setter methods for attributes

 

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

 

    public boolean isAvailable() {
        return isAvailable;
    }

 

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

 

    // Other methods as needed
}


