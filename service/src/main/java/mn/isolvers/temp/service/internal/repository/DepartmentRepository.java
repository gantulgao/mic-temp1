package mn.isolvers.temp.service.internal.repository;

import mn.isolvers.temp.api.v1.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Integer> {
    Department findByUserId(Integer userId);
}
