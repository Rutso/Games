package chess;

public class Demo {

	
	
	
	public static void main(String[] args) {
		
			
		Board a = new Board();
		a.displayBoard();
		a.putFigures();
		
		a.displayBoard();
		
			
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('A')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('A'), charFromInputToIndex('A'), intFromInputToIndex(2), intFromInputToIndex(3))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('A')]).moveFigure(a.getGameBoard(), charFromInputToIndex('A'), intFromInputToIndex(2),charFromInputToIndex('A'), intFromInputToIndex(3));
		}
		a.displayBoard();
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('b')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('b'), charFromInputToIndex('c'), intFromInputToIndex(1), intFromInputToIndex(3))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('b')]).moveFigure(a.getGameBoard(), charFromInputToIndex('b'), intFromInputToIndex(1),charFromInputToIndex('c'), intFromInputToIndex(3));
		}
		a.displayBoard();
		
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(3)][charFromInputToIndex('c')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('c'), charFromInputToIndex('e'), intFromInputToIndex(3), intFromInputToIndex(4))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(3)][charFromInputToIndex('c')]).moveFigure(a.getGameBoard(), charFromInputToIndex('c'), intFromInputToIndex(3),charFromInputToIndex('e'), intFromInputToIndex(4));
		}
		a.displayBoard();
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('b')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('b'), charFromInputToIndex('b'), intFromInputToIndex(2), intFromInputToIndex(3))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('b')]).moveFigure(a.getGameBoard(), charFromInputToIndex('b'), intFromInputToIndex(2),charFromInputToIndex('b'), intFromInputToIndex(3));
		}
		a.displayBoard();
		
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('c')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('c'), charFromInputToIndex('b'), intFromInputToIndex(1), intFromInputToIndex(2))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('c')]).moveFigure(a.getGameBoard(), charFromInputToIndex('c'), intFromInputToIndex(1),charFromInputToIndex('b'), intFromInputToIndex(2));
		}
		a.displayBoard();
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('b')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('b'), charFromInputToIndex('e'), intFromInputToIndex(2), intFromInputToIndex(5))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(2)][charFromInputToIndex('b')]).moveFigure(a.getGameBoard(), charFromInputToIndex('b'), intFromInputToIndex(2),charFromInputToIndex('e'), intFromInputToIndex(5));
		}
		a.displayBoard();
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('a')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('a'), charFromInputToIndex('b'), intFromInputToIndex(1), intFromInputToIndex(1))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('a')]).moveFigure(a.getGameBoard(), charFromInputToIndex('a'), intFromInputToIndex(1),charFromInputToIndex('b'), intFromInputToIndex(1));
		}
		a.displayBoard();
		
		if (((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('b')]).isItALegalMove(a.getGameBoard(), charFromInputToIndex('b'), charFromInputToIndex('b'), intFromInputToIndex(1), intFromInputToIndex(2))) {
			((Figure) a.getGameBoard()[intFromInputToIndex(1)][charFromInputToIndex('b')]).moveFigure(a.getGameBoard(), charFromInputToIndex('b'), intFromInputToIndex(1),charFromInputToIndex('b'), intFromInputToIndex(2));
		}
		a.displayBoard();
		
		
		
		
	}
	
	
	
	
	
	
	
	//methods:
	
	//the next two methods are very important. They transform the input from a
	//player (start letter/start number and endletter/endnumber) to indexes with
	//which the methods call array elements etc.
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
