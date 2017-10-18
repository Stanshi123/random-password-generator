import java.util.InputMismatchException;
import java.util.Scanner;

public class passwordGenerator {

    private static final String ALPHA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String ALPHA_NUMERIC_AND_SPECIAL_CHARACTERS = ALPHA_NUMERIC + SPECIAL_CHARACTERS;
    public static void main(String[] args) {

        int length;
        boolean includeCapital;
        boolean includeSpecialCharacter;

        try {
            System.out.println("Type the length: ");
            Scanner scan = new Scanner(System.in);
            length = scan.nextInt();
            System.out.println("Whether include capital: (type true/false)");
            includeCapital = scan.nextBoolean();
            System.out.println("Whether include special character: (type true/false)");
            includeSpecialCharacter = scan.nextBoolean();


            StringBuilder stringBuilder = new StringBuilder();
            String password = "";

            for (int i = 0; i < length; i++) {
                if (!includeSpecialCharacter) {
                    int characterIndex = (int) (Math.random() * ALPHA_NUMERIC.length());
                    stringBuilder.append(ALPHA_NUMERIC.charAt(characterIndex));
                } else {
                    int characterIndex = (int) (Math.random() * ALPHA_NUMERIC_AND_SPECIAL_CHARACTERS.length());
                    stringBuilder.append(ALPHA_NUMERIC_AND_SPECIAL_CHARACTERS.charAt(characterIndex));
                }
            }
            password = stringBuilder.toString();

            if (!includeCapital) {
                password = password.toLowerCase();
            }
            System.out.println("Here is the password:\n" + password);

        } catch (InputMismatchException e) {
            System.out.println("Input is not correct!");
        }
    }
}
