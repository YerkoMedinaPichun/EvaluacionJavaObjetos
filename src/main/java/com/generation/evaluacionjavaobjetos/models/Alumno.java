package com.generation.evaluacionjavaobjetos.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno extends Persona{

  // - - - - - Atributos - - - - -

  // public String nombre;
  // public String apellido;
  public String curso;
  
  //public ArrayList<String> materias;
  public Materia materia;
  public ArrayList<Double> notas;
  //public HashMap<String,ArrayList<Double>> notas;
  //public HashMap<String,ArrayList<Double>> promedios;
  public Double promedioGeneral;

  // - - - - - Constructores - - - - -

  public Alumno() {
    super();
  }
  
  public Alumno(String nombre, String apellido, String curso, Materia materia /*ArrayList<String> materias*/,
      ArrayList<Double> notas, /*HashMap<String, ArrayList<Double>> promedios,*/ Double promedioGeneral) {
    super(nombre, apellido);
    this.curso = curso;
    this.materia = materia;
    //this.materias = materias;
    this.notas = notas;
    //this.promedios = promedios;
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

  // public ArrayList<String> getMaterias() {
  //   return materias;
  // }



  // public void setMaterias(ArrayList<String> materias) {
  //   this.materias = materias;
  // }



  public ArrayList<Double> getNotas() {
    return notas;
  }



  public void setNotas(ArrayList<Double> notas) {
    this.notas = notas;
  }



  // public HashMap<String, ArrayList<Double>> getPromedios() {
  //   return promedios;
  // }



  // public void setPromedios(HashMap<String, ArrayList<Double>> promedios) {
  //   this.promedios = promedios;
  // }



  public Double getPromedioGeneral() {
    return promedioGeneral;
  }



  public void setPromedioGeneral(Double promedioGeneral) {
    this.promedioGeneral = promedioGeneral;
  }

  // - - - - - Métodos - - - - -

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

  // @Override
  // public String toString() {
  //   return super.toString() + " Alumno [curso=" + curso + ", materia=" + materia + ", notas=" + notas + ", promedios=" + promedios
  //       + ", promedioGeneral=" + promedioGeneral + "]";
  // }

  // @Override
  // public String toString() {
  //   return super.toString() + " Alumno [curso=" + curso + ", materias=" + materias + ", notas=" + notas + ", promedios=" + promedios
  //       + ", promedioGeneral=" + promedioGeneral + "]";
  // }


  
  
  
}
