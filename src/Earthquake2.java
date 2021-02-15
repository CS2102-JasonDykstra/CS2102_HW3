import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }


  // dailyMaxForMonth: consumes a list of sensor data (doubles) and a month (represented by a number between 1 and 12)
  //                   and produces a list of reports (MaxHzReport) indicating the highest frequency reading for each day in that month.

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<Double> getData = this.sortByMonth(currentData(data), month);
    LinkedList<MaxHzReport> dailyMonthMax = new LinkedList<MaxHzReport>();

    double currentDate = 0;
    double currentMax = 0;

    for(Double d : getData) {
      if(this.isDate(d) && d > currentDate)
      { currentDate = d; }
      else if(!this.isDate(d) && d > currentMax) {
        currentMax = d;
        if(d == getData.getLast())
          dailyMonthMax.add(new MaxHzReport(currentDate, currentMax));
      }
      else if(!this.isDate(d) && d < currentMax)
        dailyMonthMax.add(new MaxHzReport(currentDate, currentMax));
    }
    return dailyMonthMax;
  }

  //currentData: consumes a list of data and return a list of data with only positive data.

  public LinkedList<Double> currentData(LinkedList<Double> data) {
    LinkedList<Double> currentList = new LinkedList<Double>();
    for(Double d : data)
    {
      if(d > 0)
        currentList.add(d);
    }
    return currentList;
  }

  //sortByMonth: consumes a list of data and month and only return a list of desired date of the month.

  public LinkedList<Double> sortByMonth(LinkedList<Double> data, int month) {
    LinkedList<Double> currentSortedData = new LinkedList<Double>();
    boolean rightMonth = false;

    for(Double d: data) {
      if(this.isDate(d)) {
        if(this.extractMonth(d) == month) {
          currentSortedData.add(d);
          rightMonth = true;
        }
        else if(this.extractMonth(d) > month)
          return currentSortedData;
        else
          rightMonth = false;
      }
      else if(rightMonth) {
        currentSortedData.add(d);
      }
    }
    return currentSortedData;
  }

}