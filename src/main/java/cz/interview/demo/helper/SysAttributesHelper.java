package cz.interview.demo.helper;

import cz.interview.demo.service.domain.entity.basic.SystemAttributes;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class SysAttributesHelper {

  public static SystemAttributes getCreateSysAttributes(){
   SystemAttributes systemAttributes =  new SystemAttributes();
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    systemAttributes.setCts(timestamp);
    return systemAttributes;
  }

  public static SystemAttributes updateSysAttributes(SystemAttributes systemAttributes){
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    systemAttributes.setMts(timestamp);
    return systemAttributes;
  }

}
