
package metodos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //Configuracio de los datos de la BD
    private String usuario = "root";
    private String pass= "";
    private String host = "localhost";
    private String bd = "tienda";
    private Connection con = null;
    
   //Metodo que devuelve null si hubo error
   public Connection getConexcionMYSQL(){
     try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         String servidor = "jdbc:mysql://"+host+"/"+bd;
         con = DriverManager.getConnection(servidor, usuario, pass);
         return con;
     }catch(Exception e){
         e.printStackTrace();
         return con;
     } 
   } 
    
    
}
