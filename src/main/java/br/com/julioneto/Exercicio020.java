package br.com.julioneto;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio020
 * Data: 2023-05-21
 *
 * */
public class Exercicio020 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        HashMap<String, Double> pessoas = new HashMap<>();
        Double total = 0.0;

        System.out.print("Digite a quantidade máxima de usuários: ");
        Integer capacidadeMaximaDePessoas = teclado.nextInt();
        if (capacidadeMaximaDePessoas <= 0)
            throw new InputMismatchException("Valores Inválidos para quantidade máxima de pessoas");

        System.out.print("Digite a quantidade máxima de quilos: ");
        Double capacidadeMaximaCarga = teclado.nextDouble();
        if (capacidadeMaximaCarga <= 0.0)
            throw new InputMismatchException("Valores Inválidos para quantidade máxima de carga");

        do {
            System.out.printf("Digite o peso da Pessoa %d: ", pessoas.size() + 1);
            Double peso = teclado.nextDouble();
            if (peso <= 0.0 || peso > capacidadeMaximaCarga - total) {
                System.out.println("Valor de peso inválido ou excede capacidade máxima...");
                continue;
            }

            pessoas.put(("Pessoa " + (pessoas.size() + 1)), peso);

            total = 0.0;
            for (Double p : pessoas.values()) {
                total += p;
            }
        } while (pessoas.size() < capacidadeMaximaDePessoas && total < capacidadeMaximaCarga);
    }
}
