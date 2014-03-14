import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.*;


public class JUnitTest {
	
	SudokuModel model = new SudokuModel(9, 9);

	@Test
	public void testGet() {
		char c = model.returnValue(0, 0);
		assertEquals(c, 0);
	}

	@Test
	public void testSet() {
		char c = 1;
		model.setValue(0, 0, c);
		assertEquals(1 , model.returnValue(0, 0));
	}
	
}
