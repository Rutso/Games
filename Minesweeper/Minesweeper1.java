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
		 * 	  In the cycle you are asked to enter two coordinates (i and j)
		 * 6. then you are asked if it's a marking move (e.g. putting 'M' on a mine) or cleaning move (e.g. revealing the ' ')
		 * 	7. If you mark and the field has mine we decrement the mines counter and the field is marked with M. 
		 * 	   If there is no mine, we just mark the field with M and the mine counter stays untouched
		 * 	   If you decrement the mine counter to 0, we exit the while cycle and you are victorious
		 * 	8. If we clean and there is a mine... 'boom' == true, and we exit the while cycle
		 * 	   If there is a ' ' the program recursively reveals the ' ' up to the border, or numbers.
		 * 	   If you reveal all ' '-s the ' ' counter becomes 0 and you exit the while cycle and you are victorious.
		 */
		
		//1. Generate field:
		char[][] theField = createField();
		
		//2. Put mines on theField:
		int numberOfMines = putMinesOnTheField(theField);
		
		//3.Place numbers:
		placeNumbers(theField);
		displayTheField(theField);
	
		//4. Create the playing field:
		char[][] thePlayingField = createPlayingField(theField);
		displayTheField(thePlayingField);
		
		//5. Make your move:
			boolean boom = false;
			int nonBombSpaces = theField.length*theField[1].length - numberOfMines;
			int rowIndex = 0;
			int columnIndex = 0;
			int unRevealedSpaces = nonBombSpaces;
		while (boom != true && unRevealedSpaces != 0) {
			
			
			//Entering indexes for the player's move:
				do {
					System.out.print("Enter row's number, counting from 0: ");
					rowIndex = sc.nextInt();
					System.out.print("Enter column's number, counting from 0: ");
					columnIndex = sc.nextInt();
					
				} while (rowIndex > theField.length-1 || columnIndex > theField[1].length-1 || rowIndex < 0 || columnIndex < 0 || thePlayingField[rowIndex][columnIndex] != '#');
		 
			//Resolving the player's move:
			
				if (theField[rowIndex][columnIndex] == '*') {
					boom = true;
					break;
				} else {
					revealField(theField, thePlayingField, rowIndex, columnIndex);
				}
				
				unRevealedSpaces = nonBombSpaces - countRevealedSpaces(thePlayingField);
			
				displayTheField(thePlayingField);
			
		//End of while bracket:
		}
		
		if (boom == true) {
			System.out.print("Boooom!!!");
		} 
		if (unRevealedSpaces == 0) {
			System.out.print("You WIN!");
		}
		
		
		
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
	
	
	
	//5. Recursive method that reveals the empty spaces and the numbers:
	static void revealField(char[][] theField, char[][] thePlayingField, int rowIndex, int columnIndex) {
		
		if (rowIndex < 0 || rowIndex > theField.length-1 || columnIndex < 0 || columnIndex > theField[1].length-1) {
			return;
		}
		
		if (thePlayingField[rowIndex][columnIndex] == ' ') {
			return;
		}
		
		if (theField[rowIndex][columnIndex] == '1' || theField[rowIndex][columnIndex] == '2' || theField[rowIndex][columnIndex] == '3' || theField[rowIndex][columnIndex] == '4' || theField[rowIndex][columnIndex] == '5' || theField[rowIndex][columnIndex] == '6' || theField[rowIndex][columnIndex] == '7' || theField[rowIndex][columnIndex] == '8') {
			thePlayingField[rowIndex][columnIndex] = theField[rowIndex][columnIndex];
			return;
		} else {
			if (theField[rowIndex][columnIndex] == ' '){
				thePlayingField[rowIndex][columnIndex] = ' ';
			revealField(theField, thePlayingField, rowIndex-1, columnIndex-1);
			revealField(theField, thePlayingField, rowIndex-1, columnIndex);
			revealField(theField, thePlayingField, rowIndex-1, columnIndex+1);
			revealField(theField, thePlayingField, rowIndex, columnIndex-1);
			revealField(theField, thePlayingField, rowIndex, columnIndex+1);
			revealField(theField, thePlayingField, rowIndex+1, columnIndex-1);
			revealField(theField, thePlayingField, rowIndex+1, columnIndex);
			revealField(theField, thePlayingField, rowIndex+1, columnIndex+1);
			}
		}
					
	}
	
	//6. Method that counts the revealed spaces:
	static int countRevealedSpaces(char[][] thePlayingField) {
		
		int revealedSpaces = 0;
		for (int i = 0; i < thePlayingField.length; i++) {
			for (int j = 0; j < thePlayingField[1].length; j++) {
				if (thePlayingField[i][j] != '#') {
					revealedSpaces++;
				}
			}
		}
		return revealedSpaces;
	}
	
	
	
//End of class bracket:
}
