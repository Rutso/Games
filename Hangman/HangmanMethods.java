import java.util.Scanner;

public class HangmanMethods {

	/*
	 * Task 11: Make the Hangman game:
	 * for a secret word the user
	 * must enter letter and to get the
	 * displayed word with the right guessed letters.
	 * The still unknown letters are marked with "_".
	 * The user also must know the remaining guesses.
	 * 
	 */
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//THE GALLOWS POLE:
		char[][] gallowsPole =  {{'*','*','*','*','*','*','*','*','*','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*',' ',' ',' ',' ',' ',' ',' ',' ','*'},
								 {'*','*','*','*','*','*','*','*','*','*'}};
		
		//THE SECRET WORD AND THE WINNING CONDITIONS:		
		//Initialising the secret word:
		String secretWord = "recursion";
		//Defining the winning conditions:
		int turns = 6;
		boolean win = false;
		
		
		//PREPARING THE ALPHABET:
		//Defining the alphabet:
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		//Making sure that the user won't see the first and the last letter in the letters to choose from:
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == secretWord.charAt(0) || alphabet[i] == secretWord.charAt(secretWord.length()-1)) {
				alphabet[i] = '*';
			}
		}
		
		//HIDING THE SECRET WORD:
		//Creating an array of chars that will help us to display the changes that are going to happen
		//during the user's turns. Initially it will show the first, the last and the repeating letters:
		char[] hiddenWord = new char[secretWord.length()];
		//"Hiding" the secret word using Method 2:
		hideSecretWord(hiddenWord, secretWord);
		
		
		//START OF THE GAME:		
		while (turns > 0 && win != true) {
			
				char guess;
			do {
			
			//TURNS LEFT:
			//Displaying the turns left:
				if (turns > 1) {
					System.out.println("YOU HAVE " + turns + " TURNS LEFT!");
					System.out.println();
				} else {
					System.out.println("IT'S YOUR LAST CHANCE!");
					System.out.println();
				}
			
				
			//THE GALLOWS POLE:
			//Here we will have a method that displays the gallows pole according to the turns case:
			displayGallowsPole(turns, gallowsPole);
			
			//THE HIDDEN WORD:
			//Here we display the hidden word with the revealed letters:
			displayChars(hiddenWord);
			System.out.println();
			System.out.print("Please, guess an available lower case letter from the English alphabet: ");
			
			
			//THE USER'S MOOVE:
			//Here we show the available letters to choose from. The used ones have been replaced with "*":
			System.out.println();
			displayChars(alphabet);
			
			//Next the user can enter his guess as a char:
			guess = sc.next().charAt(0);
			
			
			//Ask the user to make a guess while he enters chars different from lower case English letters:
			} while (alphabet[guess-97] == '*' || guess < 97 || guess > 122);
			//After user's turn we replace the chosen letter with "*" in the alphabet array:
			alphabet[guess - 97] = '*';
			
			
			//CHECK IF THE ENTERED LETTER IS PRESENT IN THE SECRET WORD using Method 3:
			turns = checkLetterOccurence(guess, hiddenWord, secretWord, turns);
			
			
			//CHECK IF THE USER HAS REVEALED THE SECRET WORD using Method 4:
			win = checkWin(hiddenWord, secretWord);
			
			
					
		//the closing parenthesis of the playing while cycle:	
		}
		
		//WIN OR LOOSE STATEMENT:
		winOrLoose(turns, win, secretWord, gallowsPole);
		
		
	//End of main:	
		sc.close();
	}

	
	
	//METHODS USED:
					
	//1. Method that displays an array of chars:
	static void displayChars(char[] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	//2. Method that "hides" the secret word:
	static void hideSecretWord(char[] hiddenWord, String secretWord) {
		for (int i = 0; i < hiddenWord.length; i++) {
			if (i == 0) {
				hiddenWord[i] = secretWord.charAt(i);
			} else {
				if (i == hiddenWord.length-1) {
					hiddenWord[i] = secretWord.charAt(i); 
					} else {
						if (secretWord.charAt(i) == secretWord.charAt(0)) {
							hiddenWord[i] = secretWord.charAt(0);
						} else {
							if (secretWord.charAt(i) == secretWord.charAt(secretWord.length()-1)) {
								hiddenWord[i] = secretWord.charAt(i);
							} else {
								hiddenWord[i] = '_';
							}
					}
				}
			}
		}
	}
	
	
	//3. Method that checks if the entered letter is present in the secret word
	//and returns the number of turns remaining:
	static int checkLetterOccurence(char guess, char[] hiddenWord, String secretWord, int turns) {
		
		//Check if we have such letter in the word:
		int occurenceCounter = 0;
		for (int i = 0; i < secretWord.length(); i++) {
			if (guess == secretWord.charAt(i)) {
				hiddenWord[i] = secretWord.charAt(i);
				occurenceCounter++;
				
			}
		}
		//Decreasing the turns if the user guessed a letter that doesn't occur in the secret word:
		if (occurenceCounter == 0) {
			turns--; //See at the beginning of the while cycle for the display of turns.
		}
				
		return turns;
	}
	
	//4. Method that checks if the user has revealed the secret word:
	static boolean checkWin(char[] hiddenWord, String secretWord) {
		boolean win = false;
		int similarityCounter = 0;
		for (int i = 0; i < secretWord.length(); i++){
			if (hiddenWord[i] == secretWord.charAt(i)) {
				similarityCounter++;
			}
		}
		if (similarityCounter == secretWord.length()) {
			win = true;
		}
		return win;
	}
	
	//5. Method that checks the reason for quitting the gaming cycle:
	static void winOrLoose(int turns, boolean win, String secretWord, char[][] gallowsPole) {
		if (turns < 1) {
			System.out.println("YOU WERE HANGED!");
			displayGallowsPole(turns, gallowsPole);
			System.out.println("Reincarnate, and try again :)");
		} else {
			if (win = true) {
			System.out.println("CONGRATULATIONS, YOU HAVE WON!");
			System.out.println("The secret word is " + "'" + secretWord + "'" + ".");
			}
		}
	}
		
	//6. Method that displays the gallows pole according to the turns case:
	static void displayGallowsPole(int turns, char[][] gallowsPole) {
		
		//Changing the field according to the turns left:
		switch (turns) {
			
			case 6:
					break;
		
			case 5: 
					for (int i = 1; i <= 8; i++) {			 
						gallowsPole[i][2] = '|';
					}
					break;
					
			case 4: 
					for (int i = 2; i <= 6; i++) {			 
					gallowsPole[1][i] = '_';
					}
					break;
					
			case 3: 
					gallowsPole[2][4] = '/';
					gallowsPole[3][3] = '/';
					break;
					
			case 2: 
				 	gallowsPole[2][5] = '|';
				 	break;
				 	
			case 1: 
				 	gallowsPole[3][5] = 'O';
				 	break;
				 	
			case 0: 
			 	gallowsPole[4][5] = '|';
			 	gallowsPole[5][5] = '|';
			 	gallowsPole[4][4] = '_';
			 	gallowsPole[4][6] = '_';
			 	gallowsPole[6][4] = '/';
			 	gallowsPole[5][6] = '_';
			 	break; 	
				 	
		}
		//Displaying the 2D array:
			 	for (int i = 0; i < gallowsPole.length; i++) {
			 		for (int j = 0; j < gallowsPole[i].length; j++) {
			 			if (j < gallowsPole[i].length-1) {
			 				System.out.print(gallowsPole[i][j]);
			 			} else {
			 				System.out.println(gallowsPole[i][j]);
			 			}
			 		}
			 	}
	}
	

	
	//End of class:
}
