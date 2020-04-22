package com.platzi.functional._05_sam;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/**
 * Calcular la edad
 * En la funcion addCerros lo que hace es que agrega ceros en el caso
 * de los dias de las semana y los meses menores de 10*/
public class AgeUtils {

    public static void main(String[] args) {

        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" +
                        addCeros.apply(month) + "-" + addCeros.apply(day));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(10, 10, 1992));/**27*/
        System.out.println(addCeros.apply(9));/**Salida 09*/
        System.out.println(parseDate.apply(9,9,1994)); /**Salida 1994-09-09*/
    }

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}