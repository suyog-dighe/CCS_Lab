import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class DiffeHellman {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        // private key of the Alice
        System.out.println("Enter the value of a : ");
        int a= sc.nextInt();

        //private key of the Bob
        System.out.println("Enter the value of b :");
        int b=sc.nextInt();

        System.out.println("Enter the prime number : ");
        int p=sc.nextInt();

        Integer q = findPrimitiveRoot(p);
        System.out.println("primtive root : " + q);

//        System.out.println("Enter the primitive root : ");
//        int q=sc.nextInt();

        //find the public key of A & B
        int A = (int) (Math.pow(q, a) % p);
        int B=  (int) (Math.pow(q, b) % p);

        System.out.println("Alice :"+A);
        System.out.println("Bob :"+B);

        //shared secret key calculate
        int sa=(int) (Math.pow(B, a) % p);
        int sb=(int) (Math.pow(A, b) % p);

        //print the output of shared key
        System.out.println("shared key of Alice  :"+sa);
        System.out.println("shared key of Bob :" + sb);
    }


    private static boolean isPrimitiveRoot(int g, int p) {
        Set<Integer> residues = new HashSet<>();
        for (int i = 1; i < p; i++) {
            residues.add(modPow(g, i, p));
        }
        return residues.size() == p - 1;
    }

    private static Integer findPrimitiveRoot(int p) {
        for (int g = 2; g < p; g++) {
            if (isPrimitiveRoot(g, p)) {
                return g;
            }
        }
        return null;
    }

    private static int modPow(int base, int exponent, int modulus) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }

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

}
