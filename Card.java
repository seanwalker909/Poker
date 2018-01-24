//Sean Walker	
//Poker - Card Class

//this is a card class that contains attributes of cards in enums

public class Card {
	private Suit suit;
	private Rank rank;
	
	public Card(Suit s, Rank r)
	{
		suit = s;
		rank = r;
	}
	
	public static enum Suit{
		CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');
		
		private char suitLetter;
		
		Suit(char suitLetter){
			this.suitLetter = suitLetter;
		}
		
		public char getSuitChar(){
			return suitLetter;
		}
	}//end Suit enum
	public static enum Rank{
		TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'),
		NINE('9'), TEN('T'), JACK('J'), QUEEN('Q'), KING('K'), ACE('A');
		
		private char rankLetter;
		
		Rank(char symbol){
			this.rankLetter = symbol;
		}

		public char getRankLetter() {
			return this.rankLetter;
		}

		public void setRankLetter(char rankLetter) {
			this.rankLetter = rankLetter;
		}
	}//end Rank enum
	
	//get chars that represent enums
	public char getRankChar(){
		return this.rank.rankLetter;
	}
	
	public char getSuitChar(){
		return this.suit.suitLetter;
	}
	
	
	//get enums:
	public Rank getRankEnum(){
		return this.rank;
	}
	
	public Suit getSuitEnum(){
		return this.suit;
	}
	
	public void setSuitEnum(Suit suit){
		this.suit.equals(suit);
	}
	
	public void setRankEnum(Rank rank){
		this.rank.equals(rank);
	}
}//end Card class
