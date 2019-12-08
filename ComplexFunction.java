package Ex1;

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
		switch(op)
		{
		case "":
			this.op=Operation.None;
			break;
		case "None":
			this.op=Operation.None;
			break;
		case "Plus":
			this.op=Operation.Plus;
			break;
		case "Times":
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
		default:
			this.op=Operation.Error;
			break;

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
	public function initFromString(String s) 
	{
		if(s==null) {throw new RuntimeException("got a null string");}//if its null
		if(s.contains("^-")){throw new RuntimeException("got a negative power");}//if its got a negative power
	
		int save1=0;
		String s1="";
		if (s.contains(","))
			for (int i = 0; i < s.length(); i++)
			{
			if (s.charAt(i)=='(')
				{
				save1=i;
				if (s.charAt(i)==',') s1=s1.substring(i, save1);
				Polynom cc=new Polynom(s1);
				}
			if (s.charAt(i)==',')
			{
			save1=i;
			if (s.charAt(i)==')') s1=s1.substring(i, save1);
			Polynom ccc=new Polynom(s1);
			}
			
			}
		
		
		String op="";
		int i = 0,save=0;
		function L=new Polynom();
		Operation test=null;
		while ( i !=s.length())
		{
			if(s.charAt(i)=='(')
			{
				op=s.substring(0, i);
				save=i;
				i++;
			}
			if(s.charAt(i)==',') 
			{
				L=new Polynom(s.substring(save+1, i));
				break;
			}
			i++;	
		}
		function R=new Polynom(s.substring(i+1, s.length()-1));
		if(op.charAt(0)=='d')
		{
			test=Operation.Divid;
		}
		if(op.charAt(0)=='m'&& op.charAt(1)=='u')
		{
			test=Operation.Times;
		}
		if(op.charAt(0)=='p')
		{
			test=Operation.Plus;
		}
		if(op.charAt(0)=='c')
		{
			test=Operation.Comp;
		}
		if(op.charAt(0)=='m'&& op.charAt(1)=='i')
		{
			test=Operation.Min;
		}
		if(op.charAt(0)=='m'&& op.charAt(1)=='a')
		{
			test=Operation.Max;
		}
		ComplexFunction x=new ComplexFunction(test,L,R);
		return x;
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


	@Override
	public void mul(function f1) {
		this.plus(f1);
		this.op=Operation.Times;
		/*	Operation op=Operation.Times;
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
		 */
	}

	@Override
	public void div(function f1) {
		this.plus(f1);
		this.op=Operation.Divid;

		/*	Operation op=Operation.Divid;
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
		this.setRight(f1);*/

	}


	@Override
	public void max(function f1) 
	{
		Operation op=Operation.Max;
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
	@Override
	public void min(function f1)
	{
		Operation op=Operation.Min;
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

	@Override
	public void comp(function f1)
	{
		Operation op=Operation.Comp;
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

	@Override
	public double f(double x)
	{

		Polynom helpLeft=new Polynom();
		Polynom helpRight=new Polynom();
		if (this.right!=null)
		{
			switch(this.op)
			{
			case None:
				System.out.println("Something is wrong-Unable to calculate");
				break;
			case Error:
				System.out.println("Something is wrong-Unable to calculate");
				break;
			case Plus:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());

				return helpRight.f(x)+helpLeft.f(x);
			case Times:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());
				return helpRight.f(x)*helpLeft.f(x);
			case Divid:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());
				return helpLeft.f(x)/helpRight.f(x);
			case Max:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());
				return Math.max(helpRight.f(x),helpLeft.f(x));
			case Min:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());
				return Math.min(helpRight.f(x),helpLeft.f(x));
			case Comp:
				helpLeft=new Polynom(this.left.toString());
				helpRight=new Polynom(this.right.toString());
				return helpLeft.f(helpRight.f(x));
			default:


			}
		}
		else
		{
			helpLeft=new Polynom(this.left.toString());
			return helpLeft.f(x);
		}
		return 0;
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
