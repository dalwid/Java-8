package com.github.dalwid.streams;

import java.util.*;
import java.util.stream.Collectors;

public class MainStreams {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,5,8,9,1,4,7,6,6,9,9);
        // JAVA 8: STREAMS

        /* Stream é um fluxo de dados
        1ª
        lista.stream().forEach(e-> System.out.println(e));

        2{ Fomra e o ideal
        lista.forEach(System.out::println);

        lista.stream()
                //.skip(2) // pulas os dois primeiros números da lista
                .limit(3)
                .map(e -> e * 2)
                .skip(2)
                .distinct()
                .forEach(e-> System.out.println(e));
     */

        /* Ótio para agrupar entidades, exemplo lista de clientes e eu posso escolher em agrupar por idades
         * Pode ser usadn em caso onde vc te mclientes que residem no memso endereço
         *
         * Sempre agrupar pelo resultado d oque vc ta pondo no collectors.groupingBy()
         *
        Map<Integer, List<Integer>> collect = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(collect);
        * */

        /*
        * Collectors.joining() básicamente ele é feito pra agrupar Strings
        *
        * Bom pra usar no lugar do String Builder
        *
        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining());
        System.out.println(collect);
         */

        /*
        * Colocando um delimitar caso esteja escrevendo um arquivo csv separado por ;
        *
        *
        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";"));
        System.out.println(collect);
        * */

        // streams = loops implícitos
        // for - while - do ... while = loops explícitos



    }
}
