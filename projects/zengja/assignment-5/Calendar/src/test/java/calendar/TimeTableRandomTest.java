package calendar;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
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
				int startHour1=ValuesGenerator.RandInt(random);
				int startMinute1=ValuesGenerator.RandInt(random);
				int startDay1=ValuesGenerator.RandInt(random);
				int startMonth1=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear1=ValuesGenerator.RandInt(random);
				String title1="Birthday Party";
				String description1="This is my birthday party.";
				//Construct a new Appointment object with the initial data
				Appt appt1 = new Appt(startHour1,
						startMinute1 ,
						startDay1 ,
						startMonth1 ,
						startYear1 ,
						title1,
						description1);
				int day=ValuesGenerator.getRandomIntBetween(random, 1, 10);
				int month=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int year=ValuesGenerator.getRandomIntBetween(random, 1, 20);
				GregorianCalendar g = new GregorianCalendar(year, month, day);
				CalDay cal = new CalDay(g);
				int day1=ValuesGenerator.getRandomIntBetween(random, 11, 20);
				GregorianCalendar g1 = new GregorianCalendar(year, month, day1);
				TimeTable time = new TimeTable();
				LinkedList <Appt> appts = new LinkedList <Appt>();
				cal.addAppt(appt);
				cal.addAppt(appt1);
				appts.add(appt);
				appts.add(appt);
				appts.add(appt1);
				appts.add(appt1);
				if(!appt.getValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					if (methodName.equals("setTitle")){
						String newTitle=(String) ValuesGenerator.getString(random);
						appt.setTitle(newTitle);
						time.getApptRange(appts, g, g1);
						time.deleteAppt(appts, appt);
						time.deleteAppt(appts, appt1);
						time.deleteAppt(appts,null);
					}

				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}


	
}
