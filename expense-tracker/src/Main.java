import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the expense tracker.");
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

        }
    }
}