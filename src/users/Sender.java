package users;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import services.Message;
import services.Number;

/**
 * Reperesents the sender of the message, which is composed by a message.
 * 
 * @author guinoronhaf
 * @author pedroleal02
 * @author pedronparaiso 
 */
public class Sender {

    /**
     * Sender's message.
     */
    private String message;

    /**
     * Object of the class Mesage, mainly used to decrypt the message once the code is obtained.
     */
    private Message msg;

    /**
     * Builds a sender using the message.
     * 
     * @param message the message that will be sent.
     * @throws IllegalArgumentException exception thrown wether the message is null or empty.
     */
    public Sender(String message) throws IllegalArgumentException {

        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Mensagem inválida.");
        }

        this.message = message;
        this.msg = new Message();
    }

    /**
     * Encrypts the message using msg's algorithm.
     * @return
     */
    public String maskMessage() {
        return msg.shuffleString(msg.encryptMessage(message));
    }

   /**
    * Generates ciphers based on receiver's public key.

    * @param pubk receiver's public key.
    * @return sender's ciphers.
    */ 
    public List<BigInteger[]> generateCiphers(BigInteger[] pubk) {

        String[] blocks = msg.formatMessage(msg.encryptMessage(message)).split("-");

        List<BigInteger[]> ciphers = new ArrayList<>();

        BigInteger p = pubk[0], r = pubk[1], a = pubk[2];

        int y = Number.generateRandomNaturalNumber(p.intValue());

        BigInteger b = r.modPow(BigInteger.valueOf(y), p);

        for (String block : blocks) {

            var code = Integer.parseInt(block);

            BigInteger cezao = (BigInteger.valueOf(code).multiply(a.pow(y))).mod(p);

            ciphers.add(new BigInteger[]{b, cezao});

        }

        return ciphers;

    }

}