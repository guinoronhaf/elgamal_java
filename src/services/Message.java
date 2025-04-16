package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Message {

    private HashMap<String, String> charactersDigits;
    private HashMap<String, String> digitsCharacters;

    public Message() {
        this.charactersDigits = new HashMap<>();
        this.digitsCharacters = new HashMap<>();
        populateCharactersDigits();
        populateDigitsCharacters();
    }

    private void populateCharactersDigits() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.;:!?- 1234567890áéíóúãẽĩõũâêîôûçÇÁÉÍÓÚÃẼĨÕŨ(){}[]+=-_/<>";
        int iCode = 0;

        for (char c : characters.toCharArray()) {
            var codigo = Integer.toString(iCode);
            codigo = (codigo.length() > 1) ? codigo : "0" + codigo;
            charactersDigits.put(Character.toString(c), codigo);
            iCode++;
        }
        
    }

    private void populateDigitsCharacters() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.;:!?- 1234567890áéíóúãẽĩõũâêîôûçÇÁÉÍÓÚÃẼĨÕŨ(){}[]+=-_/<>";
        int iCode = 0;

        for (char c : characters.toCharArray()) {
            var codigo = Integer.toString(iCode);
            codigo = (codigo.length() > 1) ? codigo : "0" + codigo;
            digitsCharacters.put(codigo, Character.toString(c));
            iCode++;
        }

    }

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

    public String encryptMessage(String message) {

        String encMessage = "";

        for (char c : message.toCharArray()) {

            var character = Character.toString(c);

            encMessage += charactersDigits.get(character);

        }

        return encMessage;

    }

    public String decryptMessage(String code) {

        String[] blocks = code.split("-");

        String decMessage = "";

        for (String block : blocks) {
            decMessage += digitsCharacters.get(block);
        }

        return decMessage;

    }

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
