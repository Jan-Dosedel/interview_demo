package cz.interview.demo.helper;


import java.text.SimpleDateFormat;

public class SysAttributesHelper {

  private static final String DATE_FORMAT = "yyyy-MM-dd 'at' HH:mm:ss z";
  private static final SimpleDateFormat STRING_FORMATTER = new SimpleDateFormat(DATE_FORMAT);

  // public static SystemAttributes getCreateSysAttributes(){
  //  SystemAttributes systemAttributes =  new SystemAttributes();
  //   Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
  //   // systemAttributes.setCts(STRING_FORMATTER.format(new Date(System.currentTimeMillis())));
  //   systemAttributes.setCts(timestamp);
  //   return systemAttributes;
  // }

  // public static SystemAttributes convertSysAttributes(){
  //   SystemAttributes attribute =  new SystemAttributes();
  //   Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
  //   attribute.setCts(STRING_FORMATTER.format(new Date(System.currentTimeMillis())));
  //   return attribute;
  // }

}
