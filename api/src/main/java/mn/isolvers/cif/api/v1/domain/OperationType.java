package mn.isolvers.cif.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(staticName = "of")
@Builder
public class OperationType {
   private String Ftype;
   private String Fdesc;
}
