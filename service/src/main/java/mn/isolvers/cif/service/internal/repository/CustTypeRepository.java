package mn.isolvers.cif.service.internal.repository;

import mn.isolvers.cif.api.v1.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustTypeRepository extends JpaRepository<CustomerTypeEntity, String> {

}
