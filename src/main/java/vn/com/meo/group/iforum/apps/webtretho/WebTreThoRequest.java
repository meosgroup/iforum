/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum.apps.webtretho;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import vn.com.meo.group.iforum.apps.base.ToolBase;

/**
 *
 * @author buian
 */
public class WebTreThoRequest extends ToolBase {

    public WebTreThoRequest() {
    }

    @Override
    public void login(String username, String password) {
        String url = "https://www.webtretho.com/forum/login.php?do=login";
        try {
            HttpResponse<String> res = Unirest.get(url).asString();
            Document doc = Jsoup.parse(res.getBody());
            String cookieuser = doc.select("input[name=cookieuser]").get(0).val();
            String doo = doc.select("input[name=do]").get(0).val();
            String vb_login_md5password = doc.select("input[name=vb_login_md5password]").get(0).val();
            String vb_login_md5password_utf = doc.select("input[name=vb_login_md5password_utf]").get(0).val();
            String s = doc.select("input[name=s]").get(0).val();
            String securitytoken = doc.select("input[name=securitytoken]").get(0).val();
            Unirest.post(url).field("cookieuser", cookieuser)
                    .field("do", doo)
                    .field("vb_login_md5password", vb_login_md5password)
                    .field("vb_login_md5password_utf", vb_login_md5password_utf)
                    .field("s", s)
                    .field("securitytoken", securitytoken)
                    .field("vb_login_username", username)
                    .field("vb_login_password", password).asString();
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isLogin() {
        String url = "https://www.webtretho.com/forum/index.php";
        try {
            HttpResponse<String> res = Unirest.get(url).asString();
            Document doc = Jsoup.parse(res.getBody());
            Elements e = doc.select("div[class=user]");
            if (e.size() > 0) {
                return true;
            }
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void register(String username, String password, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isRegister(String username) {
        try {
            String securitytoken = "guest";
            HttpResponse<String> res;
            Document doc;
            if(isLogin()){
                String url = "https://www.webtretho.com/forum/profile.php?do=buddylist";
                res = Unirest.get(url).asString();
                doc = Jsoup.parse(res.getBody());
                Elements e = doc.select("input[name=securitytoken]");
                securitytoken = e.get(0).val();
            }
            res = Unirest.post("https://www.webtretho.com/forum/ajax.php?do=usersearch").field("securitytoken", securitytoken)
                    .field("do", "usersearch")
                    .field("fragment", username).asString();
            
            doc = Jsoup.parse(res.getBody());
            Elements eUsers = doc.select("user");
            for(Element e : eUsers){
                if(e.html().toLowerCase().equals(username.toLowerCase())){
                    return true;
                }
            }
            return false;
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public void post(String url, String title, String content) {
        try {
            Unirest.get(url).asString();
            HttpResponse<String> res = Unirest.get(url).asString();
            Document doc = Jsoup.parse(res.getBody());
            String securitytoken = doc.select("input[name=securitytoken]").get(0).val();
            String doo = doc.select("input[name=do]").get(0).val();
            String posthash = doc.select("input[name=posthash]").get(0).val();
            String poststarttime = doc.select("input[name=poststarttime]").val();
            String loggedinuser= doc.select("input[name=loggedinuser]").val();
            res = Unirest.post(url).field("prefixid", "")
                    .field("subject", title)
                    .field("message_backup", content)
                    .field("message", content)
                    .field("wysiwyg", 1)
                    .field("sbutton", "Đăng bài mới")
                    .field("s", "")
                    .field("securitytoken", securitytoken)
                    .field("do", doo)
                    .field("posthash", posthash)
                    .field("poststarttime", poststarttime)
                    .field("loggedinuser", loggedinuser).asString();
            Headers headers = res.getHeaders();
            //bb_wtt_login_redirect_url = url
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void comment(String threadId, String comment) {
        try {
            HttpResponse<String> res = Unirest.get("https://www.webtretho.com/forum/f1/thread-id-" + threadId).asString();
            Document doc = Jsoup.parse(res.getBody());
            String wysiwyg = doc.select("input[name=wysiwyg]").get(0).val();
            String s = doc.select("input[name=s]").get(0).val();
            String securitytoken = doc.select("input[name=securitytoken]").get(0).val();
            String doo = doc.select("input[name=do]").get(0).val();
            String t = doc.select("input[name=t]").get(0).val();
            String p = doc.select("input[name=p]").get(0).val();
            String specifiedpost = doc.select("input[name=specifiedpost]").get(0).val();
            String parseurl = doc.select("input[name=parseurl]").get(0).val();
            String loggedinuser = doc.select("input[name=loggedinuser]").get(0).val();
            String posthash = doc.select("input[name=posthash]").get(0).val();
            String poststarttime = doc.select("input[name=poststarttime]").get(0).val();
            String fromquickreply = doc.select("input[name=fromquickreply]").get(0).val();
            res = Unirest.post("https://www.webtretho.com/forum/newreply.php?do=postreply&t=" + threadId).field("message_backup", comment)
                    .field("message", comment)
                    .field("wysiwyg", wysiwyg)
                    .field("sbutton", "Gửi")
                    .field("fromquickreply", fromquickreply)
                    .field("s", s)
                    .field("securitytoken", securitytoken)
                    .field("do", doo)
                    .field("t", t)
                    .field("p", p)
                    .field("specifiedpost", specifiedpost)
                    .field("parseurl", parseurl)
                    .field("loggedinuser", loggedinuser)
                    .field("posthash", posthash)
                    .field("poststarttime", poststarttime).asString();
            System.out.println(res.getStatus());
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void replyComment(String url, String comment) {
        //url = "https://www.webtretho.com/forum/newreply.php?do=postreply&t=2684269"
        try {
            HttpResponse<String> res = Unirest.get(url).asString();
            Document doc = Jsoup.parse(res.getBody());
            String securitytoken = doc.select("input[name=securitytoken]").get(0).val();
            String doo = doc.select("input[name=do]").get(0).val();
            String message = doc.getElementById("vB_Editor_001_editor").html();
            String posthash = doc.select("input[name=posthash]").get(0).val();
            String wysiwyg = doc.select("input[name=wysiwyg]").get(0).val();
            String poststarttime = doc.select("input[name=poststarttime]").val();
            String loggedinuser= doc.select("input[name=loggedinuser]").val();
            String title = doc.select("input[name=title]").val();
            String t = doc.select("input[name=t]").val();
            String p = doc.select("input[name=p]").val();
            String s = doc.select("input[name=s]").val();
            String specifiedpost = doc.select("input[name=specifiedpost]").val();
            String multiquoteempty = doc.select("input[name=multiquoteempty]").val();
            String sbutton = "Đăng trả lời";
            res = Unirest.post(url).field("title", title)
                    .field("message_backup", message + comment)
                    .field("message", message + comment)
                    .field("wysiwyg", wysiwyg)
                    .field("s", s)
                    .field("securitytoken", securitytoken)
                    .field("do", doo)
                    .field("t", t)
                    .field("p", p)
                    .field("specifiedpost", specifiedpost)
                    .field("posthash", posthash)
                    .field("poststarttime", poststarttime)
                    .field("loggedinuser", loggedinuser)
                    .field("multiquoteempty", multiquoteempty)
                    .field("sbutton", sbutton).asString();
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logout() {
        try {
            String url = "https://www.webtretho.com/forum/index.php";
            HttpResponse<String> res = Unirest.get(url).asString();
            Document doc = Jsoup.parse(res.getBody());
            Elements e = doc.select("a[class=logout]");
            if(e.size() > 0){
                String urlLogout = e.get(0).attr("href");
                Unirest.get(urlLogout).asString();
            }
        } catch (UnirestException ex) {
            Logger.getLogger(WebTreThoRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
