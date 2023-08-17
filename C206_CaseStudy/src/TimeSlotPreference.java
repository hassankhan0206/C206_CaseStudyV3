public class TimeSlotPreference {
    private String studentName;
    private String preferredTimeSlot;

    public TimeSlotPreference(String studentName, String preferredTimeSlot) {
        this.studentName = studentName;
        this.preferredTimeSlot = preferredTimeSlot;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPreferredTimeSlot() {
        return preferredTimeSlot;
    }

    public void setPreferredTimeSlot(String preferredTimeSlot) {
        this.preferredTimeSlot = preferredTimeSlot;
    }
}
