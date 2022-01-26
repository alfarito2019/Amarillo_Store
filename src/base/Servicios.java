package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servicios {

    private final String DB = "usuario2019";
    private final String URL = "jdbc:mysql://db4free.net:3306/" + DB + "?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER = "alfaro2019";
    private final String PASS = "Aspireone";
    Connection con = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;

    public void openConnection() throws SQLException {

        Connection connect = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(URL, USER, PASS);

            if (connect != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión Fallida");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error " + ex.getMessage());
        }

    }

    public void closeConnection(Connection connect) {
        try {
            connect.close();
            System.out.println("Conexión Cerrada Exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean existe(String tabla, String llave, String valor) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select* from " + tabla);

            while (rs.next()) {
                if (rs.getString(llave).equals(valor)) {
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean subir(String tabla, HashMap<String, String> columnaCambio, String llave, String valor) {
        Set<String> keys = columnaCambio.keySet();
        String[] myArray = keys.toArray(new String[keys.size()]);

        String llaves = "";
        String valores = "";
        for (int i = 0; i < myArray.length; i++) {
            if (i != myArray.length - 1) {
                llaves += myArray[i] + ", ";
                valores += "'" + columnaCambio.get(myArray[i]) + "', ";
            } else {
                llaves += myArray[i];
                valores += "'" + columnaCambio.get(myArray[i]) + "'";
            }
        }

        if (!existe(tabla, llave, valor)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASS);
                if (con != null) {
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select* from " + tabla);

                    if (rs.next()) {
                        stmt.executeUpdate("INSERT INTO " + tabla + " (" + llaves + ") VALUES(" + valores + ")");
                        return true;
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        stmt.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        return false;
    }

    public boolean subirRepetido(String tabla, HashMap<String, String> columnaCambio) {
        Set<String> keys = columnaCambio.keySet();
        String[] myArray = keys.toArray(new String[keys.size()]);

        String llaves = "";
        String valores = "";
        for (int i = 0; i < myArray.length; i++) {
            if (i != myArray.length - 1) {
                llaves += myArray[i] + ", ";
                valores += "'" + columnaCambio.get(myArray[i]) + "', ";
            } else {
                llaves += myArray[i];
                valores += "'" + columnaCambio.get(myArray[i]) + "'";
            }
        }
        System.out.println("1");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            if (con != null) {
                System.out.println("2");
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select* from " + tabla);

                if (rs.next()) {
                    System.out.println("3");
                    stmt.executeUpdate("INSERT INTO " + tabla + " (" + llaves + ") VALUES(" + valores + ")");
                    return true;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                    stmt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    public boolean eliminar(String tabla, String llave, String valor) {
        String SQL = "DELETE from " + tabla + " WHERE " + llave + "='" + valor + "'";

        int res = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select* from " + tabla);
            stmt.executeUpdate(SQL);
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                    stmt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    public void facturar(String direccion, String tel, String tot, String prod, String user, String num, String extra) {
        File archivo;
        int contador=1;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File("C:\\Users\\alfar\\Downloads\\Factura" + num + "_admin.txt");

        while (archivo.exists()) {
            archivo = new File("C:\\Users\\alfar\\Downloads\\Factura" + num + "_admin("+contador+").txt");
        }
        try {
            archivo.createNewFile();
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            //Escritura en el archivo
            linea.println("Factura numero: " + num);
            linea.println("Amarillo Store agradece por su compra y comunica que los datos de la compra son:");
            linea.println("");
            linea.println("Cliente: " + user);
            linea.println("Direccion: " + direccion);
            linea.println("Telefono: " + tel);
            linea.println("Productos: " + prod);
            linea.println("El valor a pagar es: " + tot);
            linea.println(extra);
            linea.close();
        } catch (IOException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hubo un error");
        }

    }
    public void facturar(String direccion, String tel, String tot, String prod, String num, String extra) {
        File archivo;
        int contador=1;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File("C:\\Users\\alfar\\Downloads\\Factura" + num + "_admin.txt");

        while (archivo.exists()) {
            archivo = new File("C:\\Users\\alfar\\Downloads\\Factura" + num + "_admin("+contador+").txt");
        }
        try {
            archivo.createNewFile();
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            //Escritura en el archivo
            linea.println("Factura numero: " + num);
            linea.println("Amarillo Store agradece por su compra y comunica que los datos de la compra son:");
            linea.println("");
            linea.println("Direccion: " + direccion);
            linea.println("Telefono: " + tel);
            linea.println("Productos: " + prod);
            linea.println("El valor a pagar es: " + tot);
            linea.println(extra);
            linea.close();
        } catch (IOException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hubo un error");
        }

    }

}
