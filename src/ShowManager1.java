import java.util.LinkedList;

class ShowManager1 {

	ShowManager1() {}

	//Daytime shows have a start time at or after 6:00 am and before 5:00 pm.

	//Primetime shows have a start time at or after 5:00 pm and before 10:00 pm.

	//Late night shows have a start time at or after 10:00 pm and before 1:00 am.

	//All other non-special shows are overnight.

	//Specials are one-time shows that can be on any time of day.

	//getDaytime: consumes a list of Shows and produces a list of non-special daytime shows.

	public LinkedList<Show> getDaytime(LinkedList<Show> shows){
		LinkedList<Show> dtList = new LinkedList<>();

		for(Show s : shows){
			if(!s.isSpecial && s.broadcastTime >= 600 && s.broadcastTime < 1700)
				dtList.add(s);
		}
		return dtList;
	}

	//getPrimetime: consumes a list of Shows and produces a list of non-special primetime shows.

	public LinkedList<Show> getPrimetime(LinkedList<Show> shows){
		LinkedList<Show> ptList = new LinkedList<>();

		for(Show s : shows){
			if(!s.isSpecial && s.broadcastTime >= 1700 && s.broadcastTime < 2200)
				ptList.add(s);
		}
		return ptList;
	}

	//getLateNight: consumes a list of Shows and produces a list of non-special latenight shows.

	public LinkedList<Show> getLateNight(LinkedList<Show> shows){
		LinkedList<Show> lnList = new LinkedList<>();

		for(Show s : shows){
			if(!s.isSpecial && s.broadcastTime >= 2200 && s.broadcastTime < 100)
				lnList.add(s);
		}
		return lnList;
	}

	//organizeShows: consumes a list of Shows and produces a report containing all of the
	//               daytime, primetime, and late night shows in the list that are not specials.
	//      	     shows within each list in the report should be in the same order as in the original list.

	public ShowSummary organizeShows(LinkedList<Show> shows) {
		LinkedList<Show> dayTimeShows = this.getDaytime(shows);
		LinkedList<Show> primeTimeShows = this.getPrimetime(shows);
		LinkedList<Show> lateNightShows = this.getLateNight(shows);

		return new ShowSummary(dayTimeShows, primeTimeShows, lateNightShows);
	}


}
