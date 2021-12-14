/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formularios;
import base.Conectate;
import java.sql.SQLException;

import javax.swing.JFrame;

/**
 *
 * @author alfar
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

         Frm_InicioSesion marco_inicio = new Frm_InicioSesion();
         marco_inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         marco_inicio.setVisible(true);
        //Conectate conexion = new Conectate();
        //conexion.openConnection();
        
    }
    
}
