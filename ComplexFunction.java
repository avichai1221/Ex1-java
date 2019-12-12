package Ex1ready;

public class ComplexFunction implements complex_function
{
	private Operation op;
	private function left;
	private function right;

	public ComplexFunction (Operation op,function left,function right)
	{
		this.op=op;
		this.left=left;
		this.right=right; 
	}
	public ComplexFunction ()
	{
		this.op=null;
		this.left=null;
		this.right=null; 
	}

	public ComplexFunction (String op,function left,function right)
	{
		
		this.left=left;
		this.right=right;
		if(op=="none"||op=="Times"||op=="plus"||op=="div"||op=="Mul"||op=="max"||op=="min"||op=="comp"||op=="None"||op=="Plus"||op=="Divid"||op=="divid"||op=="mul"||op=="Max"||op=="Min"||op=="Comp")
		{
			switch(op)
			{
			case "none":
				this.op=Operation.None;
				break;
			case "plus":
				this.op=Operation.Plus;
				break;
			case "mul":
				this.op=Operation.Times;
				break;
			case"div":
				this.op=Operation.Divid;
				break;
			case"divid":
				this.op=Operation.Divid;
				break;
			case"Times":
				this.op=Operation.Times;
				break;
			case"max":
				this.op=Operation.Max;
				break;
			case "min":
				this.op=Operation.Min;
				break;
			case "comp":
				this.op=Operation.Comp;
				break;
			case "None":
				this.op=Operation.None;
				break;
			case "Plus":
				this.op=Operation.Plus;
				break;
			case "Mul":
				this.op=Operation.Times;
				break;
			case"Divid":
				this.op=Operation.Divid;
				break;
			case"Max":
				this.op=Operation.Max;
				break;
			case "Min":
				this.op=Operation.Min;
				break;
			case "Comp":
				this.op=Operation.Comp;
				break;
			}}
		else
		{
			System.out.println(op);
			this.op=Operation.Error;
		}
	}
	public ComplexFunction (function left)
	{
		this.left=left;
		this.op=null;
		this.right=null; 
	}
	////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public double f(double x)
	{
		if (op==Operation.None||op==Operation.Error)
		{
			System.out.println("Something is wrong-Unable to calculate (op= None or Error)");
		}
		if(op==Operation.Divid) 
			return left.f(x)/right.f(x);

		if(op==Operation.Plus) 
			return left.f(x)+right.f(x);

		if(op==Operation.Times) 
			return left.f(x)*right.f(x);

		if(op==Operation.Max) 
			return Math.max(left.f(x), right.f(x)); 

		if(op==Operation.Min)
			return Math.min(left.f(x), right.f(x));

		if(op==Operation.Comp)
			return left.f(right.f(x));
		return 0;
	}

	@Override
	public function initFromString(String s)
	{

		String op=""; 
		String left1="";
		String right1="";
		String ans="";
		int start=0;
		int end=s.length()-1;
		if(!s.contains(",")&&!s.contains("+")&&!s.contains("-"))
			return new Monom(s);

		if(!s.contains(",") && (s.contains("+") || s.contains("-")))
			return new Polynom(s);

		while(s.charAt(start)!='(') 
		{
			
			op=op+s.charAt(start);
			start++;
		}

		start++;
		while(s.charAt(start)!='(' && s.charAt(start) !=',')
		{
			ans=ans+s.charAt(start);
			start++;
		}

		if(s.charAt(start)=='(') {
			int temp=0;
			boolean f=true; 
			while(f) {

				if(s.charAt(start)=='(')
					temp++; 
				if(s.charAt(start)==')')
					temp--;

				ans=ans+s.charAt(start); 
				start++;

				if(temp==0)
					f=false;
			}

			left1=ans;
			right1=s.substring(start+1, end);
			op=switchOp(op);
		}

		if(s.charAt(start)==',') {
			left1=ans;
			right1=s.substring(start+1, end);
			op=switchOp(op); 
			 
		}

		function left=initFromString(left1);
		function right=initFromString(right1);
		op=switchOp(op);
		
		

		return new ComplexFunction(op,left,right);

	}


	@Override
	public void plus(function f1) 
	{
		Operation op=Operation.Plus;
		ComplexFunction cfHelp=new ComplexFunction();
		if(this.getRight()==null) 
		{
			cfHelp.setLeft(this.left);
		}
		else 
		{
			cfHelp.setLeft(this.left);
			cfHelp.setRight(this.right);
			cfHelp.setOp(this.op);
		}
		this.setLeft(cfHelp);
		this.setOp(op);
		this.setRight(f1);

	}

	private String switchOp(String Operator) 
	{
		String s="";
		switch(Operator)
		{
		case "comp":
			s= "Comp";
			break;
		case "mul":
			s= "Times";
			break;
		case "Times":
			s= "Times";
			break;
		case"div":
			s= "Divid";
			break;
		case"plus":
			s= "Plus";
			break;
		case"min":
			s= "Min";
			break;
		case"max":
			s= "Max";
			break;
		case "Comp":
			s= "Comp";
			break;
		case "Mul":
			s= "Times";
			break;
		case"Divid":
			s= "Divid";
			break;
		case"Plus":
			s= "Plus";
			break;
		case"Min":
			s= "Min";
			break;
		case"Max":
			s= "Max";
			break;
		}
		return s;

	}
	@Override
	public void mul(function f1)
	{
		this.plus(f1);
		this.op=Operation.Times;
		
	}

	@Override
	public void div(function f1) 
	{
		this.plus(f1);
		this.op=Operation.Divid;
	}


	@Override
	public void max(function f1) 
	{
		this.plus(f1);
		this.op=Operation.Max;
	

	}
	@Override
	public void min(function f1)
	{
		this.plus(f1);
		this.op=Operation.Min;
		

	}

	@Override
	public void comp(function f1)
	{
		this.plus(f1);
		this.op=Operation.Comp;
		

	}
	@Override
	public function left()
	{
		return this.getLeft();
	}

	@Override
	public function right()
	{
		return this.getRight();
	}

	@Override
	public function copy() 
	{
		ComplexFunction ans=new ComplexFunction (this.getOp(),this.getLeft(),this.getRight());	
		return (function)ans;
	}


	public boolean equals(Object obj) {
		String one=this.toString();
		String two=obj.toString();
		if (one.length()!=two.length()) return false;
		for (int i = 0; i < one.length(); i++) 
		{
			if (one.charAt(i)!=two.charAt(i))	return false;
		}
		return true;


	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Operation getOp()
	{
		return op;

	}

	public function getLeft()
	{
		return left;
	}

	public void setLeft(function left)
	{
		this.left = left;
	}

	public function getRight()
	{
		return right;
	}

	public void setRight(function right)
	{
		this.right = right;
	}

	public void setOp(Operation op)
	{
		this.op = op;
	}
	@Override
	public String toString() 
	{
		if(this.right!=null && this.op!= null)
		{
			return  this.op+"("+this.left + ","+ this.right +")";
		}
		return this.left+"";
	}

}
