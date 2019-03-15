package com.makerspace.demo.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
    public static Boolean sendEmail(String toEmail, String title, String msg ){
        String smtp="smtp.163.com";
        String charset="utf-8";
        String fromEmail="fearless_studio@163.com";
        String name="Fearless Studio";
        String password="wangliming456";
        HtmlEmail email = new HtmlEmail();
            try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(smtp);
            // 字符编码集的设置
            email.setCharset(charset);
            // 收件人的邮箱
            email.addTo(toEmail);
            // 发送人的邮箱2
            email.setFrom(fromEmail, name);
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication(fromEmail, password);
            // 要发送的邮件主题
            email.setSubject(title);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(msg);
//                "发送<p>尊敬的******用户：</p><p>您好!</p><p>您正在尝试重置密码！"
//                        +"您的验证码是：123456。</p><p>请妥善保管您的账号和密码。</p>"
//                        +"<p>******</p>"
            email.send();
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;

        }

    }
}
