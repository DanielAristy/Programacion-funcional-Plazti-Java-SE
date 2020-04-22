package com.platzi.functional._06_reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("Daniel","Jose","Ricardo", "Jeronimo");

        Consumer<String> pintar = text -> System.out.println(text);
        profesores.forEach(pintar);
        System.out.println("///");
        profesores.forEach(System.out::println);
    }
    public static <T> List<T> getList(T... elementos){
        return Arrays.asList(elementos);
    }
}
