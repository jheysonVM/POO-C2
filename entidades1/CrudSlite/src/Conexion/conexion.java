
package Conexion;

import java.sql.*;




public class conexion {
    public Connection connect(){
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:E:\\DB\\myfirst.db";
            conn = DriverManager.getConnection(url);
            System.out.println(conn);
            System.out.println("Conexion con SQLite ga sido exitosa.");
            
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());   
        }
        return conn;
        
    }
    
}
