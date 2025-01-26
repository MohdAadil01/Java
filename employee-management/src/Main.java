import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement system = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. List Employees");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Department, Designation, Salary:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String department = scanner.nextLine();
                    String designation = scanner.nextLine();
                    double salary = scanner.nextDouble();
                    system.addEmployee(new Employee(id, name, department, designation, salary));
                    break;
                case 2:
                    System.out.println("Enter ID to update:");
                    int updateId = scanner.nextInt();
                    system.updateEmployee(updateId);
                    break;
                case 3:
                    System.out.println("Enter ID to delete:");
                    int deleteId = scanner.nextInt();
                    system.deleteEmployee(deleteId);
                    break;
                case 4:
                    system.listEmployees();
                    break;
                case 5:
                    System.out.println("Enter ID to search:");
                    int searchId = scanner.nextInt();
                    system.searchEmployee(searchId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
