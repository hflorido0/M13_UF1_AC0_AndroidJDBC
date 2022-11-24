package edu.uoc.androidjdbc.model;

public class Persona {
    private int id;
    private String DNI;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Persona(int id, String DNI, String nombre, String apellidos, String direccion) {
        this.id = id;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
