package com.generation.evaluacionjavaobjetos.models;

public class Materia {

  public String nombre;
  public String profesor;


  public Materia() {
  }

  public Materia(String nombre, String profesor) {
    this.nombre = nombre;
    this.profesor = profesor;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getProfesor() {
    return profesor;
  }

  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }

  @Override
  public String toString() {
    return "Materia [nombre=" + nombre + ", profesor=" + profesor + "]";
  }

  
  
}
