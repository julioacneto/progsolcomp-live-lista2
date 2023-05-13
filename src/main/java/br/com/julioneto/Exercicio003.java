package br.com.julioneto;

import java.util.*;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio003
 * Data: 2023-05-21
 *
 * */
public class Exercicio003 {
    private static final ArrayList<Integer> numeros = new ArrayList<>();
    private static boolean saoMultiplos = false;

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
            Integer input = Integer.parseInt(valorDigitado);

            if (input < 0) {
                throw new InputMismatchException();
            }

            numeros.add(input);
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void processamento() {
        Collections.sort(numeros);

        if (numeros.get(1) == 0 || numeros.get(0) == 0 || numeros.get(1) == 1 && numeros.get(0) == 1) {
            saoMultiplos = true;
            return;
        }

        for (int i = 0; i <= numeros.get(1); i++) {
            if (numeros.get(0) * i == numeros.get(1) && numeros.get(0) != 1 && numeros.get(1) != 1) {
                saoMultiplos = true;
                break;
            }
        }
    }

    private static void saida() {
        System.out.printf("%s múltiplos", saoMultiplos ? "São" : "Não são");
    }
}
