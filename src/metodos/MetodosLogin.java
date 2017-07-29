 
package metodos;
import formularios.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MetodosLogin{
    Pool metodospool = new Pool();
    String usuario;
    
    public int validar_ingreso(){
        usuario = Login.txtUsuario.getText().replace(" ", "");
        //System.out.println(usuario.length());
        String clave = String.valueOf(Login.txtClave.getPassword());
        int resultado=0;
        String SQL = "SELECT * FROM usuario WHERE usuario='"+usuario+"' AND clave='"+clave+"' ";
        Connection conect = null;
        try {
            conect = metodospool.dataSource.getConnection();
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            if(rs.next()){
                resultado=1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error de conexio",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conect.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex,"Error de desconexio",JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    
}


