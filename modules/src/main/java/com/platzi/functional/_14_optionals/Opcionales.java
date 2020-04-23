package com.platzi.functional._14_optionals;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Opcionales {

    public static void main(String[] args) {

        List<String> names = getNames();
        if (names != null){
            //Operar con nombres.
        }

        Optional<List<String>> optionalNames = getOptionalNames();

        if (optionalNames.isPresent()){

        }

        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> valuablePlayer = optionalValuablePlayer();

        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No Player");
    }

    /**Optional
     * Obtener un dato del cual no tenemos certeza cual es el valor
     * si esta o no esta presente
     * Poder accedeer a ese dato mediante operadores consumer suplyer
     * Presencia o ausencia de un dato*/
    static List<String> getNames(){

        List<String> list = new LinkedList<>();
        return list;
    }

    static String mostValuablePlayer(){
        return null;
    }

    static  int mostExpensiveItem(){
        return -1;
    }

    static Optional<List<String>> getOptionalNames(){

        List<String> nameList = new LinkedList<>();

        //Obtener los nombres con el retorno utilizando Optional
        return Optional.of(nameList);
    }

    static Optional<String> optionalValuablePlayer(){

//        return Optional.ofNullable()

        try {
            return Optional.of("Daniel");
        }catch (Exception e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
