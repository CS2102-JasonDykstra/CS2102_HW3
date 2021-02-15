import java.util.LinkedList;

class ShowManager2 {
	
	ShowManager2() {}

	//Daytime shows have a start time at or after 6:00 am and before 5:00 pm.

	//Primetime shows have a start time at or after 5:00 pm and before 10:00 pm.

	//Late night shows have a start time at or after 10:00 pm and before 1:00 am.

	//All other non-special shows are overnight.

	//Specials are one-time shows that can be on any time of day.

	//organizeShows: consumes a list of Shows and produces a report containing all of the
	//               daytime, primetime, and late night shows in the list that are not specials.
	//


	public ShowSummary organizeShows(LinkedList<Show> shows) {
		LinkedList<Show> dayTimeShows = new LinkedList<>();
		LinkedList<Show> primeTimeShows = new LinkedList<>();
		LinkedList<Show> lateNightShows = new LinkedList<>();

		for(Show s : shows){
			if(s.isSpecial || (s.broadcastTime >= 100 && s.broadcastTime < 600 )){
				shows.remove(s);
			}
			if(s.broadcastTime >= 600 && s.broadcastTime < 1700){
				dayTimeShows.add(s);
			}
			if(s.broadcastTime >= 1700 && s.broadcastTime < 2200){
				primeTimeShows.add(s);
			}
			if(s.broadcastTime >= 2200 && s.broadcastTime < 100) {
				lateNightShows.add(s);
			}
		}
		return new ShowSummary(dayTimeShows, primeTimeShows, lateNightShows);
	}
	
}
