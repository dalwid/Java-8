package com.github.dalwid.lambida;

import java.util.Arrays;
import java.util.List;

public class DebugLambida {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,5,8,9);

        // Em bloco
        list.stream()
                .map((n)-> convertParaStringBuilder(n))
                .forEach(System.out::println);


        // utilizando um methodo apra fazer alg oparecido em cima
        list.stream()
                .map((n)-> convertParaStringBuilder(n))
                .forEach(System.out::println);

        // utilizando peek()
        list.stream()
                .peek(n -> System.out.println(n + " Eu tentado treinar para entender melhor"))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println(n + " Olhando "))
                .map((n)-> convertParaStringBuilder(n))
                .forEach(System.out::println);

    }

    private static StringBuilder convertParaStringBuilder(Integer n){
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");
        return builder;
    }
}
