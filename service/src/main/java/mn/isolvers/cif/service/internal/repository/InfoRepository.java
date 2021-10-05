package mn.isolvers.cif.service.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InfoRepository extends JpaRepository<dbInfoEntity,Integer> {
   Optional<dbInfoEntity> findById(Integer id);
}
