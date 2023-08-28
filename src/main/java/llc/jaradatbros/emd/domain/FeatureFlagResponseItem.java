package llc.jaradatbros.emd.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FeatureFlagResponseItem extends BaseModel {
   private String treatment;
}
