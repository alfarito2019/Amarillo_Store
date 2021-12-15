
package formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author alfar
 */
public class Frm_InicioSesion extends javax.swing.JFrame {
    
    Connection con = null;
    Statement stmt = null;
    private final String DB="usuario2019";
    private final String URL="jdbc:mysql://db4free.net:3306/"+DB+"?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER="alfaro2019";
    private final String PASS="Aspireone";
    PreparedStatement ps;
    ResultSet rs;
    
 
    public Frm_InicioSesion() {
        initComponents();
        ImageIcon imagenProducto = new ImageIcon(getClass().getResource("/imagenes/overlay.png"));
        Icon producto1 = new ImageIcon(imagenProducto.getImage().getScaledInstance(lbl_fondo.getWidth(), lbl_fondo.getHeight(), Image.SCALE_DEFAULT));
        lbl_fondo.setIcon(producto1);
        this.repaint();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        cmb_Tipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();
        bot_IniciarSesion = new javax.swing.JButton();
        bot_Registrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(79, 79, 79));
        setForeground(java.awt.Color.darkGray);

        jPanel1.setBackground(new java.awt.Color(239, 184, 16));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio de Sesión");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(79, 79, 79));

        jPanel2.setBackground(new java.awt.Color(202, 206, 74));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tipo de usuario:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 170, -1));

        cmb_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Cliente" }));
        jPanel2.add(cmb_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre de Usuario:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Contraseña:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));
        jPanel2.add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 320));

        bot_IniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bot_IniciarSesion.setText("Entrar");
        bot_IniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_IniciarSesionActionPerformed(evt);
            }
        });

        bot_Registrarse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bot_Registrarse.setText("Registrarse");
        bot_Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bot_RegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(bot_Registrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bot_IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bot_Registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bot_IniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void bot_IniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_IniciarSesionActionPerformed
        String user,pwd,tipo;
        user = txt_usuario.getText();
        pwd = txt_password.getText();
        tipo = cmb_Tipo.getSelectedItem().toString();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASS);
            
            ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
            ps.setString(1, user);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                if((rs.getString("password").equals(pwd))&&(rs.getString("tipo").equals("Administrador"))&&(tipo.equals("Administrador"))){
                    Frm_Productos inicio_admin = new Frm_Productos();
                    inicio_admin.setVisible(true);
                    this.setVisible(false);
                }else if((rs.getString("password").equals(pwd))&&(rs.getString("tipo").equals("Cliente"))&&(tipo.equals("Cliente"))){
                    Frm_catalogo inicio_client = new Frm_catalogo();
                }else{
                    JOptionPane.showMessageDialog(null, "Username o password incorrecta");
                }
            }else{
                JOptionPane.showMessageDialog(null, "nombre de usuario inexistente");
            }
            
            
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_bot_IniciarSesionActionPerformed

    private void bot_RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bot_RegistrarseActionPerformed
        Frm_Registro registro = new Frm_Registro();
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bot_RegistrarseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bot_IniciarSesion;
    private javax.swing.JButton bot_Registrarse;
    private javax.swing.JComboBox<String> cmb_Tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables



}

