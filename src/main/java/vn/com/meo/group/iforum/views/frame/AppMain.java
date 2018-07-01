package vn.com.meo.group.iforum.views.frame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import vn.com.meo.group.iforum.apps.webtretho.WebTreTho;
import vn.com.meo.group.iforum.views.tab.base.Tab;
import vn.com.meo.group.iforum.utils.Resources;
import vn.com.meo.group.iforum.views.LoginPanel;
import vn.com.meo.group.iforum.views.tab.base.AllForumTab;
import vn.com.meo.group.iforum.views.tab.general.AccounTab;
import vn.com.meo.group.iforum.views.tab.general.CommentCategoryTab;
import vn.com.meo.group.iforum.views.tab.general.CommentContentTab;
import vn.com.meo.group.iforum.views.tab.general.PostsLinkTab;

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
        Tab webtretho = new Tab();
        webtretho.setFontTab(fontSubTab);
        webtretho.addSubTab("Tài Khoản", new AccounTab());
        webtretho.addSubTab("Link Bài Viết", new PostsLinkTab());
        webtretho.addSubTab("Nội Dung Comment", new CommentContentTab());
        webtretho.addSubTab("Phân Loại Bình Luận", new CommentCategoryTab());
        mainTabbed.addTab("Tông Hợp", new AllForumTab());
        mainTabbed.addTab("webtretho", webtretho);
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

        pnMain.setBackground(new java.awt.Color(153, 153, 255));
        pnMain.setLayout(new java.awt.BorderLayout());
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
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AppMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        final Splash splash = new Splash(Resources.strings.get("IForum"),
//                Resources.images.get("app.png"), Resources.images.get("forum-icon.png"));
//        splash.setVisible(true);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(AppMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new AppMain(splash).setVisible(true);
//            }
//        });
//        
        WebTreTho webTreTho = new WebTreTho();
        webTreTho.register("https://www.webtretho.com/forum/forum/register.php", "ibl4ck", "buiduonga4", "buianhduong96@gmail.com");
        System.out.println("oke");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainTabbed;
    private javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables
}
