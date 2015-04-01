package ab.cd;

import java.util.Comparator;

public class VideogameComparator implements Comparator<Videogame>{

	@Override
	public int compare(Videogame one, Videogame two) {
		// TODO Auto-generated method stub
		return two.getRating() - one.getRating();
	}

}
