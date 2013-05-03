/**
 * Determines the legalities of attempted moves in a standard game of Tic-Tac-Toe.
 * 
 * @author Mark Adams
 * @version 2013/05/02
 */
public class Judge 
{  
	/**
	 * Determine whether it is currently X or O's turn.
	 * 
	 * @param board -> The board that is being or about to be played on.
	 * @return The player who gets to make a move.
	 */
	public char getPlayerTurn(Board board)
	{
		char result = 'X';
		
		int xCounter = 0, oCounter = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				if (board.getPos(j, i) == 'X')
					xCounter++;
				else if (board.getPos(j, i) == 'O')
					oCounter++;
			}
		
		if (xCounter != oCounter && !(xCounter == 0 && oCounter == 0))
			result = 'O';
				
		return result;		
	}
	
	/**
	 * Determines whether or not a player can make a move at a specified row and column on a given Board.
	 * This is determined by checking if another player has already placed their token in that position.
	 * 
	 * @param board -> The board that is being or about to be played on.
	 * @param row -> The row that the player wants to access.
	 * @param column -> The column that the player wants to access.
	 * @return Whether or not there is already a player token in that position.
	 */
	public boolean isValidMove(Board board, int row, int column)
	{
		return ((board.getPos(2, 0) != 'W') &&
				(board.getPos(row, column) != 'X') && 
				(board.getPos(row, column) != 'O') && 
				(board.getPos(row, column) != 'N') && 
				(board.getPos(row, column) != 'W'));
	}
	
	/**
	 * Checks to see if a player has won the game.
	 * 
	 * @param board -> The board that is being or about to be played on.
	 * @param player -> The players token.
	 * @return Whether or not the given player has won the game.
	 */
	public boolean hasWon(Board board, char player) 
	{
		boolean result = false; 
		
		if (board.getPos(2, 0) != 'W')
		{
			if ((checkDirection(board, player, 'd')) || 	// Check for a diagonal win.   
				(checkDirection(board, player, 'h')) || 	// Check for a horizontal win. 
				(checkDirection(board, player, 'v'))) 		// Check for a vertical win.   
				result = true;
		}
		
		return result;
	}
	
	/**
	 * Determines if x characters are all the same. 
	 * 
	 * @param firstChar -> The first character to check against others.
	 * @param otherChars -> The rest of the characters that need to be checked against the first character.
	 * @return Whether or not all of the given characters are equal to eachother.
	 */
	private static boolean areAllEqual(char firstChar, char... otherChars)
	{
		boolean areEqual = true;
		
	    for (int value : otherChars)
	        if (value != firstChar)
	            areEqual = false;
	        
	    return areEqual;
	}
	
	/**
	 * Checks to see if a player has the same character in all three of the directions positions.
	 * 
	 * @param board -> The board that is being or about to be played on.
	 * @param player -> The player being checked.
	 * @param direction -> 'd' - diagonal, 'h' - horizontal, 'v' - vertical.
	 * @return Whether or not the specified player has their character in all of the specified direction positions.
	 */
	private static boolean checkDirection(Board board, char player, char direction)
	{
		boolean result = false;
		
		switch (Character.toLowerCase(direction))
		{
			// Check for a diagonal win starting from the left or right corner of the board.
			case 'd': 	if ((areAllEqual(player, board.getPos(0, 0), board.getPos(1, 1), board.getPos(2, 2))) || 
							(areAllEqual(player, board.getPos(0, 2), board.getPos(1, 1), board.getPos(2, 0))))
							result = true;
							break;
			
			// Check for a horizontal win starting from the left rows.
			case 'h': 	if ((areAllEqual(player, board.getPos(0, 0),  board.getPos(0, 1), board.getPos(0, 2))) ||
					 		(areAllEqual(player, board.getPos(1, 0),  board.getPos(1, 1), board.getPos(1, 2))) ||
					 		(areAllEqual(player, board.getPos(2, 0),  board.getPos(2, 1), board.getPos(2, 2))))
							result = true;
							break; 
							
			// Check for a vertical win starting from the left column.
			case 'v': 	if ((areAllEqual(player, board.getPos(0, 0), board.getPos(1, 0), board.getPos(2, 0))) ||
							(areAllEqual(player, board.getPos(0, 1), board.getPos(1, 1), board.getPos(2, 1))) ||
							(areAllEqual(player, board.getPos(0, 2), board.getPos(1, 2), board.getPos(2, 2))))
							result = true;
							break;
			
			default:		result = false;
							break;
		}
		
		return result;
	}
}
