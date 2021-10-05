package mn.isolvers.cif.service.internal.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "client")
public class CustomerEntity {

    @Id
    private int Ccode;
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
    private byte[] Rem;

}
