/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.Conexion;

/**
 *
 * @author lemux_000
 */
public class ConsultaBol extends javax.swing.JInternalFrame {
    String usua;
    /**
     * Creates new form ConsultaBol
     */
    public ConsultaBol() {
        initComponents();
        usua = Menu.getUsuario();
        cargartodasBoletas();
        fecha.setEnabled(false);
        if(!"administrador".equals(usua)){
           btneliminar.setEnabled(false);
        }
    }

     void cargartodasBoletas(){
        Conexion cc= new Conexion();
        Connection cn= cc.getConexcionMYSQL();
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"Num. Boleta","Precio Total","Fecha"};
        tabla.setColumnIdentifiers(titulos);
        this.tabla7.setModel(tabla);
        String consulta= "SELECT * FROM boleta";
        String []Datos= new String [3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("num_boleta");
                Datos[1]=rs.getString("pre_total");
                Datos[2]=rs.getString("fecha");
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
           
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdb1 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        rdb3 = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        jtnumero = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla7 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnver = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Consulta de boletas");

        buttonGroup1.add(rdb1);
        rdb1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rdb1.setText("Mostrar por Nº:");
        rdb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdb2);
        rdb2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rdb2.setText("Mostrar por fecha");
        rdb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdb3);
        rdb3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rdb3.setText("Mostrar todas");
        rdb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdb3ActionPerformed(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jtnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtnumeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdb3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdb1)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rdb2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdb1)
                            .addComponent(jtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdb2)))
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdb3)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        tabla7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla7);

        btnver.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnver.setText("Ver detalle");
        btnver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnver)
                        .addGap(32, 32, 32)
                        .addComponent(btneliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb1ActionPerformed
       if(rdb1.isSelected()==true){
        jtnumero.setEnabled(true);
        jtnumero.requestFocus();
        fecha.setEnabled(false);
        
    }
    }//GEN-LAST:event_rdb1ActionPerformed

    private void rdb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb2ActionPerformed
        if(rdb2.isSelected()==true)
    {
        fecha.setEnabled(true);
        jtnumero.setEnabled(false);
        jtnumero.setText("");
        
    }
    }//GEN-LAST:event_rdb2ActionPerformed

    private void rdb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdb3ActionPerformed
       if(rdb3.isSelected()==true)
    {
        fecha.setEnabled(false);
        jtnumero.setText("");
        jtnumero.setEnabled(false);
        cargartodasBoletas();
    }
    }//GEN-LAST:event_rdb3ActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        Conexion cc= new Conexion();
        Connection cn= cc.getConexcionMYSQL();
        String consulta="";
    if(rdb1.isSelected()==true){
        String numm = jtnumero.getText();
        if(numm.trim().length()== 0){
            JOptionPane.showMessageDialog(this, "Debe insertar el numero de boleta", "Error", JOptionPane.ERROR_MESSAGE);
            cargartodasBoletas();
        }
        else{
             int num=Integer.parseInt(jtnumero.getText());
             consulta= "SELECT * FROM boleta WHERE num_boleta='"+num+"'";
        }
    }
    if(rdb2.isSelected()==true)
    {
        Date fec = fecha.getDate();
        SimpleDateFormat formatofecha= new SimpleDateFormat("dd/MM/YYYY");
        String fech=""+formatofecha.format(fec);
        consulta= "SELECT * FROM boleta WHERE fecha='"+fech+"'";
    }
    if(rdb3.isSelected()==true)
    {
        consulta= "SELECT * FROM boleta ";
    }
        DefaultTableModel tabla= new DefaultTableModel();
        String []titulos={"Num. Boleta","Precio Total","Fecha"};
        tabla.setColumnIdentifiers(titulos);
        tabla7.setModel(tabla);
        
        String []Datos= new String [3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(consulta);
            while(rs.next())
            {
                Datos[0]=rs.getString("num_boleta");
                Datos[1]=rs.getString("pre_total");
                Datos[2]=rs.getString("fecha");
                
                
                tabla.addRow(Datos);
            }
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverActionPerformed
       Conexion cc= new Conexion();
       Connection cn= cc.getConexcionMYSQL();
       int filasele= tabla7.getSelectedRow();
       if(filasele==-1){
            JOptionPane.showMessageDialog(null, "No Seleciono ninguna fila");
       }else{
           DetalleBol detalle = new DetalleBol();
           Menu.escritorio.add(detalle);
           detalle.toFront();
           detalle.setVisible(true);
        String numbol=tabla7.getValueAt(filasele, 0).toString();
        String total=tabla7.getValueAt(filasele, 1).toString();
        String fee=tabla7.getValueAt(filasele, 2).toString();
        
        DetalleBol.jtbol.setText(numbol);
        DetalleBol.jttotal.setText(total);
        DetalleBol.jtfecha.setText(fee);
        int nub = Integer.parseInt(numbol);
        
        DefaultTableModel model = (DefaultTableModel) DetalleBol.tabla8.getModel();
        String ver="SELECT * FROM detalleboleta WHERE num_boleta='"+nub+"'";
        String []datos= new String[6]   ;
        try {
                Statement st = cn.createStatement();
                ResultSet rs= st.executeQuery(ver);
                while(rs.next())
                {
                    datos[0]=rs.getString("num_boleta");
                    datos[1]=rs.getString("id_articulo");
                    datos[2]=rs.getString("categoria");
                    datos[3]=rs.getString("cantidad");
                    datos[4]=rs.getString("costo");
                    datos[5]=rs.getString("venta");
                    model.addRow(datos);
                    
                }
                DetalleBol.tabla8.setModel(model);
            } catch (SQLException ex) {
                
            }
    }
    }//GEN-LAST:event_btnverActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Conexion cc= new Conexion();
       Connection cn= cc.getConexcionMYSQL();
        int fila=tabla7.getSelectedRow();
       if(fila>=0){
        int cod=Integer.parseInt(tabla7.getValueAt(fila, 0).toString());
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM boleta WHERE num_boleta='"+cod+"'");
                pst.executeUpdate();
                cargartodasBoletas();
            } catch (SQLException ex) {
          
            }
    }
    else
    {
        JOptionPane.showMessageDialog(this, "Seleccione alguna fila");
    }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jtnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnumeroKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtnumeroKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnver;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtnumero;
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    private javax.swing.JRadioButton rdb3;
    private javax.swing.JTable tabla7;
    // End of variables declaration//GEN-END:variables
}
