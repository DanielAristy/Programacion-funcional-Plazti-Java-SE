package com.platzi.functional._09_defaults;

public class StringFunctions {

    @FunctionalInterface
    interface StringOperation {
        int getAmount();

        default void operate(String texto){
            int x = getAmount();
            while (x-- > 0){
                System.out.println(texto);
            }
        }
    }
    @FunctionalInterface
    interface DoOperation {
        void take(String text);

        default void execute(int valor, String texto){
            while (valor-- > 0){
                take(texto);
            }
        }
    }

    public static void main(String[] args) {
        StringOperation six = () -> 6;
        six.operate("Alumno");

        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "Platzi");
    }
}
