package org.seamless.util.mail;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* loaded from: classes5.dex */
public class EmailSender {
    public final String host;
    public final String password;
    public final Properties properties = new Properties();
    public final String user;

    public EmailSender(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Host is required");
        }
        this.host = str;
        this.user = str2;
        this.password = str3;
        this.properties.put("mail.smtp.port", "25");
        this.properties.put("mail.smtp.socketFactory.fallback", "false");
        this.properties.put("mail.smtp.quitwait", "false");
        this.properties.put("mail.smtp.host", str);
        this.properties.put("mail.smtp.starttls.enable", "true");
        if (str2 == null || str3 == null) {
            return;
        }
        this.properties.put("mail.smtp.auth", "true");
    }

    public Transport createConnectedTransport(Session session) throws MessagingException {
        String str;
        Transport transport = session.getTransport("smtp");
        String str2 = this.user;
        if (str2 == null || (str = this.password) == null) {
            transport.connect();
        } else {
            transport.connect(str2, str);
        }
        return transport;
    }

    public Multipart createContent(Email email) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setText(email.getPlaintext());
        MimeMultipart mimeMultipart = new MimeMultipart("alternative");
        mimeMultipart.addBodyPart(mimeBodyPart);
        if (email.getHtml() != null) {
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setContent(email.getHtml(), "text/html");
            mimeMultipart.addBodyPart(mimeBodyPart2);
        }
        return mimeMultipart;
    }

    public Session createSession() {
        return Session.getInstance(this.properties, (Authenticator) null);
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return this.password;
    }

    public Properties getProperties() {
        return this.properties;
    }

    public String getUser() {
        return this.user;
    }

    public void send(Email email) throws MessagingException {
        Session createSession = createSession();
        MimeMessage mimeMessage = new MimeMessage(createSession);
        mimeMessage.setFrom(new InternetAddress(email.getSender()));
        mimeMessage.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(email.getRecipient())});
        mimeMessage.setSubject(email.getSubject());
        mimeMessage.setSentDate(new Date());
        mimeMessage.setContent(createContent(email));
        Transport createConnectedTransport = createConnectedTransport(createSession);
        createConnectedTransport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        createConnectedTransport.close();
    }
}
