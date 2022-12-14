
package com.mycompany.examen2;
import org.bson.Document;
import javax.swing.table.DefaultTableModel;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Maquinarias extends javax.swing.JFrame {

    MongoCollection<Document> Maquinarias;
    DefaultTableModel modelMaquinarias;

    public Maquinarias() {
        initComponents();
        this.Maquinarias = main.connM.getDB().getCollection("Maquinaria");
        this.modelMaquinarias = new DefaultTableModel();
        this.modelMaquinarias.addColumn("Id");
        this.modelMaquinarias.addColumn("Marca");
        this.modelMaquinarias.addColumn("Modelo");
        this.modelMaquinarias.addColumn("Vida Util"); 
        this.llenarTabla();
        this.tblMaquinarias.getColumnModel().getColumn(0).setMinWidth(0);
        this.tblMaquinarias.getColumnModel().getColumn(0).setMaxWidth(0);
    }

   private void llenarTabla(){
        this.tblMaquinarias.setModel(this.modelMaquinarias);

        MongoCursor<Document> cursor = main.connM.getDocuments(this.Maquinarias).iterator();
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                System.out.println(documento);
                this.agregarRegistrosTabla(documento);
            }
    }

   private void agregarRegistrosTabla(Document fila){
       String id = fila.get("_id").toString();
       String marca = fila.get("Marca").toString();
       String modelo=fila.get("Modelo").toString();
       //String Vida=fila.get("Vida Util").toString();
       this.modelMaquinarias.addRow(new Object[]{id,marca,modelo});
 }

    public void insertarDatos(){
       Document datosObj = new Document("_id",new ObjectId())
            .append("Marca",txtMarca.getText().toString())
            .append("Modelo",txtModelo.getText().toString())
            .append("Vida Util", Integer.parseInt(txtVida.getText()));
 
       if(main.connM.insertDocuments(this.Maquinarias,datosObj)){
           this.limpiarForm();
           this.agregarRegistrosTabla(datosObj);
        }
    }

 

    public void limpiarForm(){
        txtMarca.setText("");
        txtVida.setText("");
        txtModelo.setText("");
        txtMarca.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtVida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaquinarias = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Marca");

        btnInsertar.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Vida Util:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Modelo");

        tblMaquinarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMaquinarias.setGridColor(new java.awt.Color(255, 204, 204));
        tblMaquinarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaquinariasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaquinarias);

        btnActualizar.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Maquinarias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(btnInsertar)
                                .addGap(102, 102, 102)
                                .addComponent(btnActualizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(19, 19, 19)
                        .addComponent(txtVida, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtVida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        this.insertarDatos();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea eliminar el registro seleccionado?", 
                    "Confirmacion de eliminacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(null, (res==JOptionPane.YES_OPTION && this.deleteTableMaquinarias())? "Registro eliminado con exito!":"Registro no pudo ser eliminado!");
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showOptionDialog(new JFrame(), "Esta seguro que desea actualizar el registro seleccionado?", 
                    "Confirmacion de actualizacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Si", "No" }, JOptionPane.YES_OPTION);

        int posicion = this.tblMaquinarias.getSelectedRow();
        if(posicion>=0 && res==JOptionPane.YES_OPTION ){
           int nCol = this.modelMaquinarias.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinarias.getValueAt(posicion, i).toString();
           }

           Document datosObj = new Document("Marca",this.txtMarca.getText())
            .append("Modelo",this.txtModelo.getText())
            .append("Vida Util", Integer.parseInt(this.txtVida.getText()));
           
           JOptionPane.showMessageDialog(null, main.connM.actualizarDocuments(this.Maquinarias,datosObj,dataTabla[0])?"Registro Actualizado con exito":"Registro no pudo ser actualizado");
          
           this.modelMaquinarias.setValueAt(this.txtMarca.getText(), posicion, 1);
           this.modelMaquinarias.setValueAt(this.txtModelo.getText(), posicion, 2);
           this.modelMaquinarias.setValueAt(this.txtVida.getText(), posicion, 3);
           this.limpiarForm();
           this.tblMaquinarias.clearSelection();
      
        }else{
           JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tblMaquinariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaquinariasMouseClicked
        // TODO add your handling code here:
        int posicion = this.tblMaquinarias.getSelectedRow();
        if(posicion>=0){
           int nCol = this.modelMaquinarias.getColumnCount();
           String[] dataTabla = new String[nCol];
           for(int i=0;i<nCol;i++){
            dataTabla[i]=this.modelMaquinarias.getValueAt(posicion, i).toString();
           }

           this.txtMarca.setText(dataTabla[1]);
           this.txtModelo.setText(dataTabla[2]);
           this.txtVida.setText(dataTabla[3]);

        }else{
           JOptionPane.showMessageDialog(null, "Seleccione otro registro de la tabla");
        }
    }//GEN-LAST:event_tblMaquinariasMouseClicked

    private void txtVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVidaActionPerformed
        // TODO add your handling code here:
    }
    
public boolean deleteTableMaquinarias(){
     int posicion = this.tblMaquinarias.getSelectedRow();
     if(posicion>=0){
        String id=this.modelMaquinarias.getValueAt(posicion, 0).toString();     
        this.modelMaquinarias.removeRow(posicion);
        main.connM.deleteDocuments(this.Maquinarias,id);
        return true;
     }else{
        return false;
     }
}
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
            java.util.logging.Logger.getLogger(Maquinarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maquinarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maquinarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maquinarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maquinarias().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaquinarias;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtVida;
    // End of variables declaration//GEN-END:variables
}
