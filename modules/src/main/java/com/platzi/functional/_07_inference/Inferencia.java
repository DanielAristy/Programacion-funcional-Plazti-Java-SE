package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inferencia {

    public static void main(String[] args) {

        Function<Integer, String> FuncionConcertidora =
                entero -> "El doble del numero es: "+ (entero *2);

        /**En este caso vamos a utilzar una clase
         * En el package reference_operator
         * NombresUtils
         * -> En el cual vamos a traer un metodo el cual no va a devolver una la lista
         *    de cierto objeto que mandemos por parametro*/

        List<String> alumnos = NombresUtils.getList("Jose","Luis", "Juan David");
        alumnos.forEach(System.out::println);/**Operador de referencia*/
    }
}
