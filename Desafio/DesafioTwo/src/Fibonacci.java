import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int num1 = 0, num2 = 1, num3;
        boolean pertence = false;

        Scanner sc = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = sc.nextInt();

        System.out.print("Sequência de Fibonacci: " + num1 + ", " + num2);

        for (int i = 2; i <= num; i++) {
            num3 = num1 + num2;
            System.out.print(", " + num3);
            num1 = num2;
            num2 = num3;
            if (num3 == num) {
                pertence = true;
            }
        }

        if (pertence) {
            System.out.println("\n" + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("\n" + num + " não pertence à sequência de Fibonacci.");
        }
    }
}
