/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers.webtretho;

import java.util.Vector;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.controllers.AutoPostExecutable;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.Comment;

/**
 *
 * @author buian
 */
public class WebtrethoAutoPostExecutable extends AutoPostExecutable {
    
    public WebtrethoAutoPostExecutable(ToolBase tool, Vector<Account> users) {
        super(tool, users);
    }

    @Override
    public void setUrl(String url) {
        this.autoPost.setUrl(url);
        String tmp[] = url.split("-");
        String id = tmp[tmp.length - 1];
        String idThread = id.replace("/", "");
        this.autoPost.setIdThread(idThread);
    }

    @Override
    public void doPost() {
        Account userPost = autoPost.getUserPost();

        if (!userPost.getUsername().equals(tool.isLogin())) {
            tool.logout();
            tool.login(userPost.getUsername(), userPost.getPassword());
        }
        if (userPost.getUsername().equals(tool.isLogin())) {
            String urlWebCategory = autoPost.getWebCategory().getUrl();
            String title = autoPost.getTitle();
            String contentPost = autoPost.getContent();
            String idThread = tool.post(urlWebCategory, title, contentPost);
            if (idThread != null) {
                autoPost.setIdThread(idThread);
                String urlPost = "https://www.webtretho.com/forum/f1/thread-id-" + idThread;
                autoPost.setUrl(urlPost);
                tool.log("Id thread: " + idThread);
                tool.log("Url post: " + urlPost);
            }
        } else {
            tool.log("User post " + userPost.getUsername() + " login fail");
        }
    }

    @Override
    public void doComment(Comment cmt, Account userComment) {
        Account userPost = autoPost.getUserPost();
        String idThread = autoPost.getIdThread();
        if (idThread == null || "".equals(idThread)) {
            tool.log("chu de khong ton tai");
            return;
        }
        if (!userComment.getUsername().equals(tool.isLogin())) {
            tool.logout();
            tool.login(userComment.getUsername(), userComment.getPassword());
        }
//                System.out.println("login comment: " + tool.isLogin());
        if (userComment.getUsername().equals(tool.isLogin())) {
            String urlReply = tool.comment(idThread, cmt.getContentComment());

            if (urlReply != null) {
                tool.log("User comment: " + userComment.getUsername()+ " Id comment: " + urlReply);
                autoPost.setLastComment(cmt);
                autoPost.setLastUserComment(userComment);
                autoPost.setLastTimeComment(System.currentTimeMillis());
                if (!userPost.getUsername().equals(tool.isLogin())) {
                    tool.logout();
                    tool.login(userPost.getUsername(), userPost.getPassword());
                }
                if (userPost.getUsername().equals(tool.isLogin())) {
                    String idReply = tool.replyComment(urlReply, cmt.getContentReply());
                    tool.log("User reply: " + userPost.getUsername() + " Id reply: " + idReply);
                } else {
                    tool.log("user " + userPost.getUsername() + " reply fail");
                }
            } else {
                tool.log("user " + userComment.getUsername() + " comment fail");
            }
        } else {
            tool.log("login user comment fail " + userComment.getUsername());
        }
    }

    @Override
    public void updateUI() {
        AutoCommentReplyController.updateUI(this);
    }
}
