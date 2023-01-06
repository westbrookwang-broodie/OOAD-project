package com.example.ooad.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@RestController
public class MailController {

    @RequestMapping("/mail")
    public String mail(String to, String context, String username) throws MessagingException, IOException{

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\86177\\Desktop\\备份\\ooad\\src\\main\\resources\\mail.properties")))
        {
            props.load(in);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("亲爱的 "+ username);
        builder.append("<br>");
        builder.append(context);
        builder.append("<br>");
        builder.append("祝好");
        builder.append("<br>");
        builder.append(" 酒店客服");
        builder.append("<br>");
        String result="";
        result +="亲爱的"+ username +":" + "<br>" + "<br>"+ context + "<br>"+ "<br>" + "祝好," + "<br>" + " 酒店客服" + "<br>";
        System.out.println(result);
        System.out.println(builder.toString());


        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport ts = mailSession.getTransport();
        ts.connect("smtp.sustech.edu.cn","12011527@mail.sustech.edu.cn","67822260Wang");
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom("12011527@mail.sustech.edu.cn");
        message.setRecipients(Message.RecipientType.TO, to);
        message.setSubject("酒店消息通知");
        message.setContent(result,"text/html;charset=UTF-8");
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
        return "成功";





    }
}
