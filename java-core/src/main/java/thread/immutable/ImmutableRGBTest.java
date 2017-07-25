package thread.immutable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImmutableRGBTest {
	private ImmutableRGB rgb=null;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isImmutableRGBReallyImmutable() {
		String name="BLACK";
		rgb=new ImmutableRGB(255, 255, 255, "BLACK");
		assertEquals("BLACK",rgb.getName());
		name="RED";
		assertEquals("BLACK",rgb.getName());
		 
	}

}
