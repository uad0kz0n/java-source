package algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArithmeticExpressionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTestPair() {
		ArithmeticExpression op = new ArithmeticExpression();
        
       // Assert.assertTrue(op.isParenthesisValid("{(A+B)-3}*5+[{cos(x+y)+7}-1]*4"));
        Assert.assertFalse(op.isParenthesisValid("{(A+B)-3}*5+[{cos(x+y)+7}-1]*4]"));
         
 
	}

}
