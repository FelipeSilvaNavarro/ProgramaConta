package visualizar;

import modelo.entidades.Conta;
import modelo.entidades.excecoes.ExcecaoDominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaConta {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Conta conta;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf02 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date dataAgora = new Date();

        try {
            System.out.println("Digite os dados da conta");
            System.out.print("Numero: ");
            int numeroConta = scanner.nextInt();
            System.out.print("Dono: ");
            scanner.nextLine();
            String dono = scanner.nextLine();
            System.out.print("Data criacao da conta (DD/MM/YYYY): ");
            Date data = sdf.parse(scanner.next());
            System.out.print("Saldo inicial: ");
            Double saldo = scanner.nextDouble();
            System.out.print("Saque limite: ");
            Double saqueLimite = scanner.nextDouble();

            conta = new Conta(numeroConta, dono, data, saldo, saqueLimite);
            System.out.print("Digite o valor para saque: ");
            Double valorSaque = scanner.nextDouble();
            conta.saque(valorSaque);
            System.out.println("Dados: " + conta);
            System.out.print("Data saque: " + sdf02.format(dataAgora));
        } catch (ExcecaoDominio excecaoDominio) {
            System.out.println("Erro no saque: " + excecaoDominio.getMessage());
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Caracteres inválidos");
        } catch (ParseException parseException) {
            System.out.println("Formato de data inválido");
        }


        scanner.close();
    }
}