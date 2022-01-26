
package formularios;
import java.sql.SQLException;

import javax.swing.JFrame;


public class NewMain {

    
    public static void main(String[] args) throws SQLException {

         Frm_InicioSesion marco_inicio = new Frm_InicioSesion();
         marco_inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         marco_inicio.setVisible(true);
           
    }
    
}
