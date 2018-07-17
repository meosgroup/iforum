/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import vn.com.meo.group.iforum.dao.AccountDao;
import vn.com.meo.group.iforum.dao.CommentCategoryDao;
import vn.com.meo.group.iforum.dao.CommentDao;
import vn.com.meo.group.iforum.dao.WebCategoryDao;
import vn.com.meo.group.iforum.dao.WebsiteDao;
import vn.com.meo.group.iforum.apps.requests.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.Controller;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.Comment;
import vn.com.meo.group.iforum.models.CommentCategory;
import vn.com.meo.group.iforum.models.WebCategory;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.tab.base.Tab;
import vn.com.meo.group.iforum.views.tab.general.AccountTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyCategoryTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyTab;
import vn.com.meo.group.iforum.views.tab.general.AutoCommentReplyTab;

/**
 *
 * @author buian
 */
public class WebTreThoController implements Controller {

    private String name = "webtretho.com";
    private Website website;
    private WebTreThoRequest toolBase;
    //db
    WebsiteDao websiteDao;
    AccountDao accountDao;
    WebCategoryDao webCategoryDao;
    CommentCategoryDao commentCategoryDao;
    CommentDao commentDao;
    //ui
    private JTabbedPane tab;
    private AccountTabController accountTabController;
    private CommentReplyCategoryController commentReplyCategoryController;
    private CommentReplyController commentReplyController;
    private AutoCommentReplyController autoCommentReplyController;

    public WebTreThoController(JTabbedPane tab) {
        this.tab = tab;
        websiteDao = new WebsiteDao();
        accountDao = new AccountDao();
        webCategoryDao = new WebCategoryDao();
        commentCategoryDao = new CommentCategoryDao();
        commentDao = new CommentDao();
        initData();
        initComponent();
    }

    @Override
    public void initData() {
        toolBase = new WebTreThoRequest();
        try {
            //get id, name website..
            website = websiteDao.getWebsiteByName(name);
            //get category website
            Vector<WebCategory> categoryWebs = webCategoryDao.getAllWebCategory(website.getId());
            website.setWebCategorys(categoryWebs);
            //get accout website
            Vector<Account> accounts = accountDao.getAllAccount(website.getId());
            website.setAccounts(accounts);
            //get category comment website
            Vector<CommentCategory> categoryCommentReplys = commentCategoryDao.
                    getAllCommentCategory(website.getId());
            website.setCommentReplyCategorys(categoryCommentReplys);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, name + " không tồn tại");
            Logger.getLogger(WebTreThoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initComponent() {
        Tab webtretho = new Tab();
        webtretho.setBackground(backGroundColor);
        webtretho.setFontTab(fontSubTab);
        //Account tab
        AccountTab accountTab = new AccountTab();
        accountTabController = new AccountTabController(toolBase, website, accountTab, accountDao);
        //PostLink tab
        AutoCommentReplyTab autoCommentReplyTab = new AutoCommentReplyTab();
        autoCommentReplyController = new AutoCommentReplyController(toolBase, website, autoCommentReplyTab);

        //CommentReplyCategory Tab
        CommentReplyCategoryTab commentReplyCategoryTab = new CommentReplyCategoryTab();
        commentReplyCategoryController = new CommentReplyCategoryController(
                toolBase, website, commentReplyCategoryTab, commentCategoryDao);

        //Comment Content Tab
        CommentReplyTab commentReplyTab = new CommentReplyTab();
        commentReplyController = new CommentReplyController(toolBase, website, commentReplyTab, commentDao);
        webtretho.addSubTab("Tài Khoản", accountTab);
        webtretho.addSubTab("Auto Bình Luận", autoCommentReplyTab);
        webtretho.addSubTab("Nội Dung Bình Luận", commentReplyTab);
        webtretho.addSubTab("Phân Loại Bình Luận", commentReplyCategoryTab);
        this.tab.addTab(website.getName(), webtretho);

    }
}
