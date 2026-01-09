package helpdesk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
class HelpDesk {
    private List<Employee> employees = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void completeTicket(String employeeFullName, int ticketId) {
        Employee emp = null;
        for (Employee e : employees) {
            if (e.getFullName().equals(employeeFullName)) {
                emp = e;
                break;
            }
        }
        if (emp == null) return;

        Ticket tick = null;
        for (Ticket t : tickets) {
            if (t.getId() == ticketId) {
                tick = t;
                break;
            }
        }
        if (tick == null || tick.isCompleted()) return;

        if (emp.getAssignedCategories().contains(tick.getCategory()) &&
            emp.getPointLevel() >= tick.getPoint()) {
            tick.setCompleted(true);
            tick.setAssignedEmployee(employeeFullName);
        }
    }

    public int getWaitingTicketCount() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isCompleted()) count++;
        }
        return count;
    }

    public int getCompletedTicketsTotalPoint() {
        int sum = 0;
        for (Ticket t : tickets) {
            if (t.isCompleted()) sum += t.getPoint();
        }
        return sum;
    }

    public List<Entry<String, Integer>> getTicketsTotalPointByCategory() {
        Map<String, Integer> map = new HashMap<>();
        String[] cats = {"InformationTechnologies", "HumanResources", "Accounting", "Sales", "Marketing", "Legal"};
        for (String c : cats) {
            map.put(c, 0);
        }
        for (Ticket t : tickets) {
            String c = t.getCategory();
            map.put(c, map.getOrDefault(c, 0) + t.getPoint());
        }
        List<Entry<String, Integer>> list = new ArrayList<>();
        for (String c : cats) {
            list.add(new SimpleEntry<>(c, map.get(c)));
        }
        return list;
    }

    public List<Entry<String, Integer>> getTicketsTotalPointByEmployee() {
        Map<String, Integer> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.getFullName(), 0);
        }
        for (Ticket t : tickets) {
            if (t.isCompleted()) {
                String e = t.getAssignedEmployee();
                map.put(e, map.getOrDefault(e, 0) + t.getPoint());
            }
        }
        List<Entry<String, Integer>> list = new ArrayList<>();
        for (Employee e : employees) {
            list.add(new SimpleEntry<>(e.getFullName(), map.get(e.getFullName())));
        }
        return list;
    }
}