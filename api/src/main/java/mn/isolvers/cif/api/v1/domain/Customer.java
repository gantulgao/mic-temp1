package mn.isolvers.cif.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(staticName = "of")
@Builder
public class Customer {

    private Integer Ccode;
    private String Cfname;
    private String Cname;
    private String Creg;
    private String Cpass;
    private String Ctype;
    private String Cfocus;
    private String Caddress;
    private String Cphone;
    private String  Cfax;
    private String Cemail;
    private LocalDateTime Cdate;
    private String Cucode;
//    private byte[] Rem;

}
