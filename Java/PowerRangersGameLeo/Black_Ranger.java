import java.util.ArrayList;

public class Black_Ranger  extends Ranger{

	
	

	public Black_Ranger() {
		super();
		setup();
	}

	@Override
	public void setup() {
		this.armor=2;
		this.attackPwr=70; 
		this.EnergyBar=110;
		this.health=320;
		this.name="gilson";   
		this.color="preto"; 
		this.pos=2;
		ArrayList<Weapon> a=new ArrayList<Weapon>();  
		Weapon one = new Weapon("black gun",70); 
		Weapon two= new Weapon("black sword", 50); 
		a.add(one); 
		a.add(two); 
		this.weapons=a;
		this.animalPwr=800;
		this.animalType="panther";  
		this.animalHealth=2300;
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
		double damage=(this.attackPwr + (w.getAttackpwr()/3) - enemie.getArmor());
		enemie.setHealth(enemie.getHealth() - damage); 
		System.out.println("o inimigo " + enemie.getName() + " sofreu " + damage + " de dano"); 
		this.EnergyBar = EnergyBar+15; 
	} 
	
	public void BlackSpecial(Villain e1,Villain e2,Villain e3,Villain e4) {
		if(EnergyBar >= 100) {
			System.out.println("o ranger preto pega sua arma e com ela atira um tiro explosivo gigante"); 
			Weapon w=weapons.get(0);
			double damage=this.attackPwr*2 + (w.getAttackpwr()/3); 
			e1.setHealth(e1.getHealth() - damage); 
			e2.setHealth(e2.getHealth() - damage); 
			e3.setHealth(e3.getHealth() - damage); 
			e4.setHealth(e4.getHealth() - damage);   
			System.out.println("os inimigos " + e1.getName() + ","+ e2.getName() + ","+e3.getName() + "," + e4.getName() + " levaram " + damage +  " de dano"); 
			this.EnergyBar=0;
		}
		else {
			System.out.println("o ranger preto nao pode usar o especial pois sua barra de energia nao esta maior que 100"); 
			this.EnergyBar +=20;
		}
	} 
	public void BlackSpecial(Boss boss) {
		if(EnergyBar >= 100) {
			System.out.println("o ranger preto pega sua arma e com ela atira um tiro explosivo gigante"); 
			Weapon w=weapons.get(0);
			double damage=this.attackPwr*2 + (w.getAttackpwr()/3); 
			boss.setHealth(boss.getHealth() - damage *5);   
			System.out.println("o boss " + boss.getName() + ","+ boss.getName() + " levou " + damage +  " de dano"); 
			this.EnergyBar=0;
		}
		else {
			System.out.println("o ranger preto nao pode usar o especial pois sua barra de energia nao esta maior que 100"); 
			this.EnergyBar +=20;
		}
	}
}