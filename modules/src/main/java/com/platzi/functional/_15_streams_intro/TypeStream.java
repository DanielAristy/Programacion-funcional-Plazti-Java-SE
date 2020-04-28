package com.platzi.functional._15_streams_intro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TypeStream {

    public static void main(String[] args) {

        /**En este caso se instancia una clase en la cual se
         * utiliza para crear una seria de numeros infinitos
         * donde le damos los parametos indicados*/
        IntStream infiniteStream = IntStream.iterate(1, x -> x + 1);

        /**Hasta donde queremos que llegue el stream
         * y retornar los numeros pares*/
        List<Integer> numberList = infiniteStream.limit(100)
                .parallel()/**Si no es necesarios el orden de los datos mas eficiente   */
                .filter( x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());/**Almacenarlos a un List*/

        numberList.forEach(System.out::println);

        Stream<Integer> unoAlDiezStream = Stream
                .iterate( 0, i -> i + 1)
                .limit(10);

        int resultado = unoAlDiezStream.reduce(0, Integer::sum);
    }
}
