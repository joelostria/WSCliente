
package formularios;

import static formularios.Boleta.tabla6;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.nio.Buffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import metodos.Conexion;
import metodos.Crud;
import metodos.GenerarPdf;


public class Productos extends javax.swing.JInternalFrame {
    String idpro, sto ,cod, nom, cate, cos, ven, uti, usu;
    String [] titulos={"Id articulo", "Codigo", "Nombre", "Stock", "Costo", "Venta", "Categoria"};
    DefaultTableModel model;
    
    
    private Crud crudp;
    DefaultTableModel modelo = new DefaultTableModel();
    int band = 0;
    
    public Productos() throws SQLException {
        initComponents();
        usu = Menu.getUsuario();
        model=new DefaultTableModel(null,titulos);
        jTableProductos.setModel(model); 
        TablaProductos();
        jtidarticulo.setEditable(false);
        jtutilidad.setEditable(false);
        cargar("");
        crudp = new Crud();
       /* tabla2.setModel(modelo);
        modelo.addColumn("Id articulo");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        modelo.addColumn("Costo");
        modelo.addColumn("Venta");
        modelo.addColumn("Utilidad");
        modelo.addColumn("Categoria"); */
       
        ArrayList<String> lista = new ArrayList<String>();
        lista = crudp.llenarCombo();
        for(int i=0; i<lista.size(); i++){
            jccategoria.addItem(lista.get(i)); 
        }
        
        /*Scanner buffer=new Scanner(System.in);
        String hola;
        hola=buffer.nextLine();
        jtcodigo.setText("hola");*/
        if(!"administrador".equals(usu)){
            for(int i=0;i<jPanel2.getComponents().length;i++) {
                jPanel2.getComponent(i).setEnabled(false);
            }
            jPanel1.getComponent(1).setEnabled(false);
            jPanel1.getComponent(2).setEnabled(false);
        }
        
    }
    
    public void TablaProductos(){
        Conexion cc= new Conexion();
        Connection cn= cc.getConexcionMYSQL();
        String [] registros= new String[8];
        try {
            String cons="SELECT * FROM articulo WHERE stock<=5";
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                registros[1]=rs.getString(2);
                registros[2]=rs.getString(3);
                registros[3]=rs.getString(4);
                registros[4]=rs.getString(5);
                registros[5]=rs.getString(6);
                registros[6]=rs.getString(8);
                model.addRow(registros);
            }
        } catch (Exception e) {
        }
    }
    
    private void limpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i-=1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jbmodificar = new javax.swing.JButton();
        jbeliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtidarticulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtcodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtnombrepro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtstock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtprecost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtpreven = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtutilidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jccategoria = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnReporte = new javax.swing.JButton();

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel9.setText("Utilidad");

        setClosable(true);
        setIconifiable(true);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(700, 565));
        setRequestFocusEnabled(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla2);

        jbmodificar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jbmodificar.setText("Modificar");
        jbmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbmodificarActionPerformed(evt);
            }
        });

        jbeliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jbeliminar.setText("Eliminar");
        jbeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbeliminarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel11.setText("Buscar");

        jtbuscar.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbuscarActionPerformed(evt);
            }
        });
        jtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtbuscarKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbuscarKeyReleased(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnbuscar.setText("Mostrar todo");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        jLabel12.setText("Ingrese el nombre o la categoria.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jbmodificar))
                            .addComponent(jbeliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbuscar))
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbmodificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbeliminar)))
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Buscar", jPanel1);

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel2KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("Datos del articulo");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setText("ID articulo");

        jtidarticulo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel3.setText("Codigo");

        jtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtcodigoActionPerformed(evt);
            }
        });
        jtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtcodigoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");

        jtnombrepro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtnombreproKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel5.setText("Stock");

        jtstock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtstockKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel6.setText("Precio costo");

        jtprecost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtprecostActionPerformed(evt);
            }
        });
        jtprecost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtprecostKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtprecostKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel7.setText("Precio venta");

        jtpreven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtprevenActionPerformed(evt);
            }
        });
        jtpreven.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtprevenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtprevenKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel8.setText("Utilidad");

        jtutilidad.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel10.setText("Categoria");

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtidarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtnombrepro, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(jtstock)
                                    .addComponent(jtcodigo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtprecost, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar)))
                        .addContainerGap(523, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtpreven, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jccategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtidarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtnombrepro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtprecost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtpreven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jccategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Nuevo / modificar", jPanel2);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableProductos);

        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnReporte)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos a agotar", jPanel3);

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

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
            //Recuperamos los valores de los jtextfield
          String codi="";
          String nomb="";
          int sto=0;
          float cost=0;
          float vent=0;
          float uti=0;
          String cat="";
                  
        try {
            codi= jtcodigo.getText();
            nomb = jtnombrepro.getText();
            sto = Integer.parseInt(jtstock.getText());
            cost = Float.parseFloat(jtprecost.getText());
            vent= Float.parseFloat(jtpreven.getText());
            uti= Float.parseFloat(jtutilidad.getText());
            cat= (String)jccategoria.getSelectedItem();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falta llenar algunos datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
            
             //Si un jtextfield esta vacio mandar error
            if(codi.trim().length()== 0 && nomb.trim().length()== 0){
                //JOptionPane.showMessageDialog(this, "Falta llenar algunos datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        if(band == 1){
            int idart = Integer.parseInt(jtidarticulo.getText());
            if(crudp.update(idart,codi,nomb,sto,cost,vent,uti,cat)){
                JOptionPane.showMessageDialog(this, "Articulo modificado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                jtidarticulo.setText("");
                jtcodigo.setText("");
                jtnombrepro.setText("");
                jtstock.setText("");
                jtprecost.setText("");
                jtpreven.setText("");
                jtutilidad.setText("");
                jccategoria.setSelectedItem(0);
                band = 0;
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al registrar los datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
           

             if(crudp.insert(codi,nomb,sto,cost,vent,uti,cat)){
                JOptionPane.showMessageDialog(this,"El articulo ha sido registrado con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
               jtidarticulo.setText("");
                jtcodigo.setText("");
                jtnombrepro.setText("");
                jtstock.setText("");
                jtprecost.setText("");
                jtpreven.setText("");
                jtutilidad.setText("");
                 jccategoria.setSelectedItem(0);
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al registrar los datos", "Error", JOptionPane.ERROR_MESSAGE);
             }
            
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void jbmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbmodificarActionPerformed
         int i = tabla2.getSelectedRow();
        if(i==-1) 
        { 
           JOptionPane.showMessageDialog(null,"Seleccione una categoria"); 
        }else{
            idpro = String.valueOf(tabla2.getValueAt(i,0));
            cod =String.valueOf(tabla2.getValueAt(i,1));
            nom = String.valueOf(tabla2.getValueAt(i,2));
            sto = String.valueOf(tabla2.getValueAt(i,3));
            cos = String.valueOf(tabla2.getValueAt(i,4));
            ven = String.valueOf(tabla2.getValueAt(i,5));
            uti = String.valueOf(tabla2.getValueAt(i,6));
            cate = String.valueOf(tabla2.getValueAt(i,7));
            
            jtidarticulo.setText(idpro);
            jtcodigo.setText(cod);
            jtnombrepro.setText(nom);
            jtstock.setText(sto);
            jtprecost.setText(cos);
            jtpreven.setText(ven);
            jtutilidad.setText(uti);
            jccategoria.setSelectedItem(cate);
            
            
            band = 1;
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jbmodificarActionPerformed

    private void jbeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbeliminarActionPerformed
        int i = tabla2.getSelectedRow();
        if(i==-1) 
        { 
           JOptionPane.showMessageDialog(null,"Seleccione una categoria"); 
        }else{
            String idc = String.valueOf(tabla2.getValueAt(i,0));
            int idca = Integer.parseInt(idc);
            if(crudp.delete(idca)){
                JOptionPane.showMessageDialog(this,"El articulo ha sido eliminado con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
                cargar("");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al eliminar el articulo", "Error", JOptionPane.ERROR_MESSAGE);
             }
            
        }
    }//GEN-LAST:event_jbeliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
            jtidarticulo.setText("");
            jtcodigo.setText("");
            jtnombrepro.setText("");
            jtstock.setText("");
            jtprecost.setText("");
            jtpreven.setText("");
            jtutilidad.setText("");
            jccategoria.setSelectedItem("");
        band = 0;
    }//GEN-LAST:event_btncancelarActionPerformed

    private void jtprevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtprevenActionPerformed
        
    }//GEN-LAST:event_jtprevenActionPerformed

    private void jtprevenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprevenKeyReleased
        String preco = jtprecost.getText();
        String preve = jtpreven.getText();
        if(preco.equals("")  == false){
            float pr = Float.parseFloat(preco);
            float pre = Float.parseFloat(preve);
            float resultado = pre - pr;
            jtutilidad.setText(resultado+"");
            
        }
    }//GEN-LAST:event_jtprevenKeyReleased

    private void jtprecostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtprecostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtprecostActionPerformed

    private void jtprecostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprecostKeyReleased
         String preve = jtprecost.getText();
        String preco = jtpreven.getText();
        if(preco.equals("")  == false){
            float pr = Float.parseFloat(preco);
            float pre = Float.parseFloat(preve);
            float resultado = pr - pre;
            jtutilidad.setText(resultado+"");
            
        }
    }//GEN-LAST:event_jtprecostKeyReleased
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
            tabla2.setModel(model);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
    private void jtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbuscarKeyReleased
        cargar(jtbuscar.getText());
    }//GEN-LAST:event_jtbuscarKeyReleased

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        cargar("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtcodigoActionPerformed

    private void jtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtcodigoKeyTyped
          
    }//GEN-LAST:event_jtcodigoKeyTyped

    private void jtnombreproKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtnombreproKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtnombreproKeyTyped

    private void jtstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtstockKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          } 
    }//GEN-LAST:event_jtstockKeyTyped

    private void jtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbuscarKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtbuscarKeyTyped

    private void jtprecostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprecostKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtprecostKeyTyped

    private void jtprevenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprevenKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_jtprevenKeyTyped

    private void jtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbuscarActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jtbuscarActionPerformed

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
     char c=evt.getKeyChar();    
      String h=String.valueOf(c);
      if(c=='a'){
          jtcodigo.setText("123");
      }//
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel2KeyReleased

    private void jPanel2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyTyped
      char c=evt.getKeyChar();     
      String h=String.valueOf(c);
      if(c=='a'){
          jtcodigo.setText("123");
      }//
    }//GEN-LAST:event_jPanel2KeyTyped

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        char c=evt.getKeyChar();     
      String h=String.valueOf(c);
      if(c=='a'){
          jtcodigo.setText("123");
      }//
    }//GEN-LAST:event_jPanel2KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        char c=evt.getKeyChar();     
      String h=String.valueOf(c);
      if(c=='a'){
          jtcodigo.setText("123");
      }// TODO add your handling code here:// TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        String datos="Codigo  Nombre  Stock  Categoria  Cantidad  \n";
        for(int j=0;j<jTableProductos.getRowCount();j++){
            datos+=jTableProductos.getValueAt(j, 1)+"    ";
            datos+=jTableProductos.getValueAt(j, 2)+"    ";
            datos+=jTableProductos.getValueAt(j, 3)+"    ";
            datos+=jTableProductos.getValueAt(j, 6)+"    ";
            datos+="\n";
        }
        try {
            GenerarPdf pdf=new GenerarPdf();
            pdf.generarPDF("Reporte de productos", datos, "0", "reporte.pdf");
            abrirarchivo("reporte.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error generando PDF. Consulte con el administrador de sistema","Mensaje de Error", JOptionPane.ERROR_MESSAGE); 
        }
        
        
    }//GEN-LAST:event_btnReporteActionPerformed
public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (Exception ex) {

            System.out.println(ex);

     }

}                   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JButton jbeliminar;
    private javax.swing.JButton jbmodificar;
    private javax.swing.JComboBox<String> jccategoria;
    private javax.swing.JTextField jtbuscar;
    private javax.swing.JTextField jtcodigo;
    private javax.swing.JTextField jtidarticulo;
    private javax.swing.JTextField jtnombrepro;
    private javax.swing.JTextField jtprecost;
    private javax.swing.JTextField jtpreven;
    private javax.swing.JTextField jtstock;
    private javax.swing.JTextField jtutilidad;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
}
