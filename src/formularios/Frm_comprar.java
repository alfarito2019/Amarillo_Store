

package formularios;

import base.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo Moreno
 */
public class Frm_comprar extends javax.swing.JFrame {
    String prd="";
    Connection con = null;
    Statement stmt = null;
    private final String DB="usuario2019";
    private final String URL="jdbc:mysql://db4free.net:3306/"+DB+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER="alfaro2019";
    private final String PASS="Aspireone";
    
    Servicios base = new Servicios();
    
    public Frm_comprar(Map<String,Float> productos) {
        initComponents();
        float total=0;
        float valor;
        DefaultListModel modelo = new DefaultListModel();
        for (String clave:productos.keySet()) {
            modelo.addElement(clave);
            lst_productos.setModel(modelo);
            valor = productos.get(clave);
            total+=valor;
            txt_total.setText(String.valueOf(valor));
            prd = prd+clave+",";
        }
        lst_productos.setModel(modelo);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_confirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmb_metPago = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_productos = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();

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
        jLabel4.setText("Confirmar Compra");

        btn_confirmar.setText("Confirmar Compra");
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar metodo de pago");

        cmb_metPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PSE", "Tarjeta de Credito", "Efectivo", " " }));

        jLabel2.setText("Direccion:");

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        jLabel3.setText("Productos a comprar");

        jScrollPane1.setViewportView(lst_productos);

        jLabel5.setText("Total a pagar");

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmb_metPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_direccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_confirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_volver)
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_metPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btn_confirmar)
                .addGap(113, 113, 113))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_volverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        String metodo,direccion,total,productos;
        
        metodo = cmb_metPago.getSelectedItem().toString();
        direccion = txt_direccion.getText();
        total = txt_total.getText();
        productos = prd;
        String tabla ="compras";
        HashMap<String,String> datos= new HashMap<>();
        datos.put("metodo", metodo);
        datos.put("direccion", direccion);
        datos.put("total", total);
        datos.put("productos", productos);
        
        
        if(base.subirRepetido(tabla, datos)){
            JOptionPane.showMessageDialog(this, "\"Se ha efectuado el pedido, llegará a su casa en 5 dias habiles\"");
            
        }
        /*
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            if(con != null){
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO compras (metodo,direccion,total,productos) VALUES('" + metodo + "','" + direccion + "','" + total + "','" + productos + "')");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(con != null){
                try {
                    con.close();
                    stmt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        int input = JOptionPane.showConfirmDialog(null,"Se ha efectuado el pedido, llegará a su casa en 5 dias habiles", "Listo!", JOptionPane.DEFAULT_OPTION);
        if(input == 0){
            System.exit(0);
        }*/
        
    }//GEN-LAST:event_btn_confirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_metPago;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lst_productos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables

}
