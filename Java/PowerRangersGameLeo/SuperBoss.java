
public class SuperBoss extends Boss { 
	private double defense;
	public SuperBoss(String name,double health, double attackPwr, double armor,Weapon weapon) {
		super(name,health, attackPwr, armor,weapon);  
		this.defense=100;
	} 
	public void attack(Megazord m) {
		double damage=(this.attackPwr + weapon.getAttackpwr()/3)- m.getDefense(); 
		m.setHealth(m.getHealth() - damage); 
		System.out.println("seu megazorde levou " + damage + " de dano");
	} 
	public void SuperBossSpecial(Megazord m) {
		System.out.println("o chefe " + name + " usa seu especial causando giggantescas explosoes que expllodem tudo ao redor");
		double damage=attackPwr * 2 + weapon.getAttackpwr();
		m.setHealth(m.getHealth() - damage); 
		System.out.println("o seu megazorde levou " + damage + " de dano");
	}
	public double getDefense() {
		return defense;
	}
	public void setDefense(double defense) {
		this.defense = defense;
	}
	
}
