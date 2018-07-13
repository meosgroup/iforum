/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.models;

/**
 *
 * @author buian
 */
public class AutoPost {

    public static String INIT = "Khởi tạo";
    public static String RUNNING = "Đang chạy";
    public static String PAUSE = "Đang dừng";
    public static String FINISH = "Hoàn thành";

    private int id;
    private String url = "";
    private String title = "";
    private String content = "";
    private CommentCategory commentCategory = null;
    private WebCategory webCategory = null;
    private Account userPost = null;
    private Account lastUserComment = null;
    private Comment lastComment = null;
    private String status = INIT;
    private long lastTimeComment = 0;
    private String idThread = "";
    private long timeCreate = 0;
    public AutoPost(){
        timeCreate = System.currentTimeMillis();
    }
    public AutoPost(String url, CommentCategory commentCategory, Account userPost) {
        this.url = url;
        this.commentCategory = commentCategory;
        this.userPost = userPost;
        timeCreate = System.currentTimeMillis();
    }

    public AutoPost(WebCategory webCategory, String title, String content, CommentCategory commentCategory, Account userPost) {
        this.title = title;
        this.content = content;
        this.commentCategory = commentCategory;
        this.userPost = userPost;
        this.webCategory = webCategory;
        timeCreate = System.currentTimeMillis();
    }

    public long getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(long timeCreate) {
        this.timeCreate = timeCreate;
    }
    
    public WebCategory getWebCategory() {
        return webCategory;
    }

    public void setWebCategory(WebCategory webCategory) {
        this.webCategory = webCategory;
    }

    public String getIdThread() {
        return idThread;
    }

    public void setIdThread(String idThread) {
        this.idThread = idThread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentCategory getCommentCategory() {
        return commentCategory;
    }

    public void setCommentCategory(CommentCategory commentCategory) {
        this.commentCategory = commentCategory;
    }

    public Account getUserPost() {
        return userPost;
    }

    public void setUserPost(Account userPost) {
        this.userPost = userPost;
    }

    public Account getLastUserComment() {
        return lastUserComment;
    }

    public void setLastUserComment(Account lastUserComment) {
        this.lastUserComment = lastUserComment;
    }

    public Comment getLastComment() {
        return lastComment;
    }

    public void setLastComment(Comment lastComment) {
        this.lastComment = lastComment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLastTimeComment() {
        return lastTimeComment;
    }

    public void setLastTimeComment(long lastTimeComment) {
        this.lastTimeComment = lastTimeComment;
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        AutoPost tmp = (AutoPost) o;
        if(tmp.getTimeCreate() == timeCreate && id == tmp.getId()){
            return true;
        }
        return false;
    }
}
