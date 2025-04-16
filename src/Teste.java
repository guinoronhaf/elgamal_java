import users.*;
import controllers.*;

public class Teste {

    public static void main(String[] args) {

        String message = args[0];
        int prime = Integer.parseInt(args[1]);

        Sender sender = new Sender(message);
        Receiver receiver = new Receiver(prime);

        CryptoController c = new CryptoController(sender, receiver);

        System.out.println(message);

        System.out.println("|\n|");

        System.out.println(c.encryptMessage());

        System.out.println("|\n|");

        System.out.println(c.decryptMessage());

    }
    
}
