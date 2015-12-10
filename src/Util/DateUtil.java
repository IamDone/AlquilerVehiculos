package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
public static String format(LocalDateTime l){
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	String formattedDateTime = l.format(formatter);
	return formattedDateTime;
}
}
