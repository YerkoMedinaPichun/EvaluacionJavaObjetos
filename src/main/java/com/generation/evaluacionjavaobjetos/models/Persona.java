package com.generation.evaluacionjavaobjetos.models;

public class Persona {
  /*
   * 2.-Creo esta clase con los atributos nombre y apellido, porque más adelante los heredaré en la clase Profesor y Alumno, para no repetirlos nuevamente
   * Ir a clase Profesor
   */
  public String nombre;
  public String apellido;

  public Persona() {
  }

  public Persona(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
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

  @Override
  public String toString() {
    return "Persona [nombre=" + nombre + ", apellido=" + apellido + "]";
  }

  
  


}
