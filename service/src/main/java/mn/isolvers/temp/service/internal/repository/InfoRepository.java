package mn.isolvers.temp.service.internal.repository;

import mn.isolvers.temp.service.internal.model.dbInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends CrudRepository<dbInfo,Integer> {
   Optional<dbInfo> findById(Integer id);
}
