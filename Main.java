import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to use a Cipher or use SHA-256?");
        System.out.println("1. Cipher, 2. SHA-256");
        int response = scanner.nextInt();

        switch(response){
            case 1:
                Cipher ep = new Cipher();
                break;

            case 2:
            Hash ha = new Hash();
            break;

            default:
                System.out.println("Not a valid response");
                break;
        }

    }
}