package helpdesk;
import java.util.List;
class Employee {
    private String fullName;
    private int pointLevel;
    private List<String> assignedCategories;

    public Employee(String fullName, int pointLevel, List<String> assignedCategories) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategories = assignedCategories;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPointLevel() {
        return pointLevel;
    }

    public List<String> getAssignedCategories() {
        return assignedCategories;
    }
}