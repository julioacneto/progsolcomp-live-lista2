package br.com.julioneto;

import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio016
 * Data: 2023-05-21
 *
 * */
public class Exercicio016 {
    public static void main(String[] args) {
        Integer numero = null;
        Scanner teclado = new Scanner(System.in);
        while (numero == null || numero >= 0) {
            System.out.print("Digite um número: ");
            numero = teclado.nextInt();
        }
    }
}
