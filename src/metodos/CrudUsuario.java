
package metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CrudUsuario {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public CrudUsuario(){
        try{
            if((con = conexion.getConexcionMYSQL()) == null){
                JOptionPane.showMessageDialog(null, "Error en la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean insert(String nombre, String paterno, String materno, String telefono, String usuario, String clave){
        try{
            String query = "INSERT INTO usuario VALUES(NULL,'"+nombre+"','"+paterno+"','"+materno+"','"+telefono+"','"+usuario+"','"+clave+"');";
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
           e.printStackTrace();
           return false;
        }
    }
    
    //Devuelve resultset con los datos de las categorias
    public ResultSet todos(){
        try{
           String query = "SELECT * FROM usuario";
           rs = st.executeQuery(query);
           return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    //Elimina la categoria
    public boolean delete(int id){
        try{
            String query = "DELETE FROM usuario WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza datos de la categoria
    public boolean update(int id, String nombre, String paterno, String materno, String telefono, String usuario, String clave){
        try{
            String query = "UPDATE usuario SET nombre = '"+nombre+"', paterno = '"+paterno+"', materno = '"+materno+"', telefono = '"+telefono+"', usuario = '"+usuario+"', clave = '"+clave+"' WHERE id = '"+id+"';"; 
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
}
