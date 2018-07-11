/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.controllers;

import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.meo.group.iforum.apps.base.ToolBase;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.CommentReply;
import vn.com.meo.group.iforum.models.CommentReplyCategory;

/**
 *
 * @author buian
 */
public class AutoExecutable extends Thread {

    public static int INIT = 0;
    public static int RUNNING = 1;
    public static int STOP = 2;
    public static int FINISH = 3;

    private int status;
    private Account userPost;
    private Vector<Account> users;
    private CommentReplyCategory commentReplyCategory;
    private ToolBase tool;
    private String urlWebCategory;
    private String title;
    private String contentPost;
    private String urlPost;
    private String idThread;
    private int commentCount;
    private Random rd;

    public AutoExecutable(ToolBase tool) {
        status = INIT;
        this.tool = tool;
        rd = new Random();
    }

    @Override
    public void run() {
        status = RUNNING;
        if (idThread == null) {
            new PostExecute();
        }
        int indexUser = 0;
        for (int i = 0; i < commentCount; i++) {
            if (users.get(indexUser).equals(userPost)) {
                indexUser++;
            }
            new CommentExecute(commentReplyCategory.getCommentReplyList().get(i), users.get(indexUser));
            indexUser++;
            int timeSleep = rd.nextInt(4) + 1;
            try {
                Thread.sleep(timeSleep*1000*60);
            } catch (InterruptedException ex) {
                Logger.getLogger(AutoExecutable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        status = FINISH;
    }

    public Account getUserPost() {
        return userPost;
    }

    public void setUserPost(Account userPost) {
        this.userPost = userPost;
    }

    public Vector<Account> getUsers() {
        return users;
    }

    public void setUsers(Vector<Account> users) {
        this.users = users;
    }

    public CommentReplyCategory getCommentReplyCategory() {
        return commentReplyCategory;
    }

    public void setCommentReplyCategory(CommentReplyCategory commentReplyCategory) {
        this.commentReplyCategory = commentReplyCategory;
    }

    public String getUrlWebCategory() {
        return urlWebCategory;
    }

    public void setUrlWebCategory(String urlWebCategory) {
        this.urlWebCategory = urlWebCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getUrlPost() {
        return urlPost;
    }

    public void setUrlPost(String urlPost) {
        this.urlPost = urlPost;
        String tmp[] = urlPost.split("-");
        String id = tmp[tmp.length - 1];
        idThread = id.replace("/", "");
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getStatusAsString() {
        if (status == INIT) {
            return "Khởi tạo";
        }
        if (status == RUNNING) {
            return "Đang chạy";
        }
        if (status == STOP) {
            return "Đang stop";
        }
        return "Hoàn thành";
    }

    public int getStatus() {
        return status;
    }

    class PostExecute extends Thread {

        public PostExecute() {
            this.start();
        }

        @Override
        public void run() {
            synchronized (tool) {
                System.out.println(tool);
                System.out.println(userPost);
                if(!userPost.getUsername().equals(tool.isLogin())){
                    tool.logout();
                    tool.login(userPost.getUsername(), userPost.getPassword());
                }
                if(userPost.getUsername().equals(tool.isLogin())){
                    idThread = tool.post(urlWebCategory, title, contentPost);
                    if(idThread != null){
                        urlPost = "https://www.webtretho.com/forum/f1/thread-id-" + idThread;
                    }
                    tool.log("idthread: " + idThread);
                    tool.log("urlpost: " + urlPost);
                }else{
                    tool.log("User post " + userPost.getUsername() + " login fail");
                }
            }
        }
    }

    class CommentExecute extends Thread {

        private CommentReply cmt;
        private Account userComment;

        public CommentExecute(CommentReply cmt, Account userComment) {
            this.cmt = cmt;
            this.userComment = userComment;
            this.start();
        }
        @Override
        public void run() {
            synchronized (tool) {
                if(idThread == null){
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
                        if (!userPost.getUsername().equals(tool.isLogin())) {
                            tool.logout();
                            tool.login(userPost.getUsername(), userPost.getPassword());
                        }
                        if(userPost.getUsername().equals(tool.isLogin())){
                            tool.replyComment(urlReply, cmt.getContentReply());
                        }else{
                            tool.log("user " + userPost.getUsername()+ " reply fail");
                        }
                    } else {
                        tool.log("user " + userComment.getUsername() + " comment fail");
                    }
                }else{
                    tool.log("login user comment fail " + userComment.getUsername());
                }
            }
        }
    }
}
