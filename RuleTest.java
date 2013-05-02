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
	
}
