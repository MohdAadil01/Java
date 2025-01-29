import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the expense tracker.");
        Service svc = new Service();
        Scanner scanner = new Scanner(System.in);

        int choice = 2;
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Filter by Category");
            System.out.println("4. View Total Expenses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    svc.addExpense(new Expense(amount, category, description, LocalDate.now()));
                    break;
                case 2:
                    svc.viewExpenses();
                    break;
                case 3:
                    String cat = scanner.nextLine();
                    List<Expense> filteredList = svc.filter(cat);
                    for (Expense e : filteredList) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Total Expenses: $" + svc.getTotalExpense());
                    break;
                case 5:
                    System.out.println("Exiting Expense Tracker...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}