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
import vn.com.meo.group.iforum.apps.dao.AutoPostDao;
import vn.com.meo.group.iforum.models.Account;
import vn.com.meo.group.iforum.models.AutoPost;
import vn.com.meo.group.iforum.models.Comment;

/**
 *
 * @author buian
 */
public abstract class AutoPostExecutable extends Thread {

    protected ToolBase tool;
    protected Random rd;
    protected AutoPost autoPost;
    protected Vector<Account> users;
    protected AutoPostDao autoPostDao;
    private Comment cmtCurrent;
    private Account userComment;
    private int commentCount;

    public AutoPostExecutable(ToolBase tool, Vector<Account> users) {
        this.tool = tool;
        this.users = users;
        rd = new Random();
        autoPostDao = new AutoPostDao();
        autoPost = new AutoPost();
        commentCount = 0;
    }

    public AutoPost getAutoPost() {
        return autoPost;
    }

    public void setAutoPost(AutoPost autoPost) {
        this.autoPost = autoPost;
    }

    public void setUrl(String url) {
        autoPost.setUrl(url);
    }

    @Override
    public void run() {
        commentCount = Math.min(users.size() - 1, autoPost.getCommentCategory().
                getCommentReplyList().size());
        autoPost.setStatus(AutoPost.RUNNING);
        //neu chua post bai thi post bai
        updateUI();
        if (autoPost.getIdThread() == null || "".equals(autoPost.getIdThread())) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    synchronized (tool) {
                        doPost();
                        updateUI();
                    }
                }
            }).start();
        }
        for (int i = 0, j = 0; i < commentCount; i++, j++) {
            if (autoPost.getUserPost().equals(users.get(i))) {
                j++;
            }
            cmtCurrent = autoPost.getCommentCategory().getCommentReplyList().get(i);
            userComment = users.get(j);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    doComment(cmtCurrent, userComment);
                    updateUI();
                }
            }).start();
            try {
                if (i < commentCount - 1) {
                    int timeSleep = rd.nextInt(2) + 5; //phut'
                    Thread.sleep(timeSleep * 60000);
                } else {
                    autoPost.setStatus(AutoPost.FINISH);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(AutoPostExecutable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        updateUI();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        AutoPostExecutable tmp = (AutoPostExecutable) o;
        if (tmp.getAutoPost().equals(autoPost)) {
            return true;
        }
        return false;
    }

    public abstract void doPost();

    public abstract void doComment(Comment cmt, Account userComment);

    public abstract void updateUI();

}
