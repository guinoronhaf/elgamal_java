package services;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Number {

    public static boolean isPrimeNumber(int n) {

        if (n < 2) return false;

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;

    }

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

    public static int findPrimitiveRoot(int n) {

        for (int i = 1; i < n; i++) {
            if (isPrimitiveRoot(n, i)) return i;
        }

        return -1;

    }

    public static int generateRandomNaturalNumber(int n) {

        int random = ThreadLocalRandom.current().nextInt(3, n - 1);

        return random;

    }

    
}
