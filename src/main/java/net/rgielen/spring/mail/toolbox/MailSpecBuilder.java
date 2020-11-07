package net.rgielen.spring.mail.toolbox;

import java.util.*;

/**
 * MailSpecBuilder.
 *
 * @author Rene Gielen
 */
public class MailSpecBuilder {

    private String from;
    private String replyTo;
    private final List<String> to = new ArrayList<>();
    private final List<String> cc = new ArrayList<>();
    private final List<String> bcc = new ArrayList<>();
    private String subject = "";
    private String template = "";
    private final Map<String, String> headers = new HashMap<>();
    private boolean html = false;
    private final Map<String, Object> templateValues = new HashMap<>();
    private String inReplyTo;

    public MailSpecBuilder() {
    }

    public MailSpecBuilder(MailSpec specTemplate) {
        this.from = specTemplate.getFrom();
        this.replyTo = specTemplate.getReplyTo();
        if (specTemplate.getTo() != null) {
            this.to.addAll(specTemplate.getTo());
        }
        if (specTemplate.getCc() != null) {
            this.cc.addAll(specTemplate.getCc());
        }
        if (specTemplate.getBcc() != null) {
            this.bcc.addAll(specTemplate.getBcc());
        }
        this.subject = specTemplate.getSubject();
        this.template = specTemplate.getTemplate();
        if (specTemplate.getHeaders() != null) {
            this.headers.putAll(specTemplate.getHeaders());
        }
        this.html = specTemplate.isHtml();
        if (specTemplate.getTemplateValues() != null) {
            this.templateValues.putAll(specTemplate.getTemplateValues());
        }
        this.inReplyTo = specTemplate.getInReplyTo();
    }

    public static MailSpecBuilder create() {
        return new MailSpecBuilder();
    }

    public static MailSpecBuilder create(MailSpec specTemplate) {
        return new MailSpecBuilder(specTemplate);
    }

    public MailSpec build() {
        return new MailSpec(
                from,
                replyTo,
                to,
                cc,
                bcc,
                subject,
                template,
                headers,
                html,
                templateValues,
                inReplyTo
        );
    }

    public MailSpecBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public MailSpecBuilder setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }

    public MailSpecBuilder addTo(String to) {
        if (to != null) {
            this.to.add(to);
        }
        return this;
    }

    public MailSpecBuilder addTo(Collection<String> tos) {
        if (tos != null) {
            this.to.addAll(tos);
        }
        return this;
    }

    public MailSpecBuilder addCc(String cc) {
        if (cc != null) {
            this.cc.add(cc);
        }
        return this;
    }

    public MailSpecBuilder addCc(Collection<String> ccs) {
        if (ccs != null) {
            this.cc.addAll(ccs);
        }
        return this;
    }

    public MailSpecBuilder addBcc(String bcc) {
        if (bcc != null) {
            this.bcc.add(bcc);
        }
        return this;
    }

    public MailSpecBuilder addBcc(Collection<String> bccs) {
        if (bccs != null) {
            this.bcc.addAll(bccs);
        }
        return this;
    }

    public MailSpecBuilder setSubject(String subject) {
        this.subject = subject != null ? subject : "";
        return this;
    }

    public MailSpecBuilder setTemplate(String template) {
        this.template = template != null ? template : "";
        return this;
    }

    public MailSpecBuilder addHeader(String header, String value) {
        this.headers.put(header, value);
        return this;
    }

    public MailSpecBuilder addHeaders(Map<String, String> headers) {
        if (headers != null) {
            this.headers.putAll(headers);
        }
        return this;
    }

    public MailSpecBuilder setHtml(boolean html) {
        this.html = html;
        return this;
    }

    public MailSpecBuilder addTemplateValue(String key, Object value) {
        this.templateValues.put(key, value);
        return this;
    }

    public MailSpecBuilder addTemplateValues(Map<String, Object> templateValues) {
        if (templateValues != null) {
            this.templateValues.putAll(templateValues);
        }
        return this;
    }

    public MailSpecBuilder setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
        return this;
    }

}
