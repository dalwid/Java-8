package com.github.dalwid.collect;

import java.util.*;
import java.util.stream.Collectors;

public class MainCollect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        // supplier é igual a  fornecedor - acumulação - combinação
        Set<String> collect = list.stream()
                .collect(
                        () -> new HashSet<>(),
                        (l, e) -> l.add(e.toString()),
                        (l1, l2) -> l1.addAll(l2)
                );
        System.out.println(list);
        System.out.println(collect);

        // toList()
        List<Integer> collect2 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("toList() " + collect2);

        // toSet()
        Set<Integer> collect3 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println("toSet() " + collect3);

        // toSet()
        Deque<Integer> collect4 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        System.out.println("Array deque " + collect4);

        /*
        * Dentro da função joining vc pode por vaios tipos de delimitador
        * joining(";") ou joining("f") ou joining(" ") e etc ...
        *
        * joining agrupa os elementos em uma unica string
        * (internamente ele usa String Builder que é muito mais perfomatico
        *
        * */
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining());
        System.out.println("joining() " +join);

        /* Para conta matemática
        *
                                averaging
        * retorna a média de todos os valores que estão dentro dele (n.intValue() converte apra int)
        * list.stream().collect(Collectors.averagingInt(n -> n.intValue()));
        *
        * */
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println("Média: " + media);

        /*      summing
        *
        * */
        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println("Média: " + soma);


        /*      summarizing
         *
         * */
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println("========= :IntSummaryStatistics: =========");
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());


        /*      counting
         *  ele ver quantos elementos tem no stream
         *  retorna um Long que é a quantidade de elemteos que temos no nosso stream
         * */
        Long count = list.stream()
                .filter((n)-> n % 2 == 0)
                .collect(Collectors.counting());
        System.out.println("counting " + count);


        System.out.println("maxBy/minBy ");
        /*      max/min
         *
         * */
        list.stream()
                .filter((n)-> n % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                        .ifPresent(System.out::println);



        /*      groupingBy
         *  vai agrupar elemesntos de acordo com a expressão lambida passada
         * retorna um mapa
         * */
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(groupingBy);


        /*          partitioningBy
         *  vai entre valores true ou false
         *  retorna um mapa booleano
         * bom para avaliar clientes e separar. exemplo: se tiver 16 anos pode votar se não não pode
         * neste caso vai retornar true ou false
         *
         * */
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 2 == 0));
        System.out.println(partitioningBy);


        /*              toMap
         *  vai entre valores true ou false
         *  retorna chave e valor
         *  primeira chava é o valor a segunda chave é como é o valor
         *  o primiero é pra encontrar a chave do valor e o segundo é de onde ele tirará o valor em si
         *  esta é a sua forma mais simples
         *
         * */
        Map<Integer, Double> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue(), 5)));
        System.out.println("toMap: ");
        System.out.println("O primeiro é a chave e o segundo é o valor : " + toMap);
    }
}
