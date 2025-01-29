import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Service {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense newExpense) {
        expenses.add(newExpense);
        System.out.println("Successfully added new expense to the list.");
    }

    public void viewExpenses() {
        if (!expenses.isEmpty()) {
            for (Expense e : expenses) {
                System.out.println(e);
            }
        } else {
            System.out.println("No expense found in the list.");
        }
    }

    public List<Expense> filter(String category) {
        return expenses.stream().filter(exp -> exp.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public double getTotalExpense() {
        return expenses.stream().mapToDouble(exp -> exp.getAmount()).sum();
    }
}
