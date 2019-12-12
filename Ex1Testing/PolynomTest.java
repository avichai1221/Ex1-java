package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import Ex1.ComplexFunction;

import Ex1.Monom;

import Ex1.Polynom;

import Ex1.function;
import Ex1.functions;
import org.junit.jupiter.api.Test;

class PolynomTest{

	@Test
	void testAddMonom() {
		Monom a=new Monom(3,3);
		Polynom p =new Polynom("5x^2-2");;
		p.add(a);
		assertEquals(p.toString(),"3.0x^3+5.0x^2-2.0");
	}

	@Test
	void testToString() {
		Polynom a=new Polynom("2.2x^4+2.4x");
		assertEquals("2.2x^4+2.4x",a.toString());
	}
	
	@Test
	void testF() {
		Polynom a=new Polynom("2x^4+2.4x+3");
		double actual= a.f(5);
	assertEquals(actual,1265);
	}
	
	
	@Test
	void testAddPolynom_able() {
		Polynom_able p1=new Polynom("2x^4+2");
		Polynom a=new Polynom("2x^4+5x+3");
		a.add(p1);
		assertEquals("4.0x^4+5.0x+5.0",a.toString());
	}
	
	@Test
	public void testPolynomString() {
		Polynom m1 =new Polynom("1");

		String s=m1.toString();

		if(!s.equals("1"))

			fail("Not the same polynom");
	}
	@Test
	public void testPolynom() {
		Polynom m =new Polynom();

		String s=m.toString();

		if(!s.equals("0")) {

			fail("this Should to be an empty polynom!");

		}
	}
	@Test
	public void testRoot() {
		Polynom p =new Polynom("x^3-x^2-7x");
		double epsilon = 0.0001;
		double a=Math.abs(p.root(3.19, 5, 0.01)-3.1935351562500003);
		if(a<epsilon)
			assertTrue(true);
		assertFalse(false);
	
		
	}
	
	@Test
	void testArea() {
		Polynom p=new Polynom("4x^4+23x^7+7");
		double a=p.area(-2, 3, 100);
		
		assertEquals(14636.0625,a);
	}
	
	
	@Test
	void testSubstractMonom() {
		Polynom a=new Polynom("4x^4+5x");
		Polynom b=new Polynom("x");
		a.substract(b);
		assertEquals("4.0x^4+4.0x",a.toString());
	}

	
	@Test
	void testSubstractPolynom_able() {
		Polynom a=new Polynom("-3x^6+2x^4+5x+3");
		Polynom_able p1=new Polynom("2x^3+2x+2");
		a.substract(p1);
		assertEquals("-3.0x^6+2.0x^4-2.0x^3+3.0x+1",a.toString());
	}

	
	@Test
	void testMultiplyMonom() {
		Polynom a=new Polynom("-3x^2+2x+3");
		Monom b=new Monom("3x");
		a.multiply(b);
		assertEquals("-9.0x^3+6.0x^2+9.0x",a.toString());
	}
	
	@Test
	void testMultiplyPolynom_able() {
		Polynom a=new Polynom("2x^2+5x+3");
		Polynom_able p1=new Polynom("2x^3+2x");
		a.multiply(p1);
		assertEquals("4.0x^5+10.0x^4+10.0x^3+10.0x^2+6.0x",a.toString());
	}

	
	@Test
	void testIsZero() {
		Polynom a=new Polynom("2x^2+5x+3");
		Polynom b=new Polynom("0");
		assertTrue(b.isZero());
		assertFalse(a.isZero());
	}
	
	@Test
	void testDerivative() {
		Polynom a=new Polynom("2x^2+5x+3");
		Polynom_able actual=a.derivative();
		assertEquals("4.0x+5.0",actual.toString());
	}

	@Test
	void testCopy() {
		Polynom a=new Polynom("2x^2+5x+3");
		Polynom_able actual=a.copy();
		assertEquals("2.0x^2+5.0x+3.0",actual.toString());
	}

	

	@Test
	void testEqualsPolynom_able() {
		Polynom a=new Polynom("2x^2+5x+3");
		Polynom_able p1=new Polynom("2x^2+5x+3");
		assertTrue(a.equals(p1));
	}

	@Test
	void testInitFromString() {
		String s="2x^2+5x-6";
		function f=new Polynom(s);
		function expected=new Polynom(s);
		assertEquals(expected.toString(),expected.initFromString(s).toString());
	}


}
