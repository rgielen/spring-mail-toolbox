package net.rgielen.spring.mail.toolbox;

import java.util.Map;

/**
 * TemplateRenderer.
 * Interface.
 *
 * @author Rene Gielen
 */

public interface TemplateRenderer {

    String render(String template, Map<String, Object> model);

}
