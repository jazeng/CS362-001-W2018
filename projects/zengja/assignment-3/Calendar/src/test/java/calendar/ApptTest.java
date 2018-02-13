package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {

	 	int startHour=9;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 int[] array = new int[0];
		 int recurBy = 2;
		 int recurIncrement = 1;
		 int recurNumber = 1;

		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 appt.setRecurrence(array, recurBy, recurIncrement, recurNumber);
		 // assertions
		 assertTrue(appt.isRecurring());
		 assertEquals(1, appt.getRecurIncrement());
		 assertEquals(2, appt.getRecurBy());
		 assertEquals(1, appt.getRecurNumber());

	 }
	@Test
	public void test03() throws Throwable {
		int hour2 = 29;
		int minute2 = 30;
		int day2 = 18;
		int month2 = 3;
		int year2 = 2018;
		String startTitle2="Study";
		String startDescription2="Test on Tuesday!";
		Appt app2 = new Appt(hour2, minute2 ,day2 ,month2 ,year2 ,startTitle2, startDescription2);
		assertFalse(app2.getValid());
		app2.setStartMonth(1);
		app2.setStartDay(1);
		app2.setStartMinute(0);
		app2.setStartHour(0);
		assertTrue(app2.getValid());
		app2.setStartMonth(12);
		int NumDaysInMonth= CalendarUtil.NumDaysInMonth(app2.getStartYear(),app2.getStartMonth()-1);
		app2.setStartDay(NumDaysInMonth);
		app2.setStartMinute(59);
		app2.setStartHour(23);
		assertTrue(app2.getValid());
		app2.setStartHour(12);
		assertTrue(app2.getValid());
		app2.setStartDay(40);
		assertFalse(app2.getValid());
		app2.setStartMinute(63);
		assertFalse(app2.getValid());
	}
	 
	@Test
	public void test05() throws Throwable {
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
		assertEquals(-5, app.compareTo(app2));

	}

//add more unit tests as you needed
	
}
