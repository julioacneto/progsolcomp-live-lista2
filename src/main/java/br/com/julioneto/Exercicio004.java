package br.com.julioneto;

import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio004
 * Data: 2023-05-21
 *
 * */
public class Exercicio004 {
    private static Integer numero = null;
    private static boolean ehPar;
    private static String ehPositivo;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite um número: ");
            String valorDigitado = teclado.nextLine();
            validacoesDeEntrada(valorDigitado);
        } while (numero == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            numero = Integer.parseInt(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void processamento() {
        ehPar = numero % 2 == 0;
        ehPositivo = numero == 0 ? "NEUTRO" : (numero > 0 ? "POSITIVO" : "NEGATIVO");
    }

    private static void saida() {
        System.out.printf("O numero %d é %s e %s%n", numero, ehPar ? "PAR" : "IMPAR", ehPositivo);
    }
}
