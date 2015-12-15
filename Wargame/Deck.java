package wargame;

public class Deck {

	//Fields:
	private int numberOfCards;
	private Card[] cards;
	private final static String[] CARD_COLORS = {"C","D","H","S"};
	private final static String[] CARD_VALUES = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	
	//Constructor:
	public Deck(int numberOfCards) {
		if (numberOfCards == 52) {
			this.numberOfCards = 0;
			this.cards = new Card[numberOfCards];
			
		} else {
			if (numberOfCards == 26) {
				this.numberOfCards = 0;
				this.cards = new Card[numberOfCards];
			} else {
				System.out.println("Invalid number of cards value.");
				this.numberOfCards = 0;
				this.cards = null;
			}
		}
		
	}
	
	
	//Getter:
	public Card[] getCards() {
		return this.cards;
	}
	
	public int getNumberOfCards() {
		return this.numberOfCards;
	}
	
	//Setter:
	public void setCards() {
		
		int cardNumber = 0;
		for(int i = 0; i < CARD_COLORS.length; i++) {
			int strength = 2;
			for(int j = 0; j < CARD_VALUES.length; j++) {
				cards[cardNumber] = new Card(CARD_COLORS[i], CARD_VALUES[j], strength);
				cardNumber++;
				strength++;
				this.numberOfCards++;
			}
		}
	}
	
	//Methods:
	public void increaseNumberOfCards(int numberOfCards) {
		if (numberOfCards > 0) {
			this.numberOfCards+=numberOfCards;
		} else {
			System.out.println("Invalid number of cards value.");
		}
	}
	
	public void decreaseNumberOfCards(int numberOfCards) {
		if (numberOfCards > 0) {
			this.numberOfCards-=numberOfCards;
		} else {
			System.out.println("Invalid number of cards value.");
		}
	}
	
	//shuffles the deck:
	public void shuffleDeck(int numberOfSwappings) {
		if (numberOfSwappings > 0) {
			int i = 0;
			int j = 0;
			int k = 0;
			while (k <= numberOfSwappings) {
				i = (int) (Math.random()*this.cards.length);
				j = (int) (Math.random()*this.cards.length);
				if (i != j) {
					Card temp = this.cards[i];
					this.cards[i] = this.cards[j];
					this.cards[j] = temp;
					k++;
				}
			}
		}
	}
	
	//'tsepi' the deck:
	public void tsepi() {
		
		Deck temp = new Deck(this.numberOfCards);
		int splitIndex = 0;
		while (splitIndex < 10 || splitIndex > 40) {
			splitIndex = (int) (Math.random()*(this.numberOfCards-1));
		}
	
		for (int i = 0; i < this.numberOfCards-splitIndex; i++) {
			temp.cards[i] = this.cards[splitIndex+i];
		}
		for (int j = this.numberOfCards-splitIndex; j <this.cards.length; j++) {
			temp.cards[j] = this.cards[j-(this.numberOfCards-splitIndex)];
		}
		
		this.cards = temp.cards;
	}
	
	//deal cards to two players from the shuffled and 'tsepi' deck:
	public void dealCards(Player a, Player b) {
		for (int i = 0; i < this.getCards().length-1; i+=2) {
			a.getCardsInHand().addCardToDeck(this.getCards()[i]);
			b.getCardsInHand().addCardToDeck(this.getCards()[i+1]);
		}
	}
	
	
	//add card to deck:
	public void addCardToDeck(Card card) {
		int counter = 0;
		for (int i = 0; i < this.getCards().length; i++) {
			counter++;
			if (this.getCards()[i] == null) {
				this.getCards()[i] = card;
				this.increaseNumberOfCards(1);
				return;
			}
			
		}
		if (counter == this.getCards().length) {
			System.out.println("The deck is full and can't take another card.");
		}
		
	}
	
	//remove card from deck: 
	public void removeCardsFromDeck() {
		for (int i = 0; i <= this.getNumberOfCards()-1 ; i++) {
				this.getCards()[i] = null;
		}
		this.decreaseNumberOfCards(this.getNumberOfCards());
	}
	
	//print deck:
	public void printDeck() {
		for (int i = 0; i < this.getCards().length; i++) {
			this.getCards()[i].printCard();
		}
		System.out.println();
	}
	
	
	
}
