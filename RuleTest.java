import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the Rule Class methods.
 * 
 * @author Mark Adams
 * @version 2013/05/01
 */
public class RuleTest 
{
  Rule rule;

	@Before
	public void setUp() throws Exception 
	{
		rule = new Rule();
		
		this.rule.setPos(0, 0, '0');
		this.rule.setPos(0, 1, '1');
		this.rule.setPos(0, 2, '2');
		this.rule.setPos(1, 0, '3');
		this.rule.setPos(1, 1, '4');
		this.rule.setPos(1, 2, '5');
		this.rule.setPos(2, 0, '6');
		this.rule.setPos(2, 1, '7');
		this.rule.setPos(2, 2, '8');
	}

	@Test
	public void testRotate90DegCW() 
	{
		Rule rotatedRule = this.rule.rotate90DegCW();
		
		assertEquals(false, rotatedRule.getPos(0, 0) == '0');
		assertEquals(true, rotatedRule.getPos(0, 0) == '6');
		assertEquals(true, rotatedRule.getPos(1, 1) == '4');
		assertEquals(true, rotatedRule.getPos(1, 1) == 52); //52 is the Ascii decimal value for the character 4.
		assertEquals(false, rotatedRule.getPos(2, 2) == '8');
		assertEquals(true, rotatedRule.getPos(2, 2) == '2');
	}
	
	@Test
	public void testRowOrColNum()
	{
		assertEquals(true, this.rule.rowOrColNum(2) == 2);
		assertEquals(true, this.rule.rowOrColNum(8) == 2);
		assertEquals(true, this.rule.rowOrColNum(10) == 0);
		assertEquals(true, this.rule.rowOrColNum(-1) == 0);
		assertEquals(false, this.rule.rowOrColNum(5) == 2);
	}
	
	@Test
	public void testRotate90DegCCMiddlePos()
	{
		assertEquals(true, this.rule.rotate90DegCCMiddlePos(0, 1, 2) == 3);
		assertEquals(true, this.rule.rotate90DegCCMiddlePos(6, 3, 0) == 7);
		assertEquals(true, this.rule.rotate90DegCCMiddlePos(8, 7, 6) == 5);
		assertEquals(true, this.rule.rotate90DegCCMiddlePos(2, 5, 8) == 1);
		assertEquals(false, this.rule.rotate90DegCCMiddlePos(0, 1, 2) == 1);
		assertEquals(false, this.rule.rotate90DegCCMiddlePos(0, 1, 2) == 5);
		assertEquals(false, this.rule.rotate90DegCCMiddlePos(0, 1, 2) == 8);
	}
}
