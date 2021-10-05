package mn.isolvers.cif.service.internal.repository;

import mn.isolvers.cif.api.v1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustEntityRepository extends JpaRepository<CustomerEntity, Integer> {

    @Query(value = "select max(ccode) from client where ccode < 10000",nativeQuery = true)
    Optional<Integer> getMaxOrig();

    @Query(value = "select max(ccode) from client where ccode > 10000",nativeQuery = true)
    Optional<Integer> getMaxCust();

    Optional<CustomerEntity> findByCreg(String creg);

}
