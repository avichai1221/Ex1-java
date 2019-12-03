package Ex1;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {
	@Test
	void testIsZero() {
		Monom a=new Monom(0,3);
		boolean act=a.isZero();
		assertTrue(act);
	}
	/*@Test
	void testIsZero2() {
		Monom a=new Monom(1,3);
		boolean act=a.isZero();
		assertTrue(act);
	}*/
	@Test
	void testF() {
		Monom a=new Monom(1,3);
		double actual=a.f(3.0);
		assertEquals(27.0, actual);
	}
	/*@Test
	void testF2() {
		Monom a=new Monom(1,3);
		double actual=a.f(3.0);
		assertEquals(2, actual);
	}*/
	
	@Test
	void testAdd() {
		Monom a=new Monom(2,3);
		Monom b=new Monom(1,3);
		a.add(b);
		Monom expected=new Monom(3,3);
		assertTrue(a.equals(expected));
		
	}
	
	@Test
	void testAdd2() {
		Monom a=new Monom(2,2);
		Monom b=new Monom(1,3);
			try
			{
				
				a.add(b);
				fail("the powers is diffrent");			}
			catch (Exception e) {
			}
			
		}
	
	@Test
	void testEquals() {
		Monom a=new Monom(1,3);
		Monom b=new Monom(1,3);
		Monom c=new Monom(1,2);
		assertTrue(a.equals(b));
		assertFalse(a.equals(c));
	}
	
	@Test
	void testsub() {
		Monom a=new Monom(2,3);
		Monom b=new Monom(1,3);
		a.add(b);
		Monom expected=new Monom(3,3);
		assertTrue(a.equals(expected));
		
	}
	@Test
	void testSub2() {
		Monom a=new Monom(2,2);
		Monom b=new Monom(1,3);
			try
			{
				a.sub(b);
				fail("the powers is diffrent");			}
			catch (Exception e) {
			}
			
		}
	
	@Test
	void testDerivative() {
		Monom a=new Monom(2.2,4);
		Monom actual=a.derivative();
		String Sactual=actual.toString();
		String expected="8.8x^3";
		assertEquals(expected,Sactual);
	}
	
	@Test
	void testToString() {
		Monom a=new Monom(2.2,4);
		assertEquals("2.2x^4",a.toString());
		
	}

	@Test
	void testMultiply() {
		Monom a=new Monom(5,2);
		Monom b=new Monom(3,1);
		a.multiply(b);
		assertEquals("15.0x^3",a.toString());
	}


	@Test
	void testInitFromString() {
		String s = "-1.5x^2";
		function w =new Monom(0,0);
		function expected=new Monom(-1.5,2);
		assertEquals(expected.toString(),w.initFromString(s).toString());
	}
	
	@Test
	void testCopy() {
		function w =new Monom(4,6);
		function actual=w.copy();
		function expected=new Monom(4,6);
		assertEquals(expected.toString(),actual.toString());
	}

}
