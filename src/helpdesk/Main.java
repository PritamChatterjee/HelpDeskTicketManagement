package helpdesk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HelpDesk hd = new HelpDesk();

        int numEmp = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numEmp; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            String name = parts[0].trim();
            int point = Integer.parseInt(parts[1].trim());
            String catsStr = "";
            for (int j = 2; j < parts.length; j++) {
                catsStr += parts[j] + (j < parts.length - 1 ? "," : "");
            }
            catsStr = catsStr.trim();
            List<String> cats = new ArrayList<>();
            if (!catsStr.isEmpty()) {
                cats = Arrays.asList(catsStr.split("\\s+"));
            }
            Employee emp = new Employee(name, point, cats);
            hd.addEmployee(emp);
        }

        int numTick = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numTick; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String tname = parts[1].trim();
            String cat = parts[2].trim();
            int point = Integer.parseInt(parts[3].trim());
            Ticket tick = new Ticket(id, tname, cat, point);
            hd.addTicket(tick);
        }

        int numQuery = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < numQuery; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            String ename = parts[0].trim();
            int tid = Integer.parseInt(parts[1].trim());
            hd.completeTicket(ename, tid);
        }

        System.out.println("WaitingTicketCount:" + hd.getWaitingTicketCount());
        System.out.println("CompletedTicketsTotalPoint:" + hd.getCompletedTicketsTotalPoint());
        System.out.println("TicketsTotalPointByCategory:");
        List<Entry<String, Integer>> catList = hd.getTicketsTotalPointByCategory();
        for (Entry<String, Integer> entry : catList) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("TicketsTotalPointByEmployee:");
        List<Entry<String, Integer>> empList = hd.getTicketsTotalPointByEmployee();
        for (Entry<String, Integer> entry : empList) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}