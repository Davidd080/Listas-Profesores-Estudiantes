import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProfesoresEstudiantes {

    ArrayList<String> listaProfesores;
    ArrayList<String> listEstudiantes;
    ArrayList<ArrayList<String>> listaGeneralEstudiantes;

    public ProfesoresEstudiantes(){
        listaProfesores=new ArrayList<>();
        listaGeneralEstudiantes=new ArrayList<>();
    }
    public void iniciar(){
        String menu="// REGISTRO PROFESORES Y ESTUDIANTES //\n\n";
        menu+="1. Registrar Profesores\n";
        menu+="2. Registrar Estudiantes\n";
        menu+="3. Consultar lista Profesores y Estudiantes\n";
        menu+="4. Consultar Profesor por nombre\n";
        menu+="5. Consultar cantidad Estudiantes por Profesor\n";
        menu+="6. Consultar Estudiante\n";
        menu+="7. Salir\n\n";
        int opc;
        do{
            opc=Integer.parseInt(JOptionPane.showInputDialog(menu+"Ingrese una opción:"));
            if(opc>=1&&opc<=7){
                switch (opc){
                    case 1:
                        registrarProfesores();
                        break;
                    case 2:
                        if(listaProfesores.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Primero debe registrar profesores");
                        }else{
                            registrarEstudiantes();
                        }
                        break;
                    case 3:
                        if(listaProfesores.isEmpty()||listaGeneralEstudiantes.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Primero debe registrar profesores y estudiantes");
                        }else{
                            consultarListaProfesoresYEstudiantes();
                        }
                        break;
                    case 4:
                        if(listaProfesores.isEmpty()||listaGeneralEstudiantes.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Primero debe registrar profesores y estudiantes");
                        }else{
                            consultaProfesorPorNombre();
                        }
                        break;
                    case 5:
                        if(listaProfesores.isEmpty()||listaGeneralEstudiantes.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Primero debe registrar profesores y estudiantes");
                        }else{
                            consultaCantidadEstudiantesPorProfesor();
                        }
                        break;
                    case 6:
                        if(listaProfesores.isEmpty()||listaGeneralEstudiantes.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Primero debe registrar profesores y estudiantes");
                        }else{
                            consultarEstudiante();
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Saliendo...");
                        break;
                }
            }
        }while(opc!=7);
    }
    public void registrarProfesores(){
        System.out.println("\n<<<< Registro de Profesores >>>>");
        int cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de profesores"));
        for(int i=0;i<cant;i++){
            String nombreProfesor=JOptionPane.showInputDialog("nombre Profesor "+(i+1));
            while(listaProfesores.contains(nombreProfesor)){
                JOptionPane.showMessageDialog(null,"El profesor ya existe. Ingrese otro nombre");
                nombreProfesor=JOptionPane.showInputDialog(null,"Nombre Profesor "+(i+1));
            }
            listaProfesores.add(nombreProfesor);
        }
        System.out.println("Registro de profesores Exitoso!\n");
    }
    public void registrarEstudiantes(){
        System.out.println("\n<<<< Registro de Estudiantes >>>>");
        for(int i=0;i<listaProfesores.size();i++){
            JOptionPane.showMessageDialog(null,"Ingrese los estudiantes para el profesor "+listaProfesores.get(i));
            listEstudiantes=new ArrayList<>();
            int cant=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for(int j=0;j<cant;j++){
                String nombreEst=JOptionPane.showInputDialog("nombre estudiante "+(j+1));
                while(listEstudiantes.contains(nombreEst)){
                    JOptionPane.showMessageDialog(null,"El estudiante ya existe. Ingrese otro nombre");
                    nombreEst=JOptionPane.showInputDialog(null,"Nombre estudiante "+(j+1));
                }
                listEstudiantes.add(nombreEst);
            }
            listaGeneralEstudiantes.add(listEstudiantes);
        }
        System.out.println("Registro de estudiantes exitoso!\n");
    }
    private void consultarListaProfesoresYEstudiantes() {
        System.out.println("\n<<<< Lista de Profesores y Estudiantes >>>>");
        ArrayList<String> listaTemporal;
        for(int i=0;i<listaGeneralEstudiantes.size();i++){
            listaTemporal=listaGeneralEstudiantes.get(i);
            System.out.println("Profesor: "+listaProfesores.get(i)+" = ");
            System.out.println("[");
            for(int j=0;j<listaTemporal.size();j++){
                System.out.println(listaTemporal.get(j));
                if(j<listaTemporal.size()-1){
                    System.out.println(",");
                }
            }
            System.out.println("]\n");
        }
    }
    private void consultaProfesorPorNombre(){
        System.out.println("\n<<<< Consulta de Profesor >>>>\n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor");
        if(listaProfesores.contains(nombre)){
            int posicion=listaProfesores.indexOf(nombre);
            ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
            System.out.println("Profesor: "+nombre+" = ");
            for(int j=0;j<listaEstudiantesTemporal.size();j++){
                System.out.println(listaEstudiantesTemporal.get(j));
                if(j<listaEstudiantesTemporal.size()-1){
                    System.out.println(",");
                }
            }
            System.out.println("]\n");
        }else{
            System.out.println("No se encuentra del profesor "+nombre+"\n");
        }
    }
    private void consultaCantidadEstudiantesPorProfesor(){
        System.out.println("\n<<<< Consulta cantidad de estudiantes de Profesores >>>>\n");
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber la cantidad de estudiantes asociados");
        if(listaProfesores.contains(nombre)){
            int posicion=listaProfesores.indexOf(nombre);
            ArrayList<String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
            System.out.println("La cantidad de estudiantes asociados al profesor "+nombre+" es "+listaEstudiantesTemporal.size());
        }else{
            System.out.println("No se encuentra el profesor "+nombre+"\n");
        }
    }
    private void consultarEstudiante(){
        System.out.println("\n<<<< Consulta de Estudiante");
        ArrayList<String> listTemporal;
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
        for(int i=0;i<listaGeneralEstudiantes.size();i++){
            listTemporal=listaGeneralEstudiantes.get(i);
            if(listTemporal.contains(nombre)){
                for(int j=0;j<listTemporal.size();j++){
                    if(listTemporal.get(j).equalsIgnoreCase(nombre)){
                        System.out.println("Encuentra el nombre: "+nombre+" pertenece al grupo de "+listaProfesores.get(i));
                    }
                }
            }else{
                System.out.println("No se encuentra el nombre en el grupo de "+listaProfesores.get(i));
            }
        }
    }
}