package matala1;

import java.util.ArrayList;

public class MonomTest {

	
		
		public static void main(String[] args) {
			test1();
			test2();
		}
	
		private static void test1() {
			System.out.println("*****  Test1:  *****");
			String[] monoms = {"2", "-x","-3.2x^0","0"};
			for(int i=0;i<monoms.length;i++) {
				Monom m = new Monom(monoms[i]);
				String s = m.toString();
				m = new Monom(s);
				double fx = m.f(i);
				System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"\t f("+i+") = "+fx);
			}
		}
		
		private static void test2() {
			System.out.println("*****  Test2:  *****");
			ArrayList<Monom> monoms = new ArrayList<Monom>();
			monoms.add(new Monom(0,5));
			monoms.add(new Monom(-1,0));
			monoms.add(new Monom(-1.3,1));
			monoms.add(new Monom(-2.2,2));
			
			for(int i=0;i<monoms.size();i++) {
				Monom m = new Monom(monoms.get(i));
				String s = m.toString();
				Monom m1 = new Monom(s);
				boolean e = m.equals(m1);
				System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
			}
		}

}

