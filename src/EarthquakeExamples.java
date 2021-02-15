import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();

  Earthquake1 E2 = new Earthquake1();
  LinkedList<Double> noData2 = new LinkedList<Double>();
  LinkedList<Double> threeDates2 = new LinkedList<Double>();
  LinkedList<MaxHzReport> DecReports2 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NovReports2 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> NovReports3 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> trueNovReport = new LinkedList<MaxHzReport>();

  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
    OctReports.add(new MaxHzReport(20151013.0, 10.0));
    OctReports.add(new MaxHzReport(20151020.0, 50.0));


    threeDates2.add(20151113.0);
    threeDates2.add(20.0);
    threeDates2.add(5.0);
    threeDates2.add(20151120.0);
    threeDates2.add(40.0);
    threeDates2.add(50.0);
    threeDates2.add(45.0);
    threeDates2.add(20151202.0);
    threeDates2.add(12.0);
    threeDates2.add(49.0);
    threeDates2.add(22.0);
    threeDates2.add(11.0);

    DecReports2.add(new MaxHzReport(20151202.0,49.0));
    NovReports2.add(new MaxHzReport(20151113,20));
    NovReports3.add(new MaxHzReport(20151120,50));

    trueNovReport.add(new MaxHzReport(20151113,20));
    trueNovReport.add(new MaxHzReport(20151120,50));
  }

  @Test
  public void instructorTestEQ() {
    assertEquals(NovReports,
            E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void OctReportTestEQ() {
    assertEquals(OctReports,
            E1.dailyMaxForMonth(threeDates, 10));
  }

  @Test
  public void test2EQ(){
    assertEquals(DecReports2, E2.dailyMaxForMonth(threeDates2,12));
  }
  @Test
  public void test3EQ(){
    assertEquals(trueNovReport, E2.dailyMaxForMonth(threeDates2,11));
  }

  /*
  Method 1 // Subtasks
  1. Instantiate a MaxHzReport list and call it maxReportList.
  2. Instantiate a MaxHzReport.
  3. For every datapoint in the data list, if it is a date with the desired mont,
     add MaxHzReport to the maxReportList and setting the date of MaxHzReport to the date.
  4. For every datapoint in the data list, if it is a data, find the max of the data and set it to the MaxHzReport.
  5. Return the maxReportList
  */

  /*
  Method 2 // Subtasks
  1. Parse the list of data into separate lists that has a month and its data points
  2. For each date get the largest data point.
  3. Compare the corresponding data points to the respective date
  4. For each earthquake, make a MaxHzReport with the date and the highest data point
  5. return list of MaxHzReports for the given list of data and month
  */

}
