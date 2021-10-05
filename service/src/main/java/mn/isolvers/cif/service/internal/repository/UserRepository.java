package mn.isolvers.cif.service.internal.repository;

import mn.isolvers.cif.api.v1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from users where age >= $1",nativeQuery = true)
    Optional<User> findByAge(int age);

    @Query(value = "exec getUser :id",nativeQuery = true)
    User getUser(int id);

}
