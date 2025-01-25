import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Generate {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password length");
        int password_length = scanner.nextInt();

        System.out.println("Include Capital letters, \'true/false\'");
        boolean include_capital_letters = scanner.nextBoolean();

        System.out.println("Include Special Characters, \'true/false\'");
        boolean include_special_characters = scanner.nextBoolean();

        System.out.println("Include Numbers, \'true/false\'");
        boolean include_numbers = scanner.nextBoolean();

        scanner.close();

        String password = generateFunction(password_length, include_capital_letters, include_special_characters,
                include_numbers);

        Display display_password = new Display();
        display_password.display(password);
    }

    private static String generateFunction(int password_length, boolean include_capital_letters,
            boolean include_special_characters, boolean include_numbers) {

        StringBuilder password_pool = new StringBuilder();
        password_pool.append(LOWERCASE);
        if (include_capital_letters)
            password_pool.append(UPPERCASE);
        if (include_special_characters)
            password_pool.append(SPECIAL);
        if (include_numbers)
            password_pool.append(DIGITS);

        if (password_pool.length() <= 0) {
            throw new IllegalArgumentException("At least one character type must be selected");
        }

        ArrayList<Character> password_list = new ArrayList<>();
        for (int i = 0; i < password_length; i++) {
            int random_index = (int) (Math.random() * password_pool.length());
            char random_char = password_pool.charAt(random_index);
            password_list.add(random_char);
        }

        Collections.shuffle(password_list);

        StringBuilder password = new StringBuilder();
        for (char c : password_list) {
            password.append(c);
        }
        return password.toString();
    }
}
