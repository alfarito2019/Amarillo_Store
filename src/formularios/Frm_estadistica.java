/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import base.Servicios;
 import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Camilo Moreno
 */
public class Frm_estadistica extends javax.swing.JFrame {

    Connection con = null;
    Statement stmt = null;
    private final String DB = "usuario2019";
    private final String URL = "jdbc:mysql://db4free.net:3306/" + DB + "?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String USER = "alfaro2019";
    private final String PASS = "Aspireone";
    PreparedStatement ps;
    ResultSet rs;
    Map<String, Float> agregados = new HashMap<>();
    String estado;
    Servicios base = new Servicios();
    HashMap<String, Integer> productosMap;
    HashMap<String[], Integer> fechasMap;
    List<Entry<String, Integer>> list;
    String[] partes, prod_fec;

    public static final int ANCHO_GRAFICA = 400;

    public static final int ALTO_GRAFICA = 300;

    private List organizarMap(HashMap map, Boolean bandera) {
        if (bandera) {
            list = new ArrayList<>(map.entrySet());
            list.sort(Entry.comparingByValue());
            return list;
        } else {
            
            list = new ArrayList<>(map.entrySet());
            
            return list;
        }

    }

    private String[] productosList(String completa) {
        completa = completa.replace(" ", "");
        String[] parts;
        parts = completa.split(",");
        return parts;
    }


    public Frm_estadistica() {
        int contador;
        List<Entry<String, Integer>> productosOrg;
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Producto", "Cantidad Comprada"});
        productosMap = new HashMap<>();
        fechasMap = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select* from compras");

            while (rs.next()) {
                java.sql.Date fecha = rs.getDate("Fecha");
                partes = productosList(rs.getString("productos"));
                prod_fec = new String[2];
                for (String parte : partes) {
                    if (productosMap.containsKey(parte)) {
                        contador = productosMap.get(parte);
                        productosMap.put(parte, contador + 1);
                        prod_fec[0] = parte;
                        prod_fec[1] = fecha.toString();
                        fechasMap.put(prod_fec, contador + 1);
                    } else {
                        productosMap.put(parte, 1);
                        prod_fec[0] = parte;
                        prod_fec[1] = fecha.toString();
                        fechasMap.put(prod_fec, 1);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        productosOrg = organizarMap(productosMap,true);
        for (Map.Entry<String, Integer> e : productosOrg) {
            modelo.addRow(new Object[]{e.getKey(), e.getValue().toString()});
        }
        tab_productos.setModel(modelo);
        
        final DefaultCategoryDataset serie1 = new DefaultCategoryDataset();
        List<Entry<String[], Integer>> fechasOrg;
        fechasOrg = organizarMap(fechasMap,false);
        String fecha = null;
        String producto = null;

        int conteo;
        for (Map.Entry<String[], Integer> e : fechasOrg) {
            
            fecha = e.getKey()[0];
            producto = e.getKey()[1];
            conteo = e.getValue();
            serie1.addValue(conteo, fecha, producto);
        }
        

        try {
            final Grafico prueba = new Grafico();
            final JFreeChart grafica = prueba.crearGrafica(serie1);
            ChartPanel chartPanel = new ChartPanel(grafica, false);
            chartPanel.setBounds(2, 2, 445, 320);
            scr_grafico.add(chartPanel);
            chartPanel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        scr_grafico = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(202, 206, 74));

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        tab_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Cantidad de veces pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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

        jPanel2.setBackground(new java.awt.Color(239, 184, 16));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setBackground(new java.awt.Color(239, 184, 16));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estadistica");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel6.setBackground(new java.awt.Color(239, 184, 16));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pedido de productos a traves del tiempo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel6)
                        .addGap(21, 36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scr_grafico)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_volver)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(scr_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addGap(52, 52, 52))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        Frm_panelAdmin panel = new Frm_panelAdmin();
        panel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_volverActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_volver;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane scr_grafico;
    private javax.swing.JTable tab_productos;
    // End of variables declaration//GEN-END:variables

}
