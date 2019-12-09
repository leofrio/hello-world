import java.util.ArrayList;

public class Red_Ranger extends Ranger  {

	
	public Red_Ranger() {
		super();
		setup();
	}

	@Override
	public void setup() { 
		this.called=false;
		this.armor=6;
		this.attackPwr=75; 
		this.EnergyBar=130;
		this.health=380;
		this.name="Carlos";   
		this.color="vermelho"; 
		this.pos=4;
		ArrayList<Weapon> a=new ArrayList<Weapon>();  
		Weapon one = new Weapon("Red Power",80); 
		Weapon two= new Weapon("Red Bazooka", 60); 
		a.add(one); 
		a.add(two); 
		this.weapons=a;
		this.animalPwr=900;
		this.animalType="lion";  
		this.animalHealth=2500;
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
	public void RedSpecial(Villain e1,Villain e2,Villain e3,Villain e4,Villain e5) { 
		if(EnergyBar >= 100) {
			System.out.println("O ranger vermelho usa suas duas armas pra aniquilar os inimigos ao redor");
			System.out.println("com sua forca ataca 5 inimigos e rapidamente pula para o ar" ); 
			System.out.println(" atirando sua bazooka rapidamente neles"); 
			Weapon w1= weapons.get(0); 
			Weapon w2=weapons.get(1);
			double damage= this.attackPwr*2 + w1.getAttackpwr()/3 + w2.getAttackpwr()/3; 
			e1.setHealth(e1.getHealth() - damage); 
			e2.setHealth(e2.getHealth() - damage);
			e3.setHealth(e3.getHealth() - damage);
			e4.setHealth(e4.getHealth() - damage);
			e5.setHealth(e5.getHealth() - damage);
			System.out.println("os inimigos " + e1.getName() + ","+ e2.getName() + ","+e3.getName() + "," + e4.getName() + "," + e5.getName() + " levaram " + damage +  " de dano");
			this.EnergyBar=0;
		}
		else {
			System.out.println("nao tem como o ranger vermelho usar o especial porque esse nao tem energia"); 
			this.EnergyBar += 25;
		}
	} 
	public void RedSpecial(Boss boss) { 
		if(EnergyBar >= 100) {
			System.out.println("O ranger vermelho usa suas duas armas pra aniquilar o boss em sua frente");
			System.out.println("com sua forca ataca 5 socos no boss com sua rapida demonstracao de superforca e rapidamente pula para o ar" ); 
			System.out.println(" atirando sua bazooka rapidamente nele"); 
			Weapon w1= weapons.get(0); 
			Weapon w2=weapons.get(1);
			double damage= this.attackPwr*2 + w1.getAttackpwr()/3 + w2.getAttackpwr()/3; 
			boss.setHealth(boss.getHealth() - damage *5.3); 
			
			System.out.println("o boss " +boss.getName() + " levou " + damage +  " de dano");
			this.EnergyBar=0;
		}
		else {
			System.out.println("nao tem como o ranger vermelho usar o especial porque esse nao tem energia"); 
			this.EnergyBar += 25;
		}
	}
}
