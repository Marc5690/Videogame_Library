package ef.gh;

import javax.swing.JOptionPane;


public class Menu {
	public static void main(String[] args){
		
		Actions action = new Actions();
		Boolean exit = false;
		while(exit == false){
		String userInput = JOptionPane.showInputDialog("1: Top three games\n" +
				"2: Add three games\n" +
				"3: List all games\n"  +
				"4: Add your own game\n" +
				"5: Load games\n" +
				"6: Save current games\n" +
				"7: Exit\n" +
				"\n" +
				"Please make your selection:");

		if(userInput.equals("1")){
			JOptionPane.showMessageDialog(null, action.topThree());
		}
		else if(userInput.equals("2")){
			action.addGames();
		}
		else if(userInput.equals("3")){
			JOptionPane.showMessageDialog(null, action.allGames());
		}
		else if(userInput.equals("4")){
			String isbn = JOptionPane.showInputDialog(null, "ISBN:");
			String title = JOptionPane.showInputDialog(null, "Title:");
			String genre = JOptionPane.showInputDialog(null, "Genre:");
			String rating = JOptionPane.showInputDialog(null, "Rating:");
			
			int parsedIsbn = Integer.parseInt(isbn);
			int parsedRating = Integer.parseInt(rating);
			action.addGame(parsedIsbn, title, genre, parsedRating);
		}
		
		else if(userInput.equals("5")){
			action.loadGames();
		}
		
		else if(userInput.equals("6")){
			action.saveGames();
		}		
		
		else if(userInput.equals("7")){
			JOptionPane.showMessageDialog(null, "Goodbye");
			exit = true;
		}
		
		else{
			JOptionPane.showMessageDialog(null, "That is not an option");
		}
		}
	}
}
