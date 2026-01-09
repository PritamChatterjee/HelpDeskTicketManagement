package helpdesk;
class Ticket {
    private int id;
    private String name;
    private String category;
    private int point;
    private String assignedEmployee = "";
    private boolean isCompleted = false;

    public Ticket(int id, String name, String category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPoint() {
        return point;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}