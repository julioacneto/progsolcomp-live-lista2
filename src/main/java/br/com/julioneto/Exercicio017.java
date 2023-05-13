package br.com.julioneto;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio017
 * Data: 2023-05-21
 *
 * */
public class Exercicio017 {
    private static final int MULTIPLO_BASE = 7;

    public static void main(String[] args) {
        int numero = -7;
        do {
            if ((numero * -1) / MULTIPLO_BASE > 1 && (numero * -1) % MULTIPLO_BASE == 0) {
                System.out.println(numero);
            }
            numero--;
        } while (numero > -1000);
    }
}
