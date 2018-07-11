/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.views.tab.general;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author buian
 */
public class AutoCommentReplyTab extends javax.swing.JPanel {

    /**
     * Creates new form PostsLinkTab
     */
    private Cursor cursorForcus = new Cursor(Cursor.HAND_CURSOR);
    private Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    public AutoCommentReplyTab() {
        initComponents();
        pnLinkNews.setVisible(false);
    }

    public JButton getBtnBackPage() {
        return btnBackPage;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnNextPage() {
        return btnNextPage;
    }

    public JButton getBtnRun() {
        return btnRun;
    }

    public JComboBox getCbCommentCategory() {
        return cbCommentCategory;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JTextField getTfLink() {
        return tfLink;
    }

    public JComboBox getCbCommentCount() {
        return cbCommentCount;
    }

    public JCheckBox getCbLinkNews() {
        return cbLinkNews;
    }

    public JComboBox getCbUsers() {
        return cbUsers;
    }

    public JComboBox getCbWebCategory() {
        return cbWebCategory;
    }

    public JLabel getLbCurrentPageUser() {
        return lbCurrentPageUser;
    }

    public JTable getTbJobs() {
        return tbJobs;
    }

    public JTextArea getTfContentPost() {
        return tfContentPost;
    }

    public JTextField getTfHeaderPost() {
        return tfHeaderPost;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbCommentCategory = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbCommentCount = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbUsers = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbJobs = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnNextPage = new javax.swing.JButton();
        lbCurrentPageUser = new javax.swing.JLabel();
        btnBackPage = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        pnPostNews = new javax.swing.JPanel();
        cbWebCategory = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tfHeaderPost = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfContentPost = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbLinkNews = new javax.swing.JCheckBox();
        pnLinkNews = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tfLink = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(830, 500));
        setMinimumSize(new java.awt.Dimension(830, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nội Dung Bình Luận");

        cbCommentCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Số Lượng Bình Luận");

        cbCommentCount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbCommentCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCommentCountActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("User Đăng Bài");

        cbUsers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("Thêm");

        tbJobs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tiêu Đề - Link", "Loại Bình Luận", "Chi Tiết", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbJobs.setGridColor(new java.awt.Color(255, 255, 255));
        tbJobs.setRowHeight(30);
        jScrollPane1.setViewportView(tbJobs);
        if (tbJobs.getColumnModel().getColumnCount() > 0) {
            tbJobs.getColumnModel().getColumn(0).setMinWidth(50);
            tbJobs.getColumnModel().getColumn(0).setMaxWidth(50);
            tbJobs.getColumnModel().getColumn(1).setMinWidth(200);
            tbJobs.getColumnModel().getColumn(1).setMaxWidth(200);
            tbJobs.getColumnModel().getColumn(2).setMinWidth(200);
            tbJobs.getColumnModel().getColumn(2).setMaxWidth(200);
            tbJobs.getColumnModel().getColumn(4).setMinWidth(70);
            tbJobs.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Link_25px.png"))); // NOI18N
        jLabel4.setText("Auto Bình Luận");

        btnNextPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Next_page_25px.png"))); // NOI18N

        lbCurrentPageUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbCurrentPageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCurrentPageUser.setText("1");

        btnBackPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Back_To_25px.png"))); // NOI18N

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Edit_Link_25px.png"))); // NOI18N
        btnEdit.setText("Sửa");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Delete_Link_25px.png"))); // NOI18N
        btnDelete.setText("Xóa");

        btnRun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/meo/group/iforum/resources/images/icons8_Start_25px.png"))); // NOI18N
        btnRun.setText("Chạy");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBackPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCurrentPageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRun)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnRun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCurrentPageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cbCommentCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(10, 10, 10)))
                        .addGap(10, 10, 10)
                        .addComponent(cbCommentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(10, 10, 10)
                        .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCommentCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCommentCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnPostNews.setBackground(new java.awt.Color(255, 255, 255));

        cbWebCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tiêu Đề");

        tfHeaderPost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfHeaderPost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        tfContentPost.setColumns(20);
        tfContentPost.setLineWrap(true);
        tfContentPost.setRows(5);
        tfContentPost.setWrapStyleWord(true);
        jScrollPane2.setViewportView(tfContentPost);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nội Dung");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Chuyên Mục");

        javax.swing.GroupLayout pnPostNewsLayout = new javax.swing.GroupLayout(pnPostNews);
        pnPostNews.setLayout(pnPostNewsLayout);
        pnPostNewsLayout.setHorizontalGroup(
            pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPostNewsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnPostNewsLayout.createSequentialGroup()
                        .addComponent(cbWebCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfHeaderPost, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        pnPostNewsLayout.setVerticalGroup(
            pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPostNewsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbWebCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfHeaderPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnPostNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPostNewsLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );

        cbLinkNews.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbLinkNews.setText("Bài Viết Có Sẵn");
        cbLinkNews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLinkNewsActionPerformed(evt);
            }
        });

        pnLinkNews.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Link Bài Viết");

        tfLink.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfLink.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnLinkNewsLayout = new javax.swing.GroupLayout(pnLinkNews);
        pnLinkNews.setLayout(pnLinkNewsLayout);
        pnLinkNewsLayout.setHorizontalGroup(
            pnLinkNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLinkNewsLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfLink))
        );
        pnLinkNewsLayout.setVerticalGroup(
            pnLinkNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLinkNewsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnLinkNewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnPostNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbLinkNews)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnLinkNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbLinkNews)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnLinkNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPostNews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbCommentCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCommentCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCommentCountActionPerformed

    private void cbLinkNewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLinkNewsActionPerformed
        // TODO add your handling code here:
        if(cbLinkNews.isSelected()){
            pnLinkNews.setVisible(true);
            pnPostNews.setVisible(false);
        }else{
            pnLinkNews.setVisible(false);
            pnPostNews.setVisible(true);
        }
    }//GEN-LAST:event_cbLinkNewsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBackPage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNextPage;
    private javax.swing.JButton btnRun;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbCommentCategory;
    private javax.swing.JComboBox cbCommentCount;
    private javax.swing.JCheckBox cbLinkNews;
    private javax.swing.JComboBox cbUsers;
    private javax.swing.JComboBox cbWebCategory;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCurrentPageUser;
    private javax.swing.JPanel pnLinkNews;
    private javax.swing.JPanel pnPostNews;
    private javax.swing.JTable tbJobs;
    private javax.swing.JTextArea tfContentPost;
    private javax.swing.JTextField tfHeaderPost;
    private javax.swing.JTextField tfLink;
    // End of variables declaration//GEN-END:variables
}
