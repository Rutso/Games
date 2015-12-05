import java.util.Scanner;

public class CowsAndBulls1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. Generating a random 4-digit number:
		String theNumber = generateNumber();
		System.out.println("I have a 4-digit number made of different digits on my mind.");
		System.out.println("CAN YOU GUESS IT IN 7 TURNS?");
		
		//2. The game's cycle:
		int bulls = 0;
		int turns = 7;
		String guess;
		while (bulls < 4 && turns > 0) {
			
			//Player's turn:
			guess = enterGuess();
			
			bulls = evaluateGuess(theNumber, guess);
			turns--;
			if (bulls < 4) {
			System.out.println(turns + " guesses left!");
			} 
			
		}
		
		//Determining the outcome:
		if (turns == 0 && bulls < 4) {
			System.out.print("TRY AGAIN :)");
		}
		if (bulls == 4) {
			System.out.print("Congratulations! You made a right guess. The number is " + theNumber + ".");
		}
		
	//Manin's method closing bracket:
	}

	
	
	//1. Method that generates a random 4-digit number (transformed into string):
	static String generateNumber() {
		
			StringBuilder number = new StringBuilder();
			int firstDigit = 0;
			while (firstDigit == 0) {
				firstDigit = (int) (Math.random()*10);
			}
			number.append( (char) (48 + firstDigit));
			
			
			
		while (number.length() < 4) {
						
			char digit = (char) (48 + (int) (Math.random()*10));
				 						
			for(int i = 0; i < number.length(); i++) {
				if (digit == number.charAt(i)) {
					digit = '0';
					break;
				}
			}
			if (digit != '0') {
				number.append(digit);
			}
		}
			return number.toString();
	}
	
	
	
	//2. Method that enters the player's guess:
	static String enterGuess() {
		Scanner sc = new Scanner(System.in);
		
		String guess;
		
		do {
			System.out.print("Please, make your guess: ");
			guess = sc.nextLine();
			
			
			for (int i = 0; i < guess.length(); i++) {
				for (int j = i+1; j < guess.length(); j++) {
					if (guess.charAt(i) == guess.charAt(j) || guess.charAt(i) == '0') {
						guess = "mistake";
						break;
					}
				}
			}
			
		} while (guess.equals("mistake") || guess.length() != 4);
		
		return guess;
	}
	
	
	//3. Method that evaluates the player's turn:
	static int evaluateGuess(String theNumber, String guess) {
		
		int bulls = 0;
		int cows = 0;
		
		for (int i = 0; i < theNumber.length(); i++) {
			if (guess.charAt(i) == theNumber.charAt(i)) {
				bulls++;
			}
			for (int j = 0; j < theNumber.length(); j++) {
				if (guess.charAt(i) == theNumber.charAt(j) && i != j) {
					cows++;
				}
			}
			
		}
		if (bulls < 4) {
			if (bulls == 1 && cows == 1) {
				System.out.println("You have " + bulls + " bull and " + cows + " cow.");
			} else {
				if (bulls == 1 && cows != 1) {
					System.out.println("You have " + bulls + " bull and " + cows + " cows.");
				} else {
					if (bulls != 1 && cows == 1) {
						System.out.println("You have " + bulls + " bulls and " + cows + " cow.");
					} else {
						System.out.println("You have " + bulls + " bulls and " + cows + " cows.");
					}
				}
			}
		
		}
			
		return bulls;
	}
	
	
	
//class's closing bracket:
}
