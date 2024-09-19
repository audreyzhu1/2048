
public class TwoModel {


	
	private int[][] tile= new int[4][4]; 
	private int score; 
	private boolean noChange; 
	
	
	
	TwoModel() {
		score = 0; 
		noChange = true; 
		addNewTile();
		addNewTile(); 
		
		
	}
	
	void newGame() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
			
				tile[i][j] = 0;
			}
		}
		
		score = 0; 
		noChange = true; 
		addNewTile(); 
		addNewTile(); 
		
	}
	public int getNumber (int row, int col) {
//	
		return tile[row][col];
	}
	public int pieceAt(int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	void addNewTile() {
		int i = 0; 
		int j = 0; 
		boolean setAgain = true; 
		boolean tileEmpty = false; 
		
		for (int k = 0; k <= 3; k++) {
			for (int m = 0; m<=3; m++) {
				if (tile[k][m] == 0) {
					tileEmpty = true; 
					
					break; 
				}
			}
			
		}
		if (tileEmpty) {
			while (setAgain) {
				
				i = (int)(Math.random() * 4); 
				j = (int)(Math.random() * 4); 
				if (tile[i][j] == 0) {
					tile[i][j] = 2;

					setAgain = false; 
				}
				
			}
		}
    }  
	
	public void moveLeft() {
		
		int [] a = new int[4]; 

		
		alignLeft (); 
		
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				
				
				if (tile[i][j] == 0) {
					a[j] = 0; 
				} else {
					a[j]= tile[i][j]; 
					
	
				}
			}
			if ((a[0]==a[1]) && (a[1]==a[2]) && (a[2]==a[3]) && (a[0]!= 0)) {
				mergeLeft (i,1); 
				mergeLeft (i,3); 
			
				
			}
			else {
				
				for (int j = 0; j<=2; j++) {
					
					if (a[j] == a[j+1] && a[j]!=0) {
						mergeLeft(i,j+1); 
						a[j] = tile[i][j];
						a[j+1] = 0; 
						
					}
								
							
						
	
					
				}
				
			}
			
			
		}
		alignLeft(); 
		if (noChange == false) {
			noChange = true;
			addNewTile(); 
			; 
		}
	}
	public void moveRight() {
		flipBoardHorizontal(); 
		moveLeft(); 
		flipBoardHorizontal(); 
	}
	
	public void moveUp() {
		flipBoardDiagonal(); 
		moveLeft(); 
		flipBoardDiagonal(); 
	}
	
	public void moveDown() {
		flipBoardDiagonal(); 
		moveRight(); 
		flipBoardDiagonal(); 
	}
	public void mergeLeft(int i, int j) {
		tile[i][j-1]=2 * tile[i][j];
			
		tile[i][j] = 0; 
		addScore(tile[i][j-1]); 
		noChange = false; 
		
		
	}
	
	
	public void alignLeft() {
		for (int i = 0; i<=3; i++) {
			for (int j = 0; j<=3; j++) {
				if (tile[i][j] == 0)  {
					
					for (int k = j+1; k<= 3; k++) {
						if (tile[i][k] != 0) {
							tile[i][j] = tile[i][k]; 
							tile[i][k] = 0; 
							noChange = false; 
							break; 
						}
					}
				}
			}
		}
		
		
		
	}
	
	public void addScore(int iScore) {
		score += iScore; 
	}
	
	// model
	public int getScore () {
		return score; 
	}
	
	// model
	public boolean win() {
		for (int i = 0; i<=3; i++) {
			for (int j = 0; j<=3; j++) {
				if (tile[i][j] != 0 && tile[i][j] == 2048) {
					
				
					return true; 
				}
			}
		}
		return false;
		
	}
	
	// model
	public boolean lose() {
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j<=3; j++) {
				if (tile[i][j] == 0) {
					return false; 
				}
				
			}
		}
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j<=2; j++) {
				if (tile[i][j] == tile[i][j+1]) {
					return false; 
				}
			}
		
		}
		for (int j = 0; j<=3; j++) {
			for (int i = 0; i<=2; i++) {
				if (tile[i][j] == tile[i+1][j]){
					return false; 
				}
			}
		}
		
		
		
		return true; 
		
		
	}
	
	// model
	public void flipBoardHorizontal () {
		int temp = 0; 
	
		for (int i = 0; i<=3; i++) {
			for (int j = 0; j<=1; j++) {
				temp = tile[i][j]; 
				tile[i][j] = tile[i][3-j]; 
				tile[i][3-j] = temp; 
			}
		}
			
			
	}
	
	//model
	public void flipBoardDiagonal() {
		int temp = 0; 
		
		for (int i = 1; i<=3; i++) {
			for (int j = 0; j<=i-1; j++) {
				temp = tile[i][j]; 
				tile[i][j] = tile[j][i]; 
				tile[j][i] = temp; 
			}
		}
	}


}
