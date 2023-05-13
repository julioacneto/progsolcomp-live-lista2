package br.com.julioneto;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio013
 * Data: 2023-05-21
 *
 * */
public class Exercicio013 {
    public static void main(String[] args) {
        int soma = 0;
        int contador = 0;

        while (contador <= 100) {
            soma += contador;
            contador++;
        }

        System.out.println(soma);
    }
}
