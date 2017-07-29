
package metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CrudCategoria {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public CrudCategoria(){
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
    
    //Inserta una categoria
    public boolean insert(String categoria){
        try{
            String query = "INSERT INTO categoria VALUES(NULL,'"+categoria+"');";
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
           String query = "SELECT * FROM categoria";
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
            String query = "DELETE FROM categoria WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza datos de la categoria
    public boolean update(int id, String categoria){
        try{
            String query = "UPDATE categoria SET categoria = '"+categoria+"' WHERE id = '"+id+"';"; 
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
}
