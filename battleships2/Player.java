package battleships2;

public abstract class Player {

	//Inner class:
	private class Aquatory {
		//Inner class fields:
		private char[][] area = {{' ','0','1','2','3','4','5','6','7','8','9',' '},
								 {'a',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','a'},
								 {'b',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','b'},
								 {'c',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','c'},
								 {'d',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','d'},
								 {'e',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','e'},
								 {'f',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','f'},
								 {'g',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','g'},
								 {'h',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','h'},
								 {'i',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','i'},
								 {'j',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','j'},
								 {' ','0','1','2','3','4','5','6','7','8','9',' '}
		};
		
		//Inner class methods:
		private void displayAquatory() {
			for (int i = 0; i < this.area.length; i++) {
				for (int j = 0; j < this.area[i].length; j++) {
					if (j < this.area[i].length-1) {
						System.out.print(this.area[i][j] + " ");
					} else {
						System.out.println(this.area[i][j] + " ");
					}
				}
			}
			System.out.println();
		}
		
		private void mark(int i, int j, char result) {
			this.area[i][j] = result;
		}
	}
	
		
	//Fields of the outer class:
	private String name;
	private Aquatory ownAquatory = new Aquatory();
	private Aquatory enemyAquatory = new Aquatory();
	private Ship[] fleet = new Ship[5];
	
	//Constructor:
	public Player(String name){
		
	}
	
	//Getters:
	protected String getName() {
		return name;
	}

	protected Aquatory getOwnAquatory() {
		return ownAquatory;
	}

	protected Aquatory getEnemyAquatory() {
		return enemyAquatory;
	}

	protected Ship[] getFleet() {
		return fleet;
	}
	
	
	//Methods:
	public void displayMaps() {
		this.ownAquatory.displayAquatory();
		this.enemyAquatory.displayAquatory();
	}
	
	
	public abstract void fire(Player opponent);
	
	
	
	
}
