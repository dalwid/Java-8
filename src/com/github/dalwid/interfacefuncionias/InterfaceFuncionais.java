package com.github.dalwid.interfacefuncionias;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

public class InterfaceFuncionais {
    public static void main(String[] args) {

        /*
        * Fornecedor (Supplier)
        * O suplier é sempre uma funçã oque não recebe nada e retorna um valor
        *
        * Consumidor (Sonsumer)
        * O Consumer recebe um valor e não retorna nada
        * */
        Stream.generate(() -> new Random().nextInt()) // Supplier
                .limit(5)
                .forEach((elemento) -> System.out.println(elemento)); // Consumer

        /*
        * Predicate
        * * é um teste, ele recebe uma valor e o compara com algo
        * BiPredicate
        * * É um teste que rece dois valores para comparar cam alguma coisa ou entre eles e retornará um boolean
        *
        * Function
        * * receb um valor e retorna outro
        * BiFunction
        * * receb dois valores apra retornar um valor
        *
        * UnaryOperator
        * * parecido com Function porém só trabalha com o mesmo tipo
        * * recebe um valor e retorna outro do mesmo tipo fornecido
        * BinaryOperator
        * * parecido com BiFunction porém só trabalha com valores do mesmo tipo
        * * recebe dois valor e retorna um do mesmo tipo fornecido
        *
        * */
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .filter(e -> e % 2 == 0)        // Predicate
                .map(e -> e.doubleValue())     //  Funtion
                .reduce((e1, e2) -> e1 + e2)  //   BinaryOperator
                .ifPresent(System.out::println);


    }
}
