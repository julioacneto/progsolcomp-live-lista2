package br.com.julioneto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio002
 * Data: 2023-05-21
 *
 * */
public class Exercicio002 {
    private static final ArrayList<Double> numeros = new ArrayList<>();

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.printf("Digite o %s número: ", numeros.isEmpty() ? "primeiro" : "segundo");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (numeros.size() < 3);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            numeros.add(Double.parseDouble(valorDigitado));
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void processamento() {
        Collections.sort(numeros);
    }

    private static void saida() {
        numeros.forEach(System.out::println);
    }
}
