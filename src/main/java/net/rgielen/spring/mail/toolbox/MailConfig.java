package net.rgielen.spring.mail.toolbox;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.METHOD})
public @interface MailConfig {
}
