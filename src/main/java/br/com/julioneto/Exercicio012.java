package br.com.julioneto;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio012
 * Data: 2023-05-21
 *
 * */
public class Exercicio012 {
    private static final int MULTIPLO_BASE = 7;

    public static void main(String[] args) {
        int numero = 0;
        do {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
            numero++;
        } while (numero % MULTIPLO_BASE != 0 || numero / MULTIPLO_BASE < 2);
    }
}
