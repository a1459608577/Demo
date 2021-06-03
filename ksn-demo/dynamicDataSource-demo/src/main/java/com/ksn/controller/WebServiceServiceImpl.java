//package com.ksn.controller;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.util.Properties;
//
//
///**
// * @author ksn
// * @version 1.0
// * @date 2021/5/7 17:45
// */
//
//public class WebServiceServiceImpl {
//
//
//    @Value("${spring.mail.password}")
//    private String password;
//
//    /**
//     * 邮件
//     * @param strSendDlyName 发送人名字
//     * @param strSendAddr 发送人地址
//     * @param strRecvDlyName 接收人名字
//     * @param strRecvAddr 接收人地址
//     * @param strCopyDlyName 抄送人名字（没有则填new string[0]）
//     * @param strCopyAddr 抄送人地址（没有则填new string[0]）
//     * @param strScrDlyName 秘密抄送人名字（没有则填new string[0]）
//     * @param strScrAddr 秘密抄送人地址（没有则填new string[0]）
//     * @param strSubject 邮件标题*
//     * @param strContent 邮件内容*
//     * @param strPriority 邮件紧急度（"High":高;"Low":低;其它:一般）
//     * @param strBodyFormat 邮件格式("Text":文本;其它:Html)
//     */
//    public void MailNoAttachmentSend(String strSendDlyName, String strSendAddr, String strRecvDlyName, String strRecvAddr
//                , String[] strCopyDlyName, String[] strCopyAddr, String[] strScrDlyName, String[] strScrAddr, String strSubject
//                , String strContent, String strPriority, String strBodyFormat) {
//
//        Properties props = new Properties();
//        // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
//        props.setProperty("mail.smtp.host", "smtp.163.com");
//        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
//        props.put("mail.smtp.host", "smtp.163.com");
//        // 用刚刚设置好的props对象构建一个session
//        props.put("mail.smtp.auth", "true");
//        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使用（你可以在控制台（console)上看到发送邮件的过程）
//        Session session = Session.getDefaultInstance(props);
//        // 用session为参数定义消息对象
//        session.setDebug(true);
//        // 加载发件人地址
//        MimeMessage message = new MimeMessage(session);
//        try {
//            // strSendDlyName 发件人邮箱地址
//            message.setFrom(new InternetAddress(strSendDlyName));
//            // 加载收件人地址
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(strRecvAddr));
//            // 加载标题
//            message.setSubject(strSubject);
//            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
//            Multipart multipart = new MimeMultipart();
//            // 设置邮件的文本内容
//            BodyPart contentPart = new MimeBodyPart();
//            if ("Text".equals(strBodyFormat)) {
//                contentPart.setContent(strContent, "text/plain;charset=utf-8");
//            } else {
//                contentPart.setContent(strContent, "text/html;charset=utf-8");
//            }
//
//            multipart.addBodyPart(contentPart);
//            message.setContent(multipart);
//            // 保存变化
//            message.saveChanges();
//            // 连接服务器的邮箱
//            Transport transport = session.getTransport("smtp");
//            // 把邮件发送出去 strSendAddr为发件人称号，同邮箱地址
//            transport.connect("smtp.163.com", strSendAddr, password);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
