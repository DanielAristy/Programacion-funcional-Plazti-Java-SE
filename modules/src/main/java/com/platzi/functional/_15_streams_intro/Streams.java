package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> courseList = new NombresUtils().getList(
                "Compiladores!",
                "Dispositivos Móviles!",
                "Calculo 1!",
                "Backend!");
        /**Lo que normalmente utilizamos para traer los datos de una
         * lista*/
        for (String course: courseList) {

            /**Primero que nada transforma el curso a minuscula, cuando
             *  se encuentre con este signo ! lo reemplaza con !!
             * */
            String newCorseName = course.toLowerCase().replace("!","!!");
            System.out.println("Platzi: " + newCorseName);
        }

        Stream<String> courseStream = Stream.of("Compiladores",
                "Dispositivos Móviles",
                "Calculo 1",
                "Backend");

//        Stream<Integer> courseLengthStream = courseStream.map(course -> course.length());

//        Optional<Integer> longest = courseLengthStream.max( (x, y) -> y -x);


        /**No se pueden ustilizar mas stream en llamados
         * cada vez que se haga un comportamiento con alguno de
         * ellos lo consume y ya no nos sirve*/

        Stream<String> emphasisCorses = courseStream.map( course -> course + "!");
        Stream<String> calculoCourse = emphasisCorses.filter( course -> course.contains("Calculo"));

        calculoCourse.forEach(System.out::println);
    }
}
