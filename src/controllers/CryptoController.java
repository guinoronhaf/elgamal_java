package controllers;

import users.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Represents a controller that simulates a chat.
 * 
 * @author guinoronhaf
 * @author pedroleal02
 * @author pedronparaiso 
 */
public class CryptoController {

    /**
     * Chat's sender, represented by a Sender object.
     */
    private Sender sender;

    /**
     * Chat's receiver, represented by a Receiver object.
     */
    private Receiver receiver;

    /**
     * Builds crypto controller using sender and receiver.
     * 
     * @param sender chat's sender.
     * @param receiver chat's receiver.
     * @throws IllegalArgumentException exception thrown wether at least one parameter is null.
     */
    public CryptoController(Sender sender, Receiver receiver) throws IllegalArgumentException {

        if (sender == null || receiver == null) {
            throw new IllegalArgumentException("Usuário inválido.");
        }

        this.sender = sender;
        this.receiver = receiver;
    }

    /**
     * Encrypts sender's message and returns it shuffled.
     * 
     * @return shuffled encrypted message.
     */
    public String encryptMessage() {

        return (sender.maskMessage());

    }

    /**
     * Decrypts message gathered by receiver.
     * 
     * @return decrypted message.
     */
    public String decryptMessage() {

        BigInteger[] pubk = receiver.generatePubk();

        List<BigInteger[]> ciphers = sender.generateCiphers(pubk);

        return (receiver.unmaskMessage(ciphers));

    }
    
}
