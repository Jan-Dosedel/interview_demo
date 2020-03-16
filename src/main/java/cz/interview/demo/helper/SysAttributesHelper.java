package cz.interview.demo.helper;

import cz.interview.demo.service.domain.entity.Art;
import cz.interview.demo.service.domain.entity.basic.SystemAttributes;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

/**
 * Helper with static method for work with the system attributes {@SystemAttributes}.
 */
public final class SysAttributesHelper {

  /**
   * Initializes system attributes for given art entity. It set creation timestamp to actual date.
   *
   * @param art art entity where new system attributes should be initialized.
   */
  public static void initSysAttributes(Art art) {
    SystemAttributes systemAttributes = new SystemAttributes();
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    systemAttributes.setCts(timestamp);
    art.setSys(systemAttributes);
    art.getArtist().setSys(systemAttributes);
  }

  /**
   * Updates system attributes for given art entity. It set modification timestamp to actual date.
   *
   * @param art art entity where new system attributes should be initialized.
   */
  public static void updateSysAttributes(Art art) {
    Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
    art.getSys().setMts(timestamp);
  }


}
