package TabloGreat;

import java.util.ArrayList;

public class Rules {
	public Expression appllyRule(Expression e) { 
		String signal=e.getLowestSignal();
		boolean validation=e.isVerification(); 
		String first="";
		String second="";
		for(int i=0; i < e.getSignalBPos();i++) { 
			char letter= e.getExpression().charAt(i);
			first += Character.toString(letter);
		}
		for(int i=e.getSignalEPos()+1;i < e.getExpression().length();i++) {
			char letter=e.getExpression().charAt(i);
			second +=Character.toString(letter);
		}
		if(signal == "v" && validation == true) {
			Bifurcation b=new Bifurcation();  
			ArrayList<Expression> y=new ArrayList<Expression>();
			ArrayList<Expression> n=new ArrayList<Expression>(); 
			Expression a=new Expression(); 
			Expression c=new Expression();
			a.setExpression(first); 
			c.setExpression(second);
			a.setVerification(true);
			c.setVerification(true);
			y.add(a); 
			n.add(c);
			b.setExp1(y); 
			b.setExp2(n); 
			return b;
		} 
		if(signal == "v" && validation == false) {
			Prolongation p=new Prolongation();
			Expression a=new Expression();
			Expression b=new Expression(); 
			a.setExpression(first);
			a.setVerification(false);
			b.setExpression(second);
			b.setVerification(false);
			p.setExp1(a);
			p.setExp2(b); 
			return p;
		}
		if(signal == "^" && validation == true) { 
			Prolongation p=new Prolongation();
			Expression a=new Expression();
			Expression b=new Expression();  
			a.setExpression(first);
			a.setVerification(true);
			b.setExpression(second);
			b.setVerification(true);
			p.setExp1(a);
			p.setExp2(b); 
			return p;
		} 
		if(signal == "^" && validation == false) {
			Bifurcation b=new Bifurcation();  
			ArrayList<Expression> y=new ArrayList<Expression>();
			ArrayList<Expression> n=new ArrayList<Expression>(); 
			Expression a=new Expression(); 
			Expression c=new Expression();
			a.setExpression(first); 
			c.setExpression(second);
			a.setVerification(false);
			c.setVerification(false);
			y.add(a); 
			n.add(c);
			b.setExp1(y); 
			b.setExp2(n); 
			return b;
		}   
		if(signal == "->" && validation == true) {
			Bifurcation b=new Bifurcation();  
			ArrayList<Expression> y=new ArrayList<Expression>();
			ArrayList<Expression> n=new ArrayList<Expression>(); 
			Expression a=new Expression(); 
			Expression c=new Expression();
			a.setExpression(first); 
			c.setExpression(second);
			a.setVerification(false);
			c.setVerification(true);
			y.add(a); 
			n.add(c);
			b.setExp1(y); 
			b.setExp2(n); 
			return b;
		} 
		if(signal == "->" && validation == false) {
			Prolongation p=new Prolongation();
			Expression a=new Expression();
			Expression b=new Expression(); 
			a.setExpression(first);
			a.setVerification(true);
			b.setExpression(second);
			b.setVerification(false);
			p.setExp1(a);
			p.setExp2(b); 
			return p;
		}  
		if(signal == "<>" && validation == true) {  
			Bifurcation b=new Bifurcation();  
			ArrayList<Expression> y=new ArrayList<Expression>();
			ArrayList<Expression> n=new ArrayList<Expression>(); 
			Expression a=new Expression(); 
			Expression c=new Expression();
			Expression d=new Expression();
			Expression f=new Expression(); 
			a.setExpression(first);
			a.setVerification(false);
			c.setExpression(second);
			c.setVerification(false);
			d.setExpression(first); 
			d.setVerification(true); 
			f.setExpression(second);
			f.setVerification(true); 
			y.add(a); 
			y.add(c);
			n.add(d);
			n.add(f); 
			b.setExp1(y);
			b.setExp2(n); 
			return b;
		} 
		if(signal == "<>" && validation == false) {  
			Bifurcation b=new Bifurcation();  
			ArrayList<Expression> y=new ArrayList<Expression>();
			ArrayList<Expression> n=new ArrayList<Expression>(); 
			Expression a=new Expression(); 
			Expression c=new Expression();
			Expression d=new Expression();
			Expression f=new Expression(); 
			a.setExpression(first);
			a.setVerification(true);
			c.setExpression(second);
			c.setVerification(false);
			d.setExpression(first); 
			d.setVerification(false); 
			f.setExpression(second);
			f.setVerification(true); 
			y.add(a); 
			y.add(c);
			n.add(d);
			n.add(f); 
			b.setExp1(y);
			b.setExp2(n);
			return b;
		}
		return null;
	} 
	public Expression  apllyRuleNot(Expression e) {
		e.setVerification(!e.isVerification()); 
		String newexp="";
		for(int i=1;i < e.getExpression().length();i++) {
			char letter=e.getExpression().charAt(i); 
			newexp += letter;
		} 
		e.setExpression(newexp);
		return e;
	}
}
