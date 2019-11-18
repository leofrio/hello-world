package TabloGreat;

import java.util.ArrayList;

public class Bifurcation  extends Expression{
	private ArrayList<Expression> exp1;
	private ArrayList<Expression> bifuArrayExp1;
	private ArrayList<Expression> exp2;
	private ArrayList<Expression> bifuArrayExp2;
	
	
	public ArrayList<Expression> getBifuArrayExp1() {
		return bifuArrayExp1;
	}
	public void setBifuArrayExp1(ArrayList<Expression> bifuArrayExp1) {
		this.bifuArrayExp1 = bifuArrayExp1;
	}
	public ArrayList<Expression> getBifuArrayExp2() {
		return bifuArrayExp2;
	}
	public void setBifuArrayExp2(ArrayList<Expression> bifuArrayExp2) {
		this.bifuArrayExp2 = bifuArrayExp2;
	}
	public ArrayList<Expression> getExp1() {
		return exp1;
	}
	public void setExp1(ArrayList<Expression> exp1) {
		this.exp1 = exp1;
	}
	public ArrayList<Expression> getExp2() {
		return exp2;
	}
	public void setExp2(ArrayList<Expression> exp2) {
		this.exp2 = exp2;
	}
	
}
