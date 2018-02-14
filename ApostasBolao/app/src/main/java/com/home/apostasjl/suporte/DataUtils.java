package com.home.apostasjl.suporte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;



public class DataUtils {

	
	private static final String TIME_ZONE = "GMT-3";
	
	public static Date converterData() {
		
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));

		//Local time zone   
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

		//Time in GMT		
		Date data = null;
		
		try {
			
			
			data = dateFormatLocal.parse( dateFormatGmt.format(new Date()));		
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static String converterData(Date data) {
		
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
		
		return dateFormatGmt.format(data);
	}
	
	

	
}
