package net.rgielen.spring.mail.toolbox;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.mail.MailParseException;

import java.io.StringReader;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.emptyMap;
import static org.springframework.ui.freemarker.FreeMarkerTemplateUtils.processTemplateIntoString;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 */
public class FreemarkerRenderer implements TemplateRenderer {

    private final Configuration freemarkerConfiguration;

    public FreemarkerRenderer(@MailConfig Configuration freemarkerConfiguration) {
        this.freemarkerConfiguration = freemarkerConfiguration;
    }

    @Override
    public String render(String template, Map<String, Object> model) {
        try {
            return processTemplateIntoString(
                    new Template("name", new StringReader(template), freemarkerConfiguration),
                    Optional.ofNullable(model).orElse(emptyMap())
            );
        } catch (Exception e) {
            throw new MailParseException("Mail template could not be processed:\n" + template, e);
        }
    }
}
