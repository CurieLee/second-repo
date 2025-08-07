package oopApi.sec06;
import java.time.LocalDateTime;
import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		}
		
		int amPm = now.get(Calendar.AM_PM);
		String strAMPM = null;
		
		LocalDateTime n = LocalDateTime.now();
		System.out.println(n.getYear() + "년" + n.getMonthValue() + "월");
		
	}

}
