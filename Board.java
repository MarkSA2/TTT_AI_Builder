import java.util.ArrayList;

/**
 * A Tic-Tac-Toe Board. Holds the contents of a game or rule.
 *
 * @author Mark Adams
 * @version 2013/05/01
 */
public class Board extends ArrayList<ArrayList<Character>>
{	
	private static final long serialVersionUID = 1L;

	public Board()
	{

	}
	
	/**
	 * Fill the Board with a specified character token.
	 * Determined filler tokens include but are not limited to the following:
	 * 	- '?' which represents "Do not care."
	 * 	- ' ' which represents "Space."
	 * 
	 * @param token
	 * @return
	 */
	public Board initializeToToken(char token)
	{	
		for (int i = 0; i < 3; i++)
		{
			this.add(new ArrayList<Character>());
			for (int j = 0; j < 3; j++)
				this.get(i).add(j, token);
		}
		
		return this;
	}
	
	/**
	 * Converts a Board into a String object.
	 */
	public String toString()
	{
		String result = new String();
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
				result += this.get(i).get(j);
		
			result += "\n";
		}
		
		return result;
	}
	
	/**
	 * Set a position on the Board to a given character token.
	 * 
	 * @param row -> The row to place the token in.
	 * @param col -> The column to place the token in.
	 * @param token -> The token to place in the specified row and column.
	 */
	public void setPos(int row, int col, char token)
	{
		//TODO: Create "setPos" method.
	}
	
	/**
	 * Get a token from a given position on the Board.
	 * 
	 * @param row -> The row to get the token from.
	 * @param col -> The column to get the token from.
	 */
	public char getPos(int row, int col)
	{
		//TODO: Create "getPos" method.
		return ' ';
	}
}
