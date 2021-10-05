package mn.isolvers.cif.service.internal.mapper;

import mn.isolvers.cif.api.v1.domain.CustomerType;
import mn.isolvers.cif.service.internal.repository.CustomerTypeEntity;

public final class CustTypeMapper {

   public static CustomerTypeEntity map(final CustomerType domain){
      final CustomerTypeEntity entity = new CustomerTypeEntity();
      entity.setCtype(domain.getCtype());
      entity.setCaccount(domain.getCaccount());
      entity.setCc(domain.getCc());
      entity.setCdesc(domain.getCdesc());
      return entity;
   }

   public static CustomerType map(final CustomerTypeEntity entity){
      final CustomerType domain = CustomerType.of();
       domain.setCtype(entity.getCtype());
       domain.setCaccount(entity.getCaccount());
       domain.setCc(entity.getCc());
       domain.setCdesc(entity.getCdesc());
      return domain;
   }

}
