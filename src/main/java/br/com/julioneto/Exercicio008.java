package br.com.julioneto;

import java.time.Month;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio008
 * Data: 2023-05-21
 *
 * */
public class Exercicio008 {
    private static final String[] estacoes = {"Verao", "Verao", "Verao/Outono", "Outono", "Outono", "Outono/Inverno", "Inverno", "Inverno", "Inverno/Primavera", "Primavera", "Primavera", "Primavera/Verao"};
    private static Integer numero = null;
    private static Month mes;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite um número [1-12]: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (numero == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            Integer input = Integer.parseInt(valorDigitado);
            if (input < 1 || input > 12) {
                throw new InputMismatchException();
            }
            numero = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void processamento() {
        mes = Month.of(numero);
    }

    private static void saida() {
        System.out.printf("Mês: %s – Estação: %s%n", mes, estacoes[mes.getValue() - 1]);
    }
}
