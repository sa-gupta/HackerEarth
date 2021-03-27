package com.cg.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTest {

	public static void main(String[] args) {
		new DateTest().testDate();
	}

	public void testDate() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		Month m = ldt.getMonth();
		int day = ldt.getDayOfMonth();
		int sec = ldt.getSecond();
		System.out.println("m-d-s: "+ m+"-"+day+"-"+sec);
		LocalDate ld = ldt.toLocalDate();
		System.out.println("ld: " + ld);
		
		
	}

}
