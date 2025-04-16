package controllers;

import users.*;

import java.math.BigInteger;
import java.util.List;

public class CryptoController {

    private Sender sender;
    private Receiver receiver;

    public CryptoController(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public String encryptMessage() {

        return (sender.maskMessage());

    }

    public String decryptMessage() {

        BigInteger[] pubk = receiver.generatePubk();

        List<BigInteger[]> ciphers = sender.generateCiphers(pubk);

        return (receiver.unmaskMessage(ciphers));

    }
    
}
