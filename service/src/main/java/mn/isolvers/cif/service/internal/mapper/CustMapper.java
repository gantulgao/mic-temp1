package mn.isolvers.cif.service.internal.mapper;

import mn.isolvers.cif.api.v1.domain.Customer;
import mn.isolvers.cif.api.v1.domain.CustomerType;
import mn.isolvers.cif.service.internal.repository.CustomerEntity;
import mn.isolvers.cif.service.internal.repository.CustomerTypeEntity;

public final class CustMapper {

   public static CustomerEntity map(final Customer domain){
      final CustomerEntity entity = new CustomerEntity();
      entity.setCcode(domain.getCcode());
      entity.setCaddress(domain.getCaddress());
      entity.setCdate(domain.getCdate());
      entity.setCemail(domain.getCemail());
      entity.setCfax(domain.getCfax());
      entity.setCfname(domain.getCfname());
      entity.setCfocus(domain.getCfocus());
      entity.setCname(domain.getCname());
      entity.setCpass(domain.getCpass());
      entity.setCphone(domain.getCphone());
      entity.setCreg(domain.getCreg());
      entity.setCtype(domain.getCtype());
      entity.setCucode(domain.getCucode());
      entity.setRem(domain.getRem());
      return entity;
   }

   public static Customer map(final CustomerEntity domain){
      final Customer entity = Customer.of();
       entity.setCcode(domain.getCcode());
       entity.setCaddress(domain.getCaddress());
       entity.setCdate(domain.getCdate());
       entity.setCemail(domain.getCemail());
       entity.setCfax(domain.getCfax());
       entity.setCfname(domain.getCfname());
       entity.setCfocus(domain.getCfocus());
       entity.setCname(domain.getCname());
       entity.setCpass(domain.getCpass());
       entity.setCphone(domain.getCphone());
       entity.setCreg(domain.getCreg());
       entity.setCtype(domain.getCtype());
       entity.setCucode(domain.getCucode());
       entity.setRem(domain.getRem());
      return entity;
   }

}
