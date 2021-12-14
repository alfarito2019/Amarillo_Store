
package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Conectate {
    
    private final String DB="usuario2019";
    private final String URL="jdbc:mysql://db4free.net:3306/"+DB+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER="alfaro2019";
    private final String PASS="Aspireone";
    
    public void openConnection() throws SQLException {
        
        Connection connect = null;
        
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect=(Connection) DriverManager.getConnection(URL,USER,PASS);
            
            if(connect!=null){
                System.out.println("Conexión exitosa");            
            }else{
                System.out.println("Conexión Fallida");            
            }
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("error "+ex.getMessage());

            
        }
        
    }    
    
    
    public void closeConnection(Connection connect){
        try {
            connect.close();
            System.out.println("Conexión Cerrada Exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Conectate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
