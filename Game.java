//Sean Walker	
//CS 342 Project 1 - Poker

/*A Game Class - This class is to contain the method main. This class will also keep
track of the particulars of the game
*/


public class Game {
	public static void main(String[] args) {
			Draw_Pile gameDeck = new Draw_Pile();
			Hands hand = new Hands(gameDeck);
			System.out.println("The deck is being shuffled...\n");//shuffle function is actually called in the hands constructor
			System.out.println("The cards are being delt to " + hand.getNumberOfPlayers() + " players\n");
			hand.swapPlayersCards(gameDeck);
			hand.calculateWinner(gameDeck);
			
	}//end main()
}//end Game class