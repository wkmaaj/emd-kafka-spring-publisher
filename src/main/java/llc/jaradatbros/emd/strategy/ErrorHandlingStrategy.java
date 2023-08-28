package llc.jaradatbros.emd.strategy;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;

import llc.jaradatbros.emd.domain.GenericDTO;

public interface ErrorHandlingStrategy<T> {
    GenericDTO<T> handleError(String response, HttpStatusCode httpStatusCode, HttpHeaders httpHeaders);
}
