package chess;

public class Demo {

	public static void main(String[] args) {
		
		
		Board a = new Board();
		a.displayBoard();
		a.putFigures();
		
		a.displayBoard();
		
		
		int b = charFromInputToIndex('A');
		System.out.println(b);
		
		int c = intFromInputToIndex(6);
		System.out.println(c);
		
		if (Pawn.isItALegalPawnMove(a.getGameBoard(), charFromInputToIndex('A'), charFromInputToIndex('A'), intFromInputToIndex(2), intFromInputToIndex(3))) {
			((Pawn) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('A')]).moveFigure(a.getGameBoard(), charFromInputToIndex('A'), intFromInputToIndex(2),charFromInputToIndex('A'), intFromInputToIndex(3));
		}
		a.displayBoard();
		
		
	}
	//methods:
	static int charFromInputToIndex(char letter) {
		int letterIndex =0;
		if (letter >= 65 && letter <=74) {
			return letterIndex = letter-64;
		} else {
			if (letter >= 97 && letter <=104) {
				return letterIndex = letter-96;
			} else {
				System.out.println("Invalid input for letter.");
				return letterIndex;
			}
		}
				
	}
	static int intFromInputToIndex(int number) {
		int numberIndex = 9 - number;
		
		return numberIndex;
				
	}
	
	
}
