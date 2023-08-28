package llc.jaradatbros.emd.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import llc.jaradatbros.emd.domain.interfaces.ErrorCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
public class ErrorDTO extends DataTransferObject {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String code;
    private String message;
    @JsonIgnore
    private ErrorCode errorCode;
    private InternalErrorDTO internalErrorDataTransferObject;
    private String internalMessage;

    @Override
    public String toString() {
        try {
            log.info("{" + OBJECT_MAPPER.writeValueAsString(this.errorCode) +"," + this.code + "," + this.message + "," + this.internalMessage + "}");
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch(JsonProcessingException e) {
            log.warn("Encountered {}: {}\nCaused by: {}", e.getClass().getSimpleName(), e.getMessage(), e.getCause());
            return "";
        }catch (Exception e) {
            log.error("Encountered unexpected exception: {}\nCaused by: {}\n{}", e.getMessage(),e.getCause(),e.getStackTrace());
            throw e;
        }
    }

    @Override
    public boolean equals(Object o) {
        if( this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ErrorDTO edto = (ErrorDTO) o;
        return new EqualsBuilder()
            .append(errorCode, edto.errorCode)
            .append(code, edto.code)
            .append(message, edto.message)
            .append(internalMessage, edto.internalMessage)
            .append(internalErrorDataTransferObject, edto.internalErrorDataTransferObject)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(code)
            .append(message)
            .append(errorCode)
            .append(internalMessage)
            .append(internalErrorDataTransferObject)
            .toHashCode();
    }
}
