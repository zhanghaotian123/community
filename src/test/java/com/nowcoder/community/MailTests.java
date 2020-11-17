package com.nowcoder.community;


import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {


    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testEmail(){
        mailClient.sendMail("ZHTLOVGMY@163.COM","test","welcome");
    }

    @Test
    public void testHtmlMail(){
        Context context =new Context();
        context.setVariable("username","I love guomeiyu baby");
        String content=templateEngine.process("/mail/demo",context);
        System.out.print(content);
        mailClient.sendMail("ZHTLOVGMY@163.com","html",content);
    }
}
