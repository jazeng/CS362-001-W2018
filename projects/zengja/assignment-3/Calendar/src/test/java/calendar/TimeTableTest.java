package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable time = new TimeTable();
		 LinkedList<CalDay> cals = new LinkedList<CalDay>();
		 int hour1=12;
		 int minute1=20;
		 int day1=19;
		 int month1=9;
		 int year1=2018;
		 String title1="Start of School";
		 String description1="I hope I pass";
		 Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		 int day = 12;
		 int month = 12;
		 int year = 2018;
		 LinkedList<Appt> apptsList = new LinkedList<Appt>();
		 GregorianCalendar startDay = new GregorianCalendar(year, month, day);
		 CalDay cal = new CalDay(startDay);
		 int hour2 = 14;
		 int minute2 = 30;
		 int day2 = 18;
		 int month2 = 3;
		 int year2 = 2018;
		 String startTitle2="Study";
		 String startDescription2="Test on Tuesday!";
		 Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		 int Day = 15;
		 int Month = 12;
		 int Year = 2018;
		 GregorianCalendar endDay = new GregorianCalendar(Year, Month, Day);
		 CalDay cal2 = new CalDay(endDay);
		 apptsList.add(app);
		 apptsList.add(app2);
		 assertEquals("[\t --- 0/12/2019 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n" +
				 ", \t --- 0/13/2019 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n" +
				 ", \t --- 0/14/2019 --- \n" +
				 " --- -------- Appointments ------------ --- \n" +
				 "\n" +
				 "]", time.getApptRange(apptsList, startDay, endDay).toString());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 TimeTable time = new TimeTable();
		 LinkedList<CalDay> cals = new LinkedList<CalDay>();
		 int hour1=12;
		 int minute1=20;
		 int day1=19;
		 int month1=9;
		 int year1=2018;
		 String title1="Start of School";
		 String description1="I hope I pass";
		 Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		 int day = 12;
		 int month = 12;
		 int year = 2018;
		 LinkedList<Appt> apptsList = new LinkedList<Appt>();
		 GregorianCalendar startDay = new GregorianCalendar(year, month, day);
		 CalDay cal = new CalDay(startDay);
		 int hour2 = 14;
		 int minute2 = 30;
		 int day2 = 18;
		 int month2 = 3;
		 int year2 = 2018;
		 String startTitle2="Study";
		 String startDescription2="Test on Tuesday!";
		 Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		 int Day = 15;
		 int Month = 12;
		 int Year = 2018;
		 GregorianCalendar endDay = new GregorianCalendar(Year, Month, Day);
		 CalDay cal2 = new CalDay(endDay);
		 apptsList.add(app);
		 apptsList.add(app2);
		 int[] pv = {1,0};
		 assertEquals("[\t9/19/2018 at 12:20pm ,Start of School, I hope I pass\n" +
				 ", \t3/18/2018 at 2:30pm ,Study, Test on Tuesday!\n" +
				 "]", time.permute(apptsList, pv).toString());
	 }
	 @Test
		public void test03() throws Throwable {
		TimeTable time = new TimeTable();
		LinkedList<CalDay> cals = new LinkedList<CalDay>();
		int hour1=12;
		int minute1=20;
		int day1=19;
		int month1=9;
		int year1=2018;
		String title1="Start of School";
		String description1="I hope I pass";
		Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		int day = 12;
		int month = 12;
		int year = 2018;
		LinkedList<Appt> apptsList = new LinkedList<Appt>();
		GregorianCalendar startDay = new GregorianCalendar(year, month, day);
		CalDay cal = new CalDay(startDay);
		int hour2 = 14;
		int minute2 = 30;
		int day2 = 100;
		int month2 = 3;
		int year2 = 2018;
		String startTitle2="Study";
		String startDescription2="Test on Tuesday!";
		Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		int Day = 15;
		int Month = 12;
		int Year = 2018;
		Appt app3 = null;
		GregorianCalendar endDay = new GregorianCalendar(Year, Month, Day);
		CalDay cal2 = new CalDay(endDay);
		assertEquals(null, time.deleteAppt(apptsList, app));
		apptsList.add(app);
		assertEquals(null, time.deleteAppt(apptsList, app2));
		 assertEquals(null, time.deleteAppt(apptsList, app3));
		apptsList.add(app2);
		 assertEquals(null, time.deleteAppt(apptsList, app2));
		assertEquals(null, time.deleteAppt(apptsList, app3));
	}
	@Test
		public void test04() throws Throwable{
		TimeTable time = new TimeTable();
		LinkedList<CalDay> cals = new LinkedList<CalDay>();
		int hour1=12;
		int minute1=20;
		int day1=19;
		int month1=9;
		int year1=2018;
		String title1="Start of School";
		String description1="I hope I pass";
		Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		int day = 12;
		int month = 12;
		int year = 2018;
		LinkedList<Appt> apptsList = new LinkedList<Appt>();
		GregorianCalendar startDay = new GregorianCalendar(year, month, day);
		CalDay cal = new CalDay(startDay);
		int hour2 = 14;
		int minute2 = 30;
		int day2 = 18;
		int month2 = 3;
		int year2 = 2018;
		String startTitle2="Study";
		String startDescription2="Test on Tuesday!";
		Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		int Day = 15;
		int Month = 12;
		int Year = 2018;
		GregorianCalendar endDay = new GregorianCalendar(Year, Month, Day);
		CalDay cal2 = new CalDay(endDay);
		apptsList.add(app);
		apptsList.add(app2);
		assertEquals("[\t9/19/2018 at 12:20pm ,Start of School, I hope I pass\n" +
				"]", time.deleteAppt(apptsList, app2).toString());
	}
//add more unit tests as you needed
}
