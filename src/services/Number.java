package services;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Service's class Number, which contains static methods asscociated with interesting number properties.
 * 
 * @author guinoronhaf
 * @author pedroleal02
 * @author pedronparaiso 
 */
public class Number {

    /**
     * Checks if a number "n" is a prime number.
     * 
     * @param n number to be checked.
     * @return boolean that confirms (true) or not (false) the assumption.
     */
    public static boolean isPrimeNumber(int n) {

        if (n < 2) return false;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;

    }

    /**
     * Returns all "n" prime factors.
     * 
     * @param n number that will be factorized.
     * @return set of "n" prime factors.
     */
    public static HashSet<Integer> getPrimeFactors(int n) {

        HashSet<Integer> primeFactors = new HashSet<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                primeFactors.add(i);
                n /= i;
            }
        }

        if (n > 1) {
            primeFactors.add(n);
        }

        return primeFactors;

    }

    /**
     * Checks if "g" is a primitive root module "n".
     * 
     * @param n module "n".
     * @param g possible primitive root.
     * @return boolean that confirms or not the assumption.
     */
    public static boolean isPrimitiveRoot(int n, int g) {

        int phi = n - 1;
        HashSet<Integer> primeFactorsN = getPrimeFactors(phi);

        for (int factor : primeFactorsN) {

            BigInteger exp = BigInteger.valueOf(phi/factor);

            BigInteger result = BigInteger.valueOf(g).modPow(exp, BigInteger.valueOf(n));

            if (result.equals(BigInteger.ONE)) {
                return false;
            }

        }

        return true;

    }

    /**
     * Returns "n" first primitive root.
     * 
     * @param n number necessary to extract primitive root.
     * @return first number "n" primitive root.
     */
    public static int findPrimitiveRoot(int n) {

        for (int i = 1; i < n; i++) {
            if (isPrimitiveRoot(n, i)) return i;
        }

        return -1;

    }

    /**
     * Generates a random natural number from 3 to n - 2.
     * 
     * @param n number from which the random natural number will be generated.
     * @return a random number from 3 to n - 2.
     */
    public static int generateRandomNaturalNumber(int n) {

        int random = ThreadLocalRandom.current().nextInt(3, n - 1);

        return random;

    }

    
}
