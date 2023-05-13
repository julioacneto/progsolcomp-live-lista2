package br.com.julioneto;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio021
 * Data: 2023-05-21
 *
 * */
public class Exercicio021 {
    private static Integer numero = null;

    public static void main(String[] args) {
        entrada();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite um número (positivo): ");
            String valorDigitado = teclado.nextLine();
            validacoesDeEntrada(valorDigitado);
        } while (numero == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            Integer input = Integer.parseInt(valorDigitado);

            if (input <= 0) {
                throw new InputMismatchException();
            }

            numero = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void saida() {
        for (int i = 1; i <= numero; i++) {
            System.out.printf("%d x %d = %d%n", numero, i, (numero * i));
        }
    }
}
