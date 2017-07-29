
package formularios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.Conexion;
import metodos.CrudCategoria;


public class Categorias extends javax.swing.JInternalFrame {

    private CrudCategoria crud;
    DefaultTableModel modelo = new DefaultTableModel();
    int band = 0;
    String cate, idcate, usu;
    public Categorias() {
        initComponents();
        usu = Menu.getUsuario();
        jtidcategoria.setEditable(false);
        crud = new CrudCategoria();
        if(!"administrador".equals(usu)){
            for(int i=0;i<jPanel2.getComponents().length;i++) {
                jPanel2.getComponent(i).setEnabled(false);
            }
            jPanel1.getComponent(1).setEnabled(false);
            jPanel1.getComponent(2).setEnabled(false);
        }
        cargar("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnmodifcar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtidcategoria = new javax.swing.JTextField();
        jtcategoria = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel11.setText("Buscar");

        setClosable(true);
        setIconifiable(true);
        setTitle("Categorias");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla1);

        btnmodifcar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnmodifcar.setText("Modificar");
        btnmodifcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifcarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Buscar");

        jtbuscar.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtbuscarKeyTyped(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnbuscar.setText("Mostrar todo");

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel5.setText("Ingrese el nombre de la categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnmodifcar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbuscar))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmodifcar)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Buscar", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("Datos de la categoria");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("ID categoria");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jtidcategoria.setBackground(new java.awt.Color(204, 204, 204));
        jtidcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtidcategoriaActionPerformed(evt);
            }
        });

        jtcategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtcategoriaKeyTyped(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtidcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nuevo / modificar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtidcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtidcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtidcategoriaActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if(band == 1){
            int idcat = Integer.parseInt(jtidcategoria.getText());
            String cat = jtcategoria.getText();
            
            if(crud.update(idcat,cat)){
                JOptionPane.showMessageDialog(this, "Categoria modificada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                jtidcategoria.setText("");
                jtcategoria.setText("");
                band = 0;
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al registrar los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
             //Recuperamos los valores de los jtextfield
            String categoria = jtcategoria.getText();
        
            //Si un jtextfield esta vacio mandar error
            if(categoria.trim().length()== 0){
                JOptionPane.showMessageDialog(this, "Falta llenar algunos datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

             if(crud.insert(categoria)){
                JOptionPane.showMessageDialog(this,"La categoria ha sido registrada con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
                jtcategoria.setText("");
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al registrar los datos", "Error", JOptionPane.ERROR_MESSAGE);
             }
            
        }
       
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodifcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifcarActionPerformed
        int i = tabla1.getSelectedRow();
        if(i==-1) 
        { 
           JOptionPane.showMessageDialog(null,"Seleccione una categoria"); 
        }else{
            idcate = String.valueOf(tabla1.getValueAt(i,0));
            cate=String.valueOf(tabla1.getValueAt(i,1));
            jtidcategoria.setText(idcate);
            jtcategoria.setText(cate);
            band = 1;
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnmodifcarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        jtidcategoria.setText("");
        jtcategoria.setText("");
        band = 0;
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int i = tabla1.getSelectedRow();
        if(i==-1) 
        { 
           JOptionPane.showMessageDialog(null,"Seleccione una categoria"); 
        }else{
            String idc = String.valueOf(tabla1.getValueAt(i,0));
            int idca = Integer.parseInt(idc);
            if(crud.delete(idca)){
                JOptionPane.showMessageDialog(this,"La categoria ha sido eliminada con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al eliminar la categoria", "Error", JOptionPane.ERROR_MESSAGE);
             }
            
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbuscarKeyReleased
        cargar(jtbuscar.getText());
    }//GEN-LAST:event_jtbuscarKeyReleased

    private void jtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbuscarKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtbuscarKeyTyped

    private void jtcategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtcategoriaKeyTyped
       char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtcategoriaKeyTyped
   
    private void limpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i-=1;
        }
    }
    
    public void cargar(String a){
        Conexion cc= new Conexion();
        Connection cn= cc.getConexcionMYSQL();
        try{
            String [] titulos={"Id categoria","Categoria"};
            String [] registros= new String[2];
            DefaultTableModel model=new DefaultTableModel(null,titulos);
            String cons="select * from categoria WHERE categoria LIKE '%"+a+"%'";
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                registros[1]=rs.getString(2);
                
                model.addRow(registros);      
                }
            tabla1.setModel(model);
            }catch(Exception e){
                System.out.println(e.getMessage());
                 }
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodifcar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jtbuscar;
    private javax.swing.JTextField jtcategoria;
    private javax.swing.JTextField jtidcategoria;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
