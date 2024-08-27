package com.mycompany.primerproyecto;

public class POO {

    // Clase interna POOExplicacion
    public class POOExplicacion {
        // Atributos de la clase
        public String nombre;
        public int edad;
        private static String especie = "Humano"; // Atributo estático

        // Constructor
        public POOExplicacion(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        // Métodos
        public void saludar() {
            System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
        }

        private String obtenerDetallesPrivados() {
            return "Nombre: " + nombre + ", Edad: " + edad;
        }

        public static void mostrarEspecie() {
            System.out.println("Especie: " + especie);
        }

        public int obtenerEdad() {
            return edad;
        }

        public void cambiarNombre(String nuevoNombre) {
            this.nombre = nuevoNombre;
        }

        public void cambiarNombre(String primerNombre, String segundoNombre) {
            this.nombre = primerNombre + " " + segundoNombre;
        }

        public void incrementarEdad() {
            this.edad++;
            System.out.println("¡Feliz cumpleaños! Ahora tienes " + edad + " años.");
        }

        public static void cambiarEspecie(String nuevaEspecie) {
            especie = nuevaEspecie;
        }
    }

    // Método principal
    public static void main(String[] args) {
        POO outer = new POO(); // Instancia de la clase externa
        POO.POOExplicacion persona = outer.new POOExplicacion("Juan", 25);

        // Llamar a métodos públicos
        persona.saludar();
        int edad = persona.obtenerEdad();
        System.out.println("Edad obtenida: " + edad);

        persona.cambiarNombre("Carlos");
        persona.saludar();

        persona.cambiarNombre("Carlos", "Santana");
        persona.saludar();

        POOExplicacion.mostrarEspecie();
        POOExplicacion.cambiarEspecie("Cyborg");
        POOExplicacion.mostrarEspecie();

        persona.incrementarEdad();
    }
}

