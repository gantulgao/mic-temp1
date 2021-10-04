package mn.isolvers.temp.api.v1.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clients {
    private String GID;
    private String ACCN;
    private String LNAME;
    private String BDATE;
    private String PDATE;
    private String LDUN;
    private String LCUR;
    private String Uldegdel;
    private String RESERVED;
    private String Uname;
    private String b1;
    private String BNAME;
    private String b2;
    private String b3;
    private String b4;
    private String b5;
    private String b8;
}
