/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.views.tab.base;

import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author loda
 */
public class Tab extends javax.swing.JPanel {

    /**
     * Creates new form Tab
     */
    public Tab() {
        initComponents();
    }
    public void addSubTab(String name,JPanel subtab){
        this.contentTab.add(name,subtab);
    }
    public void setFontTab(Font font){
        this.contentTab.setFont(font);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentTab = new javax.swing.JTabbedPane();

        setPreferredSize(new java.awt.Dimension(900, 600));

        contentTab.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTab, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTab, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane contentTab;
    // End of variables declaration//GEN-END:variables
}
