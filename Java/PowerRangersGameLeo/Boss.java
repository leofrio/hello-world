import java.util.ArrayList;

public class Boss extends Villain {
	protected Weapon weapon; 
	protected String name; 
	
	public Boss(String name,double health, double attackPwr, double armor ,Weapon weapon) { 
		super(name,health, attackPwr, armor);
		this.weapon=weapon; 
		this.name=name;
	}
	public void BossSpecial(ArrayList<Ranger> r) {
		System.out.println("o chefao ataca com um ataque explosivo que feta todos os rangers"); 
		for(int i=0; i< r.size();i++) {
			
			if(r.get(i).isCalled()) { 
				double damage= attackPwr*2.2 + weapon.getAttackpwr()/3; 
				r.get(i).setAnimalHealth(r.get(i).getAnimalHealth() - damage); 
				System.out.println("o animal do ranger " + r.get(i).getName() + ": " + r.get(i).getAnimalType() + " levou " + damage + " de dano");
			}
			else {
				double damage= attackPwr*2.2 + weapon.getAttackpwr()/3 - r.get(i).getArmor(); 
				r.get(i).setHealth(r.get(i).getHealth() - damage); 
				System.out.println("o ranger " + r.get(i).getName() + " levou " + damage +  " de dano");
			}
		}
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
