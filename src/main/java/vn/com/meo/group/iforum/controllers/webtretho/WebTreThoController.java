/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTabbedPane;
import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;
import vn.com.meo.group.iforum.controllers.Controller;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.CommentReply;
import vn.com.meo.group.iforum.models.CommentReplyCategory;
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

    private Website website;
    private WebTreThoRequest toolBase;
    //ui
    private JTabbedPane tab;
    private AccountTabController accountTabController;
    private CommentReplyCategoryController commentReplyCategoryController;
    private CommentReplyController commentReplyController;
    private AutoCommentReplyController autoCommentReplyController;

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
        Vector<WebCategory> categoryWebs = new Vector<>();
        categoryWebs.add(new WebCategory("Tâm Sự", "https://www.webtretho.com/forum/newthread.php?do=newthread&f=186"));
        categoryWebs.add(new WebCategory("Làm Đẹp", "https://www.webtretho.com/forum/newthread.php?do=newthread&f=16"));
        categoryWebs.add(new WebCategory("Kinh Nghiệm Hay", "https://www.webtretho.com/forum/newthread.php?do=newthread&f=73"));
        website.setWebCategorys(categoryWebs);
        //get accout website
        Vector<Account> accounts = new Vector<>();
        accounts.add(new Account("namhn1495", "123456a@", true));
        accounts.add(new Account("duongbv2", "buiduonga4", true));
        accounts.add(new Account("muahoatuyet9x", "buiduonga4", true));
        website.setAccounts(accounts);
        //get category comment website
        Vector<CommentReplyCategory> categoryCommentReplys = new Vector<>();
        CommentReplyCategory cmt1 = new CommentReplyCategory(1, "Làm Đẹp");
//        cmt1.getCommentReplyList().add(new CommentReply("Mình nghe nói uống nghệ đen sẽ chứa được á.", "Thank bạn, mình có thử uống mà chưa thấy đỡ lắm"));
//        cmt1.getCommentReplyList().add(new CommentReply("Như bạn phía trên, bà mình bị đau dạ dày và uông nghệ đen với mật ong quanh năm riết cũng khỏi.", "Thank bạn, mình mới uống được 1 tháng nên chưa thấy tác dụng mấy"));
        categoryCommentReplys.add(cmt1);
        categoryCommentReplys.add(new CommentReplyCategory(1, "Kinh Nghiệm Hay"));
        website.setCommentReplyCategorys(categoryCommentReplys);
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
        AutoCommentReplyTab autoCommentReplyTab = new AutoCommentReplyTab();
        autoCommentReplyController = new AutoCommentReplyController(toolBase, website, autoCommentReplyTab);
        
        //CommentReplyCategory Tab
        CommentReplyCategoryTab commentReplyCategoryTab = new CommentReplyCategoryTab();
        commentReplyCategoryController = new CommentReplyCategoryController(toolBase, website, commentReplyCategoryTab);
        
        //Comment Content Tab
        CommentReplyTab commentReplyTab = new CommentReplyTab();
        commentReplyController = new CommentReplyController(toolBase, website, commentReplyTab);

        webtretho.addSubTab("Tài Khoản", accountTab);
        webtretho.addSubTab("Auto Bình Luận", autoCommentReplyTab);
        webtretho.addSubTab("Nội Dung Bình Luận", commentReplyTab);
        webtretho.addSubTab("Phân Loại Bình Luận", commentReplyCategoryTab);
        this.tab.addTab(website.getName(), webtretho);

    }
}
