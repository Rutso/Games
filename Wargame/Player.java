package wargame;

public class Player {

	//Fields:
	private final String name;
	private Deck cardsInHand;
	private Deck cardsWon;
	
	
	//Constructor:
	public Player(String name) {
		this.name = name;
		this.cardsInHand = new Deck(26);
		this.cardsWon = new Deck(52);
	}
	
	//Getters:
	public String getName() {
		return this.name;
	}
	
	public Deck getCardsInHand() {
		return this.cardsInHand;
	}
	
	public Deck getCardsWon() {
		return this.cardsWon;
	}
	
	
	//Methods:
	
	//play card: it plays the last (e.g. the card from the top of the deck and in the same time
	//removes it from the hand deck, lowering the number of cards by 1:
	public void playCard(Deck table) {
		System.out.println(this.name + " plays :");
		this.getCardsInHand().getCards()[this.getCardsInHand().getNumberOfCards()-1].printCard();
		table.addCardToDeck(this.getCardsInHand().getCards()[this.getCardsInHand().getNumberOfCards()-1]);
		this.getCardsInHand().getCards()[this.getCardsInHand().getNumberOfCards()-1] = null;
		this.getCardsInHand().decreaseNumberOfCards(1);
		
		
	}
	//add cards to the player's won deck: it takes as an argument a Deck
	//called 'hand' that has 52 boxes and contains all cards played by both
	//players on every turn:
	public void addCardsToWinDeck(Deck table) {
		int i = 0;
		while (table.getCards()[i] != null) {
			cardsWon.addCardToDeck(table.getCards()[i]);
			
			i++;
		}
		
	}
	
	
	
	
	
	
}
