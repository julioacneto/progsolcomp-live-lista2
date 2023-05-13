package br.com.julioneto;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio018
 * Data: 2023-05-21
 *
 * */
public class Exercicio018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int numeroDigitado = scanner.nextInt();

        if (numeroDigitado < 0)
            throw new InputMismatchException("Número digitado é negativo!");

        BigInteger fatorial = BigInteger.valueOf(1);

        for (int i = numeroDigitado; i > 1; i--) {
            fatorial = fatorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(numeroDigitado + "! = " + fatorial);
    }
}
