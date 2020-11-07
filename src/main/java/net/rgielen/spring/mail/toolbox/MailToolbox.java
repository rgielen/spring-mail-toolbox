package net.rgielen.spring.mail.toolbox;

import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * MailToolbox.
 *
 * @author Rene Gielen
 */
public class MailToolbox {

    public static final String HEADER_IN_REPLY_TO = "In-Reply-To";

    private final JavaMailSender emailSender;

    private TemplateRenderer defaultRenderer = new PlainTextRenderer();

    public MailToolbox(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void setDefaultRenderer(TemplateRenderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
    }

    public void send(MailSpec mailSpec) {
        send(mailSpec, defaultRenderer);
    }
    public void send(MailSpec mailSpec, TemplateRenderer renderer) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            applySpec(mailSpec, renderer, mimeMessage, helper);
            emailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new MailSendException("Unable to send mail", e);
        }
    }

    void applySpec(MailSpec mailSpec, TemplateRenderer renderer, MimeMessage mimeMessage,
                   MimeMessageHelper helper) throws MessagingException {
        applyFrom(helper, mailSpec.getFrom());
        applyReplyTo(helper, mailSpec.getReplyTo());
        applyTo(helper, mailSpec.getTo());
        applyCc(helper, mailSpec.getCc());
        applyBcc(helper, mailSpec.getBcc());
        applySubject(helper, mailSpec.getSubject());
        applyText(helper, renderer, mailSpec.getTemplate(), mailSpec.getTemplateValues(), mailSpec.isHtml());
        applyHeaders(mimeMessage, mailSpec.getHeaders());
        applyInReplyTo(mimeMessage, mailSpec.getInReplyTo());
    }

    void applyFrom(MimeMessageHelper helper, String from) throws MessagingException {
        Assert.notNull(from, "A valid from address must be given");
        helper.setFrom(from);
    }

    void applyReplyTo(MimeMessageHelper helper, String replyTo) throws MessagingException {
        if (replyTo != null) {
            helper.setReplyTo(replyTo);
        }
    }

    void applyTo(MimeMessageHelper helper, List<String> to) throws MessagingException {
        if (to != null) {
            for (String value : to) {
                helper.addTo(value);
            }
        }
    }

    void applyCc(MimeMessageHelper helper, List<String> cc) throws MessagingException {
        if (cc != null) {
            for (String value : cc) {
                helper.addCc(value);
            }
        }
    }

    void applyBcc(MimeMessageHelper helper, List<String> bcc) throws MessagingException {
        if (bcc != null) {
            for (String value : bcc) {
                helper.addBcc(value);
            }
        }
    }

    void applySubject(MimeMessageHelper helper, String subject) throws MessagingException {
        helper.setSubject(subject != null ? subject : "");
    }

    void applyText(MimeMessageHelper helper, TemplateRenderer renderer, String template,
                   Map<String, Object> templateValues, boolean isHtml) throws MessagingException {
        helper.setText(
                renderer.render(
                        template != null ? template : "",
                        templateValues != null ? templateValues : Collections.emptyMap()
                ),
                isHtml
        );
    }

    void applyHeaders(MimeMessage mimeMessage, Map<String, String> headers) throws MessagingException {
        if (headers != null) {
            for (Map.Entry<String, String> headerEntry : headers.entrySet()) {
                mimeMessage.addHeader(headerEntry.getKey(), headerEntry.getValue());
            }
        }
    }

    void applyInReplyTo(MimeMessage mimeMessage, String inReplyTo) throws MessagingException {
        if (inReplyTo != null) {
            mimeMessage.addHeader(HEADER_IN_REPLY_TO, inReplyTo);
        }
    }

}
