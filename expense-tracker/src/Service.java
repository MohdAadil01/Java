import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

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
        List<Expense> filtered_list = new ArrayList<>();
        if (!expenses.isEmpty()) {
            filtered_list = expenses.stream().filter(exp -> exp.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        } else {
            System.out.println("No expense found in the list with the given input.");
            filtered_list = Collections.emptyList();
        }
        return filtered_list;
    }

    public double getTotalExpense() {
        return expenses.stream().mapToDouble(exp -> exp.getAmount()).sum();
    }
}
