package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;
public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		int day = 12;
		int month = 10;
		int year = 2018;
		GregorianCalendar g = new GregorianCalendar(year, month, day);
		CalDay cal = new CalDay(g);
		//cal.setDay(day);
		//cal.setMonth(month);
		//cal.setYear(year);
		 assertTrue(cal.isValid());
		assertEquals(12, cal.getDay());
		assertEquals(10, cal.getMonth());
		assertEquals(2018, cal.getYear());
		CalDay cal1 = new CalDay();
		assertFalse(cal1.isValid());
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int hour1=12;
		 int minute1=20;
		 int day1=19;
		 int month1=9;
		 int year1=2018;
		 String title1="Start of School";
		 String description1="I hope I pass";
		 Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		 LinkedList<Appt> apptsList = new LinkedList<Appt>();
		 int day = 12;
		 int month = 10;
		 int year = 2018;
		 GregorianCalendar g = new GregorianCalendar(year, month, day);
		 CalDay cal = new CalDay(g);
		 assertTrue(cal.getAppts().isEmpty());
		 cal.addAppt(app);
		 assertFalse(cal.getAppts().isEmpty());
		 assertTrue(app.getValid());

	 }
	 @Test
		public void test03() throws Throwable {
		 int day = 12;
		 int month = 10;
		 int year = 2018;
		 GregorianCalendar g = new GregorianCalendar(year, month, day);
		 CalDay cal = new CalDay(g);
		 assertEquals( "\t --- 10/12/2018 --- \n --- -------- Appointments ------------ --- \n\n", cal.toString());
		 int hour1=12;
		 int minute1=20;
		 int day1=19;
		 int month1=9;
		 int year1=2018;
		 String title1="Start of School";
		 String description1="I hope I pass";
		 Appt app = new Appt(hour1, minute1 ,day1 ,month1 ,year1 ,title1, description1);
		 int hour2 = 14;
		 int minute2 = 30;
		 int day2 = 18;
		 int month2 = 3;
		 int year2 = 2018;
		 String startTitle2="Study";
		 String startDescription2="Test on Tuesday!";
		 Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		 cal.addAppt(app);
		 cal.addAppt(app2);
		 assertEquals("\t --- 10/12/2018 --- \n --- -------- Appointments ------------ --- \n\t9/19/2018 at 12:20pm ,Start of School, I hope I pass\n \t3/18/2018 at 2:30pm ,Study, Test on Tuesday!\n \n", cal.toString());
		 assertTrue(cal.iterator().hasNext());
		 assertEquals(2, cal.getSizeAppts());
	 }



//add more unit tests as you needed	
}
