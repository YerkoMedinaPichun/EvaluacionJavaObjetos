package com.generation.evaluacionjavaobjetos.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno extends Persona{

  // - - - - - Atributos - - - - -

  /*
   * 4.-Aquí en la clase Alumno, también heredo de Persona el nombre y apellido
   * Además agregro el atributo curso, ya que el alumno pertenece a un curso, agrego un Objeto de tipo Materia que es otra Clase que he creado y agrego un atributo promedioGeneral
   * 
   * Bajar para ver el método calcularPromedio
   */
  
  public String curso;
  public Materia materia;
  public ArrayList<Double> notas;
  public Double promedioGeneral;

  // - - - - - Constructores - - - - -

  public Alumno() {
    super();
  }
  
  public Alumno(String nombre, String apellido, String curso, Materia materia,
      ArrayList<Double> notas, Double promedioGeneral) {
    super(nombre, apellido);
    this.curso = curso;
    this.materia = materia;
    this.notas = notas;
    this.promedioGeneral = promedioGeneral;
  }

  // - - - - - Getters And Setters - - - - -


  public String getCurso() {
    return curso;
  }



  public void setCurso(String curso) {
    this.curso = curso;
  }


  public Materia getMateria() {
    return materia;
  }



  public void setMateria(Materia materia) {
    this.materia = materia;
  }


  public ArrayList<Double> getNotas() {
    return notas;
  }



  public void setNotas(ArrayList<Double> notas) {
    this.notas = notas;
  }



  public Double getPromedioGeneral() {
    return promedioGeneral;
  }



  public void setPromedioGeneral(Double promedioGeneral) {
    this.promedioGeneral = promedioGeneral;
  }

  // - - - - - Métodos - - - - -
  /*  
   * 5.-Aquí ocupé un Metodo dentro de la Clase alumno, para poder calcular el promedio y agregarlo a la misma instancia del Objeto
   * Ir a clase Materia
   */

  public Double calcularPromedio(){
    Double promedio = 0.0;

    for(int i = 0; i < this.notas.size(); i++){
      promedio += this.notas.get(i);
    }
    promedio /= this.notas.size();

    return promedio;
  }

  // - - - - - toString - - - - -


  @Override
  public String toString() {
    return super.toString() + " Alumno [curso=" + curso + ", materia=" + materia + ", notas=" + notas + ", promedioGeneral=" + promedioGeneral + "]";
  }


  
  
  
}
