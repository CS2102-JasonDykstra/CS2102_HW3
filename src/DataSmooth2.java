import java.util.LinkedList;

class DataSmooth2 {
    DataSmooth2() {
    }

    //getEPRunTimes: consumes a list of episodes and produces a list of doubles for the runtimes of each episode.

    public LinkedList<Double> getEPrt(LinkedList<Episode> episodes) {
        LinkedList<Double> EPlist = new LinkedList<Double>();
        for (Episode e : episodes) {
            EPlist.add(e.runTime);
        }
        return EPlist;
    }

    //getAVGrt: consumes a list of runtimes and produces the average runtime of the whole show.

    public double getAVGrt(LinkedList<Double> runtimes) {

        double avgacc = 0;
        for (int i = 0; i < runtimes.size(); i++) {
            avgacc = avgacc + runtimes.get(i);

        }

        return (avgacc / runtimes.size());
    }

    //AverageShows:consumes a list of shows and produces a list of average runtimes of each show.

    public LinkedList<Double> AverageShows(LinkedList<Show> shows) {
        LinkedList<Double> ShowAverage = new LinkedList<Double>();
        for (Show s : shows) {
            ShowAverage.add(getAVGrt(this.getEPrt(s.episodes)));
        }
        return ShowAverage;
    }

    //dataSmooth: consumes a list of Shows, calculates the average runtime for each show,
    //            and produces a list of the smoothed runTime values (not the entire records).

    public LinkedList<Double> dataSmooth(LinkedList<Show> listofshows) {
        LinkedList<Double> Y = this.AverageShows(listofshows);
        LinkedList<Double> alort = new LinkedList<Double>();

        for (int i = 1; i < (Y.size() - 1); i++) {
            alort.add(((Y.get(i + 1)) + (Y.get(i - 1)) + (Y.get(i))) / 3);

        }
        alort.addFirst(Y.get(0));
        alort.addLast(Y.get(Y.size() - 1));

        return alort;
    }
}