package mn.isolvers.cif.service.internal.mapper;

import mn.isolvers.cif.api.v1.domain.User;
import mn.isolvers.cif.service.internal.repository.UserEntity;

public final class UserMapper {

   public static UserEntity map(final User user){
      final UserEntity userEntity = new UserEntity();
      userEntity.setId(user.getId());
      userEntity.setAge(user.getAge());
      userEntity.setName(user.getName());
      userEntity.setSalary(user.getSalary());
      return userEntity;
   }

   public static User map(final UserEntity userEntity){
      final User user = new User();
      user.setId(userEntity.getId());
      user.setAge(userEntity.getAge());
      user.setName(userEntity.getName());
      user.setSalary(userEntity.getSalary());
      return user;
   }

}
