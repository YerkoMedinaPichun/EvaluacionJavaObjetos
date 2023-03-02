package com.generation.evaluacionjavaobjetos.models;

public class Profesor extends Persona {
  /*
   * 3.-Acá ocupo extends Persona; para heredar todo de la Clase Persona
   * Además agrego el atributo curso y materiaImpartida
   * Ir a clase Alumno
   */

  public String curso;
  public String materiaImpartida;

  public Profesor() {
    super();
  }

  public Profesor(String nombre, String apellido, String curso, String materiaImpartida) {
    super(nombre, apellido);
    this.curso = curso;
    this.materiaImpartida = materiaImpartida;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getMateriaImpartida() {
    return materiaImpartida;
  }

  public void setMateriaImpartida(String materiaImpartida) {
    this.materiaImpartida = materiaImpartida;
  }



  @Override
  public String toString() {
    return super.toString() + " Profesor [curso=" + curso + ", materiaImpartida=" + materiaImpartida + "]";
  }

    

  
  
}
