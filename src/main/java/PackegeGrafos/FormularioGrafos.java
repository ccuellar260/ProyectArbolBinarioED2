

package PackegeGrafos;

import javax.swing.JOptionPane;


public class FormularioGrafos extends javax.swing.JFrame {
    
    Grafo G;
    public FormularioGrafos() {
        initComponents();
        G= new Grafo();
                
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtoniNSERTAR = new javax.swing.JButton();
        txtEntrada = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        jButtonDFS = new javax.swing.JButton();
        jButtonBFS = new javax.swing.JButton();
        jButtonDistanciaAB = new javax.swing.JButton();
        jButtonCamoinoCorto = new javax.swing.JButton();
        jButtonMostrarMatriz = new javax.swing.JButton();
        txtUbicacionA = new javax.swing.JTextField();
        txtUbicacionB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonMostrarDistancia = new javax.swing.JButton();
        jButton1EsTernario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtoniNSERTAR.setText("INSERTAR");
        jButtoniNSERTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoniNSERTARActionPerformed(evt);
            }
        });

        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        jButtonDFS.setText("DFS");
        jButtonDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDFSActionPerformed(evt);
            }
        });

        jButtonBFS.setText("BFS");

        jButtonDistanciaAB.setText("Mostrar Distancia");
        jButtonDistanciaAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDistanciaABActionPerformed(evt);
            }
        });

        jButtonCamoinoCorto.setText("Camino mas corto");
        jButtonCamoinoCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCamoinoCortoActionPerformed(evt);
            }
        });

        jButtonMostrarMatriz.setText("Mostrar Matriz");
        jButtonMostrarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarMatrizActionPerformed(evt);
            }
        });

        jLabel1.setText("A");

        jLabel2.setText("B");

        jButtonMostrarDistancia.setText("Mostrar Distancia");
        jButtonMostrarDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarDistanciaActionPerformed(evt);
            }
        });

        jButton1EsTernario.setText("EsTernario");
        jButton1EsTernario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1EsTernarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDFS)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBFS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDistanciaAB)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCamoinoCorto)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrarMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonMostrarDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtoniNSERTAR)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUbicacionA, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUbicacionB, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jButton1EsTernario)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtoniNSERTAR)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicacionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUbicacionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1EsTernario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonMostrarMatriz, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonDFS)
                        .addComponent(jButtonBFS)
                        .addComponent(jButtonDistanciaAB)
                        .addComponent(jButtonCamoinoCorto)
                        .addComponent(jButtonMostrarDistancia)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoniNSERTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoniNSERTARActionPerformed
        G.crearVertice("A"); //0
        G.crearVertice("B"); //1
        G.crearVertice("C"); //2
        G.crearVertice("D"); //3
        G.crearVertice("E"); //4
        G.crearVertice("F"); //5
       // G.crearVertice("G"); //6
    //    G.crearVertice("H"); //7
   //     G.crearVertice("I"); //8
       

                
                
        
        
        //insertar distancias 
        
        G.insertarArco(0, 1, 5);
        G.insertarArco(0, 2, 5);
        G.insertarArco(2, 1, 5);
        G.insertarArco(1, 3, 5);
        G.insertarArco(2, 3, 5);
        G.insertarArco(3, 5, 5);
        G.insertarArco(1, 4, 5);
    
        
     
        
        
        
    }//GEN-LAST:event_jButtoniNSERTARActionPerformed

    private void jButtonDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDFSActionPerformed
        G.mostrar(txtSalida);
    }//GEN-LAST:event_jButtonDFSActionPerformed

    private void jButtonDistanciaABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDistanciaABActionPerformed
        G.Mostrardistancia("Santa Cruz", "Cochabamba", txtSalida);
    }//GEN-LAST:event_jButtonDistanciaABActionPerformed

    private void jButtonCamoinoCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCamoinoCortoActionPerformed
        String A = txtUbicacionA.getText();
        String B = txtUbicacionB.getText();
        G.CaminoCorto(A,B,txtSalida);
        
    }//GEN-LAST:event_jButtonCamoinoCortoActionPerformed

    private void jButtonMostrarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarMatrizActionPerformed
         G.mostrar(txtSalida);
    }//GEN-LAST:event_jButtonMostrarMatrizActionPerformed

    private void jButtonMostrarDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarDistanciaActionPerformed
       /* StputDialog("Dijite La Segunda Ubicacion" ); 
        int A = G.NumDepartamento(x);
        int B = G.NumDepartamento(y);       
        txtSalida.setText("Entre "+txtUbicacionA.getText()+" y "+txtUbicacionB.getText()
                +"hay una distancia de "+Integer.toString(G.mostarPeso(A,B))+" kilometros");ring x = JOptionPane.showInputDialog("Dijite La Prinmera Ubicacion" );
        String y = JOptionPane.showInputDialog("Dijite La Segunda Ubicacion" ); 
        int A = G.NumDepartamento(x);
        int B = G.NumDepartamento(y);       
        txtSalida.setText("Entre "+txtUbicacionA.getText()+" y "+txtUbicacionB.getText()
                +"hay una distancia de "+Integer.toString(G.mostarPeso(A,B))+" kilometros"); */
        //+txtUbicacionA.getText()" y "+txtUbicacionB.getText()+"hay una distancia de "+Integer.toString(G.getArco(A,B))+" kilometros"))
        
        G.mostarPeso(0, 4, txtSalida);
        
    }//GEN-LAST:event_jButtonMostrarDistanciaActionPerformed

    private void jButton1EsTernarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1EsTernarioActionPerformed
        if(G.EsTernario("A")){
            txtSalida.setText("Es ternario");
        }else  txtSalida.setText("No es ternario");
    }//GEN-LAST:event_jButton1EsTernarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioGrafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioGrafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioGrafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioGrafos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioGrafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1EsTernario;
    private javax.swing.JButton jButtonBFS;
    private javax.swing.JButton jButtonCamoinoCorto;
    private javax.swing.JButton jButtonDFS;
    private javax.swing.JButton jButtonDistanciaAB;
    private javax.swing.JButton jButtonMostrarDistancia;
    private javax.swing.JButton jButtonMostrarMatriz;
    private javax.swing.JButton jButtoniNSERTAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtSalida;
    private javax.swing.JTextField txtUbicacionA;
    private javax.swing.JTextField txtUbicacionB;
    // End of variables declaration//GEN-END:variables
}
