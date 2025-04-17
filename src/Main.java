import users.*;
import controllers.*;

public class Main {

    private static final int MINIMUM_ARGS_LENGTH = 2;

    public static void main(String[] args) {

        if (args.length < MINIMUM_ARGS_LENGTH) {
            System.err.println("Número insuficiente de argumentos para o programa.");
            System.exit(1);
        }

        try {

            String message = args[0];
            int primeNumber = Integer.parseInt(args[1]);

            Sender sender = new Sender(message);
            Receiver receiver = new Receiver(primeNumber);

            CryptoController c = new CryptoController(sender, receiver);

            System.out.println(message);

            System.out.println("|\n|");

            System.out.println(c.encryptMessage() + " (Encrypted message)");

            System.out.println("|\n|");

            System.out.println(c.decryptMessage() + " (Decrypted message)");

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
    
}
