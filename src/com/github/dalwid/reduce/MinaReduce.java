package com.github.dalwid.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class MinaReduce {
    public static void main(String[] args) {

        String s = " E aeeeeeee Java e PHP e um pouquinho de Python e também JS!";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // reduce - soma (É Assossiativa)
        Optional<Integer> soma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(soma.get());

        // reduce - multiplicação (É Assossiativa)
        Optional<Integer> multiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(multiplicacao.get());

        // reduce - concatenação (É Assossiativa)
        Optional<String> concatenacao = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2) );
        System.out.println(concatenacao.get());

        // reduce - subtração (Não é Assossiativa) NÃO USAR REDUCE SEM ASSOSSIAÇÃO
        //  ====> NÃO FAÇA ISSO<====
        Optional<Integer> subitracao = list.stream()
                .reduce((n1, n2) -> n1 - n2 );
        System.out.println(subitracao.get());
        // =========================================================================

        List<Integer> listVazia = Arrays.asList();
        // reduce - soma (É Assossiativa)
        Integer soma2 = listVazia.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println("soma dois da lista vazia "+soma2);

        // reduce - multiplicação (É Assossiativa)
        Integer multiplicacao2 = listVazia.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(multiplicacao2);

        // reduce - concatenação (É Assossiativa)
        String concatenacao2 = listStr.stream()
                .reduce("", (s1, s2) -> s1.concat(s2) );
        System.out.println(concatenacao2);

        // reduce - menor valor
        double menorValor = DoubleStream.of(135, 2.9, 6.7)
                .reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor);

        //
        Integer soma3 = list.stream()
                // Primeiro parametro é o de identidade, segundo é o de acomulação, o terceiro é o de combinação
                .reduce(0,(n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println("Com terceiro parametro de combinação: " + soma3);

        // reduce - map + combiner
        Optional<String> reduce1 = list.stream()
                .map(n1 -> n1.toString())
                .reduce((n1, n2) -> n1.concat(n2));
        System.out.println(reduce1);

        // reduce - map + combiner
        // omesmo que o anterior, porém numa linha só
        String reduce2 = list.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );

        System.out.println(reduce2);
        // Reduce é pra trabalhar com dados ou objetos imutavies
    }
}
