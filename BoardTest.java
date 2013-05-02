import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Mark Adams
 * @version 2013/05/01
 */
public class BoardTest 
{
	Board board;
	
	@Before
	public void setUp() throws Exception
	{
		this.board = new Board();
	}

	@Test
	public void testInitializeToToken()
	{
		assertEquals(true, this.board.get(0).get(0).equals(' '));
		assertEquals(true, this.board.get(0).get(1).equals(' '));
		assertEquals(true, this.board.get(0).get(2).equals(' '));
		assertEquals(true, this.board.get(1).get(0).equals(' '));
		assertEquals(true, this.board.get(1).get(1).equals(' '));
		assertEquals(true, this.board.get(1).get(2).equals(' '));
		assertEquals(true, this.board.get(2).get(0).equals(' '));
		assertEquals(true, this.board.get(2).get(1).equals(' '));
		assertEquals(true, this.board.get(2).get(2).equals(' '));	
		assertEquals(false, this.board.get(1).get(2).equals('X'));
	}
	
	@Test
	public void testToString()
	{
		assertEquals(true, this.board.toString().equals("   \n   \n   \n"));
		assertEquals(false, this.board.toString().equals("   \n   \n   "));
		assertEquals(false, this.board.toString().equals("         "));
		
		this.board.setPos(0, 1, 'X');
		assertEquals(true, this.board.toString().equals(" X \n   \n   \n"));
	
	}
	
	@Test
	public void testSetPos()
	{
		this.board.setPos(0, 1, 'X');
		assertEquals(true, this.board.get(0).get(1).equals('X'));
		assertEquals(false, this.board.get(0).get(1).equals(' '));
		
		this.board.setPos(2, 2, '?');
		assertEquals(true, this.board.get(2).get(2).equals('?'));
		assertEquals(false, this.board.get(2).get(2).equals('0'));
		
		this.board.setPos(1, 1, ' ');
		assertEquals(true, this.board.get(1).get(1).equals(' '));
		assertEquals(false, this.board.get(1).get(1).equals('?'));
	}
	
	@Test
	public void testGetPos()
	{
		assertEquals(true, this.board.getPos(0, 0) == ' ');
		assertEquals(true, this.board.getPos(1, 1) == ' ');
		assertEquals(true, this.board.getPos(2,2) == ' ');
		
		this.board.setPos(1, 0, 'O');
		assertEquals(false, this.board.getPos(1, 0) == ' ');
		assertEquals(true, this.board.getPos(1, 0) == 'O');
	}
}
