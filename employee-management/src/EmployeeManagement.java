import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
    private ArrayList<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    public void updateEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter new name:");
                e.setName(scanner.nextLine());
                System.out.println("Enter new department:");
                e.setDepartment(scanner.nextLine());
                System.out.println("Enter new designation:");
                e.setDesignation(scanner.nextLine());
                System.out.println("Enter new salary:");
                e.setSalary(scanner.nextDouble());
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
        System.out.println("Employee deleted successfully!");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    public void searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}
