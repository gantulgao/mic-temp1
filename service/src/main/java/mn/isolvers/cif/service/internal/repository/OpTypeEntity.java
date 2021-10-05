package mn.isolvers.cif.service.internal.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "zfocus")
public class OpTypeEntity {
   private String Ftype;
   private String Fdesc;
}
