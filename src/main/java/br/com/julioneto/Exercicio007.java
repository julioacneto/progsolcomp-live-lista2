package br.com.julioneto;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

enum TaxaExtra {
    TAXA_EXTRA_A(5.50),
    TAXA_EXTRA_B(6.00),
    TAXA_EXTRA_C(8.00);

    private final Double VALOR_DA_TAXA;

    TaxaExtra(Double VALOR_DA_TAXA) {
        this.VALOR_DA_TAXA = VALOR_DA_TAXA;
    }

    public static TaxaExtra definirTaxacao(Integer diarias) {
        if (diarias > 15) {
            return TAXA_EXTRA_A;
        } else if (diarias < 15) {
            return TAXA_EXTRA_C;
        } else {
            return TAXA_EXTRA_B;
        }
    }

    public Double obterTaxa() {
        return VALOR_DA_TAXA;
    }
}

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio007
 * Data: 2023-05-21
 *
 * */
public class Exercicio007 {
    private static final Double VALOR_DA_DIARIA = 60.00;
    private static Integer diarias = null;
    private static TaxaExtra taxaExtra;
    private static Double valorTotal = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a quantidade de diárias: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (diarias == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {

            Integer input = Integer.parseInt(valorDigitado);

            if (input < 1) {
                throw new InputMismatchException();
            }

            diarias = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar diarias, tente novamente!");
        }
    }

    private static void processamento() {
        taxaExtra = TaxaExtra.definirTaxacao(diarias);
        valorTotal = (diarias * VALOR_DA_DIARIA) + (diarias * taxaExtra.obterTaxa());
    }

    private static void saida() {
        System.out.printf("Total de diarias: %d%nValor da Taxa extra: %.2f%nTotal a pagar: %.2f%n", diarias, taxaExtra.obterTaxa(), valorTotal);
    }
}
