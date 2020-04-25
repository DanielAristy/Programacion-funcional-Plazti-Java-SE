package com.platzi.functional._15_streams_intro;

import com.platzi.functional._06_reference_operator.NombresUtils;

import java.util.List;
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
         * ellos lo consume y ya no nos sirve lo interesante aqui
         * es que no tenemos que almacenar los datos sino que con esta
         * clase y este patron nos ayudan a ejecutar ciertos requerimientos
         * o trasnformaciones directamente en el objeto
         *
         * Los Streams tienen dos tipos de operaciones
         * Intermedias -> Genera un nuevo stream
         * Terminales -> Generan un dato final ya que se interactua
         *  directamente con el objeto por ejemplo foreach*/

        Stream<String> emphasisCorses = courseStream.map( course -> course + "!");
        Stream<String> calculoCourse = emphasisCorses.filter( course -> course.contains("Calculo"));

        calculoCourse.forEach(System.out::println);

        System.out.println("");

        /**En este caso es muy parecido a el codigo anterior
         * pero todo funciona en la misma instancia y se
         * usa bajo el patron Chaining o cadena*/
        Stream<String> courseStream2 = courseList.stream();

        courseStream2.map( course -> course + "!!")
                .filter( course -> course.contains("Calculo"))
                .forEach(System.out::println);

        Persona persona = new Persona(1,"Daniel","Aristizabal",
                5484840);
        Persona persona1 = new Persona(2,"Jose","Aristizabal",
                5484840);
        Persona persona2 = new Persona(2,"Joselito","Perez",
                5484840);

        List<Persona> personas = NombresUtils.getList(
             persona, persona1
        );

        Stream<Persona> buscarPersonas = personas.stream();

        getPersons(
                buscarPersonas.filter( person -> person.apellido.contains("Aristizabal"))
                ).forEach(System.out::println);
    }

    static <T> Stream<T> getPersons(Stream<T> stream){
        return stream.peek( data -> data.toString());
    }

    static class Persona {
        private int id;
        private String nombre;
        private String apellido;
        private long telefono;


        public Persona(int id, String nombre, String apellido, long telefono){
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "id=" + id +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", telefono=" + telefono +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public long getTelefono() {
            return telefono;
        }

        public void setTelefono(long telefono) {
            this.telefono = telefono;
        }
    }
}
