//Sean Walker	
//CS 342 Project 1 - Poker

import java.util.ArrayList;

public class AI_Player extends Player{	
	private int AIPlayerNumber;
	
	public AI_Player(Card FirstCard, Card SecondCard,
			Card ThirdCard, Card FourthCard, Card FifthCard, int AIPlayerNumber){
		//add the cards to passed to the hand ArrayList
		super(FirstCard, SecondCard, ThirdCard, FourthCard, FifthCard);
		this.AIPlayerNumber = AIPlayerNumber;
	}//end AI_Player constructor
	
	
	public void switchCards(Card s1, Card s2){
	    Card temp = s1;
	    s1=s2;
	    s2=temp;
	}
	
	public void AIswapCardsAlgo(Draw_Pile gameDeck){
		//AI Algorithm
		
		//1. First check if the computer player already has a hand of One Pair or better. If so,
		//discard all other card.
		if(this.handScore == 1){//if AI player has one pair, discard 3 other cards...
			hand.set(2, gameDeck.drawCard(gameDeck));
			hand.set(3, gameDeck.drawCard(gameDeck));
			hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(handScore == 2){//if the AI Player has Two Pairs, swap the card that's not in the pairs...
			hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(handScore == 3){//if the AI Player has Three Of A Kind, swap their other 2 cards...
			hand.set(3, gameDeck.drawCard(gameDeck));
			hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(handScore == 7)//if AI player has Four Of A Kind, swap their other card that's not part of the pair...
		{
			hand.set(4, gameDeck.drawCard(gameDeck));
			System.out.println("after swap:");
			this.showCards();
		}
		//2. If the hand evaluates to "High Card"
		else if(handScore == 0){
			//determine if the user has 4 cards of the same
			//suit. If so, discard the card of the different suit.
			
			for(Card x : this.hand){
				for(Card y : this.hand){
					if(x.getSuitEnum().ordinal() > y.getSuitEnum().ordinal()){
						this.switchCards(x, y);
					}
				}
			}//end loops
			
			int isThereFourOfSameKind = 0;
			for(Card x : this.hand)
				for(Card y : this.hand)
				{
					if(x.getSuitEnum() == y.getSuitEnum())
						isThereFourOfSameKind++;
					else
						isThereFourOfSameKind=0;
				}
			if(isThereFourOfSameKind == 4)
			{
				if(this.hand.get(0).getSuitEnum() == this.hand.get(1).getSuitEnum()) //first four cards are of the same suit
					this.hand.set(4, gameDeck.drawCard(gameDeck)); //swap last card
				else //last 4 cards are of the same suit. 
					this.hand.set(0, gameDeck.drawCard(gameDeck)); //swap first card
			}
		}//end if(handScore == 0)
		//3. Next determine if the user has 4 cards in sequence. If so, discard the card that is out of sequence.
		else if(this.hand.get(0).getRankEnum().ordinal() == this.hand.get(1).getRankEnum().ordinal() + 1 &&
				this.hand.get(0).getRankEnum().ordinal() == this.hand.get(2).getRankEnum().ordinal() + 2 &&
				this.hand.get(0).getRankEnum().ordinal() == this.hand.get(3).getRankEnum().ordinal() + 3)
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		else if(this.hand.get(1).getRankEnum().ordinal() == this.hand.get(2).getRankEnum().ordinal() + 1 &&
				this.hand.get(1).getRankEnum().ordinal() == this.hand.get(3).getRankEnum().ordinal() + 2 &&
				this.hand.get(1).getRankEnum().ordinal() == this.hand.get(4).getRankEnum().ordinal() + 3)
				this.hand.set(0, gameDeck.drawCard(gameDeck));
		else if(this.hand.get(0).getRankEnum() == Card.Rank.ACE) //4. Next if the user has an Ace, discard the other four cards.
		{
			this.hand.set(1, gameDeck.drawCard(gameDeck)); 
			this.hand.set(2, gameDeck.drawCard(gameDeck));
			this.hand.set(3, gameDeck.drawCard(gameDeck));
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(this.hand.get(1).getRankEnum() == Card.Rank.ACE)
		{
			this.hand.set(0, gameDeck.drawCard(gameDeck)); 
			this.hand.set(2, gameDeck.drawCard(gameDeck));
			this.hand.set(3, gameDeck.drawCard(gameDeck));
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(this.hand.get(2).getRankEnum() == Card.Rank.ACE)
		{
			this.hand.set(0, gameDeck.drawCard(gameDeck)); 
			this.hand.set(1, gameDeck.drawCard(gameDeck));
			this.hand.set(3, gameDeck.drawCard(gameDeck));
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(this.hand.get(3).getRankEnum() == Card.Rank.ACE)
		{
			this.hand.set(0, gameDeck.drawCard(gameDeck)); 
			this.hand.set(1, gameDeck.drawCard(gameDeck));
			this.hand.set(2, gameDeck.drawCard(gameDeck));
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		}
		else if(this.hand.get(4).getRankEnum() == Card.Rank.ACE)
		{
			this.hand.set(0, gameDeck.drawCard(gameDeck)); 
			this.hand.set(1, gameDeck.drawCard(gameDeck));
			this.hand.set(2, gameDeck.drawCard(gameDeck));
			this.hand.set(3, gameDeck.drawCard(gameDeck));
		}
		else{ //5. Otherwise, keep the two highest cards and discard the other 3.
			//cards are already sorted. swap last 3...
			this.hand.set(2, gameDeck.drawCard(gameDeck));
			this.hand.set(3, gameDeck.drawCard(gameDeck));
			this.hand.set(4, gameDeck.drawCard(gameDeck));
		}
			
	}//end swapCards()

	
	public ArrayList <Card> getHandArray(){
		return hand;
	}
	
	public ArrayList <Card> getHandArrayList(){
		return this.hand;
	}
	
	public void showCards(){
		for(int i = 0; i <= 4; i++) //loop through hand
		{
			System.out.print(hand.get(i).getRankChar() + "" + hand.get(i).getSuitChar() + " ");
		}
		System.out.println("");
	} //end showCards()


	public int getAIPlayerNumber() {
		return AIPlayerNumber;
	}


	public void setAIPlayerNumber(int aIPlayerNumber) {
		AIPlayerNumber = aIPlayerNumber;
	}
	
	
}//end AI_Player class
