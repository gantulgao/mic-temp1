package mn.isolvers.cif.service.internal.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "zclient")
public class CustomerTypeEntity {

    @Id
    private String Ctype;
    private String Cdesc;
    private String Caccount;
    private String Cc;

}
