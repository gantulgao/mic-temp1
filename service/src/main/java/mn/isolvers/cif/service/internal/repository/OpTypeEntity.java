package mn.isolvers.cif.service.internal.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "zfocus")
public class OpTypeEntity {
    @Id
   private String Ftype;
   private String Fdesc;
}
