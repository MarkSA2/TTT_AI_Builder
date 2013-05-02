/**
 * Based on specified scenarios, a Rule tells the Strategy how it should make moves on the Tic-Tac-Toe Board. 
 * 
 * @author Mark Adams
 * @version 2013/05/01
 */
public class Rule extends Board
{
	private static final long serialVersionUID = 1L;
	
	public Rule() 
	{
		this.initializeToToken('?');
	}
	
	/**
	 * Rotate a Rule 90 degrees clockwise.
	 * 
	 * @return A Rule that has been rotated 90 degrees clockwise.
	 */
	public Rule rotate90DegCW()
	{
		Rule rotatedRule = new Rule();

		for (int sRowGCol = 0; sRowGCol < 3; sRowGCol++)
			for (int sCol = 0, gRow = 2; sCol < 3; sCol++, gRow--)
				rotatedRule.setPos(sRowGCol, sCol, this.getPos(gRow, sRowGCol));
				
		return rotatedRule;	
	}
	
	/**
	 * Determines the column or row number based on the given starting position.
	 * 
	 * @param position1 -> The first position in the set of three positions.
	 * @return An integer representing the column or row number that is started by the first position.
	 */
	public int rowOrColNum(int position1)
	{
		int result = 0;
		
		if (position1 == 2 || position1 == 8)
			result = 2;
		
		return result;
	}
	
	/**
	 * Calculates the 90 degrees counter-clockwise rotated middle position of a board containing only three positions.
	 * Assumes that together the positions make up a distinct row or column.
	 * 
	 * @param position1 -> The first position in the set of three positions.
	 * @param position2 -> The middle position in the set of three positions.
	 * @param position3 -> The last position in the set of three positions.
	 * @return An integer representing the rotated middle position.
	 */
	public int rotate90DegCCMiddlePos(int position1, int position2, int position3)
	{
		int middlePos = Math.max(position1, position3) - Math.min(position1, position3), rowOrColNum = rowOrColNum(position1);
		
		if (rowOrColNum < 2)
			middlePos += rowOrColNum + 1;
		else
			middlePos = Math.abs((-1*middlePos) + position2);
		
		return middlePos;
	}
	
	/**
	 * Calculates the 90 degrees counter-clockwise rotated positions for a board containing only three positions.
	 * Assumes that together the positions make up a distinct row or column.
	 * 
	 * @param position1 -> The first position in the set of three positions.
	 * @param position2 -> The middle position in the set of three positions.
	 * @param position3 -> The last position in the set of three positions.
	 * @return An integer array containing the rotated positions.
	 */
	public int[] rotated90DegCCSection(int position1, int position2, int position3)
	{
		int[] rotatedPositions = new int[3];
		int middlePos = rotate90DegCCMiddlePos(position1, position2, position3);
		
		rotatedPositions[0] = (middlePos*2) - position1;
		rotatedPositions[1] = middlePos;
		rotatedPositions[2] = position1; // The last rotated position will always be the first argument position.
		
		return rotatedPositions;
	}
	
	/**
	 * Shift the Rule contents one space horizontally (downward). 
	 * The bottom-most row of the Rule will place its contents in the positions of the top-most row.
	 * 
	 * @return A Rule that has had its contents shifted one space horizontally.
	 */
	public Rule shiftHorizontal()
	{
		//TODO: Create "shiftHorizontal" method.
		return new Rule();
	}
	
	/**
	 * Shift the Rule contents one space vertically (right). 
	 * The right-most column of the Rule will place its contents in the positions of the left-most columns.
	 * 
	 * @return A Rule that has had its contents shifted one space vertically.
	 */
	public Rule shiftVertical()
	{
		//TODO: Create "shiftVertical" method.
		return new Rule();
	}
	
	/**
	 * Flip the Rule contents. The contents of the left and right columns will be switched.
	 * 
	 * @return A board which has switched its left column contents with its right column contents. 
	 */
	public Rule flip()
	{
		//TODO: Create "flip" method.
		return new Rule();
	}
}
