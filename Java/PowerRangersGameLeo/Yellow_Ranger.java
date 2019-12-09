import java.util.ArrayList;

public class Yellow_Ranger extends Ranger{
	
	public Yellow_Ranger() {
		super();
		setup();
	}

	@Override
	public void setup() {
		this.armor=2;
		this.attackPwr=35; 
		this.EnergyBar=100;
		this.health=280;
		this.name="Beth";    
		this.pos=1;
		this.color="amarelo";
		ArrayList<Weapon> a=new ArrayList<Weapon>();  
		Weapon one = new Weapon("Yellow punch",55); 
		Weapon two= new Weapon("yellow gun", 40); 
		a.add(one); 
		a.add(two); 
		this.weapons=a;
		this.animalPwr=600;
		this.animalType="eagle";  
		this.animalHealth=1900;
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
	public void YellowSpecial(Villain e1,Villain e2,Villain e3) {
		if(EnergyBar >= 100) {
			System.out.println("o ranger amarelo soca rapidamente os que estao envolta com rapida velocidade!"); 
			Weapon w=weapons.get(0);
			double damage=this.attackPwr *2 + w.getAttackpwr()/3; 
			e1.setHealth(e1.getHealth() - damage); 
			e2.setHealth(e2.getHealth() - damage);
			e3.setHealth(e3.getHealth() - damage); 
			System.out.println("os inimigos " + e1.getName() + "," + e2.getName() + "," + e3.getName() + " levaram " + damage  + " de dano");
			this.EnergyBar=0;
 		} 
		else {
			System.out.println("o ranger amarelo nao pode usar o especial pois este nao tem energia suficiente");
		}
	} 
	public void YellowSpecial(Boss boss) {
		if(EnergyBar >= 100) {
			System.out.println("o ranger amarelo soca rapidamente os que estao envolta com rapida velocidade!"); 
			Weapon w=weapons.get(0);
			double damage=this.attackPwr *2 + w.getAttackpwr()/3; 
			boss.setHealth(boss.getHealth() - damage*4); 
			System.out.println("o boss " + boss.getName() + " levou " + damage  + " de dano");
			this.EnergyBar=0;
 		} 
		else {
			System.out.println("o ranger amarelo nao pode usar o especial pois este nao tem energia suficiente");
		}
	}
}
