package Ex1;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Policy.Parameters;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonParser;



public class Functions_GUI implements functions{
	LinkedList<function> collection= new LinkedList<function>();
	@Override
	public boolean add(function f) {
		return collection.add(f);
	
	}

	@Override
	public boolean addAll(Collection<? extends function> f)
	{
		return collection.addAll(f);
	}

	@Override
	public void clear() {
		collection.clear();
		
	}

	@Override
	public boolean contains(Object o) {
		return collection.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		
		return collection.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return collection.isEmpty();
	}

	@Override
	public Iterator<function> iterator() {
		return collection.iterator();
	}



	@Override
	public boolean removeAll(Collection<?> arg0) {
		return collection.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return collection.retainAll(arg0);
	}

	@Override
	public int size() {
		return collection.size();
	}

	@Override
	public Object[] toArray() {
		return collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return collection.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException 
		 {
		   String line = "";
		    
		        try 
		        {
		        	BufferedReader br = new BufferedReader(new FileReader(file));
		        	ComplexFunction cfHelp=new ComplexFunction();
		            while ((line = br.readLine()) != null) 
		            {
		            	function fHelp= cfHelp.initFromString(line);
		            	collection.add(fHelp);
		            }
		            br.close();
		        } 
		        catch (IOException e) 
		        {
		            e.printStackTrace();
		            System.out.println("could not read file");
		        }
		
	}

	@Override
	public void saveToFile(String file) throws IOException 
		{	
			try 
			{
				PrintWriter pw = new PrintWriter(new File(file));
				
				StringBuilder sb = new StringBuilder();
				
				Iterator <function> it = collection.iterator();
				while (it.hasNext())
				{
				sb.append(it.next().toString()+"\n");
				}
				pw.write(sb.toString());
				pw.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				return;
			}
		
		
	}


	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) 
	{
		

		double AxisX=rx.get_max()-rx.get_min();
		double AxisY=ry.get_max()-ry.get_min();
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
		for(int i=0;i<collection.size();i++)// all function 
		{
			double Step=AxisX/resolution;
			double help=rx.get_min();
			int helpForColor=(int)(Math.random()*7);
			StdDraw.setPenColor(ColorsFunctions[helpForColor]);
			while(help<rx.get_max())
			{
				StdDraw.line(help, collection.get(i).f(help),help+Step,collection.get(i).f(help+Step));
				help=help+Step;
			}
			
		}

	}

	@Override
	public boolean remove(Object o) {
		return collection.remove(o);
	}

	
	@Override
	public void drawFunctions(String json_file) 
	{
		  Gson gson = new Gson();
	        try {
	            FileReader reader = new FileReader(json_file);
	            helpFordrawFunctions fromJson =  gson.fromJson(reader,helpFordrawFunctions.class);
	            Range forX = new Range(fromJson.Range_X[0],fromJson.Range_X[1]);
	            Range forY = new Range(fromJson.Range_Y[0], fromJson.Range_Y[1]);
	            drawFunctions(fromJson.Width, fromJson.Height, forX, forY, fromJson.Resolution);
	        }
	        catch (FileNotFoundException e) {
	        	int w=1000, h=600, res=200;
	    		Range rx = new Range(-10,10);
	    		Range ry = new Range(-5,15);
	    		drawFunctions(w,h,rx,ry,res);
	            e.printStackTrace();
	        }
		
	}
	public String toString()
	{
		return collection.toString();
	}

/////////////////////////class help////////////////////////////////
public class helpFordrawFunctions {

public int Width;
public int Height;
public int Resolution;
public double[] Range_X;
public double[] Range_Y;
}


}
