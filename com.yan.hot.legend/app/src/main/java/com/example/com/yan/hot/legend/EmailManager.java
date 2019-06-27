package com.example.com.yan.hot.legend;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Xml;

import com.example.com.yan.hot.legend.runstate.ActionRun;
import com.example.com.yan.hot.legend.runstate.ActionRunFile;
import com.example.com.yan.hot.legend.screencap.ScreencapPathUtil;
import com.zsctc.remote.touch.bytes.ClickTool;
import com.zsctc.remote.touch.bytes.LogManager;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class EmailManager {
    private static final EmailManager ourInstance = new EmailManager();

    static EmailManager getInstance() {
        return ourInstance;
    }

    private EmailManager() {
    }

    @SuppressLint("CheckResult")
    public void sendSync(){
        Observable.just(1)
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        EmailManager.getInstance().send();
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void send() {
        try {
            // 1. 创建参数配置, 用于连接邮件服务器的参数配置
            Properties props = new Properties();                    // 参数配置
            props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议(JavaMail规范要求)
            props.setProperty("mail.smtp.host", "smtp.139.com");     // 发件人的邮箱的 SMTP 服务器地址
            props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

            // 2. 根据配置创建会话对象, 用于和邮件服务器交互
            Session session = Session.getDefaultInstance(props);
            // 设置为debug模式, 可以查看详细的发送 log
            session.setDebug(true);
            ActionRun actionRun = ActionRunFile.read();
            // 3. 创建一封邮件
            String filePath = getFilePath(actionRun);
            MimeMessage message;
            if (filePath == null) {
                message = createMimeMessage(session,
                        "15900081492@139.com", "273549560@qq.com",
                        getTitle(actionRun), getContent(actionRun));//我这里是以163邮箱为发信邮箱测试通过
            } else {
                message = createMimeMessage(session,
                        "15900081492@139.com", "273549560@qq.com",
                        getTitle(actionRun), getContent(actionRun), filePath);//我这里是以163邮箱为发信邮箱测试通过
            }
            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            transport.connect("15900081492@139.com", "Zzy515144");
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            // 7. 关闭连接
            transport.close();
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }


    private String getTitle(ActionRun actionRun) {
        return actionRun.getModeType() + "";
    }

    private String getContent(ActionRun actionRun) {
        List<ActionRun.ActionState> actionStates = actionRun.getActionStates();
        StringBuffer msg = new StringBuffer();
        for (ActionRun.ActionState state : actionStates) {
            if (state.isRun()) {
                msg.append(state.getClientType() + ",");
            }
        }
        return msg.toString();
    }

    private String getFilePath(ActionRun actionRun) {
        List<ActionRun.ActionState> actionStates = actionRun.getActionStates();
        ClickTool.ClientType clientType = null;
        for (ActionRun.ActionState state : actionStates) {
            if (state.isRun()) {
                clientType = state.getClientType();
                break;
            }
        }
        if (clientType != null) {
            return ScreencapPathUtil.getExistPath(clientType.name());
        } else {
            return null;
        }
    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session     和服务器交互的会话
     * @param sendMail    发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String title, String content) throws Exception {
        LogManager.newInstance().writeMessage("email title:" + title + ",content:" + content);
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "发件人", "UTF-8"));
        // 3. To: 收件人(可以增加多个收件人、抄送、密送)
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "收件人", "UTF-8"));
        // 4. Subject: 邮件主题
        message.setSubject(title, "UTF-8");
        // 5. Content: 邮件正文(可以使用html标签)
        message.setContent(content, "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());
        // 7. 保存设置
        message.saveChanges();
        return message;
    }

    public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,
                                         String title, String content, String filePath) throws Exception {
        // 根据session创建一个邮件消息
        MimeMessage mailMessage = new MimeMessage(session);
        // 创建邮件发送者地址
        Address from = new InternetAddress(sendMail);
        // 设置邮件消息的发送者
        mailMessage.setFrom(from);
        // 创建邮件的接收者地址，并设置到邮件消息中
        Address to = new InternetAddress(receiveMail);
        mailMessage.setRecipient(Message.RecipientType.TO, to);
        // 设置邮件消息的主题
        mailMessage.setSubject(title);
        // 设置邮件消息发送的时间
        mailMessage.setSentDate(new Date());
        // 设置邮件消息的主要内容
        String mailContent = content;
        mailMessage.setContent(mailContent, "text/html;charset=gb2312");

        // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
        Multipart mainPart = new MimeMultipart();
        // 创建一个包含HTML内容的MimeBodyPart
        BodyPart html = new MimeBodyPart();
        // 设置HTML内容
        html.setContent(content, "text/html; charset=GBK");
        mainPart.addBodyPart(html);

        // 为邮件添加附件
        // 存放邮件附件的MimeBodyPart
        MimeBodyPart attachment = null;
        File file = null;
        attachment = new MimeBodyPart();
        // 根据附件文件创建文件数据源
        file = new File(filePath);
        FileDataSource fds = new FileDataSource(file);
        attachment.setDataHandler(new DataHandler(fds));
        // 为附件设置文件名
        attachment.setFileName(MimeUtility.encodeText(file.getName(),"gbk",null));
        attachment.setContentID(file.getName().replace(".jpg", "").replace(".png", ""));
        mainPart.addBodyPart(attachment);
        // 将MiniMultipart对象设置为邮件内容
        mailMessage.setContent(mainPart);
        return mailMessage;
    }
}
