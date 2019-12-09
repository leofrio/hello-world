
import java.util.ArrayList;

public abstract class Ranger implements Animal {
	protected String name;
	protected double health; 
	protected double attackPwr;
	protected double armor; 
	protected double EnergyBar;
	protected ArrayList<Weapon> weapons; 
	protected String animalType; 
	protected double animalPwr;
	protected double animalHealth;
	protected boolean called=false; 
	protected String color; 
	protected int pos; 
	protected boolean alreadyCalled=false;
	public boolean isCalled() {
		return called;
	} 
	public void setCalled(boolean called) {
		this.called = called;
	} 
	
	
	public boolean isAlreadyCalled() {
		return alreadyCalled;
	}
	public void setAlreadyCalled(boolean alreadyCalled) {
		this.alreadyCalled = alreadyCalled;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public double getEnergyBar() {
		return EnergyBar;
	}
	public void setEnergyBar(double energyBar) {
		EnergyBar = energyBar;
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(ArrayList<Weapon> weapons) {
		this.weapons = weapons;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public double getAnimalPwr() {
		return animalPwr;
	}
	public void setAnimalPwr(double animalPwr) {
		this.animalPwr = animalPwr;
	}
	public double getAnimalHealth() {
		return animalHealth;
	}
	public void setAnimalHealth(double animalHealth) {
		this.animalHealth = animalHealth;
	} 
	protected boolean isDestroyed() {
		if(animalHealth <= 0 ) { 
			return true;
		} 
		else { 
			return false;
		}
	}  
	protected boolean died() { 
		if(health <= 0) { 
			return true;
		}
		else {
			return false;
		}
	}
	public void status() {
		System.out.println("nome: " + name); 
		System.out.println("cor: " + color);
		System.out.println("vida: " + health); 
		System.out.println("attackPwr: " + attackPwr);
		System.out.println("armor: " + armor); 
		System.out.println("energy bar: " + EnergyBar); 
		System.out.println("armas: " + weapons.get(0).getName() + ","+ weapons.get(1).getName()); 
		System.out.println("tipo do animal: " + animalType); 
		System.out.println("animal power: " + animalPwr);  
		System.out.println("vida do animal: " + animalHealth); 
		System.out.print("animal foi chamado? "); 
		if(called) {
			 System.out.println("sim");
		}
		else {
			System.out.println("nao");
		}  
		System.out.println("");
	}
	
}
