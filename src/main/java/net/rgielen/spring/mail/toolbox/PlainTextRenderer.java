package net.rgielen.spring.mail.toolbox;

import java.util.Map;

/**
 * PlainTextRenderer.
 *
 * @author Rene Gielen
 */
public class PlainTextRenderer implements TemplateRenderer {

    @Override
    public String render(String template, Map<String, Object> model) {
        return template;
    }
}
