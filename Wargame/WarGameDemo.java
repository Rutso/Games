package wargame;

public class WarGameDemo {

	public static void main(String[] args) {
		
		//1.PLAYERS
		//Declaring the players:
			Player pesho = new Player("Pesho");
			Player gosho = new Player("Gosho");
		
		//2.THE PLAYING DECK
		//Declaring the playing deck:
			Deck playingDeck = new Deck(52);
		//Setting the playing deck:
			playingDeck.setCards();
		//shuffling the playing deck:
			playingDeck.shuffleDeck(100);
		//'tsepim' the playing deck:
			playingDeck.tsepi();
			
		//3.DEALING CARDS
			playingDeck.dealCards(pesho, gosho);
			
		//4.START GAME
		//declare the hand on the table - it's a deck with potential of getting 52 cards:
			Deck table = new Deck(52);
		//start the actual game - the players will play cards while both of them have no more cards in hand:
			while (pesho.getCardsInHand().getNumberOfCards() != 0 && gosho.getCardsInHand().getNumberOfCards() != 0) {
				//each player plays one card on the table:
				pesho.playCard(table);
				gosho.playCard(table);
				
				if (table.getCards()[table.getNumberOfCards()-2].compareCards(table.getCards()[table.getNumberOfCards()-1])) {
					System.out.println(pesho.getName() + " wins.");
					System.out.println();
					pesho.addCardsToWinDeck(table);
					table.removeCardsFromDeck();
				} else {
					if (table.getCards()[table.getNumberOfCards()-1].compareCards(table.getCards()[table.getNumberOfCards()-2])) {
						System.out.println(gosho.getName() + " wins.");
						System.out.println();
						gosho.addCardsToWinDeck(table);
						table.removeCardsFromDeck();
					} else {
						if (table.getCards()[table.getNumberOfCards()-2].checkIfEqual(table.getCards()[table.getNumberOfCards()-1])) {
							if (pesho.getCardsInHand().getNumberOfCards() == 0) {
								System.out.println("Last war ends with tie.");
								break;
							}
							if (pesho.getCardsInHand().getNumberOfCards() < 3) {
								while(pesho.getCardsInHand().getNumberOfCards() != 0) {
									pesho.playCard(table);
									gosho.playCard(table);
								}
								if (table.getCards()[table.getNumberOfCards()-2].compareCards(table.getCards()[table.getNumberOfCards()-1])) {
									System.out.println(pesho.getName() + " wins the war.");
									System.out.println();
									pesho.addCardsToWinDeck(table);
									table.removeCardsFromDeck();
									break;
								} else {
									if (table.getCards()[table.getNumberOfCards()-1].compareCards(table.getCards()[table.getNumberOfCards()-2])) {
										System.out.println(gosho.getName() + " wins the war.");
										System.out.println();
										gosho.addCardsToWinDeck(table);
										table.removeCardsFromDeck();
										break;
									}
								}
							}
							war(pesho, gosho, table);
						}
					}
				}
				
				
				
			//the while closing bracket:
			}
			checkWinner(pesho, gosho);
			
	//the closing bracket of the main:	
	}

	
	//METHODS:
	
	//1. Method that resolves the war situation:
	private static void war(Player a, Player b, Deck table) {
		//each player places 3 cards from his hand deck on the table:
		//first:
		
		
		a.playCard(table);
		b.playCard(table);
		//secong:
		a.playCard(table);
		b.playCard(table);
		//the third:
		a.playCard(table);
		b.playCard(table);
		//at this pont there are 8 cards on the table - 2 that started the war and 6 that take part in the war.
		//now we chech the last two cards:
		
		if (table.getCards()[table.getNumberOfCards()-2].compareCards(table.getCards()[table.getNumberOfCards()-1])) {
			System.out.println(a.getName() + " wins the war.");
			System.out.println();
			a.addCardsToWinDeck(table);
			table.removeCardsFromDeck();
		} else {
			if (table.getCards()[table.getNumberOfCards()-1].compareCards(table.getCards()[table.getNumberOfCards()-2])) {
				System.out.println(b.getName() + " wins the war.");
				System.out.println();
				b.addCardsToWinDeck(table);
				table.removeCardsFromDeck();
			} else {
				if (table.getCards()[table.getNumberOfCards()-2].checkIfEqual(table.getCards()[table.getNumberOfCards()-1])) {
					
					//if the last cards are equal, the two players play one card more while these cards are equal:
					while(true) {
						//if we finish the cards in hand before getting a winner the game ends and noone takes
						//the cards from the table
						if (a.getCardsInHand().getNumberOfCards() == 0) {
							System.out.println("Last war ends with tie.");
							return;
						}
						
						a.playCard(table);
						b.playCard(table);
						if (table.getCards()[table.getNumberOfCards()-2].compareCards(table.getCards()[table.getNumberOfCards()-1])) {
							System.out.println(a.getName() + " wins the war.");
							System.out.println();
							a.addCardsToWinDeck(table);
							table.removeCardsFromDeck();
							break;
						} else {
							if (table.getCards()[table.getNumberOfCards()-1].compareCards(table.getCards()[table.getNumberOfCards()-2])) {
								System.out.println(b.getName() + " wins the war.");
								System.out.println();
								b.addCardsToWinDeck(table);
								table.removeCardsFromDeck();
								break;
							}
						}
					}
					
				}
			}
		}
		
	}
	
	//2. Method that checks who is the winner:
	private static void checkWinner(Player a, Player b) {
		if (a.getCardsWon().getNumberOfCards() > b.getCardsWon().getNumberOfCards()) {
			System.out.println(a.getName() + " is the winner with " + a.getCardsWon().getNumberOfCards() + " against " + b.getCardsWon().getNumberOfCards() + " cards.");
		} else {
			if (a.getCardsWon().getNumberOfCards() < b.getCardsWon().getNumberOfCards()) {
				System.out.println(b.getName() + " is the winner with " + b.getCardsWon().getNumberOfCards() + " against " + a.getCardsWon().getNumberOfCards() + " cards.");
			} else {
				System.out.println("Draw!" + a.getName() + " has " + a.getCardsWon().getNumberOfCards() + " cards. And " + b.getName() + " has " + b.getCardsWon().getNumberOfCards() + " cards.");

			}
		}
	}
	
	
	
	
	
	
	
//the closing bracket of the class:
}
