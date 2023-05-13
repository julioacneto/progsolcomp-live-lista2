package br.com.julioneto;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/*
 *
 * Nome do Aluno: Julio Neto
 * RA: 1272314251
 * Nome do Programa: Exercicio005
 * Data: 2023-05-21
 *
 * */
public class Exercicio005 {
    private static char opcao = '?';
    private static String nome = null;
    private static String sobrenome = null;
    private static Integer idade = null;
    private static String naturalidade = null;
    private static Pessoa pessoa;

    public static void main(String[] args) {
        entrada();
        processamento();
        saida();
    }

    private static void entrada() {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.US);

        do {
            System.out.print("Digite seu nome: ");
            String valorDigitado = teclado.nextLine().trim();
            validacoesDeEntradaNome(valorDigitado);
        } while (nome == null);

        do {
            System.out.print("Digite seu sobrenome: ");
            String valorDigitado = teclado.nextLine().trim();
            validacoesDeEntradaSobrenome(valorDigitado);
        } while (sobrenome == null);

        do {
            System.out.print("Digite sua idade: ");
            String valorDigitado = teclado.nextLine();
            validacoesDeEntradaIdade(valorDigitado);
        } while (idade == null);

        do {
            System.out.print("Digite seu local de nascimento: ");
            String valorDigitado = teclado.nextLine().trim();
            validacoesDeEntradaLocalDeNascimento(valorDigitado);
        } while (naturalidade == null);

        do {
            System.out.print("Deseja visualizar dados completos? ");
            String valorDigitado = teclado.nextLine().trim();
            validacoesDeEntradaoOpcao(valorDigitado);
        } while (opcao == '?');

        teclado.close();
    }

    private static void validacoesDeEntradaNome(String valorDigitado) {
        try {
            nome = valorDigitado.length() > 0 ? valorDigitado : null;
        } catch (Exception e) {
            System.out.println("Erro ao digitar nome, tente novamente!");
        }
    }

    private static void validacoesDeEntradaSobrenome(String valorDigitado) {
        try {
            sobrenome = valorDigitado.length() > 0 ? valorDigitado : null;
        } catch (Exception e) {
            System.out.println("Erro ao digitar número, tente novamente!");
        }
    }

    private static void validacoesDeEntradaIdade(String valorDigitado) {
        try {
            Integer input = Integer.parseInt(valorDigitado);
            if (input < 0) {
                throw new InputMismatchException();
            }
            idade = input;
        } catch (Exception e) {
            System.out.println("Erro ao digitar idade, tente novamente!");
        }
    }

    private static void validacoesDeEntradaLocalDeNascimento(String valorDigitado) {
        try {
            naturalidade = valorDigitado.length() > 0 ? valorDigitado : null;
        } catch (Exception e) {
            System.out.println("Erro ao digitar local de nascimento, tente novamente!");
        }
    }

    private static void validacoesDeEntradaoOpcao(String valorDigitado) {
        try {
            char input = valorDigitado.trim().toUpperCase().charAt(0);

            if (valorDigitado.length() != 1 || input != 'S' && input != 'N') {
                throw new InputMismatchException();
            }

            opcao = input;
        } catch (Exception e) {
            System.out.println("Digitação errada. Tente Novamente");
        }
    }

    private static void processamento() {
        pessoa = new Pessoa(nome, sobrenome, idade, naturalidade);
    }

    private static void saida() {
        switch (opcao) {
            case 'S' -> System.out.println(pessoa.apresentacaoCompleta());
            case 'N' -> System.out.println(pessoa.apresentacaoSimples());
        }
    }
}

class Pessoa {
    private final String nome;
    private final String sobrenome;
    private final Integer idade;
    private final String naturalidade;

    public Pessoa(String nome, String sobrenome, Integer idade, String naturalidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.naturalidade = naturalidade;
    }

    public String apresentacaoSimples() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public String apresentacaoCompleta() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", naturalidade='" + naturalidade + '\'' +
                '}';
    }
}
