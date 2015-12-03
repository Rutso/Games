import java.util.Scanner;

public class Minesweeper1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * 1. Generate the field
		 * 
		 * 2. Place mines
		 * 		- Enter mines' number
		 * 		- Use Math.random() to generate random indexes for the mines' coordinates
		 * 		- Check that there is no more than 5 mines closer to any field (that's for the second version; we'll keep it simpler for
		 * 		  now ;) )
		 * 3. Place numbers
		 * 4. Create a help 2d array that will be the user interface
		 * 
		 * 5. While cycle that goes until you enter coordinates of a bomb '*' or you mark all mines with 'M' or you reveal all 
		 * 	  numbers and ' ' spaces.
		 * 6. In the cycle you are asked to enter two coordinates (i and j)
		 * 7. then you are asked if it's a marking move (e.g. putting 'M' on a mine) or cleaning move (e.g. revealing the ' ')
		 * 	8. If you mark and the field has mine we decrement the mines counter and the field is marked with M. 
		 * 	   If there is no mine, we just mark the field with M and the mine counter stays untouched
		 * 	   If you decrement the mine counter to 0, we exit the while cycle and you are victorious
		 * 	9. If we clean and there is a mine... 'boom' == true, and we exit the while cycle
		 * 	   If there is a ' ' the program recursively reveals the ' ' up to the border, or numbers.
		 * 	   If you reveal all ' '-s the ' ' counter becomes 0 and you exit the while cycle and you are victorious.
		 */
		
		//1. Generate field:
		char[][] theField = createField();
		
		//2. Put mines on theField:
		int numberOfMinse = putMinesOnTheField(theField);
		
		//3.Place numbers:
		placeNumbers(theField);
		displayTheField(theField);
	
		//4. Create the playing field:
		char[][] thePlayingField = createPlayingField(theField);
		displayTheField(thePlayingField);
		
	//End of main bracket:	
	}
	
	
	
	
	//1. Method that generates the field
	static char[][] createField() {
		Scanner sc = new Scanner(System.in);
		
		int rows = 0;
			do {
				System.out.print("Please, enter the number of rows >5: ");
				rows = sc.nextInt();
			} while (rows <= 5);
		
		int columns = 0;
			do {
				System.out.print("Please, enter the number of columns >5: ");
				columns = sc.nextInt();
			} while (columns <= 5);
		
		char[][] field = new char[rows][columns];
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[1].length; j++) {
					field[i][j] = ' ';
				}
			}
		return field;
	}
	
	//2. Method that puts mines on the field
	static int putMinesOnTheField(char[][] theField) {
		Scanner sc = new Scanner(System.in);
		
		int numberOfElements = theField.length*theField[1].length;
		int maxNumberOfMines = numberOfElements/2;
		int numberOfMines = 0;
			do {
				System.out.print("Please, enter the number of mines <= " + maxNumberOfMines);
				numberOfMines = sc.nextInt();
		} while (numberOfMines <= 0);
			
			int minesNumber = numberOfMines;
			
			while (minesNumber > 0) {
				
				int i = generateRandomIndex(theField.length);
				int j = generateRandomIndex(theField[1].length);
				
				if (theField[i][j] != '*') {
					theField[i][j] = '*';
					minesNumber--;
				}
			}
			
		return numberOfMines;
	}
	
	//2.1. Method that generates random coordinates
	static int generateRandomIndex(int fieldLength) {
		int randomIndex = (int) (Math.random()*fieldLength);
		return randomIndex;
	}
	
	//2.2. Method that displays a 2D array of chars:
	static void displayTheField(char[][] theField) {
		for (int i = 0; i < theField.length; i++) {
			for (int j = 0; j < theField[1].length; j++) {
				if (j < theField[1].length-1) {
					System.out.print(theField[i][j] + " ");
				} else {
					System.out.println(theField[i][j]);
				}
			}
		}
	}
	
	//3. Method that places numbers:
	static void placeNumbers(char[][] theField) {
		char[] numbers = {'0','1','2','3','4','5','6','7','8'};
		for (int i = 0; i < theField.length; i++) {
			for (int j = 0; j < theField[1].length; j++) {
				int counter = 0;
				if (theField[i][j] != '*') {
					
					if (i > 0 && theField[i-1][j] == '*') {
						counter++;
					}
					if (i > 0 && j > 0 && theField[i-1][j-1] == '*') {
						counter++;
					}
					if (i > 0 && j < theField[1].length-1 && theField[i-1][j+1] == '*') {
						counter++;
					}
					if (j > 0 && theField[i][j-1] == '*') {
						counter++;
					}
					if (j < theField[1].length-1 && theField[i][j+1] == '*') {
						counter++;
					}
					if (i < theField.length-1 && j > 0 && theField[i+1][j-1] == '*') {
						counter++;
					}
					if (i < theField.length-1 && theField[i+1][j] == '*') {
						counter++;
					}
					if (i < theField.length-1 && j < theField[1].length-1 && theField[i+1][j+1] == '*') {
						counter++;
					}
				}
				
				if (counter != 0) {
					theField[i][j] = numbers[counter];
					
				}
			}
		}
	}
	
	//4. Method that generates the user interface 2D array:
	static char[][] createPlayingField(char[][] theField) {
		
		char[][] playField = new char[theField.length][theField[1].length];
		for (int i = 0; i < playField.length; i++) {
			for (int j = 0; j < playField[1].length; j++) {
				playField[i][j] = '#';
			}
		}
		
		return playField;
	}
	
	
	
	
//End of class bracket:
}
