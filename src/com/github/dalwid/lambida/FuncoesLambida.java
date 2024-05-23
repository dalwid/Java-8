package com.github.dalwid.lambida;

import java.util.stream.IntStream;

public class FuncoesLambida {
    public static void main(String[] args) {

        // parênteses
        // Obrigatório quando eu não tenho nenhum argumento
        // mais de um argumento ou quando desejamos declarar o tipo do argumento
        Runnable runnable = () -> System.out.println(" olá e aeee");

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // chaves
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("Ea aeeee de novo dentro do filter utilize as chaves com return ou não sempre terminaod com ; ao final da expressão da sua lógica");
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
    }
}
