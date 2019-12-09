
public class Weapon {
	private String name;
	private double attackpwr;
	
	
	public Weapon(String name, double attackpwr) {
		super();
		this.name = name;
		this.attackpwr = attackpwr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAttackpwr() {
		return attackpwr;
	}
	public void setAttackpwr(double attackpwr) {
		this.attackpwr = attackpwr;
	}
	
	
}
