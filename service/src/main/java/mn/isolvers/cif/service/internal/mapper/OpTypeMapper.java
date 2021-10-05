package mn.isolvers.cif.service.internal.mapper;

import mn.isolvers.cif.api.v1.domain.OperationType;
import mn.isolvers.cif.service.internal.repository.OpTypeEntity;

public final class OpTypeMapper {

   public static OpTypeEntity map(final OperationType domain){
      final OpTypeEntity entity = new OpTypeEntity();
      entity.setFtype(domain.getFtype());
      entity.setFdesc(domain.getFdesc());
      return entity;
   }

   public static OperationType map(final OpTypeEntity entity){
      final OperationType domain = OperationType.of();
       domain.setFdesc(entity.getFdesc());
       domain.setFtype(entity.getFtype());
      return domain;
   }

}
