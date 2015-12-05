import java.util.Scanner;

public class TicTacToe {

	
	
	
	
	
	public static void main(String[] args) {
		
		
		//Creating the field:
		char[][] field = {
				{'a','b','c'},
				{'d','e','f'},
				{'g','h','i'}
		};
		
		//Displaying the field:
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (j < field[i].length-1) {
					System.out.print(field[i][j] + " ");
				} else {
					System.out.println(field[i][j]);
				}
			}
		}
		
		
		//Creating a cycle that cycles while there is no winner:
		boolean win = false;
		int turn = 0;
		char move;
		Scanner sc = new Scanner(System.in);
		
		while (win != true) {
			
			if (turn%2 == 0) {
				System.out.print("Player 1, choose a letter to be replaced with your tokken (X): ");
				move = sc.next().charAt(0);
				
				switch (move) {
				case 'a':
					field[0][0] = 'X';
					break;
				case 'b':
					field[0][1] = 'X';
					break;
				case 'c':
					field[0][2] = 'X';
					break;
				case 'd':
					field[1][0] = 'X';
					break;
				case 'e':
					field[1][1] = 'X';
					break;
				case 'f':
					field[1][2] = 'X';
					break;
				case 'g':
					field[2][0] = 'X';
					break;
				case 'h':
					field[2][1] = 'X';
					break;
				case 'i':
					field[2][2] = 'X';
					break;
				}
				
				//Refresh the field after the changes that the move has triggered:
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						if (j < field[i].length-1) {
							System.out.print(field[i][j] + " ");
						} else {
							System.out.println(field[i][j]);
						}
					}
				}
				//Checking the winning condition:
				//Checking by rows and columns:
				for (int i = 0; i < field.length; i++) {
					int winCounterRow = 0;
					int winCounterCol = 0;
					for (int j = 0; j < field[i].length; j++) {
						if (field[i][j] == 'X') {
							winCounterRow++;
						}
						if (winCounterRow == 3) {
							win = true;
							break;
						}
						if (field[j][i] == 'X') {
							winCounterCol++;
						}
						if (winCounterCol == 3) {
							win = true;
							break;
						}
						
												
						
					}
					
				}
				//Checking the diagonals:
				//The main:
				int mainDiag = 0;
				for (int i = 0; i < field.length; i++) {
					if (field[i][i] == 'X') {
						mainDiag++;
					}
				}
				if (mainDiag == 3) {
					win = true;
					turn++;
					break;
				}
				
				//The second:
				int secDiag = 0;
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						if ((i + j) == field.length-1 && field[i][j] == 'X') {
							secDiag++;
					}
				}
				}
				if (secDiag == 3) {
					win = true;
					turn++;
					break;
				}
				
				
				
				
			} else {
				System.out.print("Player 2, choose a letter to be replaced with your tokken (O): ");
				move = sc.next().charAt(0);
				
				switch (move) {
				case 'a':
					field[0][0] = 'O';
					break;
				case 'b':
					field[0][1] = 'O';
					break;
				case 'c':
					field[0][2] = 'O';
					break;
				case 'd':
					field[1][0] = 'O';
					break;
				case 'e':
					field[1][1] = 'O';
					break;
				case 'f':
					field[1][2] = 'O';
					break;
				case 'g':
					field[2][0] = 'O';
					break;
				case 'h':
					field[2][1] = 'O';
					break;
				case 'i':
					field[2][2] = 'O';
					break;
				}
				
				//Refresh the field after the changes that the move has triggered:
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						if (j < field[i].length-1) {
							System.out.print(field[i][j] + " ");
						} else {
							System.out.println(field[i][j]);
						}
					}
				}
				
				//Checking the winning condition:
				//Checking by rows and columns:
				for (int i = 0; i < field.length; i++) {
					int winCounterRow = 0;
					int winCounterCol = 0;
					for (int j = 0; j < field[i].length; j++) {
						if (field[i][j] == 'O') {
							winCounterRow++;
						}
						if (winCounterRow == 3) {
							win = true;
							break;
						}
						if (field[j][i] == 'O') {
							winCounterCol++;
						}
						if (winCounterCol == 3) {
							win = true;
							break;
						}
						
												
						
					}
					
				}
				//Checking the diagonals:
				//The main:
				int mainDiag = 0;
				for (int i = 0; i < field.length; i++) {
					if (field[i][i] == 'O') {
						mainDiag++;
					}
				}
				if (mainDiag == 3) {
					win = true;
					turn++;
					break;
				}
				
				//The second:
				int secDiag = 0;
				for (int i = 0; i < field.length; i++) {
					for (int j = 0; j < field[i].length; j++) {
						if ((i + j) == field.length-1 && field[i][j] == 'O') {
							secDiag++;
					}
				}
				}
				if (secDiag == 3) {
					win = true;
					turn++;
					break;
				}
				
				
							
			//The closing bracket of the if statement in the beginning:	
			}
			
			
			
			//To change the players:
			turn++;
		
			
		//The closing bracket for the while cycle:	
		}
		
		if (turn%2 == 0) {
			System.out.print("Player 2 wins!");
		} else {
			System.out.print("Player 1 wins!");
		}
		sc.close();
		
		
		
		
		
	}

}
