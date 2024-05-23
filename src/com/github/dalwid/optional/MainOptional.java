package com.github.dalwid.optional;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class MainOptional {
    public static void main(String[] args) {
      // String s = "e aeeee!";
//        String s = "1";
        //Optional<Integer> numero = converteEmNumero(s);
        //System.out.println(numero.isPresent());// verificar se o valor está presente, retorna boolean
        //System.out.println(numero.get());// pegao valor armazenado no Optional, caso ovalaor não existe vc terá erro
        /* numero.ifPresent(n -> System.out.println(n)); // retorna um valor caso exista, se não ele não retorna nada nem excessão
          o memso resultado de outra forma
        converteEmNumero(s).ifPresent(System.out::println);
        */

        /*
          caso a conversã ode error o número 2 sera impresso por padrão
          Integer numero = converteEmNumero(s).orElse(2);
          System.out.println(numero);
       */

        /*
        *  Caso o valor retornado seja null ou vazio vc pode usar isso como o anterior, porém
        * aqui usa-se uma expressão lambida para retornar uma funçõs ou operção pesadas ou uma possível lógica
        *
        Integer numero = converteEmNumero(s)
                .orElseGet(() -> {return operacoPesada()});
        System.out.println(numero);
         */

        /* Lança ua mexcessão
        *
            Integer numero = converteEmNumero(s)
                    .orElseThrow(()-> new NullPointerException("Valor vazio."));
            System.out.println(numero);

         */

        /*
        *  Com Streams
        *  Caso esteja vázio não imprime no console e não tem excessão
        *
            Stream.of()
                    .findFirst()
                    .ifPresent(System.out::println);
         */

        /* Optional com tipos primitivos*/
         //String s = "e aeeee!";
        String s = "1";
        int numero = converteEmNumero(s)
                .orElseThrow(()-> new NullPointerException("Valor vazio."));
        System.out.println(numero);

        /*
        *  Optional foi feito para ser usando como retorno de método
        *  que nem sempre retornará um valor
        * */

    }

    /*public  static Optional<Integer> converteEmNumero(String numeroStr){
        try {
            Integer integer = Integer.Value.of(numeroStr);
            //return Optional.ofNullable(null); // me permite retornar null
            return Optional.of(integer);
        }
        catch(Exception e){
            return Optional.empty();
        }

    }*/

    /*
     *    Optional com tipos primitivos
     * */
    public  static OptionalInt converteEmNumero(String numeroStr){
        try {
            Integer integer = Integer.parseInt(numeroStr);
            return OptionalInt.of(integer);
        }
        catch(Exception e){
            return OptionalInt.empty();
        }

    }
}
