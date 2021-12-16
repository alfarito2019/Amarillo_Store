/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Moreno
 */
public class Frm_catalogo extends javax.swing.JFrame {
    Connection con = null;
    Statement stmt = null;
    private final String DB="usuario2019";
    private final String URL="jdbc:mysql://db4free.net:3306/"+DB+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER="alfaro2019";
    private final String PASS="Aspireone";
    PreparedStatement ps;
    ResultSet rs;
    Map <String, Float> agregados = new HashMap <> ();
    private String saltosDeLinea(String descripción) {
        String convertido = "";
        for (int i = 0; i < descripción.length(); i++) {
            Character cha = descripción.charAt(i);
            
            
            if((i%14>9)&&(String.valueOf(cha).equals(" "))){
                
                convertido= convertido+ "<br> ";
            }
            convertido = convertido + cha;
        }
        convertido = "<HTML> " + convertido + " </HTML>";
        
        return convertido;
    }
    
    
    public Frm_catalogo() {
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Nombre","Precio","Descripcion"});
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select* from Productos");
            
            while(rs.next()){
                if(rs.getString("cantidad").equals("0")){
                    continue;
                }
                modelo.addRow(new Object[]{rs.getString("nombre"),rs.getString("precio"),saltosDeLinea(rs.getString("Descripcion"))});
                cmb_producto_carro.addItem(rs.getString("nombre"));
                
            }
            
            tab_productos.setModel(modelo);
            tab_productos.setRowHeight(60);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_productos = new javax.swing.JTable();
        cmb_producto_carro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        spn_cantidad = new javax.swing.JSpinner();
        btn_addCarro = new javax.swing.JButton();
        btn_verCarro = new javax.swing.JButton();

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel4.setText("Catalogo de productos");

        tab_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_productos.setRowHeight(30);
        jScrollPane2.setViewportView(tab_productos);

        cmb_producto_carro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_producto_carroActionPerformed(evt);
            }
        });

        jLabel1.setText("Escoja el producto que desea ");

        jLabel2.setText("añadir al carrito de compras");

        jLabel3.setText("Que cantidad de este producto desea añadir");

        jLabel5.setText("La cantidad disponible de este producto es:");

        txt_cantidad.setEditable(false);

        spn_cantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 3, 1));
        spn_cantidad.setMinimumSize(new java.awt.Dimension(40, 20));
        spn_cantidad.setPreferredSize(new java.awt.Dimension(40, 20));

        btn_addCarro.setText("Añadir");
        btn_addCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addCarroActionPerformed(evt);
            }
        });

        btn_verCarro.setText("Ver Carrito");
        btn_verCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verCarroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_producto_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_addCarro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_verCarro)))))
                .addGap(127, 127, 127))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spn_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_volver)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(cmb_producto_carro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addCarro)
                    .addComponent(btn_verCarro))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_volverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_verCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verCarroActionPerformed
        Frm_carrito carrito = new Frm_carrito(agregados);
        carrito.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_verCarroActionPerformed

    private void cmb_producto_carroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_producto_carroActionPerformed
        String seleccion = cmb_producto_carro.getSelectedItem().toString();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            ps = con.prepareStatement("SELECT * FROM Productos WHERE nombre = ?");
            ps.setString(1, seleccion);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                txt_cantidad.setText(rs.getString("cantidad"));
                if (Integer.parseInt(rs.getString("cantidad")) <= 0) {
                    btn_addCarro.setEnabled(false);
                    int input = JOptionPane.showConfirmDialog(null,"Se ha terminado este producto, escoge otro :)", ":(", JOptionPane.DEFAULT_OPTION);
                }else{
                    btn_addCarro.setEnabled(true);
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cmb_producto_carroActionPerformed

    private void btn_addCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addCarroActionPerformed
        String seleccion = cmb_producto_carro.getSelectedItem().toString();
        Integer cantidad; 
        Integer resultante =0;
        Float precio;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            ps = con.prepareStatement("SELECT * FROM Productos WHERE nombre = ?");
            ps.setString(1, seleccion);
            rs = ps.executeQuery();
            
            if(rs.next()){
                cantidad=Integer.valueOf(spn_cantidad.getValue().toString());
                resultante = Integer.parseInt(rs.getString("cantidad"))-cantidad ;
                if (resultante <= 0) {
                    btn_addCarro.setEnabled(false);
                    int input = JOptionPane.showConfirmDialog(null,"Ufff cogiste los ultimos de ese producto, ya traeran mas.", ":(", JOptionPane.DEFAULT_OPTION);
                }
                precio=Float.valueOf(rs.getString("precio"));
                agregados.put(seleccion, cantidad*precio);
                
                
                
                
            }
            if(con != null){
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE Productos SET cantidad='" + String.valueOf(resultante) + "'WHERE nombre='" + seleccion + "'");
                txt_cantidad.setText(String.valueOf(resultante));
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_addCarroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addCarro;
    private javax.swing.JButton btn_verCarro;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_producto_carro;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spn_cantidad;
    private javax.swing.JTable tab_productos;
    private javax.swing.JTextField txt_cantidad;
    // End of variables declaration//GEN-END:variables

}
