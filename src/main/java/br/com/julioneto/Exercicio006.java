package br.com.julioneto;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

enum Conceito {
    OTIMO("Otimo", 85, 100),
    BOM("Bom", 65, 84),
    REGULAR("Regular", 50, 64),
    INSUFICIENTE("Insuficiente", 0, 49);

    private final String CONCEITO;
    private final Integer MIN;
    private final Integer MAX;

    Conceito(String CONCEITO, Integer MIN, Integer MAX) {
        this.CONCEITO = CONCEITO;
        this.MIN = MIN;
        this.MAX = MAX;
    }

    public static Conceito definirConceito(Integer nota) {
        if (Conceito.OTIMO.aderenteAoConceito(nota)) {
            return Conceito.OTIMO;
        } else if (Conceito.BOM.aderenteAoConceito(nota)) {
            return Conceito.BOM;
        } else if (Conceito.REGULAR.aderenteAoConceito(nota)) {
            return Conceito.REGULAR;
        } else {
            return Conceito.INSUFICIENTE;
        }
    }

    public String obterConceito() {
        return CONCEITO;
    }

    private boolean aderenteAoConceito(Integer nota) {
        return nota >= this.MIN && nota <= this.MAX;
    }
}

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio006
 * Data: 2023-05-21
 *
 * */
public class Exercicio006 {
    private static Integer nota = null;
    private static Conceito conceito;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite a nota do aluno: ");
            String valorDigitado = teclado.nextLine().replace(",", ".");
            validacoesDeEntrada(valorDigitado);
        } while (nota == null);

        teclado.close();
    }

    private static void validacoesDeEntrada(String valorDigitado) {
        try {
            Integer input = Integer.parseInt(valorDigitado);

            if (input < 0 || input > 100) {
                throw new InputMismatchException();
            }

            nota = Integer.parseInt(valorDigitado);
        } catch (Exception e) {
            System.out.println("Erro ao digitar nota, tente novamente!");
        }
    }

    private static void processamento() {
        conceito = Conceito.definirConceito(nota);
    }

    private static void saida() {
        System.out.printf("Nota: %d%nConceito: %s%n", nota, conceito.obterConceito());
    }
}
