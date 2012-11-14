/**
 *  This code is written by Umar Qasim Qureshi 
 *  $$$$$$$$$$$$$$ All Rights Reserved $$$$$$$$$$$$
 *  Email: engr.umar.qureshi@gmail.com 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Calculations
{
	private String Exp,value,cmp,rtn;
	private Queue<String> parts=new LinkedList<String>();
	private Queue<String> pfix=new LinkedList<String>();
	private Stack<String> stack=new Stack<String>();
	private float op1,op2,ans;
	private int flag1=0,erflag=0,syerflag=0,valflag=0,minusflag=0;
	public String Calc(String exp)
	{
		Exp=exp;
		value="";
		cmp="x/+-0123456789.";
		
		 for(int i=0; i<Exp.length(); i++)
			{
			 			
					 if(Exp.charAt(i)==cmp.charAt(4) || Exp.charAt(i)==cmp.charAt(5) || Exp.charAt(i)==cmp.charAt(6)||Exp.charAt(i)==cmp.charAt(7)||Exp.charAt(i)==cmp.charAt(8)||Exp.charAt(i)==cmp.charAt(9)||Exp.charAt(i)==cmp.charAt(10)||Exp.charAt(i)==cmp.charAt(11)||Exp.charAt(i)==cmp.charAt(11)||Exp.charAt(i)==cmp.charAt(12)||Exp.charAt(i)==cmp.charAt(13)||Exp.charAt(i)==cmp.charAt(14))
					 {
						 value=value+Exp.charAt(i);
						 if(i==Exp.length()-1)
						 {
							 
							 parts.add(value);
								value="";
								valflag=0;
						 }
						 valflag=1;
							 
					 }
					 else
					 if(Exp.charAt(i)==cmp.charAt(0) || Exp.charAt(i)==cmp.charAt(1) || Exp.charAt(i)==cmp.charAt(2)||Exp.charAt(i)==cmp.charAt(3))
					 {
						
						if(i==0)
						{
							minusflag=1;
							
						}
						else
						{
							if(valflag==1)
							 {
								 
								 parts.add(value);
								 valflag=0;
							 }
							value=""+Exp.charAt(i);
							parts.add(value);
							value="";
						}
						
					 }
					 
			 
			}
		 while(!(parts.isEmpty()))
		 {
			 String ruff=new String(parts.poll());
			 //Log.v("Chkr", "Minus Flag Value="+ruff);
			 if(ruff.length()==1 && ruff.charAt(0)==cmp.charAt(0) || ruff.charAt(0)==cmp.charAt(1) || ruff.charAt(0)==cmp.charAt(2) || ruff.charAt(0)==cmp.charAt(3))
			 {
				 syerflag=syerflag+1;
				
				 if(stack.isEmpty())
				 {
					 stack.push(ruff);
				 }
				 else
				 {
					
						 if(ruff.charAt(0)==cmp.charAt(0) || ruff.charAt(0)==cmp.charAt(1))
						 {
							 while(!(stack.isEmpty()))
							 {
									 String chk=stack.pop();
									if(chk.charAt(0)==cmp.charAt(0)||chk.charAt(0)==cmp.charAt(1))
									{
										pfix.add(chk);
									}
									else
									{
										stack.push(chk);
										stack.push(ruff);
										flag1=1;
										break;
									}
							 }
							 if(flag1 != 1)
							 {
								 stack.push(ruff);
							 }
						 }
						 else
						 if(ruff.charAt(0)==cmp.charAt(2) || ruff.charAt(0)==cmp.charAt(3))
						 {
							 while(!(stack.isEmpty()))
							 {
								 pfix.add(stack.pop());
							 }
							 stack.push(ruff);
						 }
						 
				 } 
				 
			 }
			 else
			 {
				 if(syerflag==1)
				 {
					 syerflag=0;
				 }
				 pfix.add(ruff);
			 }
			
		 }
		 while(!(stack.isEmpty()))
		 {
			 pfix.add(stack.pop());
		 }
		 flag1=0;
		 if(syerflag==0)
		 {
			 while(!(pfix.isEmpty()))
			 {
				 if(flag1>=2)
				 {
					 String ruff=new String(pfix.poll());
					 if(ruff.length()==1 && ruff.charAt(0)==cmp.charAt(0) || ruff.charAt(0)==cmp.charAt(1) || ruff.charAt(0)==cmp.charAt(2) || ruff.charAt(0)==cmp.charAt(3))
					 {
						
						 op1=new Float(stack.pop());
						 op2=new Float(stack.pop());
						 
						 if(ruff.charAt(0)==cmp.charAt(0))
						 {
							 
							 ans=op2*op1;
							 stack.push(""+ans);
							 flag1=flag1-1;
						 }
						 else
						 if(ruff.charAt(0)==cmp.charAt(1))
						 {
							 
							 if(op1==0.0){ans=0;erflag=1;}
							 else{ans=op2/op1;}
							 stack.push(""+ans);
							 flag1=flag1-1;	
						 }
						 else
						 if(ruff.charAt(0)==cmp.charAt(2))
						 {
							
							 ans=op2+op1;
							 stack.push(""+ans);
							 flag1=flag1-1;
						 }
						 else
						 if(ruff.charAt(0)==cmp.charAt(3))
						 {
							
							 ans=op2-op1;
							 stack.push(""+ans);
							 flag1=flag1-1;	 
						 }
					 }
					 else
					 {
						
						
						 stack.push(ruff);
						 flag1=flag1+1;
						 
					 }
					 
				 }
				 else
				 {
					 
					 if(minusflag==1)
					 {
						 stack.push("-"+pfix.poll());
						 flag1=flag1+1;
						minusflag=0;
					 }
					 else
					 {
					 stack.push(pfix.poll());
					 flag1=flag1+1;
					 }
				 }
			 }
		 }
		 if(erflag==1)
		 {
			 rtn="Math Error";
			 erflag=0;
		 }
		 else
		 if(syerflag!=0)
		 {
			 
			 rtn="Syntax Error";
			 syerflag=0;
		 }
		 else
		 {
			 rtn=stack.pop();
		 }
		 stack.clear();
		 pfix.clear();
		 parts.clear();
		 flag1=0;
		 
		return rtn;
	}
	
	
}