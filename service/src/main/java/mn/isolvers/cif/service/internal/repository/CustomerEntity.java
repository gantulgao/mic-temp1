package mn.isolvers.cif.service.internal.repository;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "client")
public class CustomerEntity {

    @Id
    @Column(name = "Ccode")
    private int ccode;
    @Column(name = "Cfname")
    private String cfname;
    @Column(name = "Cname")
    private String cname;
    @Column(name = "Creg")
    private String creg;
    @Column(name = "Cpass")
    private String cpass;
    @Column(name = "Ctype")
    private String ctype;
    @Column(name = "Cfocus")
    private String cfocus;
    @Column(name = "Caddress")
    private String caddress;
    @Column(name = "Cphone")
    private String cphone;
    @Column(name = "Cfax")
    private String cfax;
    @Column(name = "Cemail")
    private String cemail;
    @Column(name = "Cdate")
    private LocalDateTime cdate;
    @Column(name = "Cucode")
    private String cucode;
//    @Column(name = "Rem")
//    private byte[] rem;

}
