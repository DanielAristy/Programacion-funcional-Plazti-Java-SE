package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintasis {

    public static void main(String[] args) {

        List<String> cursos = NombresUtils.getList("Java", "Docker");

        cursos.forEach(curso -> System.out.println(curso));

        usarZero(()-> "Hola mundo");
        /**En este caso de este ejemplo el parenteis abierto
         * es que no toma ningun argumento de su unico método
         * declarado en la clase ZeroArgumentos*/

        usarPredicado(text -> text.isEmpty());
        /**En este caso sabemos que los predicados toman
         * un solo dato, y en este caso los predicados
         * necesitan obtener un Boolean*/

        usarBiFuction((x,y) -> x * y);
        /**Segun esta funcion se usa la sintaxis declarada en la funcion
         * usarBiFunction en el cual recibe dos entradas y retorna
         * un valor */

        usarBiFuction( (x, y) -> {
            System.out.println("X: " + x +", Y: "+ y);
            return x -y;
        });

        usarNada( () -> {
            System.out.println("Hola Amigos como estan");
        });
        /**En este caso no tiene un retorno en la funcion
         * por la definicion de ella desde la interface
         * operarNada*/

    }

    static void usarZero(ZeroArgumentos zeroArgumentos){

    }

    static void usarPredicado(Predicate<String> predicate){

    }

    static void usarBiFuction(BiFunction<Integer, Integer, Integer> operacion){

    }
    static void usarNada(OperarNada operarNada){

    }

    @FunctionalInterface
    interface ZeroArgumentos{
//        int get();
        String getString();
    }

    @FunctionalInterface
    interface OperarNada {
        void nada();
    }
}
