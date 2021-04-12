import java.util.Scanner;

public class TicTacToe {
	
	public static void printBoard(String[][] gameBoard) {
		
		for (int row = 0; row < gameBoard.length; row++) {
			for (int col = 0; col < gameBoard[row].length; col++)
				System.out.print(gameBoard[row][col]);
			System.out.println();
		}
		
	}
	
	public static boolean makeMove(String[][] gameBoard, String player, int row, int col) {
		
		if (gameBoard[row][col].equals("X") || gameBoard[row][col].equals("O"))
			return true;
		
		else {
			gameBoard[row][col] = player;
			return false;
		}
		
	}
	
	public static boolean haveWinner(String[][] gameBoard, String player) {
		
		// Horizontal victory
		if ((gameBoard[0][0].equals(player) && gameBoard[0][1].equals(player) && gameBoard[0][2].equals(player)) ||
			(gameBoard[1][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[1][2].equals(player)) ||
			(gameBoard[2][0].equals(player) && gameBoard[2][1].equals(player) && gameBoard[2][2].equals(player)))
			return true;
	
		// Vertical victory
		else if ((gameBoard[0][0].equals(player) && gameBoard[1][0].equals(player) && gameBoard[2][0].equals(player)) ||
				 (gameBoard[0][1].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][1].equals(player)) ||
				 (gameBoard[0][2].equals(player) && gameBoard[1][2].equals(player) && gameBoard[2][2].equals(player)))
			return true;
		
		// Diagonal victory
		else if ((gameBoard[0][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][2].equals(player)) ||
				 (gameBoard[2][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[0][2].equals(player)))
			return true;
		
		else
			return false;
		
	}
	
    public static void main(String[] args) {
		
		String[][] gameBoard = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
		String player = "O";
						
		Scanner keyboard = new Scanner(System.in);
		
		int turns;
		boolean idiot;
		
		printBoard(gameBoard);
		
		for (turns = 1; turns <= 9 && !haveWinner(gameBoard, player); turns++) {
		
			player = player.equals("X") ? "O" : "X";
		
			System.out.println("Player " + player + " please pick a slot between 1 and 9");
			int choice = keyboard.nextInt();
			
			switch (choice) {
								
				case 1:
					idiot = makeMove(gameBoard, player, 0, 0);
					break;
	
				case 2:
					idiot = makeMove(gameBoard, player, 0, 1);
					break;
										
				case 3:
					idiot = makeMove(gameBoard, player, 0, 2);
					break;
					
				case 4:
					idiot = makeMove(gameBoard, player, 1, 0);
					break;
	
				case 5:
					idiot = makeMove(gameBoard, player, 1, 1);
					break;
	
				case 6:
					idiot = makeMove(gameBoard, player, 1, 2);
					break;
	
				case 7:
					idiot = makeMove(gameBoard, player, 2, 0);
					break;
	
				case 8:
					idiot = makeMove(gameBoard, player, 2, 1);
					break;
	
				case 9:
					idiot = makeMove(gameBoard, player, 2, 2);
					break;
	
				default:
					idiot = true;
					break;
					
			}
			
			printBoard(gameBoard);
			
			if (idiot == true) {
				turns--;
				player = player.equals("X") ? "O" : "X";
				System.out.println("Please enter a valid move you idiot!");
				idiot = false;
			}
			
		}

		if (turns == 10)
			System.out.println("We have a tie!");

		else
			System.out.println("Player " + player + " has won the game!");
    }
}
