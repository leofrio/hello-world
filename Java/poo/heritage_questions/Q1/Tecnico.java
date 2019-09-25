
public class Tecnico extends Assistente {
	private double bonus;
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public Tecnico(double salary,double bonus) {
		this.bonus = bonus;
		this.salary=salary;
		this.salary+= bonus;
	}
	
	
}
