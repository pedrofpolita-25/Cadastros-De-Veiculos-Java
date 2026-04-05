import java.util.Scanner;

public class input {
    static Scanner scanner = new Scanner(System.in);

    public static int scanInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static String scanString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }
}