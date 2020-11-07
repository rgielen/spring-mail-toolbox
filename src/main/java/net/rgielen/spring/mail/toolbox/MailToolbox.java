package net.rgielen.spring.mail.toolbox;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * MailToolbox.
 *
 * @author Rene Gielen
 */
public class MailToolbox {

    private final JavaMailSender emailSender;

    public MailToolbox(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void send(MailSpec mailSpec) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setFrom(mailSpec.getFrom());
            if (mailSpec.getReplyTo() != null) {
                helper.setReplyTo(mailSpec.getReplyTo());
            }
        } catch (Exception e) {
            throw new MailSendException("Unable to send mail", e);
        }
    }

}
