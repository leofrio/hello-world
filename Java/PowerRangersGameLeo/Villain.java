import java.util.ArrayList;

public class Villain  {
	protected double health; 
	protected double attackPwr;
	protected double armor; 
	protected String name;   
	protected int pos;
	public void attack(Ranger r, Weapon w) { 
		if(r.isCalled()) {
			double damage=attackPwr - w.getAttackpwr()/3;
			r.setAnimalHealth(r.getAnimalHealth() - damage );
			System.out.println("o animal do  ranger " + r.getName() + ":" + r.getAnimalType() + " levou " + damage + " de dano");
		} 
		else {
			double damage=(attackPwr+ w.getAttackpwr()/3) - r.getArmor();
			r.setHealth(r.getHealth() - damage); 
			System.out.println("o ranger " + r.getName() + " levou " + damage + " de dano");
		}
	} 
	

	public Villain(String name,double health, double attackPwr, double armor) {
		super();
		this.health = health;
		this.attackPwr = attackPwr;
		this.armor = armor;
		this.name = name;
	}
	

	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getAttackPwr() {
		return attackPwr;
	}
	public void setAttackPwr(double attackPwr) {
		this.attackPwr = attackPwr;
	}
	public double getArmor() {
		return armor;
	}
	public void setArmor(double armor) {
		this.armor = armor;
	} 
	

	public boolean died() { 
		if(health <= 0) { 
			return true;
		}
		else {
			return false;
		}
	}
	
}
