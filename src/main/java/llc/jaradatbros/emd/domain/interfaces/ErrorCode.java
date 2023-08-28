package llc.jaradatbros.emd.domain.interfaces;

import java.io.Serializable;

public interface ErrorCode extends Serializable {
    String getKey();

    enum Default implements ErrorCode {
        UNMAPPED_ERROR;

        @Override
        public String getKey() {
            return this.name();
        }
    }
}
