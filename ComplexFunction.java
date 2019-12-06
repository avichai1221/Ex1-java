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
		Operation op=Operation.Times;
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
	public void div(function f1) {
		Operation op=Operation.Divid;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public function right()
	{
		// TODO Auto-generated method stub
		return null;
	}
	public void mul(Polynom f1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public function copy() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double f(double x)
	{
		// TODO Auto-generated method stub
		return 0;
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
