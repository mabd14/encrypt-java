import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Cipher {
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    public Cipher() {
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestion();
    }
    private void askQuestion() {
        while(true){
            System.out.println("Would you like to get key, make a new key, encrypt, decrypt, or quit?");
            System.out.println("1. New key, 2. Get key, 3. Encrypt, 4. Decrypt, 5. Quit");
            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    newKey();
                    break;
                case 2:
                    getKey();
                    break;
                case 3:
                    encrypt();
                    break;
                case 4:
                    decrypt();
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Not a valid response");
                    break;
            }
        }

    }

    private void newKey(){
        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i = 32; i < 127; i++){
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("New key generated.");

    }

    private void getKey() {
        System.out.println("*******************************************************************************************");
        for (Character x : list) {
            System.out.print(x);
        }

        System.out.println();

        for (Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
        System.out.println("*******************************************************************************************");


    }

    private void encrypt() {
        System.out.println("Enter a message to encrypt");
        scanner.nextLine();
        line = scanner.nextLine();

        letters = line.toCharArray();
        secretLetters = new char[letters.length];

        for(int i = 0; i < letters.length; i++){
            character = letters[i];
            int index = list.indexOf(character);
            secretLetters[i] = shuffledList.get(index);
        }

        System.out.println("Encrypted message: ");
        System.out.println(String.valueOf(secretLetters));

    }

    private void decrypt() {
        System.out.println("Enter a message to decrypt");
        scanner.nextLine();
        line = scanner.nextLine();

        letters = line.toCharArray();
        secretLetters = new char[letters.length];

        for(int i = 0; i < letters.length; i++){
            character = letters[i];
            int index = shuffledList.indexOf(character);
            secretLetters[i] = list.get(index);
        }

        System.out.println("Decrypted message: ");
        System.out.println(String.valueOf(secretLetters));

    }

    private void quit() {
        System.out.println("Thank you for using the encryption program.");
        System.exit(0);

    }
}
