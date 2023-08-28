package llc.jaradatbros.emd.service.impl;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.springframework.context.NoSuchMessageException;

import llc.jaradatbros.emd.framework.core.support.message.ResourceBundleMessageSource;
import llc.jaradatbros.emd.service.MessageResolverService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MessageResolverServiceImpl implements MessageResolverService {

    private ResourceBundleMessageSource messageSource;

    MessageResolverServiceImpl(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String key, Object[] argsForKey, Locale locale) {
        String message;

        try {
            message = messageSource.getMessage(key, argsForKey, locale);
        } catch(NoSuchMessageException e) {
            message = key;
            log.warn("No message found for key: {}", key);
        }catch (Exception e) {
            log.error("Encountered unexpected exception: {}\nCaused by: {}\n{}", e.getMessage(),e.getCause(),e.getStackTrace());
            throw e;
        }

        return Objects.equals(message, key) ? null : message;
    }

    @Override
    public Map<String, String> getMessages(Locale locale) {
        Properties properties = messageSource.getMessages(locale);
        Map<String, String> messagesMap = new HashMap<>();

        for(Map.Entry<Object,Object> entry:properties.entrySet()) {
            if(entry.getKey() != null && entry.getValue() != null) {
                messagesMap.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        return messagesMap;
    }

}
