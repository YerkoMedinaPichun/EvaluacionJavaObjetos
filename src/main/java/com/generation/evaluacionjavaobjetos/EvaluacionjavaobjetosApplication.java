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


//calcularPromedio
 public static void notasAlumnosYPromedio( Profesor profesor, Materia materia){
  Scanner sc = new Scanner(System.in);//creo el objeto sc para leer por consola
  int cantidadAlumnos = 0; //inicializo en 0 la cantidad de alumnos
  
  //Agrego un bucle do while para "validar" que la cantidad de alumnos no sea menos de 1 o mayor a 5,
  //lo de mayor a 5 es solo parte del diseño, para no permitir que ingrese un numero muy alto
  do{
    System.out.print("Ingrese la cantidad de alumnos: ");
    cantidadAlumnos = sc.nextInt();//Leo por consola la cantidad de alumnos que me indica
        
        
    if(cantidadAlumnos < 1 || cantidadAlumnos > 5){
      //Muestro el Error en caso de que el numero ingresado sea menor a 1 y mayor a 5
      System.out.println("ERROR: Recuerda que no puedes agregar 0 alumnos o mayores a 5\n");
    }
        
  }while(cantidadAlumnos < 1 || cantidadAlumnos > 5);//Compara, si la cantidad de alumnos es menor a 1 o mayor a 5, entonces le repito las instrucciones



  //Esta validacion es similar a la de arriba, solo que cambia el mensaje por consola y la variable donde se guarda la cantidad de notas
  int cantidadNotas = 0;
  do{
      System.out.print("Ingrese la cantidad de notas por alumno: ");
      cantidadNotas = sc.nextInt();
        
        
      if(cantidadNotas < 1 || cantidadNotas > 5){
        System.out.println("ERROR: Recuerda que no puedes agregar 0 notas o mayores a 5\n");
      }
        
    }while(cantidadNotas < 1 || cantidadNotas > 5);
  

    //Creo un ArrayList de mi objeto Alumno y lo llamo alumnos
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

    for(int i = 0; i < cantidadAlumnos; i++){
      sc.nextLine();//Limpiar el residuo

      Alumno alumno = new Alumno();//Creo un objeto alumno, para pasarlo a mi ArrayList de Alumnos

      ArrayList<Double> notas = new ArrayList<Double>();//creo un ArrayList de notas para ingresar las notas del alumno

      

      System.out.print("Ingrese el nombre del alumno: ");
      String nombreAlumno = sc.nextLine();

      System.out.print("Ingrese el apellido del alumno: ");
      String apellidoAlumno = sc.nextLine();

      for(int x = 0; x < cantidadNotas; x++){

        Double notaAlumno = 1.0;
        //valido que las notas ingresadas sean de 1 a 7
      do{
      
        //ocupo x+1 para mostrar un orden entendible para el usuario, ya que si solo agrego x, sería 0 en primera instancia y se ve feo
        System.out.print((x+1)+".-Ingrese la nota de "+nombreAlumno+" "+apellidoAlumno+": ");
        notaAlumno = sc.nextDouble();

        if(notaAlumno < 1 || notaAlumno > 7){
          //Lo mismo, si me un numero no permitido le muestro este mensaje 
          System.out.println("ERROR: Recuerda que las notas deben ir de 1 a 7");
        }
        //sc.nextLine();//limpiar residuos
      }while(notaAlumno < 1 || notaAlumno > 7);

        //Al final agrego a mi ArrayList de notas, la nota actual del alumno
        notas.add(notaAlumno);
      }

      //Una vez terminado agrego los datos al objeto alumno
    
      alumno.setNombre(nombreAlumno);
      alumno.setApellido(apellidoAlumno);
      alumno.setMateria(materia);
      alumno.setNotas(notas);
      //Acá ocupo el metodo de alumno para calcular su promedio y se lo asigno a su atributo promedioGeneral
      alumno.setPromedioGeneral(alumno.calcularPromedio());


      //Al arrayList de alumnos le agrego el alumno actual y repito las veces necesarias
      alumnos.add(alumno);
    }

    for(int i = 0; i < alumnos.size(); i++){
      //Ocupo un ciclo for para iterar sobre todos los alumnos
      Alumno alumnoActual = alumnos.get(i);//creo un objeto alumnoActual y le agrego los datos del alumno en posicion i
      Materia materiaActual = alumnoActual.getMateria();//creo un objeto llamado materiaActual para extraer el objeto materia que tiene el objeto AlumnoActual

      //Muestro
      System.out.println("--------------");
      System.out.println("Alumno: "+ alumnoActual.getNombre() + " " + alumnoActual.getApellido());
      System.out.println("Materia: "+materiaActual.getNombre());
      System.out.println("Notas: "+alumnoActual.getNotas());
      System.out.println("Promedio: "+alumnoActual.getPromedioGeneral());
      System.out.println("--------------");
    }
 }

  public static void notaMejorPeorPromedio(){ 
    Scanner sc = new Scanner(System.in);//más de lo mismo, para leer por consola
    int numeroNotas = 0;

    do{
      System.out.print("Ingrese el numero de notas que quiere ingresar: ");
      numeroNotas = sc.nextInt();
        
        //válido que las notas que quiera ingresar no sean 0 o inferior ni mayores a 5
        if(numeroNotas < 1 || numeroNotas > 5){
          System.out.println("ERROR: Recuerda que no puedes agregar 0 notas o mayores a 5\n");
        }
        
      }while(numeroNotas < 1 || numeroNotas > 5);

    ArrayList<Double> notas = new ArrayList<Double>();
    for(int i = 0; i < numeroNotas; i++){
      Double nota = 0.0;
      do{
      
        System.out.print("Ingrese la nota n°"+(i+1)+" : ");
        nota = sc.nextDouble();
        //válido que las notas sean de 1 a 7
        if(nota < 1 || nota > 7){
          System.out.println("ERROR: Recuerda que las notas deben ir de 1 a 7");
        }
        //sc.nextLine();//limpiar residuos
      }while(nota < 1 || nota > 7);

      notas.add(nota);
    }

    //ocupo el Objeto Collections.min para poder extraer el numero menor en un ArrayList
    Double notaBaja = Collections.min(notas);

    //ocupo el Objeto Collections.max para poder extraer el numero mayor en un ArrayList
    Double notaAlta = Collections.max(notas);

    Double promedio = 0.0;//Inicio promedio con 0.0
    for(int i = 0; i< notas.size();i++){
      //itero sobre las notas y las sumo
      promedio += notas.get(i);
    }

    //divido las notas sumadas (promedio), y las divido por el largo de notas
    promedio /= notas.size();


    //Muestro
    System.out.println("=====================");
    System.out.println("Notas: "+notas);
    System.out.println("Nota más Baja: "+notaBaja);
    System.out.println("Nota más Alta: "+notaAlta);
    System.out.println("Promedio: "+promedio);
    System.out.println("=====================");

  }

  public static void agregarAlumnosACurso(){
    Scanner sc = new Scanner(System.in);
    Curso curso = new Curso();//Creo un objeto Curso

    //pido el nombre del curso, como IV Medio
    System.out.print("Ingrese el curso: ");
    String nombreCurso = sc.nextLine();
    
    //Creo un ArrayList de alumnos para almacenarlos
    ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    

    int opcion = 0;

    do{
      //Repito tantas veces como sea necesario
      Alumno alumno = new Alumno();
      System.out.print("Ingrese el nombre del Alumno: ");
      String nombreAlumno = sc.nextLine();

      System.out.print("Ingrese el apellido del Alumno: ");
      String apellidoAlumno = sc.nextLine();

      alumno.setNombre(nombreAlumno);
      alumno.setApellido(apellidoAlumno);

      
      //indico que para salirse hay que presionar 0
      System.out.println("\nSi desea terminar el proceso, ingrese 0 ");
      System.out.println("Si desea continuar agregando alumnos, presione otro numero\n");
      opcion = sc.nextInt();
    
      alumnos.add(alumno);
      sc.nextLine();
    }while(opcion != 0);

    //Al objeto curso le agrego el nombre (IV Medio) y agrego el ArrayList de Alumnos
    curso.setNombre(nombreCurso);
    curso.setAlumnos(alumnos);

    //Muestro el nombre del curso
    System.out.println("================");
    System.out.println("Curso: " + curso.getNombre());
    for(int i = 0; i < curso.alumnos.size(); i++){
      //Itero y almaceno los datos actuales del objeto curso de su atributo alumno para mostrarlo de forma ordenada
      Alumno alumnoActual = curso.alumnos.get(i);
      System.out.println("================");
      System.out.println("Alumno: "+alumnoActual.getNombre()+" "+alumnoActual.getApellido());
      System.out.println("================");
    }

  }

  

	public static void main(String[] args) {
    /* 
     * 1.-Primero Creé las clases Persona, Profesor, Alumno, Curso y Materia
     * Ir a clase Persona
    */
		Scanner sc = new Scanner(System.in);//Inicio el objeto scanner para leer por consola
    System.out.println("===============================");
    System.out.println("= = Bienvenido/a Profesor/a = =");
    System.out.println("===============================");
    //Doy la bienvenida, ya que es un profesor quien lo ocupa


    System.out.print("Ingrese su primer nombre: ");
    String nombreProfesor = sc.nextLine();
    

    System.out.print("Ingrese su primer apellido: ");
    String apellidoProfesor = sc.nextLine();

    System.out.print("Ingrese su curso: ");
    String curso = sc.nextLine();

    System.out.print("Ingrese la materia que imparte: ");
    String materiaImpartida = sc.nextLine();

    //Agrego los datos del profesor al objeto profesor y lo mismo para materia
    Profesor profesor = new Profesor(nombreProfesor,apellidoProfesor,curso,materiaImpartida);
    Materia materia = new Materia(materiaImpartida, nombreProfesor);
    
    //Creo una opcion 
    int opcion = 1;
    do{
      do{
        System.out.println("\n- - - - - Menú - - - - -");
        System.out.println("Ingrese la opción 1 para ingresar notas por estudiante y obtener el promedio");
        System.out.println("Ingrese la opcion 2 para agregar alumnos a un curso y mostrarlos");
        System.out.println("Ingrese la opcion 3 para ingresar notas, obtener la nota más baja, la nota más alta y el promedio");
        System.out.println("Ingrese la opción 0 para salir del programa");

        //Leo la opcion por consola
        opcion = sc.nextInt();

        //ocupo un if para comparar que opcion a seleccionado y así ejecutar esa función
        if(opcion == 1){
          System.out.println("\nOpcion 1 Seleccionada\n");
          //Ir a la funcion notasAlumnosYPromedio
          notasAlumnosYPromedio(profesor, materia);
        }else if(opcion == 2){
          System.out.println("\nOpcion 2 Seleccionada\n");
          //Ir a la funcion agregarAlumnosACurso
          agregarAlumnosACurso();

        }else if(opcion == 3){
          System.out.println("\nOpcion 3 Seleccionada\n");
          //Ir a la funcion notaMejorPeorPromedio
          notaMejorPeorPromedio();
        }else if(opcion < 0 || opcion > 3){
          //Indico un error si la opcion no es 0,1,2 o 3
          System.out.println("Error: Debes ingresar una opcion válida");

        }else{
          //Me despido
          System.out.println("Hasta Luego");
        }


      }while( opcion >= 1 && opcion <= 3);
      
    }while(opcion != 0);
    
	}

}
