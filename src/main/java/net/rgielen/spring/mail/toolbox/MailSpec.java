package net.rgielen.spring.mail.toolbox;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * MailSpec.
 *
 * @author Rene Gielen
 */
public class MailSpec {

    private final String from;
    private final String replyTo;
    private final List<String> to;
    private final List<String> cc;
    private final List<String> bcc;
    private final String subject;
    private final String template;
    private final Map<String, String> headers;
    private final boolean html;
    private final Map<String, Object> templateValues;
    private final String inReplyTo;

    protected MailSpec(String from, String replyTo, List<String> to, List<String> cc, List<String> bcc,
             String subject,
             String template, Map<String, String> headers, boolean html,
             Map<String, Object> templateValues, String inReplyTo) {
        this.from = from;
        this.replyTo = replyTo;
        this.to = (to != null) ? Collections.unmodifiableList(to) : Collections.emptyList();
        this.cc = (cc != null) ? Collections.unmodifiableList(cc) : Collections.emptyList();
        this.bcc = (bcc != null) ? Collections.unmodifiableList(bcc) : Collections.emptyList();
        this.subject = (subject != null) ? subject : "";
        this.template = (template != null) ? template : "";
        this.headers = (headers == null) ? Collections.emptyMap() : Collections.unmodifiableMap(headers);
        this.html = html;
        this.templateValues = (templateValues == null) ? Collections.emptyMap() : Collections.unmodifiableMap(templateValues);
        this.inReplyTo = inReplyTo;
    }

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public List<String> getCc() {
        return cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getTemplate() {
        return template;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public boolean isHtml() {
        return html;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public Map<String, Object> getTemplateValues() {
        return templateValues;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    @Override
    public String toString() {
        return "MailSpec{" +
                "from='" + from + '\'' +
                ", replyTo='" + replyTo + '\'' +
                ", to=" + to +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", subject='" + subject + '\'' +
                ", template='" + template + '\'' +
                ", headers=" + headers +
                ", html=" + html +
                ", templateValues=" + templateValues +
                ", inReplyTo='" + inReplyTo + '\'' +
                '}';
    }
}
