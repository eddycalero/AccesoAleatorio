/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import Pojos.Estudiante;
import dao.EstudianteController;
import java.io.IOException;

/**
 *
 * @author Eddy
 */
public class Principall {
    
    public static void main(String[] args) throws IOException {
          EstudianteController ec = new EstudianteController();

        Estudiante e1 = new Estudiante();
         e1.setIdEstudiante(2);
         e1.setNombre("Nombre auto EDDITADO 2.1");
         e1.setEdad(15);
         e1.setActivo(true);
         ec.Guardar(e1);
         
         
        //ec.Eliminar(2);

        //Estudiante e2 = ec.EncontrarPorId(5);
         System.out.println(e1.getIdEstudiante());
         System.out.println(e1.getNombre());
         System.out.println(e1.getEdad());
         System.out.println(e1.isActivo());
       for (Estudiante est : ec.EncontrarTodo()) {
            System.out.println(est.getIdEstudiante());
            System.out.println(est.getNombre());
            System.out.println(est.getEdad());
            System.out.println(est.isActivo());
            System.out.println("-------------------------------------------------");
        }
    }
    
}
