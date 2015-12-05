import java.util.Scanner;

public class Game5 {

	public static void main(String[] args) {
		
		//Enter the playing field:
		char[][] field = { 
							{'#','#','#','#','#','#','#','#','#','#','#','#'},
							{'#','H',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
							{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
							{'#',' ',' ',' ',' ',' ','#',' ',' ','#',' ','#'},
							{'#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
							{'#',' ',' ','#','#',' ',' ',' ',' ',' ',' ','#'},
							{'#',' ',' ',' ',' ','O',' ',' ','#',' ',' ','#'},
							{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','#'},
							{'#',' ','#','#',' ',' ','#','#',' ',' ',' ','#'},
							{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
							{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','F','#'},
							{'#','#','#','#','#','#','#','#','#','#','#','#'}
							
		};
		
		//Displaying the field:
		for (int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				if (j < field[i].length-1) {
					System.out.print(field[i][j]);
				} else {
					System.out.println(field[i][j]);
				}
			}
		}
		
		//Stating the rules and controls:
		System.out.println("Welcome to my first PC game!");
		System.out.println("Move 'H' to 'O' and then push 'O' to the 'F'");
		System.out.println("To move press w-up/s-down/a-left/d-right and then press ENTER.");
		System.out.println("If you push 'O' towards the '#' - IT WILL EXPLODE AND THE GAME IS OVER!");
		System.out.println();
		
		
		
		//Creating a cycle that will run until the ball reaches F or is pushed to an obstacle.
		boolean boom = false;
		boolean win = false;
		char move;
		Scanner sc = new Scanner(System.in);
		
		//Cycle of player's moves:
		while (boom != true && win != true) {
			
									
			//Find the 'H' element:
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[i].length; j++) {
					
					//When we find 'H' we make a move and check different options, according to the move's value:
					if (field[i][j] == 'H') {
						
						//Enter a valid moving key:
						System.out.println("Make your move:");
						move = sc.next().charAt(0);
							
						
						//Define the actions to be performed according to the value of move:
			
						//MOVING UPWARDS:
						if (move == 'w') {
									
							//If above 'H' there is '#' we do nothing and break, going to the beginning of the cycle to
							//wait for another move:
							if (field[i-1][j] == '#') {
								break;
								
							} else {
								//If the space above 'H' is empty, change the values of this empty space and 'H'.
								//That means moving 'H' upwards.
								if (field[i-1][j] == ' ') {
									char temp = field[i][j];
									field[i][j] = field[i-1][j];
									field[i-1][j] = temp;
									break;
									
								} else {
									//If the ball is above 'H' and there is a '#' above the ball, the ball explodes 
									//the boom variable changes its value to true and we break the cycle:
									if (field[i-1][j] == 'O' && field[i-2][j] == '#') {
										boom = true;
										break;
										
									} else {
										//If the ball is above 'H' and above the ball there is an empty space
										//then the ball moves to this empty space and 'H' follows it:
										if (field[i-1][j] == 'O' && field[i-2][j] == ' ') {
											char temp = field[i][j];
											field[i][j] = field[i-2][j];
											field[i-2][j] = field[i-1][j];
											field[i-1][j] = temp;
											break;
										} else {
											if (field[i-1][j] == 'O' && field[i-2][j] == 'F') {
												win = true;
												break;
											}
										}
									}
								}
							}
							
						} 
						
						//MOVING DOWNWARDS:
						if (move == 's') {
							//If below 'H' there is '#' we do nothing and break, going to the beginning of the cycle to wait for another move:
							if (field[i+1][j] == '#') {
								break;
							} 

							//If the space below 'H' is empty, change the values of this empty space and 'H'.That means moving 'H' downwards.
							if (field[i+1][j] == ' ') {
								char temp = field[i][j];
								field[i][j] = field[i+1][j];
								field[i+1][j] = temp;
									//Display the modified field:
									for (int k = 0; k < field.length; k++) {
										for(int l = 0; l < field[k].length; l++) {
											if (l < field[k].length-1) {
												System.out.print(field[k][l]);
											} else {
												System.out.println(field[k][l]);
											}
										}
									}
								break;
							} 
									
							//If the ball is below 'H' and there is a '#' below the ball, the ball explodes 
							//the boom variable changes its value to true and we break the cycle:
							if (field[i+1][j] == 'O' && field[i+2][j] == '#') {
								boom = true;
									//Display the modified field:
									for (int k = 0; k < field.length; k++) {
										for(int l = 0; l < field[k].length; l++) {
											if (l < field[k].length-1) {
												System.out.print(field[k][l]);
											} else {
												System.out.println(field[k][l]);
											}
										}
									}
									break;
							} 
										
							//If the ball is below 'H' and below the ball there is an empty space
							//then the ball moves to this empty space and 'H' follows it:
							if (field[i+1][j] == 'O' && field[i+2][j] == ' ') {
								char temp = field[i][j];
								field[i][j] = field[i+2][j];
								field[i+2][j] = field[i+1][j];
								field[i+1][j] = temp;
									//Display the modified field:
									for (int k = 0; k < field.length; k++) {
										for(int l = 0; l < field[k].length; l++) {
											if (l < field[k].length-1) {
												System.out.print(field[k][l]);
											} else {
												System.out.println(field[k][l]);
											}
										}
									}
									break;
							} 
										
										
							if (field[i+1][j] == 'O' && field[i+2][j] == 'F') {
								win = true;
									//Display the modified field:
									for (int k = 0; k < field.length; k++) {
										for(int l = 0; l < field[k].length; l++) {
											if (l < field[k].length-1) {
												System.out.print(field[k][l]);
											} else {
												System.out.println(field[k][l]);
											}
										}
									}
								break;
							}
																										
						} 
				
						
						//MOVING LEFT:
							if (move == 'a') {
								//Here we will check the different scenarios and define different actions 
								//according to the outcome:
									
									//If left to 'H' there is '#' we do nothing and break, going to the beginning of the cycle to
									//wait for another move:
									if (field[i][j-1] == '#') {
										break;
										
									} else {
										//If the space left to 'H' is empty, change the values of this empty space and 'H'.
										//That means moving 'H' upwards.
										if (field[i][j-1] == ' ') {
											char temp = field[i][j];
											field[i][j] = field[i][j-1];
											field[i][j-1] = temp;
											break;
											
										} else {
											//If the ball is left of 'H' and there is a '#' on the left of the ball, the ball explodes 
											//the boom variable changes its value to true and we break the cycle:
											if (field[i][j-1] == 'O' && field[i][j-2] == '#') {
												boom = true;
												break;
												
											} else {
												//If the ball is left to 'H' and on the left of the ball there is an empty space
												//then the ball moves to this empty space and 'H' follows it:
												if (field[i][j-1] == 'O' && field[i][j-2] == ' ') {
													char temp = field[i][j];
													field[i][j] = field[i][j-2];
													field[i][j-2] = field[i][j-1];
													field[i][j-1] = temp;
													break;
												} else {
													if (field[i][j-1] == 'O' && field[i][j-2] == 'F') {
														win = true;
														break;
													}
												}
											}
										}
									}
							} 

							
							//MOVING RIGHT:
								if (move == 'd') {
									//Here we will check the different scenarios and define different actions 
									//according to the outcome:
										
										//If right to 'H' there is '#' we do nothing and break, going to the beginning of the cycle to
										//wait for another move:
										if (field[i][j+1] == '#') {
											break;
											
										} else {
											//If the space right to 'H' is empty, change the values of this empty space and 'H'.
											//That means moving 'H' upwards.
											if (field[i][j+1] == ' ') {
												char temp = field[i][j];
												field[i][j] = field[i][j+1];
												field[i][j+1] = temp;
												break;
												
											} else {
												//If the ball is right of 'H' and there is a '#' on the right of the ball, the ball explodes 
												//the boom variable changes its value to true and we break the cycle:
												if (field[i][j+1] == 'O' && field[i][j+2] == '#') {
													boom = true;
													break;
													
												} else {
													//If the ball is right to 'H' and on the right of the ball there is an empty space
													//then the ball moves to this empty space and 'H' follows it:
													if (field[i][j+1] == 'O' && field[i][j+2] == ' ') {
														char temp = field[i][j];
														field[i][j] = field[i][j+2];
														field[i][j+2] = field[i][j+1];
														field[i][j+1] = temp;
														break;
													} else {
														if (field[i][j+1] == 'O' && field[i][j+2] == 'F') {
															win = true;
															break;
														}
													}
												}
											}
										}
								} 

								
														
					}
					
				}
						
			}
			
			//Display the modified field:
			for (int i = 0; i < field.length; i++) {
				for(int j = 0; j < field[i].length; j++) {
					if (j < field[i].length-1) {
						System.out.print(field[i][j]);
					} else {
						System.out.println(field[i][j]);
					}
				}
			}
			
		//After finishing the while cycle, we check the reason why: because the ball pushed an obstacle or because it reached F.	
		
	}
		System.out.println();		
		if (boom == true) {
			System.out.println("GAME OVER!");
			System.out.print("Let's try again :)");
		}
		
		if (win == true) {
			System.out.println("Congratulations!!!");
			System.out.print("YOU WIN!");
		}
		sc.close();
		
}
}
