package com.tcm.mainPanels;

import java.awt.Container;

/**
 *
 * @author saad
 */
public class prStatsPanel extends javax.swing.JPanel {

    /** Creates new form prStatsPanel */
    public prStatsPanel() { 
        initComponents();
    }
    public Container getContentPane() {
         return getRootPane().getContentPane();
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        closePanel = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(348, 510));

        statPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
        statPanel.setPreferredSize(new java.awt.Dimension(348, 510));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        closePanel.setText("Close");
        closePanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closePanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statPanelLayout = new javax.swing.GroupLayout(statPanel);
        statPanel.setLayout(statPanelLayout);
        statPanelLayout.setHorizontalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                .addContainerGap())
        );
        statPanelLayout.setVerticalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closePanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closePanelActionPerformed
        statPanel.setVisible(false);
    }//GEN-LAST:event_closePanelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel statPanel;
    // End of variables declaration//GEN-END:variables
}
