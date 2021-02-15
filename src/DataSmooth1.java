import java.util.LinkedList;

class DataSmooth1 {

    DataSmooth1() {
    }

    //showAverage: consumes a show and calculates the average runtime of the show.

    public double showAverage(Show show) {
        double sum = 0;
        int n = 0;

        for (Episode e : show.episodes) {
            sum = sum + e.runTime;
            n++;
        }
        return sum / n;
    }

    //dataSmooth: consumes a list of Shows, calculates the average runtime for each show,
    //            and produces a list of the smoothed runTime values (not the entire records).

    public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {
        LinkedList<Double> averageList = new LinkedList<>();
        LinkedList<Double> smoothList = new LinkedList<>();

        for (Show s : shows) {
            averageList.add(this.showAverage(s));
        }

        for (int i = 0; i < averageList.size(); i++) {
            if (i == 0 || i == averageList.size() - 1) {
                smoothList.add(averageList.get(i));
            }
            else smoothList.add((averageList.get(i - 1) + averageList.get(i) + averageList.get(i + 1)) / 3);
        }
        return smoothList;
    }
}