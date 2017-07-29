
package metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Crud {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public Crud(){
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
    
    //Inserta articulo
    public boolean insert(String codigo, String nombre, int stock, float costo, float venta, float utilidad, String categoria ){
        try{
            String query = "INSERT INTO articulo VALUES(NULL,'"+codigo+"', '"+nombre+"','"+stock+"','"+costo+"','"+venta+"','"+utilidad+"','"+categoria+"');";
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
           e.printStackTrace();
           return false;
        }
    }
    
   //Devuelve resultset con los datos de los articulos
    public ResultSet todos(){
        try{
           String query = "SELECT * FROM articulo";
           rs = st.executeQuery(query);
           return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    //Elimina el articulo
    public boolean delete(int id_articulo){
        try{
            String query = "DELETE FROM articulo WHERE id_articulo = '"+id_articulo+"'";
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza datos del articulo
    public boolean update(int id_articulo, String codigo, String nombre, int stock, float costo, float venta, float utilidad, String categoria){
        try{
            String query = "UPDATE articulo SET codigo = '"+codigo+"', nombre = '"+nombre+"', stock = '"+stock+"', costo = '"+costo+"', venta = '"+venta+"', utilidad = '"+utilidad+"', categoria = '"+categoria+"' WHERE id_articulo = '"+id_articulo+"';"; 
            st.executeUpdate(query);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    public ArrayList<String> llenarCombo() throws SQLException{
        ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM categoria";
        rs = st.executeQuery(q);   
         
         try {
            while(rs.next()){
                lista.add(rs.getString("categoria"));
            }
        } catch (Exception e) {
            
        }
        
        
        return lista;
        
    }
    
}
