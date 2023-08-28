package llc.jaradatbros.emd.domain.enums;

import java.util.HashMap;
import java.util.Map;

import llc.jaradatbros.emd.domain.interfaces.ErrorCode;

public enum ErrorCodeEnum implements ErrorCode {
    UNEXPECTED_DOWNSTREAM_ERROR("error.downstream.unexpected"),
    UNEXPECTED_RUNTIME_ERROR("error.downstream.runtime");

    private static Map<String, ErrorCodeEnum> errorCodes = new HashMap<>();
    private String key;

    ErrorCodeEnum(String key) {
        this.key = key;
    }

    static {
        for(ErrorCodeEnum errorCode: ErrorCodeEnum.values()) {
            errorCodes.put(errorCode.getKey(),errorCode);
        }
    }

    public ErrorCodeEnum getErrorCode(final String key) {
        return errorCodes.get(key);
    }

    public ErrorCodeEnum[] getErrorCodes() {
        return (ErrorCodeEnum[]) errorCodes.values().toArray();
    }

    public String getKey() {
        return key;
    }
}
