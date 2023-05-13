package br.com.julioneto;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio015
 * Data: 2023-05-21
 *
 * */
public class Exercicio015 {
    public static void main(String[] args) {
        int linhas = 10;
        int colunas = 10;
        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.println("Posicao [" + i + "][" + j + "]: " + matriz[i][j]);
            }
        }
    }
}
