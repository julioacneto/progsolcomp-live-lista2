package br.com.julioneto;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio001
 * Data: 2023-05-21
 *
 * */
public class Exercicio001 {
    private static final ArrayList<Double> numeros = new ArrayList<>();
    private static Double resultado = null;

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
        } while (numeros.size() < 2);

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
        if (numeros.get(0) > numeros.get(1)) {
            resultado = numeros.get(0);
        }

        if (numeros.get(1) > numeros.get(0)) {
            resultado = numeros.get(1);
        }
    }

    private static void saida() {
        if (resultado != null) {
            System.out.printf("O maior número é %.3f", resultado);
        } else {
            System.out.println("Os números são iguais!");
        }
    }
}
