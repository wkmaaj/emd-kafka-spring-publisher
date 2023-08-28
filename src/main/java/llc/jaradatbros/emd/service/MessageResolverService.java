package llc.jaradatbros.emd.service;

import java.util.Locale;
import java.util.Map;

/**
 * Interface that defines the methods that supports retrieving locale specific messages from message sources.
 */
public interface MessageResolverService {
    /**
     * @param key        the key to lookup, such as 'calculator.noRateSet'
     * @param argsForKey an array of arguments that will be filled in for params within
     *                   the message (params look like "{0}", "{1,date}", "{2,time}" within a message),
     *                   or {@code null} if none
     * @param locale     the locale in which to do the lookup
     *
     * @return           the resolved message
     */
    String getMessage(String key, Object[] argsForKey, Locale locale);

    /**
     * @param locale the locale in which to do the lookup
     * @return       the resolved messages
     */
    @Deprecated
    Map<String, String> getMessages(Locale locale);
}
