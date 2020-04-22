package com.platzi.functional._04_functional;

import java.util.function.Function;

public class MathFunctions {

    public static void main(String[] args) {

        Function<Integer, Integer> square = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer valor) {
                return valor * valor;
            }
        };

        System.out.println(square.apply(5));

    }
}
