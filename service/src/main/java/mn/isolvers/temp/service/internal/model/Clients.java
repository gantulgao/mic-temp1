package mn.isolvers.temp.service.internal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gantulga.o
 * @date 2021-10-03
 */
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
