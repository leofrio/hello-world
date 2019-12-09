
public class Megazord {
	private double health;
	private double attackPwr;   
	private double defense;
	private Weapon weapon;   
	private int turn=0;
	
	public Megazord() {
		setup();
	}

	public void setup() {
		health=24000;
		attackPwr=4000;  
		defense=200;
		Weapon w=new Weapon("explosive sword",600); 
		this.weapon=w;
	}  
	
	public void attack(SuperBoss great) { 
		double damage=(attackPwr + weapon.getAttackpwr()/3) - great.getDefense();  
		great.setHealth(great.getHealth()- damage);
		turn++; 
		System.out.println("o superchefao " + great.getName() + " levou " + damage + " de dano");
	} 
	public void SpecialExplosiveSword(SuperBoss great) {
		if(turn >= 2) {
			System.out.println("o megazorde pega sua espada explosiva e com rapidez"); 
			System.out.println(" e habilidade ataca seu inimigo causando uma explosao"); 
			System.out.println(" que o joga pra longe e causa estrago devido as imensas ");
			System.out.println("explosoes causadas"); 
			double damage=attackPwr *2 + weapon.getAttackpwr() - great.getDefense();
			great.setHealth(great.getHealth() - damage);  
			System.out.println(" o super chefao " + great.getName() + " levou " + damage + " de dano com a espada explosiva");
			this.turn=0;
		} 
		else { 
			System.out.println("o especial nao pode ser usado ainda por favor escolha outra opcao");
		}
	}
	public boolean died() {
		if(health <= 0) {
			return true;
		} 
		else {
			return false;
		}
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

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}   
	public void status() {
		System.out.println("MEGAZORD");
		System.out.println("vida: " + health); 
		System.out.println("attackPwr: " + attackPwr);
		System.out.println("armor: " + defense);  
		System.out.println("armas: " + weapon.getName()); 
	}
}
