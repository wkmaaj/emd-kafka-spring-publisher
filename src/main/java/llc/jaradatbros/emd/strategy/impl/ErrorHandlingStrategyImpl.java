package llc.jaradatbros.emd.strategy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.databind.ObjectMapper;

import llc.jaradatbros.emd.domain.GenericDTO;
import llc.jaradatbros.emd.service.MessageResolverService;
import llc.jaradatbros.emd.strategy.ErrorHandlingStrategy;

public class ErrorHandlingStrategyImpl<T> implements ErrorHandlingStrategy<T> {
    private MessageResolverService messageResolverService;

    @Autowired
    ErrorHandlingStrategyImpl(MessageResolverService messageResolverService) {
        this.messageResolverService = messageResolverService;
    }

    public GenericDTO<T> handleError(String response, HttpStatusCode httpStatusCode, HttpHeaders httpHeaders) {
        var mapper = new ObjectMapper();
        try {
            GenericDTO<T> errorResponse = mapper.readValue(response, GenericDTO.class);
            String code = "http" + httpStatusCode.value();
            String errorValue = messageResolverService.getMessage(code, null, LocaleContextHolder.getLocale());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
