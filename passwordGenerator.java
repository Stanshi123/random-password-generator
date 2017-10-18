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
        Scanner scan = null;
        
        while (true) {
            try {
                System.out.println("Type the length: ");
                scan = new Scanner(System.in);
                length = scan.nextInt();
                System.out.println("Whether include capital: (type Y/N)");
                includeCapital = stringToBool(scan.next());
                System.out.println("Whether include special character: (type Y/N)");
                includeSpecialCharacter = stringToBool(scan.next());

                StringBuilder stringBuilder = new StringBuilder();

                String password = includeSpecialCharacter ? generateString(stringBuilder,length,ALPHA_NUMERIC) :
                generateString(stringBuilder,length,ALPHA_NUMERIC_AND_SPECIAL_CHARACTERS);
                
                if (!includeCapital) {
                    password = password.toLowerCase();
                }
                System.out.println("Here is the password:\n" + password);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Input is not correct!");
            }
        }
        
        if (scan != null) {
            scan.close();
        }
    }
    
    private static String generateString(StringBuilder sb,int length,String CONSTANT_STRING) {
        for (int i = 0; i < length; i++) {
            int characterIndex = (int) (Math.random() * ALPHA_NUMERIC.length()) ;
            sb.append(CONSTANT_STRING.charAt(characterIndex));
        }
        return sb.toString();
    }
    
    private static boolean stringToBool(String str) {
        str = str.toLowerCase();
        switch (str) {
            case "y":
                return true;
            case "n":
                return false;
            default:
                throw new InputMismatchException();
        }
    }
}
