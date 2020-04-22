package com.platzi.functional._04_functional;

import com.sun.javafx.fxml.expression.UnaryExpression;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * Utilizando clases
 * UnaryOperator
 * -> En el cual recibe un tipo de clase y le agrega cierta caracteristica a este elemento
 * BiFunction
 *  -> el cual recibe tres parametros en los cuales se puede hacer la transformacion
 *
 *  */
public class StringFunctions {

    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola carepitos lindos!"));
        System.out.println(addMark.apply("Bienvenido"));

        BiFunction<Integer, Integer ,Integer> multiplicacion =
                (x, y) -> x * y;

        System.out.println(multiplicacion.apply(5,9));

        BiFunction<String, Integer ,String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Java",10));
    }
}
