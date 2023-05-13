package br.com.julioneto;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio019
 * Data: 2023-05-21
 *
 * */
public class Exercicio019 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o volume do gás (em cm³): ");
        int volume = teclado.nextInt();
        int segundos = 0;

        if (volume <= 0)
            throw new InputMismatchException("Volume inválido");

        while (volume < 1000) {
            segundos++;
            volume *= 2;
        }

        System.out.printf("Total de %ds", segundos);
    }
}
