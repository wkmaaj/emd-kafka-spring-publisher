package llc.jaradatbros.emd.framework.core.support.message;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceBundleMessageSource extends ReloadableResourceBundleMessageSource{
    /**
     * Gets all messages for presented locale.
     *
     * @param locale user requested locale
     * @return       the resolved messages
     */
    public Properties getMessages(Locale locale) {
        if (log.isTraceEnabled()) {
            // TODO - log properties if TRACE logging enabled
        }
        return getMergedProperties(locale).getProperties();
    }
}
