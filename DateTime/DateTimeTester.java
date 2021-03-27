package com.cg.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTimeTester {

	public static void main(String[] args) {
		DateTimeTester tester = new DateTimeTester();
		//tester.testLocalDateTime();
		//tester.testZonedDateTime();
//		tester.testChromoUnits();
		tester.testPeriod();
		//tester.testDuration();
//		tester.testAdjusters();
	}
	public void testAdjusters() {
		LocalDate now = LocalDate.now();
		LocalDate date1 = LocalDate.of(now.getYear(), now.getMonthValue(), 1);
		LocalDate secondSat = date1.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println(secondSat);
		// find second saturday of the month
	}
	public void testDuration() {
		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);
		LocalTime time2 = time1.plus(twoHours);
		Duration duration = Duration.between(time1, time2);
		System.out.println(duration);
		
	}
	public void testPeriod() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.parse("2017-03-15");
		Period period = Period.between(date2, date1);
		System.out.println(ChronoUnit.YEARS.between(date2, date1));
		
	}
	// PT2H, PT1H30M : ISO 8601 format
	public void testChromoUnits() {
		LocalDate today = LocalDate.now();
		LocalDate nxtWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println(nxtWeek);
		LocalDate nxtMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println(nxtMonth);
		LocalDate nxtYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println(nxtYear);
		LocalDate nxtDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println(nxtDecade);
		// try year, decade,...
	}
	public void testZonedDateTime() {
		ZonedDateTime date1 = ZonedDateTime
				.parse("2017-12-03T10:15:25+05:30[Asia/Calcutta]");
		System.out.println(date1);
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println(id);
		ZoneId currZone = ZoneId.systemDefault();
		System.out.println(currZone);
	}
	// ISO 8601 format is used 
	public void testLocalDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime date1 = ldt.withDayOfMonth(10).withMonth(4).withYear(2019);
		System.out.println(date1);
		LocalDate date2 = LocalDate.of(2018, Month.DECEMBER, 12);
		System.out.println(date2);
		LocalTime time1 = LocalTime.of(22, 15);
		System.out.println(time1);
		LocalTime time2 = LocalTime.parse("20:15:30");
		System.out.println(time2);
		
	}

}
