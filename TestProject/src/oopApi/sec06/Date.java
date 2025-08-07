package oopApi.sec06;
import java.util.*;
import java.text.SimpleDateFormat;

public class Date {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today.toString());
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy/mm/dd");
		String str = simple.format(today);
		System.out.println(str);
	}

}
