import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  public boolean isDate(double anum) {
    return (int)anum > 10000000;
  }

  // extracts the month from an 8-digit date
  public int extractMonth(double dateNum) {
    return ((int)dateNum % 10000) / 100;
  }

  // dailyMaxForMonth: consumes a list of sensor data (doubles) and a month (represented by a number between 1 and 12)
  //                   and produces a list of reports (MaxHzReport) indicating the highest frequency reading for each day in that month.

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> maxReportList = new LinkedList<MaxHzReport>();
    MaxHzReport report = new MaxHzReport(0,0);

    for(Double d: data){
      if((this.isDate(d)) && (this.extractMonth(d) == month)){
        maxReportList.add(report);
        report = new MaxHzReport (d,-1);
      }

      if(d >= 0 && d <= 500){
        if (d > report.maxReading) {
          report.maxReading = d;
        }
      }
    }

    maxReportList.add(report);
    maxReportList.remove(0);

    for(MaxHzReport m: maxReportList){
      if(m.maxReading == -1){
        maxReportList.remove(m);
      }
    }
    return maxReportList;
  }
}