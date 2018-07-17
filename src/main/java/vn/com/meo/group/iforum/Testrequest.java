/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vn.com.meo.group.iforum.dao.AccountDao;
import vn.com.meo.group.iforum.models.Account;

/**
 *
 * @author buian
 */
class Job {

    public Job() {

    }

    public void post() {

        System.out.println("post");
    }

    public void login() {
        System.out.println("Login");
    }

    public void logout() {
        System.out.println("Logout");
    }
}

class ThreadJob extends Thread {

    private Job job;
    private String name;

    public ThreadJob(Job j, String name) {
        job = j;
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        
            synchronized (job) {
                System.out.print(name);
                job.login();
                System.out.print(name);
                job.post();
                System.out.print(name);
                job.logout();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadJob.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
    }
}

class ThreadExecute extends Thread{
    private String name;
    private int number;
    private Job job;
    public ThreadExecute(Job job, String name, int number){
        this.job = job;
        this.name = name;
        this.number = number;
    }
    @Override
    public void run(){
        for(int i =0; i<number;i++){
            new ThreadJob(job, name);
            try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadJob.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}

public class Testrequest {

    public static void main(String[] args) throws UnsupportedEncodingException {

//        WebTreThoRequest w = new WebTreThoRequest();
//        w.login("muahoatuyet9x", "buiduonga4");
//        System.out.println(w.isLogin());
//        System.out.println(w.isLogin());
//        w.post("https://www.webtretho.com/forum/newthread.php?do=newthread&f=77", "Hỏi địa điểm chữa bệnh đau dạ dày hiệu quả", "Chào các mẹ, mình bị bệnh đau dạ dày cả năm nay rồi, đi chữa khá nhiều nơi, uống thuốc tây thì được 1 thời gian sau đó lại tái phát, rất là khổ sở. Có mẹ nào biết đia điểm chữa bệnh đau dạ dày hiệu quả mách mình với. :'(");
//        w.replyComment("36638099", "Nghe noi bot nghe den chua duoc do ban");
//        w.comment("2687406", "Có mẹ nào biết không giúp mình với");
//        System.out.println(w.isRegister("iblack"));
//        Job jon = new Job();
//        ThreadExecute j1 = new ThreadExecute(jon, "Thread 1: ", 5);
//        ThreadExecute j2 = new ThreadExecute(jon, "Thread 2: ", 5);
//        ThreadExecute j3 = new ThreadExecute(jon, "Thread 3: ", 5);
//        j1.start();
//        j2.start();
//        j3.start();
//        String s = "Set-Cookie=[bb_wtt_login_redirect_url=https%3A%2F%2Fwww.webtretho.com%2Fforum%2Fshowthread.php%3Ft%3D2687406; path=/; secure], Pragma=[private], Date=[Tue, 10 Jul 2018 18:47:36 GMT], Content-Type=[text/html; charset=utf-8]}";
//        int start = s.indexOf("bb_wtt_login_redirect_url=") + "bb_wtt_login_redirect_url=".length();
//        int finish = s.indexOf(";", start);
//        String url = s.substring(start, finish);
//        url = URLDecoder.decode(url, "ASCII");
//        System.out.println(url.substring(url.indexOf("t=")+2));
//        System.out.println();


    }
}
