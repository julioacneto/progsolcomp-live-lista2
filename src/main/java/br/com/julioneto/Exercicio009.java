package br.com.julioneto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

enum FormasDePagamento {
    A_VISTA("À vista", 0.0, 0.10),
    PRAZO_30("À prazo (30 dias)", 0.0, 0.05),
    PRAZO_60("À prazo (60 dias)", 0.0, 0.00),
    PRAZO_90("À prazo (90 dias)", 0.05, 0.0),
    CARTAO_DEBITO("Cartão de débito", 0.0, 0.08),
    CARTAO_CREDITO("Cartão de crédito", 0.0, 0.07);

    private final String TIPO;
    private final Double ACRESCIMO;
    private final Double DESCONTO;

    FormasDePagamento(String TIPO, Double ACRESCIMO, Double DESCONTO) {
        this.TIPO = TIPO;
        this.ACRESCIMO = ACRESCIMO;
        this.DESCONTO = DESCONTO;
    }

    public static void menuDeOpcoes() {
        System.out.println("Opções de pagamento:");
        Arrays.stream(FormasDePagamento.values()).toList().forEach(e -> System.out.println((e.ordinal() + 1) + " - " + e.TIPO));
        System.out.print("Digite a forma de pagamento: ");
    }

    public Double obterAcrescimo() {
        return this.ACRESCIMO;
    }

    public Double obterDesconto() {
        return this.DESCONTO;
    }
}

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio009
 * Data: 2023-05-21
 *
 * */
public class Exercicio009 {
    private static Double valorParcial = null;
    private static Integer opcao = null;
    private static FormasDePagamento formaDePagamento;
    private static Double valorFinal = null;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite o valor total da venda: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntradaValorDaVenda(valorDigitado);
        } while (valorParcial == null);

        do {
            FormasDePagamento.menuDeOpcoes();
            String valorDigitado = teclado.nextLine();
            validacoesDeEntradaOpcoes(valorDigitado);
        } while (opcao == null);

        teclado.close();
    }

    private static void validacoesDeEntradaValorDaVenda(String valorDigitado) {
        try {
            Double input = Double.parseDouble(valorDigitado);

            if (input <= 0) {
                throw new InputMismatchException();
            }

            valorParcial = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar valor da venda, tente novamente!");
        }
    }

    private static void validacoesDeEntradaOpcoes(String valorDigitado) {
        try {
            Integer input = Integer.parseInt(valorDigitado);

            if (input < 1 || input > FormasDePagamento.values().length) {
                throw new InputMismatchException();
            }

            opcao = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar opção de pagamento, tente novamente!");
        }
    }

    private static void processamento() {
        formaDePagamento = FormasDePagamento.values()[opcao - 1];
        Double descontos = valorParcial * formaDePagamento.obterDesconto();
        Double acrescimos = valorParcial * formaDePagamento.obterAcrescimo();
        valorFinal = valorParcial - descontos + acrescimos;
    }

    private static void saida() {
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }
}
