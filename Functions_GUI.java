package Ex1;


import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions {

	public ArrayList<function> funcs = new ArrayList<function>();
	
	public Functions_GUI()
	{
		
	}
	@Override
	public boolean add(function arg0) 
	{
		return funcs.add(arg0);
		
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		return funcs.addAll(arg0);
		
	}

	@Override
	public void clear() {
		funcs.clear();
		
	}

	@Override
	public boolean contains(Object arg0) {
		
		return funcs.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return funcs.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return funcs.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		
		return funcs.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return funcs.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
	
		return funcs.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return funcs.retainAll(arg0);
	}

	@Override
	public int size() {
		return funcs.size();
	}

	@Override
	public Object[] toArray() {
		return funcs.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return funcs.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {
		ComplexFunction cf4 = new ComplexFunction("div", new Polynom("x+1"),new Polynom("x+1"));

		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		String st; 
		while ((st = br.readLine()) != null) {
		  funcs.add(cf4.initFromString(st)); 
		  
		}
		br.close();
	
	}

	@Override
	public void saveToFile(String file) throws IOException 
	{
			File f= new File(file);
			f.createNewFile();
		    BufferedWriter buffer = new BufferedWriter(new FileWriter(f));
		    for (function function : funcs) 
		    {
			    buffer.write(function.toString()+"\n");
			    buffer.newLine();
		    }

		 
		    buffer.close();
		    
		    Path currentRelativePath = Paths.get("");
		    String s = currentRelativePath.toAbsolutePath().toString();
		    System.out.println("Current relative path is: " + s);	
		    }

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {
		
	
		
		

		double AxisX=rx.get_max()-rx.get_min();
	
		StdDraw.setXscale(rx.get_min(),rx.get_max()); 
		StdDraw.setYscale(ry.get_min(),ry.get_max()); 
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(),0,rx.get_max(),0);      //Axis x
		StdDraw.line(0,ry.get_min(),0,ry.get_max());     //Axis y
		StdDraw.setPenRadius(0.002);
////////horizontal lines and numbers
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+1)
		{
		StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		StdDraw.textRight(0, i, Integer.toString((int)i)); 
		}
////////vertical lines and numbers
		for(double i=rx.get_min();i<rx.get_max();i=i+2)
		{
			StdDraw.line(i, ry.get_min(),i , ry.get_max());
			StdDraw.textRight(i, 0, Integer.toString((int)i));
		}
		StdDraw.setPenRadius(0.003);
		Color[] ColorsFunctions= {Color.blue, Color.cyan,
				Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
		for(int i=0;i<funcs.size();i++)// all function 
		{
			double Step=AxisX/resolution;
			double help=rx.get_min();
			int helpForColor=(int)(Math.random()*7);
			StdDraw.setPenColor(ColorsFunctions[helpForColor]);
			while(help<rx.get_max())
			{
				StdDraw.line(help, funcs.get(i).f(help),help+Step,funcs.get(i).f(help+Step));
				help=help+Step;
			}
			
		}
	
	
	}
	


	@Override
	public void drawFunctions(String json_file) {

		
	}

		
	

	@Override
	public String toString() 
	{
		return funcs.toString();
	}

	public function get(int i) 
	{
		if(i<funcs.size())
			return funcs.get(i);
		return null;
	}

	}

