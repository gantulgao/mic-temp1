package mn.isolvers.temp.service.internal.repository;

import mn.isolvers.temp.service.internal.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findByUserId(Integer userId);
}
