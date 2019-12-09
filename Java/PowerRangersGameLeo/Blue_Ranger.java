
import java.util.ArrayList;

public class Blue_Ranger extends Ranger {
	
	public Blue_Ranger() {
		super();
		setup();
	}

	@Override
	public void setup() {
		this.armor=5; 
		this.pos=3;
		this.attackPwr=60; 
		this.EnergyBar=100;
		this.health=340;
		this.name="Lucas";   
		this.color="azul";
		ArrayList<Weapon> a=new ArrayList<Weapon>();  
		Weapon one = new Weapon("Blue kick",65); 
		Weapon two= new Weapon("Blue magic", 45); 
		a.add(one); 
		a.add(two); 
		this.weapons=a;
		this.animalPwr=710;
		this.animalType="Dolphin";  
		this.animalHealth=2250;
	}

	@Override
	public void call() { 
		if(!alreadyCalled) {
			called=true; 
			System.out.println(animalType + "pronto para ser usado"); 
			this.EnergyBar = EnergyBar+20; 
		} 
		else {
			System.out.println(animalType + " nao pode ser chamado pois este ja foi destruido");
		}
	}

	@Override
	public void attack(Villain enemie) {
		if(called){ 
			double damage = this.animalPwr - enemie.getArmor();
			enemie.setHealth(enemie.getHealth() - (this.animalPwr - enemie.getArmor())); 
			System.out.println("o inimigo " + enemie.getName() + " levou " + damage + " de dano");  
			this.EnergyBar = EnergyBar+15;
		}	 
		else { 
			System.out.println("nao pode usar animal pois este nao foi chamado"); 
			this.EnergyBar = EnergyBar+20;
		}
	}  
	public void attack(Villain enemie,Weapon w) { 
		double damage=(this.attackPwr + w.getAttackpwr()/3) - enemie.getArmor();
		enemie.setHealth(enemie.getHealth() - damage); 
		System.out.println("o inimigo " + enemie.getName() + " sofreu " + damage + " de dano"); 
		this.EnergyBar = EnergyBar+15; 
	} 
	
	public void BlueSpecial(Villain e1,Villain e2) { 
		if(EnergyBar >= 100) {
			System.out.println("o ranger azul dar rapidos chutes com sua arte marcial magica,e com isso chuta varios");  
			Weapon w1=weapons.get(0); 
			Weapon w2=weapons.get(1);
			double damage=this.attackPwr *2 + w1.getAttackpwr()/3 + w2.getAttackpwr()/3;
			e1.setHealth(e1.getHealth() - damage); 
			e2.setHealth(e2.getHealth() - damage);   
			System.out.println("os inimigos " + e1.getName() + "," + e2.getName() +", levaram " + damage + " de dano");
			this.EnergyBar=0;
		} 
		else {
			System.out.println("o ranger azul nao pode usar o especial pois este nao tem energia sufiencete"); 
			this.EnergyBar += 20;
		}
	} 
	public void BlueSpecial(Boss boss) { 
		if(EnergyBar >= 100) {
			System.out.println("o ranger azul dar rapidos chutes com sua arte marcial magica,e com isso chuta varios");  
			Weapon w1=weapons.get(0); 
			Weapon w2=weapons.get(1);
			double damage=this.attackPwr *2 + w1.getAttackpwr()/3 + w2.getAttackpwr()/3;
			boss.setHealth(boss.getHealth() - damage*3);   
			System.out.println("o boss " + boss.getName() +" levou " + damage + " de dano");
			this.EnergyBar=0;
		} 
		else {
			System.out.println("o ranger azul nao pode usar o especial pois este nao tem energia sufiencete"); 
			this.EnergyBar += 20;
		}
	}
}
