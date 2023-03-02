package com.generation.evaluacionjavaobjetos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.generation.evaluacionjavaobjetos.models.Alumno;
import com.generation.evaluacionjavaobjetos.models.Curso;
import com.generation.evaluacionjavaobjetos.models.Materia;
import com.generation.evaluacionjavaobjetos.models.Profesor;

@SpringBootApplication
public class EvaluacionjavaobjetosApplication {


  /*1.- Se debe crear una función que permita al profesor ingresar notas por estudiante y que
luego permita obtener el promedio de cada estudiante.
 */

//  public static void ingresarNotas(){
//   Scanner sc = new Scanner(System.in);
//   System.out.println("====================");
//   System.out.println("= =   Opción 1   = =");
//   System.out.println("====================\n");

//   int cantidadEstudiantes = 0;
//   do{
//     System.out.println("Ingrese la cantidad de estudiantes");
//     cantidadEstudiantes = sc.nextInt();

//     if(cantidadEstudiantes < 1){
//       System.out.println("Error: Debe ingresar una cantidad de estudiantes superior a 0");
//     }
//   }while(cantidadEstudiantes < 1);

//   int notasPorEstudiantes = 0;
//   do{
//     System.out.println("Ingrese la cantidad de notas por estudiante");
//     notasPorEstudiantes = sc.nextInt();
//     if(notasPorEstudiantes < 1){
//       System.out.println("Error: Debe ingresar una cantidad de notas por estudiante superior a 0");
//     }
//   }while(notasPorEstudiantes < 1);

//   //sc.nextLine();//Limpiar el buffer



//   for(int i = 0; i < cantidadEstudiantes; i++){
//     sc.nextLine();//Limpiar el buffer
//     ArrayList<Double> notasAlumno = new ArrayList<Double>();
//     HashMap<String, ArrayList<Double>> notasAlumnos = new HashMap<String, ArrayList<Double>>();
//     HashMap<String, Double> promediosAlumnos = new HashMap<String,Double>();

//     System.out.println("Ingrese el nombre del Alumno/a");
//     String nombreAlumno = sc.nextLine();
//     Double promedioNotaAlumno = 0.0;

//     for(int j = 0; j < notasPorEstudiantes; j++){
//       System.out.println((j+1)+".- Ingrese la nota de "+nombreAlumno+" : ");

//       Double nota = 1.0;
//       do{
//         nota = sc.nextDouble();
//         if(nota < 1 || nota > 7){
//           System.out.println("Error: las notas van de 1 a 7");
//         }
//       }while(nota < 1 || nota > 7);
      
//       notasAlumno.add(nota);
//     }
//     notasAlumnos.put(nombreAlumno, notasAlumno);
//     //promedioNotaAlumno = calcularPromedio(notasAlumno);
//     promediosAlumnos.put(nombreAlumno,calcularPromedio(notasAlumno));

//     System.out.println("El promedio de "+nombreAlumno+" es de : "+promedioNotaAlumno);
//   }


//   //Promedio por cada estudiante
//  }



//calcularPromedio
 public static void notasAlumnosYPromedio( Profesor profesor, Materia materia){
  Scanner sc = new Scanner(System.in);
  System.out.print("Ingrese la cantidad de alumnos: ");
    int cantidadAlumnos = sc.nextInt();

    System.out.print("Ingresa la cantidad de notas por alumno: ");
    int cantidadNotas = sc.nextInt();

    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    for(int i = 0; i < cantidadAlumnos; i++){
      sc.nextLine();//Limpiar el residuo

      Alumno alumno = new Alumno();

      ArrayList<Double> notas = new ArrayList<Double>();

      HashMap<String, ArrayList<Double>> notasAlumno = new HashMap<String, ArrayList<Double>>();

      System.out.print("Ingrese el nombre del alumno: ");
      String nombreAlumno = sc.nextLine();

      System.out.print("Ingrese el apellido del alumno: ");
      String apellidoAlumno = sc.nextLine();

      for(int x = 0; x < cantidadNotas; x++){
        System.out.print("Ingrese la nota del alumno: ");
        Double notaAlumno = sc.nextDouble();

        notas.add(notaAlumno);
      }

      notasAlumno.put(nombreAlumno,notas);

      alumno.setNombre(nombreAlumno);
      alumno.setApellido(apellidoAlumno);
      alumno.setMateria(materia);
      alumno.setNotas(notas);
      alumno.setPromedioGeneral(alumno.calcularPromedio());


      alumnos.add(alumno);
    }

    for(int i = 0; i < alumnos.size(); i++){
      Alumno alumnoActual = alumnos.get(i);
      Materia materiaActual = alumnoActual.getMateria();
      System.out.println("--------------");
      System.out.println("Alumno: "+ alumnoActual.getNombre() + " " + alumnoActual.getApellido());
      System.out.println("Materia: "+materiaActual.getNombre());
      System.out.println("Notas: "+alumnoActual.getNotas());
      System.out.println("Promedio: "+alumnoActual.getPromedioGeneral());
      System.out.println("--------------");
    }
 }

  public static void notaMejorPeorPromedio(){ 
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el numero de notas que quiere ingresar: ");
    int numeroNotas = sc.nextInt();
    ArrayList<Double> notas = new ArrayList<Double>();
    for(int i = 0; i < numeroNotas; i++){
      System.out.print("Ingrese la nota n°"+(i+1)+" : ");
      Double nota = sc.nextDouble();

      notas.add(nota);
    }

    Double notaBaja = Collections.min(notas);
    Double notaAlta = Collections.max(notas);
    Double promedio = 0.0;
    for(int i = 0; i< notas.size();i++){
      promedio += notas.get(i);
    }
    promedio /= notas.size();

    System.out.println("=====================");
    System.out.println("Notas: "+notas);
    System.out.println("Nota más Baja: "+notaBaja);
    System.out.println("Nota más Alta: "+notaAlta);
    System.out.println("Promedio: "+promedio);
    System.out.println("=====================");

  }

  public static void agregarAlumnosACurso(){
    Scanner sc = new Scanner(System.in);
    Curso curso = new Curso();

    System.out.print("Ingrese el curso: ");
    String nombreCurso = sc.nextLine();

    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    int opcion = 0;

    do{
      Alumno alumno = new Alumno();
      System.out.print("Ingrese el nombre del Alumno: ");
      String nombreAlumno = sc.nextLine();

      System.out.print("Ingrese el apellido del Alumno: ");
      String apellidoAlumno = sc.nextLine();

      alumno.setNombre(nombreAlumno);
      alumno.setApellido(apellidoAlumno);

      System.out.println("\nSi desea terminar el proceso, ingrese 0 ");
      System.out.println("Si desea continuar agregando alumnos, presione otro numero\n");
      opcion = sc.nextInt();
    
      alumnos.add(alumno);
      sc.nextLine();
    }while(opcion != 0);

    curso.setNombre(nombreCurso);
    curso.setAlumnos(alumnos);

    System.out.println("================");
    System.out.println("Curso: " + curso.getNombre());
    for(int i = 0; i < curso.alumnos.size(); i++){
      Alumno alumnoActual = curso.alumnos.get(i);
      System.out.println("================");
      System.out.println("Alumno: "+alumnoActual.getNombre()+" "+alumnoActual.getApellido());
      System.out.println("================");
    }

  }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    System.out.println("===============================");
    System.out.println("= = Bienvenido/a Profesor/a = =");
    System.out.println("===============================");

    System.out.print("Ingrese su primer nombre: ");
    String nombreProfesor = sc.nextLine();

    System.out.print("Ingrese su primer apellido: ");
    String apellidoProfesor = sc.nextLine();

    System.out.print("Ingrese su curso: ");
    String curso = sc.nextLine();

    System.out.print("Ingrese la materia que imparte: ");
    String materiaImpartida = sc.nextLine();

    Profesor profesor = new Profesor(nombreProfesor,apellidoProfesor,curso,materiaImpartida);
    Materia materia = new Materia(materiaImpartida, nombreProfesor);
    
    int opcion = 1;
    do{
      do{
        System.out.println("- - - - - Menú - - - - -");
        System.out.println("Ingrese la opción 1 para ingresar notas por estudiante y obtener el promedio");
        System.out.println("Ingrese la opcion 2 para agregar alumnos a un curso y mostrarlos");

        System.out.println("Ingrese la opcion 3 para ingresar notas, obtener la nota más baja, la nota más alta y el promedio");

        System.out.println("Ingrese la opción 0 para salir del programa");
        opcion = sc.nextInt();

        if(opcion == 1){
          System.out.println("\nOpcion 1 Seleccionada\n");
          notasAlumnosYPromedio(profesor, materia);
        }

        if(opcion == 2){
          System.out.println("\nOpcion 2 Seleccionada\n");
          agregarAlumnosACurso();

        }

        if(opcion == 3){
          System.out.println("\nOpcion 3 Seleccionada\n");
          notaMejorPeorPromedio();
        }

        if(opcion < 0 || opcion > 3){
          System.out.println("Error: Debes ingresar una opcion válida");

        }
      }while( opcion >= 1 && opcion <= 3);
      
    }while(opcion != 0);
    
	}

}
