package com.github.dalwid.lambida;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MinaLambda {
    public static void main(String[] args) {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Olá mundo!");
//            }
//        }).run();
//
//        new Thread(() -> System.out.println("Olá mundo!")).run();

        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Olá mundo!");
            }
        });

        JButton jButton2 = new JButton();
        jButton2.addActionListener(e -> System.out.println("Olá mundo"));

        List<Integer> asList = Arrays.asList(1,2,3,4);
        asList.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));



    }
}
