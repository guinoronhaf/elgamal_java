package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Services's class Message, which encrypts, decrypts, formats and shuffles strings.
 * 
 * @author guinoronhaf
 * @author pedroleal02
 * @author pedronparaiso 
 */
public class Message {

    /**
     * Hashtable that maps characters to digits.
     */
    private HashMap<String, String> charactersNumbers;

    /**
    * Hashtable that maps digits to characters. 
    */
    private HashMap<String, String> numbersCharacters;

    /**
     * Builds Message and populates the hashtables.
     */
    public Message() {
        this.charactersNumbers = new HashMap<>();
        this.numbersCharacters = new HashMap<>();
        populateCharactersNumbers();
        populateNumbersCharacters();
    }

    private void populateCharactersNumbers() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.;:!?- 1234567890áéíóúãẽĩõũâêîôûçÇÁÉÍÓÚÃẼĨÕŨ(){}[]+=-_/<>''\"\\";
        int iCode = 0;

        for (char c : characters.toCharArray()) {
            var codigo = Integer.toString(iCode);
            codigo = (codigo.length() > 1) ? codigo : "0" + codigo;
            charactersNumbers.put(Character.toString(c), codigo);
            iCode++;
        }
        
    }

    private void populateNumbersCharacters() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.;:!?- 1234567890áéíóúãẽĩõũâêîôûçÇÁÉÍÓÚÃẼĨÕŨ(){}[]+=-_/<>''\"\\";
        int iCode = 0;

        for (char c : characters.toCharArray()) {
            var codigo = Integer.toString(iCode);
            codigo = (codigo.length() > 1) ? codigo : "0" + codigo;
            numbersCharacters.put(codigo, Character.toString(c));
            iCode++;
        }

    }

    /**
     * Formats a string, adding "-" at each 2 characters.
     * 
     * @param encMessage message to be formatted.
     * @return formattted message.
     */
    public String formatMessage(String encMessage) {

        String formatEncMessage = "";
        int iFormatEncMessage = 0;

        for (char c : encMessage.toCharArray()) {

            var digit = Character.toString(c);

            if ((iFormatEncMessage != 0) && (iFormatEncMessage % 2 == 0)) {
                formatEncMessage += "-" + digit;
            } else {
                formatEncMessage += digit;
            }

            iFormatEncMessage++;

        }

        return formatEncMessage;

    }

    /**
     * Encrypts message, mapping each character to its number.
     * 
     * @param message message to be encrypted.
     * @return encrypted message.
     */
    public String encryptMessage(String message) {

        String encMessage = "";

        for (char c : message.toCharArray()) {

            var character = Character.toString(c);

            encMessage += charactersNumbers.get(character);

        }

        return encMessage;

    }

    /**
     * Decrypts message, mapping each digit to its character.
     * @param code code to be decrypted.
     * @return decrypted message.
     */
    public String decryptMessage(String code) {

        String[] blocks = code.split("-");

        String decMessage = "";

        for (String block : blocks) {
            decMessage += numbersCharacters.get(block);
        }

        return decMessage;

    }

    /**
     * Shuffles a string randomly.
     * 
     * @param message string to be shuffled.
     * @return shuffled string.
     */
    public String shuffleString(String message) {

        String result = "";

        List<Character> characters = new ArrayList<>();

        for (Character c : message.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        for (Character c : characters) {
            result += Character.toString(c);
        }

        return result;

    }
    
}
