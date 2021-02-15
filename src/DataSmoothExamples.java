import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples
{
	LinkedList<Show> shows = new LinkedList<Show>();
	LinkedList<Double> showResults = new LinkedList<Double>();
	DataSmooth1 D1 = new DataSmooth1();
	DataSmooth2 D2 = new DataSmooth2();
	LinkedList<Double> epStarTrek = new LinkedList<>();
	LinkedList<Double> epFuturama = new LinkedList<>();
	LinkedList<Double> epAnimaniacs = new LinkedList<>();
	LinkedList<Double> epSesameStreet = new LinkedList<>();
	LinkedList<Double> AVGShows = new LinkedList<>();

	public DataSmoothExamples() {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));
		shows.add(new Show("Star Trek", 1800, eps1, false));
		epStarTrek.add(eps1.get(0).runTime);
		epStarTrek.add(eps1.get(1).runTime);
		epStarTrek.add(eps1.get(2).runTime);

		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));
		epFuturama.add(eps2.get(0).runTime);
		epFuturama.add(eps2.get(1).runTime);
		epFuturama.add(eps2.get(2).runTime);
		epFuturama.add(eps2.get(3).runTime);

		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		epAnimaniacs.add(eps3.get(0).runTime);
		epAnimaniacs.add(eps3.get(1).runTime);
		epAnimaniacs.add(eps3.get(2).runTime);

		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));
		epSesameStreet.add(eps4.get(0).runTime);
		epSesameStreet.add(eps4.get(1).runTime);
		epSesameStreet.add(eps4.get(2).runTime);

		showResults.add(60.0);
		showResults.add(29.75);
		showResults.add(29.08333);
		showResults.add(58.0);

		AVGShows.add(60.0);
		AVGShows.add(22.25);
		AVGShows.add(7.0);
		AVGShows.add(58.0);
	}

	@Test
	public void instructorTestDS() {
		LinkedList<Double> runtimes = D1.dataSmooth(shows);

		for(int i = 0; i < runtimes.size(); i++)
		{
			assertEquals(runtimes.get(i), showResults.get(i), .01);
		}
	}

	@Test
	public void showAverageStarTrek() {
		assertEquals(60,D1.showAverage(shows.get(0)),0.1);
	}

	@Test
	public void showAverageFuturama() {
		assertEquals(22.25,D1.showAverage(shows.get(1)),0.1);
	}

	@Test
	public void showAverageAnimaniacs() {
		assertEquals(7,D1.showAverage(shows.get(2)),0.1);
	}

	@Test
	public void showAverageSesameStreet() {
		assertEquals(58,D1.showAverage(shows.get(3)),0.1);
	}

	@Test
	public void DataSmooth2Test() {
		LinkedList<Double> runtimes = D2.dataSmooth(shows);

		for(int i = 0; i < runtimes.size(); i++)
		{
			assertEquals(runtimes.get(i), showResults.get(i), .01);
		}
	}

	@Test
	public void getEPrtStarTrek(){
		assertEquals(epStarTrek, D2.getEPrt(shows.get(0).episodes));
	}

	@Test
	public void getEPrtFuturama(){
		assertEquals(epFuturama, D2.getEPrt(shows.get(1).episodes));
	}

	@Test
	public void getEPrtAnimaniacs(){
		assertEquals(epAnimaniacs, D2.getEPrt(shows.get(2).episodes));
	}

	@Test
	public void getEPrtSesameStreet(){
		assertEquals(epSesameStreet, D2.getEPrt(shows.get(3).episodes));
	}

	@Test
	public void getAVRrtStarTrek(){
		assertEquals(60, D2.getAVGrt(epStarTrek), 0.1);
	}

	@Test
	public void getAVRrtFuturama() {
		assertEquals(22.25, D2.getAVGrt(epFuturama), 0.1);
	}

	@Test
	public void getAVRrtAnimaniacs() {
		assertEquals(7, D2.getAVGrt(epAnimaniacs), 0.1);
	}

	@Test
	public void getAVRrtSesameStreet() {
		assertEquals(58, D2.getAVGrt(epSesameStreet), 0.1);
	}

	@Test
	public void AverageShows() {
		assertEquals(AVGShows, D2.AverageShows(shows));
	}


	/*
	Method 1 // Subtasks
	1. Instantiate a new list of raw average runtime and call it averageList.
	2. Loop around the list and add the average runtime of each show into the list of averageList
	   using a helper function to find the average run time of each show.
	3. Loop through the averageList and smooth the data in the middle then add it to the list called smoothList.
	4. Add the first and last data point at the beginning and the end of the smoothList respectively.
	*/

	/*
	Method 2 // Subtasks
	1. Take a list of episodes and make a list of run times from those episodes
	2. Take a list of runtimes and calculate the average run time for those episodes
	3. Creates a list of averages from a list of shows
	4. Create a list of smoothed runtime by using the list of averages
	5. Return the smoothed runtime values
	*/


}