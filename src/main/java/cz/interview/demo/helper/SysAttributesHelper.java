package cz.interview.demo.helper;

import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.domain.entity.basic.SystemAttributes;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class SysAttributesHelper {

  public static void initSysAttributes(Art art){
    SystemAttributes systemAttributes =  new SystemAttributes();
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    systemAttributes.setCts(timestamp);
    art.setSys(systemAttributes);
    art.getArtist().setSys(systemAttributes);
  }

  public static void updateSysAttributes(Art art){
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    art.getSys().setMts(timestamp);
  }


}
