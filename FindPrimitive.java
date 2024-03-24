import java.util.ArrayList;
import java.util.Scanner;

public class FindPrimitive {

    public static ArrayList<Integer> findAllPrimitiveRoots(int p) {
        ArrayList<Integer> primitiveRoots = new ArrayList<>();
        ArrayList<Integer> factors = findPrimeFactors(p - 1);

        for (int r = 2; r < p; r++) {
            boolean isPrimitiveRoot = true;

            for (int factor : factors) {
                if (modPow(r, (p - 1) / factor, p) == 1) {
                    isPrimitiveRoot = false;
                    break;
                }
            }

            if (isPrimitiveRoot) {
                primitiveRoots.add(r);
            }
        }

        return primitiveRoots;
    }

    // Function to find prime factors of a number
    private static ArrayList<Integer> findPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        return factors;
    }

    // Function to calculate (base^exponent) % modulus efficiently
    private static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        base %= modulus;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }

            exponent >>= 1;
            base = (base * base) % modulus;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int primeNumber = sc.nextInt(); // Replace this with your desired prime number
        ArrayList<Integer> primitiveRoots = findAllPrimitiveRoots(primeNumber);

        if (!primitiveRoots.isEmpty()) {
            System.out.println("Primitive Roots modulo " + primeNumber + " are: " + primitiveRoots);
        } else {
            System.out.println("No primitive roots found for " + primeNumber);
        }
    }
}
