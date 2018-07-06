/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.util.ArrayList;
import javax.swing.JTabbedPane;
import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.Controller;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.CommentReplyCategory;
import vn.com.meo.group.iforum.models.CategoryWeb;
import vn.com.meo.group.iforum.models.Website;
import vn.com.meo.group.iforum.views.tab.base.Tab;
import vn.com.meo.group.iforum.views.tab.general.AccountTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyCategoryTab;
import vn.com.meo.group.iforum.views.tab.general.CommentReplyTab;
import vn.com.meo.group.iforum.views.tab.general.PostsLinkTab;

/**
 *
 * @author buian
 */
public class WebTreThoController implements Controller {

    private Website website;
    private WebTreThoRequest toolBase;
    //ui
    private JTabbedPane tab;
    private AccountTabController accountTabController;
    private CommentReplyCategoryController commentReplyCategoryController;
    private CommentReplyController commentReplyController;

    public WebTreThoController(JTabbedPane tab) {
        this.tab = tab;
        website = new Website();
        toolBase = new WebTreThoRequest();
        initData();
        initComponent();
    }

    @Override
    public void initData() {
        //get id, name website..
        website.setNameWeb("Web Tre Tho");
        //get category website
        ArrayList<CategoryWeb> categoryWebs = new ArrayList<>();
        website.setCategoryWebs(categoryWebs);
        //get accout website
        ArrayList<Account> accounts = new ArrayList<>();
        website.setAccounts(accounts);
        //get category comment website
        ArrayList<CommentReplyCategory> categoryCommentReplys = new ArrayList<>();
        website.setCategoryCommentReplys(categoryCommentReplys);
    }

    @Override
    public void initComponent() {
        Tab webtretho = new Tab();
        webtretho.setBackground(backGroundColor);
        webtretho.setFontTab(fontSubTab);
        //Account tab
        AccountTab accountTab = new AccountTab();
        accountTabController = new AccountTabController(toolBase, website, accountTab);
        //PostLink tab
        
        
        //CommentReplyCategory Tab
        CommentReplyCategoryTab commentReplyCategoryTab = new CommentReplyCategoryTab();
        
        commentReplyCategoryController = new CommentReplyCategoryController(toolBase, website, commentReplyCategoryTab);
        
        //Comment Content Tab
        CommentReplyTab commentReplyTab = new CommentReplyTab();
       
        commentReplyController = new CommentReplyController(toolBase, website, commentReplyTab);
        
        
        webtretho.addSubTab("Tài Khoản", accountTab);
        webtretho.addSubTab("Link Bài Viết", new PostsLinkTab());
        webtretho.addSubTab("Nội Dung Comment", commentReplyTab);
        webtretho.addSubTab("Phân Loại Bình Luận", commentReplyCategoryTab);
        this.tab.addTab(website.getName(), webtretho);

    }
}
