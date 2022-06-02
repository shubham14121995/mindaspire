
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("CalculatorTest");
    }
	
	// Empty String
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	// One Number
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	// Two Numbers
	@Test
	public void testTwoNumbers(){
		assertEquals(5, Calculator.add("2,3"));
	}
	
	// Three Numbers
	@Test
    public void testThreeNumbers(){
    	assertEquals(15, Calculator.add("4,5,6"));
    }

	// New Line
    @Test
    public void testNewLine(){
    	assertEquals(17, Calculator.add("7\n2,8"));
    }

    @Test
    public void testNegativeNumver(){
    	// One Negative Number
    	try {
			Calculator.add("-9,10");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -9");
		}
    	
    	// Multiple Negative Number
		try {
			Calculator.add("11,-12,13,-14");
		}
		catch (IllegalArgumentException e){
			assertEquals(e.getMessage(), "Negatives not allowed: -12,-14");
		}
    }


    // Other Delimiter
    @Test
    public void testOtherDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
}