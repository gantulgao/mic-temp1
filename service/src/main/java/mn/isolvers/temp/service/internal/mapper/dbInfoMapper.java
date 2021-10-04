package mn.isolvers.temp.service.internal.mapper;

import mn.isolvers.temp.api.v1.domain.dbInfo;
import mn.isolvers.temp.service.internal.repository.dbInfoEntity;

public final class dbInfoMapper {

   public static dbInfoEntity map(final dbInfo dbInfo){
       final dbInfoEntity dbInfoEntity = new dbInfoEntity();
       dbInfoEntity.setCcode(dbInfo.getCcode());
       dbInfoEntity.setL0C(dbInfo.getL0C());
      return dbInfoEntity;
   }

   public static dbInfo map(final dbInfoEntity dbInfoEntity){
       final dbInfo dbInfo = new dbInfo();
       dbInfo.setCcode(dbInfoEntity.getCcode());
       dbInfo.setL0C(dbInfoEntity.getL0C());
       dbInfo.setL1C(dbInfoEntity.getL1C());
      return dbInfo;
   }

}
