import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	ShowManager2 sm2 = new ShowManager2();
	LinkedList<Show> shows = new LinkedList<Show>();
	LinkedList<Show> shows1 = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	ShowSummary report2 = new ShowSummary();
	LinkedList<Show> dtExpected = new LinkedList<Show>();
	LinkedList<Show> ptExpected = new LinkedList<Show>();
	LinkedList<Show> lnExpected = new LinkedList<Show>();
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1, false);
		shows.add(s1);
		shows1.add(s1);
		report1.primetime.add(s1);
		report2.primetime.add(s1);
		ptExpected.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2, false);
		shows.add(s2);
		report1.primetime.add(s2);
		ptExpected.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3, false);
		shows.add(s3);
		shows1.add(s3);
		report1.daytime.add(s3);
		report2.daytime.add(s3);
		dtExpected.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4, false);
		shows.add(s4);
		report1.daytime.add(s4);
		dtExpected.add(s4);
	}
	
	@Test
	public void instructorTestOrganizeShows() {
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}

	@Test public void dayTimeTestsm1(){
		LinkedList<Show> dt = sm1.getDaytime(shows);
		assertEquals(dt, dtExpected);
	}

	@Test public void primeTimeTestsm1(){
		LinkedList<Show> pt = sm1.getPrimetime(shows);
		assertEquals(pt, ptExpected);
	}

	@Test public void lateNightTestsm1(){
		LinkedList<Show> ln = sm1.getLateNight(shows);
		assertEquals(ln, lnExpected);
	}

	@Test
	public void showManager2Test() {
		ShowSummary report2 = sm2.organizeShows(shows);
		assertEquals(report1, report2);
	}

	@Test
	public void showManager2Test2() {
		ShowSummary report = sm2.organizeShows(shows1);
		assertEquals(report2, report);
	}


	/*
	Method 1 // Subtask
	1. Create a method for list of non-special daytime shows.
	2. Create a method for list of non-special primetime shows.
	3. Create a method for list of non-special latenight shows.
	4. Instantiate 3 lists of non-special daytime, primetime, and latenight shows.
	5. Add the lists of shows to a show summary and return the show summary.
	 */

	/*
	Method 2 // Subtask
	1. Clean the list of shows by removing all the special and other shows
	2. Instantiate 3 lists of daytime shows, primetime shows, and latenight show.
	3. Loop through the clean list and add shows to daytime, primetime, and latenight list according to the broadcast time.
	4. Add the lists of shows to a show summary, then return the show summary.
	 */

}
