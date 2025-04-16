package users;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import services.Message;
import services.Number;

public class Sender {

    private String message;
    private Message msg;

    public Sender(String message) {
        this.message = message;
        this.msg = new Message();
    }

    public String maskMessage() {
        return msg.shuffleString(msg.encryptMessage(message));
    }

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