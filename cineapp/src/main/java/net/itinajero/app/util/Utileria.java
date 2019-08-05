package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Utileria {
	
	/**
	 * Metodo que regresa una Lista de Strings con las fechas siguientes, segun el parametro count
	 * @param count
	 * @return
	 */
	public static List<String> getNextDays(int count){
		List<String> nextDays = new ArrayList<String>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); //Next N days from now
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		while(!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(simpleDateFormat.format(d));
		}
		return nextDays;
	}
}
