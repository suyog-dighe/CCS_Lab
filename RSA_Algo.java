import java.util.Scanner;

public class RSA_Algo {

    public static int modInverse(int base, int modulus) {
        int result = 1;
        while ((result * base) % modulus != 1) {
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int m,e,p,q;
        int flag=0;

        System.out.println("Enter the values of plain text :");
        m=sc.nextInt();

        System.out.println("Enter the value of E :");
        e=sc.nextInt();

        System.out.println("Enter the value of p :");
        p=sc.nextInt();

        System.out.println("Enter the value of q :");
        q=sc.nextInt();

        //check p and q are prime or not

        int a=p/2;
        int b=q/2;

        for (int i=2;i<=a;i++){
            if (p%i==0){
                System.out.println("number is not prime ");
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.println("number is prime ");
        }



        for (int j=2;j<=b;j++){
            if (q%j==0){
                System.out.println("number is not prime ");
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.println("number is prime ");
        }

        int n=p*q;  // calculate n
        int c = (int) (Math.pow(m, e) % n);   //calculate cipher text

        int sv=(p-1)*(q-1);  //calculate  ϕ(n)

        int d = modInverse(e, sv);  // calculate Decryption key

        int sp=(int) (Math.pow(c, e) % n); // calculate plain text from cipher text


        System.out.println();
        System.out.println("The value of N is : "+n);

        System.out.println("The value of ϕ(n) is :"+sv);

        System.out.println("the value of Cipher text  is :"+c);

        System.out.println("The value of Decryption is :"+d);

        System.out.println("After cipher text to plain text again :"+sp);

    }
}
