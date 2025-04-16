package users;

import java.math.BigInteger;
import java.util.List;

import services.Message;
import services.Number;

public class Receiver {

    private int p, privk;
    private Message msg;

    public Receiver(int p) throws IllegalArgumentException {

        if (!(Number.isPrimeNumber(p))) {
            throw new IllegalArgumentException("Número informado não é primo.");
        }

        this.p = p;
        this.privk = Number.generateRandomNaturalNumber(p);
        this.msg = new Message();
    }

    public BigInteger[] generatePubk() {

        int r = Number.findPrimitiveRoot(p);

        if (r == -1) {
            throw new IllegalArgumentException("Número informado não possui raiz primitiva.");
        }

        BigInteger a = BigInteger.valueOf(r).modPow(BigInteger.valueOf(privk), BigInteger.valueOf(p));

        return new BigInteger[]{BigInteger.valueOf(p), BigInteger.valueOf(r), a};

    }

    public String unmaskMessage(List<BigInteger[]> ciphers) {

        String decMensagem = "";

        for (BigInteger[] cipher : ciphers) {

            BigInteger b = cipher[0], cezao = cipher[1];

            int pezao = ((cezao.multiply(b.pow(p - 1 - privk))).mod(BigInteger.valueOf(p))).intValue();

            String fPezao = (Integer.toString(pezao).length() > 1) ? Integer.toString(pezao) : "0" + Integer.toString(pezao);

            decMensagem += fPezao;

        }

        return msg.decryptMessage(msg.formatMessage(decMensagem));

    }
    
}
