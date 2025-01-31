package vn.com.meo.group.iforum.views.frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import vn.com.meo.group.iforum.controllers.webtretho.WebTreThoController;
import vn.com.meo.group.iforum.views.tab.base.Tab;
import vn.com.meo.group.iforum.utils.Resources;
import vn.com.meo.group.iforum.views.LoginPanel;
import vn.com.meo.group.iforum.views.LoginPanel;
import vn.com.meo.group.iforum.views.frame.Splash;
import vn.com.meo.group.iforum.views.tab.base.AllForumTab;
import vn.com.meo.group.iforum.views.tab.general.AccountTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyCategoryTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyTab;
import vn.com.meo.group.iforum.views.tab.general.EnterCategoryTab;
import vn.com.meo.group.iforum.views.tab.general.PostNewsTab;
import vn.com.meo.group.iforum.views.tab.general.AutoCommentReplyTab;
import vn.com.meo.group.iforum.views.tab.general.AddCategoryTab;

/**
 *
 * @author loda
 */
public class AppMain extends javax.swing.JFrame {

    /**
     * Creates new form AppFrame
     */
    private Splash splash;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;
    private Font fontTab = new Font("Tahoma", Font.BOLD, 16);
    private Font fontSubTab = new Font("Tahoma", Font.PLAIN, 14);
    private Color backGroundColor = new Color(255,255,255);
    private LoginPanel loginPanel;
    public AppMain(Splash splash) {
        this.splash = splash;
        initComponents();
        initDefaultConfig();
        //initTabs();
        mainTabbed.setVisible(false);
        loginPanel = new LoginPanel(this);
        pnMain.add(loginPanel, BorderLayout.CENTER);
        this.splash.setVisible(false);
        loginPanel.setVisible(true);
    }

    private void initDefaultConfig() {
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //center screen
        setLocationRelativeTo(null);

    }

    public void initTabs() {
        mainTabbed.setVisible(true);
        mainTabbed.setFont(fontTab);
        //tab tong hop
        mainTabbed.addTab("Tổng Hợp", new AllForumTab());
        //tab dang tin tong hop
        Tab dangTinTongHop = new Tab();
        dangTinTongHop.setBackground(backGroundColor);
        dangTinTongHop.setFontTab(fontSubTab);
        dangTinTongHop.addSubTab("Đăng Tin", new PostNewsTab());
        dangTinTongHop.addSubTab("Nhập Chuyên Mục", new EnterCategoryTab());
        dangTinTongHop.addSubTab("Thêm Chuyên Mục", new  AddCategoryTab());
        mainTabbed.addTab("Đăng Tin Tổng Hợp", dangTinTongHop);
        //webtretho
        new WebTreThoController(mainTabbed);
        //other web
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        mainTabbed = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(909, 600));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setLayout(new java.awt.BorderLayout());

        mainTabbed.setBackground(new java.awt.Color(255, 255, 255));
        mainTabbed.setMaximumSize(new java.awt.Dimension(900, 600));
        mainTabbed.setMinimumSize(new java.awt.Dimension(900, 600));
        mainTabbed.setPreferredSize(new java.awt.Dimension(900, 600));
        pnMain.add(mainTabbed, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        final Splash splash = new Splash(Resources.strings.get("IForum"),
                Resources.images.get("app.png"), Resources.images.get("forum-icon.png"));
        splash.setVisible(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AppMain(splash).setVisible(true);
            }
        }); 
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainTabbed;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables
}
