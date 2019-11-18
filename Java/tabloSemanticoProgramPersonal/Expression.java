package TabloGreat;

public class Expression {
	private String expression;
	private boolean verification;
	private boolean closes=false;
	private String lowestSignal;
	private int signalPriority; 
	private int signalBPos;
	private int signalEPos; 
	private double label;
	
	public int getSignalBPos() {
		return signalBPos;
	}
	public void setSignalBPos(int signalBPos) {
		this.signalBPos = signalBPos;
	}
	public int getSignalEPos() {
		return signalEPos;
	}
	public void setSignalEPos(int signalEPos) {
		this.signalEPos = signalEPos;
	}
	public String getLowestSignal() {
		return lowestSignal;
	}
	public void setLowestSignal(String lowestSignal) {
		this.lowestSignal = lowestSignal;
	}
	public int getSignalPriority() {
		return signalPriority;
	}
	public void setSignalPriority(int signalPriority) {
		this.signalPriority = signalPriority;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public boolean isVerification() {
		return verification;
	}
	public void setVerification(boolean verification) {
		this.verification = verification;
	}
	public boolean isCloses() {
		return closes;
	}
	public void setCloses(boolean closes) {
		this.closes = closes;
	}
	public double getLabel() {
		return label;
	}
	public void setLabel(double label) {
		this.label = label;
	}
	  
	
}
