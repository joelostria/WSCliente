/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.Conexion;

/**
 *
 * @author lemux_000
 */
public class Productos2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Productos2
     */
    public Productos2() {
        initComponents();
        cargar("");
    }
    
    public void cargar(String a){
        Conexion cc= new Conexion();
        Connection cn= cc.getConexcionMYSQL();
        try{
            String [] titulos={"Id articulo","Codigo","Nombre","Stock", "Compra", "Venta", "Utilidad", "Categoria"};
            String [] registros= new String[8];
            DefaultTableModel model=new DefaultTableModel(null,titulos);
            String cons="select * from articulo WHERE CONCAT (nombre,'',categoria) LIKE '%"+a+"%'";
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                registros[1]=rs.getString(2);
                registros[2]=rs.getString(3);
                registros[3]=rs.getString(4);
                registros[4]=rs.getString(5);
                registros[5]=rs.getString(6);
                registros[6]=rs.getString(7);
                registros[7]=rs.getString(8);
                
                model.addRow(registros);      
                }
            tabla5.setModel(model);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    
        String comparar(int cod){
            Conexion cc= new Conexion();
            Connection cn= cc.getConexcionMYSQL();
            String cant="";
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM articulo WHERE id_articulo='"+cod+"'");
                    while(rs.next())
                    {
                        cant=rs.getString(4);
                    }
            
                } catch (SQLException ex) {
                    Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
                }
            return cant;  
        }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtproducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla5 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();
        btnenviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setText("Buscar");

        jtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtproductoKeyReleased(evt);
            }
        });

        tabla5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla5);

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton1.setText("Mostrar todo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnenviar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnenviar.setText("Enviar");
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setText("El stock será modificado hasta concretar la venta.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)
                                .addComponent(jtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnenviar)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnenviar)
                        .addContainerGap(154, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtproductoKeyReleased
        cargar(jtproducto.getText());
    }//GEN-LAST:event_jtproductoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargar("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        try {
            DefaultTableModel tabladet = (DefaultTableModel) Boleta.tabla6.getModel();  //tbdetbol = tabla6 tbprod = tabla5
            String[]  dato = new String[8];
            int  fila = tabla5.getSelectedRow();
            if(fila==-1){
                JOptionPane.showMessageDialog(null, "No ha seleccionado ningun registro");
            }
            else{
                String id=tabla5.getValueAt(fila, 0).toString();
                String codigo=tabla5.getValueAt(fila, 1).toString();
                String nombre=tabla5.getValueAt(fila, 2).toString();
                String venta=tabla5.getValueAt(fila, 5).toString();
                String categoria=tabla5.getValueAt(fila, 7).toString();
                int c=0;
                int j=0;
                String  cant=JOptionPane.showInputDialog("ingrese cantidad");
                if((cant.equals("")) || (cant.equals("0")))
                {
                    JOptionPane.showMessageDialog(this, "Debe ingresar algun valor mayor que 0");
                }
                else
                {
                    int canting=Integer.parseInt(cant);
                    int comp=Integer.parseInt(comparar(Integer.parseInt(id)));
                    if(canting>comp)
                    {
                        JOptionPane.showMessageDialog(this,"Ud. no cuenta con el stock apropiado");
                    }
                    else
                    {
                        for(int i=0;i<Boleta.tabla6.getRowCount();i++){
                            Object com=Boleta.tabla6.getValueAt(i,0);
                            if(id.equals(com)){
                                j=i;
                                Boleta.tabla6.setValueAt(cant, i, 5);
                                c=c+1;
                            }
                            Boleta.calcular();
                            cargar("");
                        }
                        if(c==0){
                            dato[0]=id;
                            dato[1]=codigo;
                            dato[2]=nombre;
                            dato[3]=venta;
                            dato[4]=categoria;
                            dato[5]=cant;
                            double total2=Double.parseDouble(venta)*Double.parseDouble(cant);
                            dato[6]=String.valueOf(total2);

                            tabladet.addRow(dato);
                            Boleta.calcular();
                            Boleta.tabla6.setModel(tabladet); 
                            
                    
                        }
                    }
  
                }   
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnenviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnenviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtproducto;
    public static javax.swing.JTable tabla5;
    // End of variables declaration//GEN-END:variables
}
