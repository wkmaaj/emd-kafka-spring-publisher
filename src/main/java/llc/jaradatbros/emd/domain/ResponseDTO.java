package llc.jaradatbros.emd.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import llc.jaradatbros.emd.domain.enums.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO<T extends BaseModel> extends BaseDTO<T> {

    @NonNull
    private ResponseStatusEnum responseStatus;

    @NonNull
    private T data;

    private List<ErrorDTO> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, FeatureFlagResponseItem> featureFlags;

    @JsonIgnore
    private Class<?> dataType;

    ResponseDTO() {
        this.responseStatus = ResponseStatusEnum.ERROR;
        this.data = null;
        this.errors = new ArrayList<>();
        this.featureFlags = new HashMap<>();
        this.dataType = this.getClass();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        List<ErrorDTO> errors
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.errors = errors;
        this.featureFlags = new HashMap<>();
        this.dataType = this.getClass();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.featureFlags = featureFlags;
        this.errors = new ArrayList<>();
        this.dataType = this.getClass();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        Class<?> dataType
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.dataType = dataType;
        this.errors = new ArrayList<>();
        this.featureFlags = new HashMap<>();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        List<ErrorDTO> errors,
        Map<String, FeatureFlagResponseItem> featureFlags
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.errors = errors;
        this.featureFlags = featureFlags;
        this.dataType = this.getClass();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        List<ErrorDTO> errors,
        Class<?> dataType
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.errors = errors;
        this.dataType = dataType;
        this.featureFlags = new HashMap<>();
    }

    public ResponseDTO(
        ResponseStatusEnum responseStatus,
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        this.responseStatus = responseStatus;
        this.data = data;
        this.featureFlags = featureFlags;
        this.dataType = dataType;
        this.errors = new ArrayList<>();
    }

    private static <T extends BaseModel> ResponseDTO<T> generateDTO(
        ResponseStatusEnum responseStatus,
        T data,
        List<ErrorDTO> errors,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return new ResponseDTO<T>(responseStatus, data, errors, featureFlags, dataType);
    }

    protected static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data,
        List<ErrorDTO> errors,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return generateDTO(
            ResponseStatusEnum.SUCCESS,
            data,
            errors,
            featureFlags,
            dataType);
    }

    protected static <T extends BaseModel> ResponseDTO<T> forError(
        T data,
        List<ErrorDTO> errors,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return generateDTO(
            ResponseStatusEnum.ERROR,
            data,
            errors,
            featureFlags,
            dataType);
    }

    protected static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data,
        List<ErrorDTO> errors,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return generateDTO(
            ResponseStatusEnum.PARTIAL,
            data,
            errors,
            featureFlags,
            dataType);
    }

    static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data
    ) {
        return forSuccess(data, new ArrayList<>(), new HashMap<>(), data.getClass());
    }

    static <T extends BaseModel> ResponseDTO<T> forError(
        T data
    ) {
        return forError(data, new ArrayList<>(), new HashMap<>(), data.getClass());
    }

    static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data
    ) {
        return forPartial(data, new ArrayList<>(), new HashMap<>(), data.getClass());
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data,
        Class<?> dataType
    ) {
        return forSuccess(data, new ArrayList<>(), new HashMap<>(), dataType);
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forError(
        T data,
        Class<?> dataType
    ) {
        return forError(data, new ArrayList<>(), new HashMap<>(), dataType);
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data,
        Class<?> dataType
    ) {
        return forPartial(data, new ArrayList<>(), new HashMap<>(), dataType);
    }

    public static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data,
        List<ErrorDTO> errors
    ) {
        return forSuccess(data, errors, new HashMap<>(), data.getClass());
    }

    public static <T extends BaseModel> ResponseDTO<T> forError(
        T data,
        List<ErrorDTO> errors
    ) {
        return forError(data, errors, new HashMap<>(), data.getClass());
    }

    public static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data,
        List<ErrorDTO> errors
    ) {
        return forPartial(data, errors, new HashMap<>(), data.getClass());
    }

    public static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags
    ) {
        return forSuccess(data, new ArrayList<>(), featureFlags, data.getClass());
    }

    public static <T extends BaseModel> ResponseDTO<T> forError(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags
    ) {
        return forError(data, new ArrayList<>(), featureFlags, data.getClass());
    }

    public static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags
    ) {
        return forPartial(data, new ArrayList<>(), featureFlags, data.getClass());
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forSuccess(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return forSuccess(data, new ArrayList<>(), featureFlags, dataType);
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forError(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return forError(data, new ArrayList<>(), featureFlags, dataType);
    }

    @Deprecated
    public static <T extends BaseModel> ResponseDTO<T> forPartial(
        T data,
        Map<String, FeatureFlagResponseItem> featureFlags,
        Class<?> dataType
    ) {
        return forPartial(data, new ArrayList<>(), featureFlags, dataType);
    }
}
