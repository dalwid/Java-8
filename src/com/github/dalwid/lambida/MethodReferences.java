package com.github.dalwid.lambida;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        // reference
        List<Integer> list = Arrays.asList(1,2,3,4,5); // method reference
        list.stream()
                .forEach(System.out::println);

        list.stream()
                .forEach((n)-> System.out.println(n)); // sem method reference

        // métodos estáticos
        list.stream()
                .map((n) -> multipliquePorDois(n))
                .forEach((n)-> System.out.println(n));

        list.stream()
                .map(MethodReferences::multipliquePorDois)
                .forEach(System.out::println);

        // construttores
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach((n)-> System.out.println(n));

        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);


        // várias instâncias
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach((n)-> System.out.println(n));

        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);


        // única instãncia
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((b) -> dois.multiply(b))
                .forEach((n)-> System.out.println(n));

        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);


    }

    private static Integer multipliquePorDois(Integer i){
        return i * 2;
    }
}
