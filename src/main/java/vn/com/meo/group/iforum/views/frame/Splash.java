/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.views.frame;

/**
 *
 * @author buian
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * Splash Form Component.
 * 
 * <p>
 * <pre><code>
 *  Splash splash = new Splash(I18n.COMMON.getString("App.Title"), 
 *      ViewHelpers.ICONS16 + "app.png", 
 *      ViewHelpers.IMAGES + "splash.png");
 * </code></pre>
 * </p>
 *
 * @author Cem Ikta
 */
public class Splash extends JFrame {
    private final String title;
    private final Image icon;
    private final Image image;
    /**
     * Create splash form
     * 
     * @param title title of splash form for taskbar
     * @param iconPath icon path for taskbar
     * @param imagePath image path for splash form
     */
    public Splash(String title, Image icon, Image image) {
        this.title = title;
        this.icon = icon;
        this.image = image;

        initComponents();
    }

    /**
     * init components
     */
    private void initComponents() {
        setTitle(title);
        setIconImage(icon);
        setResizable(false);
        setUndecorated(true);

        JLabel imgSplash = new JLabel(new ImageIcon(image));
        
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);
        progressBar.setPreferredSize(new Dimension(7, 7));
        progressBar.setBackground(new Color(165, 196, 238));
        progressBar.setForeground(new Color(243, 179, 69));

        getContentPane().add(imgSplash, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
}
