/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.meo.group.iforum;

import vn.com.meo.group.iforum.apps.webtretho.WebTreThoRequest;

/**
 *
 * @author buian
 */
public class Testrequest {
    public static void main(String[] args) {
           
        WebTreThoRequest w = new WebTreThoRequest();
        w.login("namhn1495", "123456a@");
        w.post("https://www.webtretho.com/forum/newthread.php?do=newthread&f=110", "Xin review du lịch cô tô", "Chào cả nhà, hè này mình"
                + "có dự định đi cô tô, các bạn ai đi rồi cho mình xin ít review được không. trung bình mỗi người hết bao nhiêu tiền ạ");
        w.replyComment("https://www.webtretho.com/forum/newreply.php?do=newreply&p=36625533", "cảm ơn bạn. <3");
        w.comment("2266218", "cam on ban, bai viet rat bo ich");
        System.out.println(w.isRegister("iblack"));
    }
}
