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
    private final String text;
    private final Map<String, String> headers;
    private final boolean html;

    public MailSpec(String from, String replyTo, List<String> to, List<String> cc, List<String> bcc,
                    String subject,
                    String text, Map<String, String> headers, boolean html) {
        this.from = from;
        this.replyTo = replyTo;
        this.to = (to == null) ? Collections.emptyList() : Collections.unmodifiableList(to);
        this.cc = (cc == null) ? Collections.emptyList() : Collections.unmodifiableList(cc);
        this.bcc = (bcc == null) ? Collections.emptyList() : Collections.unmodifiableList(bcc);
        this.subject = subject;
        this.text = text;
        this.headers = (headers == null) ? Collections.emptyMap() : Collections.unmodifiableMap(headers);
        this.html = html;
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

    public String getText() {
        return text;
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
}
