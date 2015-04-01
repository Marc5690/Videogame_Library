package ef.gh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import ab.cd.*;
import ab.cd.VideogameComparator;

public class Actions {
	
	ArrayList<Videogame> videogames = new ArrayList<Videogame>();
	
	FileInputStream in = null;
    FileOutputStream out = null;
    ObjectInputStream ois = null;
	
	public void loadGames(){
		try {
			in = new FileInputStream("C:/Users/Marc/Downloads/games.txt");
			ois = new ObjectInputStream(in);
			videogames = (ArrayList<Videogame>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveGames() {
		ObjectOutputStream oos;
		try {
			out = new FileOutputStream("C:/Users/Marc/Downloads/games.txt");
			oos = new ObjectOutputStream(out);
			oos.writeObject(videogames);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	String topThree(){
		Collections.sort(videogames, new VideogameComparator());
		String result = "#1 " + videogames.get(0).getTitle() + " \n#2 " + videogames.get(1).getTitle() + " \n#3 " + videogames.get(2).getTitle() + ".";
		return result;
		}
	
	public void addGame(int isbn, String title,String genre, int rating){
		Videogame newGame = new Videogame(isbn, title, genre, rating);		
		videogames.add(newGame);
	}
	
	public void addGames(){
		Videogame theLastOfUs = new Videogame(1,"The Last Of Us","Adventure", 10);
		Videogame battlefield4 = new Videogame(2,"Battlefield 4","Action", 8);
		Videogame mgs4 = new Videogame(3,"Metal Gear Solid 4","Stealth", 9);
				
		videogames.add(theLastOfUs);
		videogames.add(battlefield4);
		videogames.add(mgs4);
	}
	
	public String allGames(){
		String all = new String();
		for(Videogame game: videogames){
			all += game.toString() + "\n";
		}
		return all;
	}
}
