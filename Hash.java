import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.security.MessageDigest;

public class Hash {
    private byte[] message;
    private Scanner scanner;

    public Hash() throws NoSuchAlgorithmException {
        try {
            scanner = new Scanner(System.in);
            message = new byte[255];
            getMessage();
            encryptMessage();
        } finally {
            scanner.close();
        }
    }

    private void getMessage() {
        System.out.println("What message would you like to pass through SHA-256?");
        String line = scanner.nextLine();
        message = line.getBytes();
    }

    private void encryptMessage() throws NoSuchAlgorithmException {
        System.out.println("Encryption started");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message);

        byte[] digest = md.digest();
        System.out.println("Digest: " + bytesToHex(digest));
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder out = new StringBuilder();
        for (byte b : bytes) {
            out.append(String.format("%02X", b));
        }
        return out.toString();
    }
}
