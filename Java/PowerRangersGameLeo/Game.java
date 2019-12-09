import java.util.ArrayList;
import java.util.Scanner;



public class Game {

	public static void main(String[] args) {
		ArrayList<Ranger> r=new ArrayList<Ranger>();   
		Green_Ranger green=new Green_Ranger();
		Yellow_Ranger yellow=new Yellow_Ranger(); 
		Black_Ranger black=new Black_Ranger(); 
		Blue_Ranger blue=new Blue_Ranger(); 
		Red_Ranger red=new Red_Ranger();  
		r.add(green); 
		r.add(yellow);
		r.add(black);
		r.add(blue); 
		r.add(red);
		boolean end=false;  
		boolean win=false;
		int level=1; 
		ArrayList<Villain> villains=new ArrayList<Villain>(); 
		Scanner let=new Scanner(System.in);
		while(!end) {
			if(level == 1) { 
				System.out.println(".____                      .__     ____ \n" +
						"|    |    _______  __ ____ |  |   /_   |\n" +
						"|    |  _/ __ \\  \\/ // __ \\|  |    |   |\n" +
						"|    |__\\  ___/\\   /\\  ___/|  |__  |   |\n" +
						"|_______ \\___  >\\_/  \\___  >____/  |___|\n" +
						"        \\/   \\/          \\/            ");
				for(int i =0 ; i < 15; i++) {
					String namenum=Integer.toString(i); 
					villains.add(new Villain(namenum, 70,60,2)); 
					villains.get(i).setPos(villains.indexOf(villains.get(i)));
				} 
				while(!villains.isEmpty()) { 
					int randomizer=0; 
					int randomizeraux1=0;
					int randomizeraux2=0;
					int randomizeraux3=0; 
					int randomizeraux4=0;  
					//red
					if(!red.isCalled() && !red.died()) {
						System.out.println("oque o ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(Red powerBlast-5 inimigos)");  
						int choicered=let.nextInt(); 
						if(choicered == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + red.getWeapons().get(0).getName()); 
							System.out.println("2-" + red.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							red.attack(villains.get(randomizer), red.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicered == 2) {
							red.call(); System.out.println("o animal " + red.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(red.isCalled() && !red.died()) {
						System.out.println("oque o animal "+ red.getAnimalType() +  " do ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt(); 
						if(choicered == 1) {
							randomizer=(int) (Math.random()* villains.size());
							red.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}   
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//black
					if(!black.isCalled() && !black.died()) {
						System.out.println("oque o ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(giant explosive shot-4 inimigos)");  
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + black.getWeapons().get(0).getName()); 
							System.out.println("2-" + black.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							black.attack(villains.get(randomizer), black.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblack == 2) {
							black.call(); System.out.println("o animal " + black.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(black.isCalled() && !black.died()) {
						System.out.println("oque o animal "+ black.getAnimalType() +  " do ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) {
							randomizer=(int) (Math.random()* villains.size());
							black.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//blue 
					if(!blue.isCalled() && !blue.died()) {
						System.out.println("oque a ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(magic martial arts-2 inimigos)");  
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + blue.getWeapons().get(0).getName()); 
							System.out.println("2-" + blue.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							blue.attack(villains.get(randomizer), blue.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblue == 2) {
							blue.call(); System.out.println("o animal " + blue.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(blue.isCalled() && !blue.died()) {
						System.out.println("oque o animal "+ blue.getAnimalType() +  " da ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) {
							randomizer=(int) (Math.random()* villains.size());
							blue.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					}
					//green
					if(!green.isCalled() && !green.died()) {
						System.out.println("oque o ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(greenish lightning arrows-3 inimigos)");  
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + green.getWeapons().get(0).getName()); 
							System.out.println("2-" + green.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							green.attack(villains.get(randomizer), green.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicegreen == 2) {
							green.call(); System.out.println("o animal " + green.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(green.isCalled() && !green.died()) {
						System.out.println("oque o animal "+ green.getAnimalType() +  " do ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) {
							randomizer=(int) (Math.random()* villains.size());
							green.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");  
					if(villains.size() == 0) {
						break;
					} 
					//yellow  
					if(!yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(yellowish bright punches-3 inimigos)");  
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + yellow.getWeapons().get(0).getName()); 
							System.out.println("2-" + yellow.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							yellow.attack(villains.get(randomizer), yellow.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceyellow == 2) {
							yellow.call(); 
							System.out.println("o animal " + yellow.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o animal "+ yellow.getAnimalType() +  " do ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) {
							randomizer=(int) (Math.random()* villains.size());
							yellow.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}  
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					} 
					for(int i=0;i< villains.size();i++) {
						randomizer= (int) (Math.random() * r.size()); 
						Weapon t=new Weapon("villain weapon",(int) (Math.random() *40));
						villains.get(i).attack(r.get(randomizer), t); 
						if(r.get(randomizer).getAnimalHealth() <= 0) {
							r.get(randomizer).setAlreadyCalled(true); 
							r.get(randomizer).setCalled(false);
						}
						if(r.get(randomizer).died()) { 
							System.out.println("o ranger " + r.get(randomizer).getColor() + "," + r.get(randomizer).getName() + " foi derrotado!");
							r.remove(r.get(randomizer).getPos()); 
							if(r.size() != 0) {
								for(int j=0;j< r.size();j++) {
									r.get(j).setPos(r.indexOf(r.get(j)));
								}
							}
						} 
					}  
					if(r.size() == 0) {
						win= false; 
						end=true;
						break; 
					}
					for(int i=0;i< r.size();i++) {
						r.get(i).status();
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
				}  
				System.out.println("o chefao DESOTROYA aparece aos rujudos pronto para matar");
				Weapon h=new Weapon("magic scythe",40);
				Boss boss1=new Boss("DESOTROYA",4000,700,5,h); 
				System.out.println(" ______     ______     ______     ______     _____     ______     ______     ______     ______   ______     ______     __  __     ______    \n" +
						"/\\  == \\   /\\  __ \\   /\\  ___\\   /\\  ___\\   /\\  __-.  /\\  ___\\   /\\  ___\\   /\\  __ \\   /\\__  _\\ /\\  == \\   /\\  __ \\   /\\ \\_\\ \\   /\\  __ \\   \n" +
						"\\ \\  __<   \\ \\ \\/\\ \\  \\ \\___  \\  \\ \\___  \\  \\ \\ \\/\\ \\ \\ \\  __\\   \\ \\___  \\  \\ \\ \\/\\ \\  \\/_/\\ \\/ \\ \\  __<   \\ \\ \\/\\ \\  \\ \\____ \\  \\ \\  __ \\  \n" +
						" \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\/\\_____\\  \\ \\____-  \\ \\_____\\  \\/\\_____\\  \\ \\_____\\    \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\  \\/\\_____\\  \\ \\_\\ \\_\\ \n" +
						"  \\/_____/   \\/_____/   \\/_____/   \\/_____/   \\/____/   \\/_____/   \\/_____/   \\/_____/     \\/_/   \\/_/ /_/   \\/_____/   \\/_____/   \\/_/\\/_/ \n" +
						"                                                                                                                                            ");
				while(boss1.getHealth() > 0) { 
					if(!red.isCalled() && !red.died()) {
						System.out.println("oque o ranger vermelho vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(red powerblast)");
						int choicered=let.nextInt(); 
						if(choicered == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + red.getWeapons().get(0).getName()); 
							System.out.println("2-" + red.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							red.attack(boss1, red.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								break;
							}
						}else if(choicered == 2) {
							red.call(); 
							System.out.println("o animal " + red.getName() + " esta pronto pra uso");
						} 
						else {
							red.RedSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(red.isCalled() && !red.died()) {
						System.out.println("oque o animal " + red.getAnimalType() + " do ranger vermelho vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt();
						if(choicered== 1) {
							red.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							red.RedSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					} 
					//black  
					if(!black.isCalled() && !black.died()) {
						System.out.println("oque o ranger preto vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(giant explosive shot)");
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + black.getWeapons().get(0).getName()); 
							System.out.println("2-" + black.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							black.attack(boss1, black.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) { 
								System.out.println("o boss" + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceblack == 2) {
							black.call();  
							if(!black.isAlreadyCalled()) {
								System.out.println("o animal " + black.getName() + " esta pronto pra uso"); 
							}
						} 
						else {
							black.BlackSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(black.isCalled() && !black.died()) {
						System.out.println("oque o animal " + black.getAnimalType() + " do ranger preto vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choiceblack=let.nextInt();
						if(choiceblack== 1) {
							black.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							black.BlackSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//blue 
					if(!blue.isCalled() && !blue.died()) {
						System.out.println("oque o ranger azul vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(magic martial arts)");
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + blue.getWeapons().get(0).getName()); 
							System.out.println("2-" + blue.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							blue.attack(boss1, blue.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss" + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceblue == 2) {
							blue.call();  
							if(!blue.isAlreadyCalled()) {
								System.out.println("o animal " + blue.getName() + " esta pronto pra uso"); 
							}
						} 
						else {
							blue.BlueSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(blue.isCalled() && !blue.died()) {
						System.out.println("oque o animal " + blue.getAnimalType() + " do ranger azul vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt();
						if(choicered== 1) {
							blue.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							blue.BlueSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//green 
					if(!green.isCalled() && !green.died()) {
						System.out.println("oque o ranger verde vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(greenish lightning arrows)");
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + green.getWeapons().get(0).getName()); 
							System.out.println("2-" + green.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							green.attack(boss1, green.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choicegreen == 2) {
							green.call(); 
							if(!green.isAlreadyCalled()) {
								System.out.println("o animal " + red.getName() + " esta pronto pra uso");
							}
						} 
						else {
							green.GreenSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(green.isCalled() && !green.died()) {
						System.out.println("oque o animal " + green.getAnimalType() + " do ranger verde vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicegreen=let.nextInt();
						if(choicegreen== 1) {
							green.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							green.GreenSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//yellow
					if(!yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o ranger amarelo vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(red powerblast)");
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + yellow.getWeapons().get(0).getName()); 
							System.out.println("2-" + yellow.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							yellow.attack(boss1, yellow.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceyellow == 2) {
							yellow.call(); 
							System.out.println("o animal " + yellow.getName() + " esta pronto pra uso");
						} 
						else {
							yellow.YellowSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o animal " + yellow.getAnimalType() + " da ranger amarela vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choiceyellow=let.nextInt();
						if(choiceyellow == 1) {
							yellow.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							yellow.YellowSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					} 
					int chance=((int) (Math.random() * 100)) +1 ; 
					if(chance < 70) {
						int randomizer=(int) (Math.random() * r.size());
						boss1.attack(r.get(randomizer), h); 
						if(r.get(randomizer).getAnimalHealth() <=0) { 
							System.out.println("o animal do ranger " + r.get(randomizer).getColor() + " foi destruido!");
							r.get(randomizer).setAlreadyCalled(true);
							r.get(randomizer).setCalled(false);
						} 
						if(r.get(randomizer).died()) {
							System.out.println("o ranger " + r.get(randomizer).getColor() + "que tinha nome de " + r.get(randomizer).getName() +" foi derrotado");
							r.remove(r.get(randomizer).getPos());  
							for(int i=0;i< r.size();i++) {
								r.get(i).setPos(r.indexOf(r.get(i)));
							}
						}
					} 
					else {
						boss1.BossSpecial(r);
						for(int i=0;i< r.size();i++) {
							if(r.get(i).getAnimalHealth() <= 0) { 
								System.out.println("o animal do ranger " + r.get(i).getColor() + " foi destruido!");
								r.get(i).setAlreadyCalled(true); 
								r.get(i).setCalled(false);
							} 
							if(r.get(i).died()) {
								System.out.println("o ranger " + r.get(i).getColor() + "que tinha nome de " + r.get(i).getName() +" foi derrotado");
								r.remove(r.get(i).getPos()); 
								for(int j=0;j< r.size();j++) {
									r.get(j).setPos(r.indexOf(r.get(j)));
								}
								i=0;
							}
						} 
					} 
					if(r.size()==0) {
						win = false; 
						end=true;
						break; 
					} 
					for(int i=0;i< r.size();i++) {
						r.get(i).status();
					} 
				} 
				if(end) {
					break;
				}
				System.out.println("parabens voce venceu o chefao " +boss1.getName() + "!"); 
				System.out.println("voce esta pronto para o nivel 2"); 
				green=new Green_Ranger(); 
				yellow=new Yellow_Ranger();
				black=new Black_Ranger(); 
				blue=new Blue_Ranger(); 
				red=new Red_Ranger();  
				r.clear(); 
				r.add(green); 
				r.add(yellow);
				r.add(black);
				r.add(blue);
				r.add(red);
				System.out.println("seus rangers foram curados"); 
				level++;
			}  
			if(level == 2) {  
				System.out.println(".____                      .__    ________  \n" +
						"|    |    _______  __ ____ |  |   \\_____  \\ \n" +
						"|    |  _/ __ \\  \\/ // __ \\|  |    /  ____/ \n" +
						"|    |__\\  ___/\\   /\\  ___/|  |__ /       \\ \n" +
						"|_______ \\___  >\\_/  \\___  >____/ \\_______ \\\n" +
						"        \\/   \\/          \\/               \\/");
				for(int i =0 ; i < 20; i++) {
					String namenum=Integer.toString(i); 
					villains.add(new Villain(namenum, 70,75,2)); 
					villains.get(i).setPos(villains.indexOf(villains.get(i)));
				} 
				while(!villains.isEmpty()) { 
					int randomizer=0; 
					int randomizeraux1=0;
					int randomizeraux2=0;
					int randomizeraux3=0; 
					int randomizeraux4=0;  
					//red
					if(!red.isCalled() && !red.died()) {
						System.out.println("oque o ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(Red powerBlast-5 inimigos)");  
						int choicered=let.nextInt(); 
						if(choicered == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + red.getWeapons().get(0).getName()); 
							System.out.println("2-" + red.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							red.attack(villains.get(randomizer), red.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicered == 2) {
							red.call(); System.out.println("o animal " + red.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(red.isCalled() && !red.died()) {
						System.out.println("oque o animal "+ red.getAnimalType() +  " do ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt(); 
						if(choicered == 1) {
							randomizer=(int) (Math.random()* villains.size());
							red.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}   
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//black
					if(!black.isCalled() && !black.died()) {
						System.out.println("oque o ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(giant explosive shot-4 inimigos)");  
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + black.getWeapons().get(0).getName()); 
							System.out.println("2-" + black.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							black.attack(villains.get(randomizer), black.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblack == 2) {
							black.call(); System.out.println("o animal " + black.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(black.isCalled() && !black.died()) {
						System.out.println("oque o animal "+ black.getAnimalType() +  " do ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) {
							randomizer=(int) (Math.random()* villains.size());
							black.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//blue 
					if(!blue.isCalled() && !blue.died()) {
						System.out.println("oque a ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(magic martial arts-2 inimigos)");  
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + blue.getWeapons().get(0).getName()); 
							System.out.println("2-" + blue.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							blue.attack(villains.get(randomizer), blue.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblue == 2) {
							blue.call(); System.out.println("o animal " + blue.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(blue.isCalled() && !blue.died()) {
						System.out.println("oque o animal "+ blue.getAnimalType() +  " da ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) {
							randomizer=(int) (Math.random()* villains.size());
							blue.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					}
					//green
					if(!green.isCalled() && !green.died()) {
						System.out.println("oque o ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(greenish lightning arrows-3 inimigos)");  
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + green.getWeapons().get(0).getName()); 
							System.out.println("2-" + green.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							green.attack(villains.get(randomizer), green.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicegreen == 2) {
							green.call(); System.out.println("o animal " + green.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(green.isCalled() && !green.died()) {
						System.out.println("oque o animal "+ green.getAnimalType() +  " do ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) {
							randomizer=(int) (Math.random()* villains.size());
							green.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");  
					if(villains.size() == 0) {
						break;
					} 
					//yellow  
					if(!yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(yellowish bright punches-3 inimigos)");  
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + yellow.getWeapons().get(0).getName()); 
							System.out.println("2-" + yellow.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							yellow.attack(villains.get(randomizer), yellow.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceyellow == 2) {
							yellow.call(); 
							System.out.println("o animal " + yellow.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o animal "+ yellow.getAnimalType() +  " do ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) {
							randomizer=(int) (Math.random()* villains.size());
							yellow.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}  
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					} 
					for(int i=0;i< villains.size();i++) {
						randomizer= (int) (Math.random() * r.size()); 
						Weapon t=new Weapon("villain weapon",(int) (Math.random() *40));
						villains.get(i).attack(r.get(randomizer), t); 
						if(r.get(randomizer).getAnimalHealth() <= 0) {
							r.get(randomizer).setAlreadyCalled(true); 
							r.get(randomizer).setCalled(false);
						}
						if(r.get(randomizer).died()) { 
							System.out.println("o ranger " + r.get(randomizer).getColor() + "," + r.get(randomizer).getName() + " foi derrotado!");
							r.remove(r.get(randomizer).getPos()); 
							if(r.size() != 0) {
								for(int j=0;j< r.size();j++) {
									r.get(j).setPos(r.indexOf(r.get(j)));
								}
							}
						} 
					}  
					if(r.size() == 0) {
						win= false; 
						end=true;
						break; 
					}
					for(int i=0;i< r.size();i++) {
						r.get(i).status();
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
				}  
				System.out.println("o chefao TSUTAYAH aparece aos rujudos pronto para matar");
				Weapon h=new Weapon("magic venom",50);
				Boss boss1=new Boss("TSUTAYAH",6000,900,5,h); 
				System.out.println(" ______     ______     ______     ______     ______   ______     __  __     ______   ______     __  __     ______     __  __    \n" +
						"/\\  == \\   /\\  __ \\   /\\  ___\\   /\\  ___\\   /\\__  _\\ /\\  ___\\   /\\ \\/\\ \\   /\\__  _\\ /\\  __ \\   /\\ \\_\\ \\   /\\  __ \\   /\\ \\_\\ \\   \n" +
						"\\ \\  __<   \\ \\ \\/\\ \\  \\ \\___  \\  \\ \\___  \\  \\/_/\\ \\/ \\ \\___  \\  \\ \\ \\_\\ \\  \\/_/\\ \\/ \\ \\  __ \\  \\ \\____ \\  \\ \\  __ \\  \\ \\  __ \\  \n" +
						" \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\/\\_____\\    \\ \\_\\  \\/\\_____\\  \\ \\_____\\    \\ \\_\\  \\ \\_\\ \\_\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\ \n" +
						"  \\/_____/   \\/_____/   \\/_____/   \\/_____/     \\/_/   \\/_____/   \\/_____/     \\/_/   \\/_/\\/_/   \\/_____/   \\/_/\\/_/   \\/_/\\/_/ \n" +
						"                                                                                                                                ");  
				while(boss1.getHealth() > 0) {
					if(!red.isCalled() && !red.died()) {
						System.out.println("oque o ranger vermelho vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(red powerblast)");
						int choicered=let.nextInt(); 
						if(choicered == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + red.getWeapons().get(0).getName()); 
							System.out.println("2-" + red.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							red.attack(boss1, red.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								break;
							}
						}else if(choicered == 2) {
							red.call(); 
							System.out.println("o animal " + red.getName() + " esta pronto pra uso");
						} 
						else {
							red.RedSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(red.isCalled() && !red.died()) {
						System.out.println("oque o animal " + red.getAnimalType() + " do ranger vermelho vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt();
						if(choicered== 1) {
							red.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							red.RedSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					} 
					//black  
					if(!black.isCalled() && !black.died()) {
						System.out.println("oque o ranger preto vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(giant explosive shot)");
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + black.getWeapons().get(0).getName()); 
							System.out.println("2-" + black.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							black.attack(boss1, black.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) { 
								System.out.println("o boss" + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceblack == 2) {
							black.call();  
							if(!black.isAlreadyCalled()) {
								System.out.println("o animal " + black.getName() + " esta pronto pra uso"); 
							}
						} 
						else {
							black.BlackSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(black.isCalled() && !black.died()) {
						System.out.println("oque o animal " + black.getAnimalType() + " do ranger preto vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choiceblack=let.nextInt();
						if(choiceblack== 1) {
							black.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							black.BlackSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//blue 
					if(!blue.isCalled() && !blue.died()) {
						System.out.println("oque o ranger azul vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(magic martial arts)");
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + blue.getWeapons().get(0).getName()); 
							System.out.println("2-" + blue.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							blue.attack(boss1, blue.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss" + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceblue == 2) {
							blue.call();  
							if(!blue.isAlreadyCalled()) {
								System.out.println("o animal " + blue.getName() + " esta pronto pra uso"); 
							}
						} 
						else {
							blue.BlueSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(blue.isCalled() && !blue.died()) {
						System.out.println("oque o animal " + blue.getAnimalType() + " do ranger azul vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt();
						if(choicered== 1) {
							blue.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							blue.BlueSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//green 
					if(!green.isCalled() && !green.died()) {
						System.out.println("oque o ranger verde vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(greenish lightning arrows)");
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + green.getWeapons().get(0).getName()); 
							System.out.println("2-" + green.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							green.attack(boss1, green.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choicegreen == 2) {
							green.call(); 
							if(!green.isAlreadyCalled()) {
								System.out.println("o animal " + red.getName() + " esta pronto pra uso");
							}
						} 
						else {
							green.GreenSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(green.isCalled() && !green.died()) {
						System.out.println("oque o animal " + green.getAnimalType() + " do ranger verde vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choicegreen=let.nextInt();
						if(choicegreen== 1) {
							green.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							green.GreenSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}
					//yellow
					if(!yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o ranger amarelo vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-chamar animal(recomendado)"); 
						System.out.println("3-usar especial(red powerblast)");
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) {
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + yellow.getWeapons().get(0).getName()); 
							System.out.println("2-" + yellow.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							yellow.attack(boss1, yellow.getWeapons().get(weaponchoice-1)); 
							if(boss1.died()) {
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}else if(choiceyellow == 2) {
							yellow.call(); 
							System.out.println("o animal " + yellow.getName() + " esta pronto pra uso");
						} 
						else {
							yellow.YellowSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					}else if(yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o animal " + yellow.getAnimalType() + " da ranger amarela vai fazer?"); 
						System.out.println("1-atacar boss"); 
						System.out.println("2-usar especial"); 
						int choiceyellow=let.nextInt();
						if(choiceyellow == 1) {
							yellow.attack(boss1);  
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							} 
						}
						else {
							yellow.YellowSpecial(boss1); 
							if(boss1.died()) { 
								System.out.println("o boss " + boss1.getName() + " foi derrotado!");
								break;
							}
						}
					} 
					int chance=((int) (Math.random() * 100)) +1 ; 
					if(chance < 60) {
						int randomizer=(int) (Math.random() * r.size());
						boss1.attack(r.get(randomizer), h); 
						if(r.get(randomizer).getAnimalHealth() <=0) { 
							System.out.println("o animal do ranger " + r.get(randomizer).getColor() + " foi destruido!");
							r.get(randomizer).setAlreadyCalled(true);
							r.get(randomizer).setCalled(false);
						} 
						if(r.get(randomizer).died()) {
							System.out.println("o ranger " + r.get(randomizer).getColor() + "que tinha nome de " + r.get(randomizer).getName() +" foi derrotado");
							r.remove(r.get(randomizer).getPos());  
							for(int i=0;i< r.size();i++) {
								r.get(i).setPos(r.indexOf(r.get(i)));
							}
						} 
					} 
					else {
						boss1.BossSpecial(r);
						for(int i=0;i< r.size();i++) {
							if(r.get(i).getAnimalHealth() <= 0) { 
								System.out.println("o animal do ranger " + r.get(i).getColor() + " foi destruido!");
								r.get(i).setAlreadyCalled(true); 
								r.get(i).setCalled(false);
							} 
							if(r.get(i).died()) {
								System.out.println("o ranger " + r.get(i).getColor() + "que tinha nome de " + r.get(i).getName() +" foi derrotado");
								r.remove(r.get(i).getPos()); 
								for(int j=0;j< r.size();j++) {
									r.get(j).setPos(r.indexOf(r.get(j)));
								}
								i=0;
							}
						}
					} 
					for(int i=0;i< r.size();i++) {
						r.get(i).status();
					}
					if(r.size() == 0) {
						win=false; 
						end=true;
						break;
					}
				} 
				if(end) {
					break;
				}
				System.out.println("parabens voce venceu o chefao " +boss1.getName() + "!"); 
				System.out.println("voce esta pronto para o nivel 3"); 
				green=new Green_Ranger(); 
				yellow=new Yellow_Ranger();
				black=new Black_Ranger(); 
				blue=new Blue_Ranger(); 
				red=new Red_Ranger();  
				r.clear(); 
				r.add(green); 
				r.add(yellow);
				r.add(black);
				r.add(blue);
				r.add(red);
				System.out.println("seus rangers foram curados"); 
				level++;
			} 
			if(level == 3) { 
				System.out.println(".____                      .__    ________  \n" +
						"|    |    _______  __ ____ |  |   \\_____  \\ \n" +
						"|    |  _/ __ \\  \\/ // __ \\|  |     _(__  < \n" +
						"|    |__\\  ___/\\   /\\  ___/|  |__  /       \\\n" +
						"|_______ \\___  >\\_/  \\___  >____/ /______  /\n" +
						"        \\/   \\/          \\/              \\/");
				for(int i =0 ; i < 25; i++) {
					String namenum=Integer.toString(i); 
					villains.add(new Villain(namenum, 70,90,2)); 
					villains.get(i).setPos(villains.indexOf(villains.get(i)));
				} 
				while(!villains.isEmpty()) { 
					int randomizer=0; 
					int randomizeraux1=0;
					int randomizeraux2=0;
					int randomizeraux3=0; 
					int randomizeraux4=0;  
					//red
					if(!red.isCalled() && !red.died()) {
						System.out.println("oque o ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(Red powerBlast-5 inimigos)");  
						int choicered=let.nextInt(); 
						if(choicered == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + red.getWeapons().get(0).getName()); 
							System.out.println("2-" + red.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							red.attack(villains.get(randomizer), red.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicered == 2) {
							red.call(); System.out.println("o animal " + red.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(red.isCalled() && !red.died()) {
						System.out.println("oque o animal "+ red.getAnimalType() +  " do ranger vermelho vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicered=let.nextInt(); 
						if(choicered == 1) {
							randomizer=(int) (Math.random()* villains.size());
							red.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 5) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
								randomizeraux4=(int) (Math.random() * villains.size()); 
								while(randomizeraux4 == randomizer || randomizeraux4 == randomizeraux1 || randomizeraux4 == randomizeraux2|| randomizeraux4 == randomizeraux3) {
									randomizeraux4=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								red.RedSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3), villains.get(randomizeraux4));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died() || villains.get(randomizeraux4).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;  
												if(villains.get(randomizeraux4).getPos() != randomizeraux4)
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--;
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 > saver || randomizeraux4 > saver) {
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
											if(randomizeraux4 >saver) {
												randomizeraux4--; 
												if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
													villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
											}
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux3).getPos();
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux4 >saver) {
											randomizeraux4--;  
											if(villains.get(randomizeraux4).getPos() != randomizeraux4) 
												villains.get(randomizeraux4).setPos(villains.get(randomizeraux4).getPos() -1);
										}
									}
									if(villains.get(randomizeraux4).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux4).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux4).getPos();
										villains.remove(villains.get(randomizeraux4).getPos());  
										if(villains.size() != 0) {
											for(int i=0; i< villains.size();i++) { 
												villains.get(i).setPos(villains.indexOf(villains.get(i))); 
											} 
										}
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}   
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//black
					if(!black.isCalled() && !black.died()) {
						System.out.println("oque o ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(giant explosive shot-4 inimigos)");  
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + black.getWeapons().get(0).getName()); 
							System.out.println("2-" + black.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							black.attack(villains.get(randomizer), black.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblack == 2) {
							black.call(); System.out.println("o animal " + black.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(black.isCalled() && !black.died()) {
						System.out.println("oque o animal "+ black.getAnimalType() +  " do ranger preto vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblack=let.nextInt(); 
						if(choiceblack == 1) {
							randomizer=(int) (Math.random()* villains.size());
							black.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 4) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
								randomizeraux3=(int) (Math.random() * villains.size());
								while(randomizeraux3 == randomizer || randomizeraux3 == randomizeraux1 || randomizeraux3 == randomizeraux2) {
									randomizeraux3=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								black.BlackSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2), villains.get(randomizeraux3));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died() || villains.get(randomizeraux3 ).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--;  
												if(villains.get(randomizeraux3).getPos() != randomizeraux3)
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 > saver || randomizeraux3 > saver) {
											if(randomizeraux2 >saver) {
												randomizeraux2--; 
												if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
											if(randomizeraux3 >saver) {
												randomizeraux3--; 
												if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
													villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
											}
										}
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux2).getPos();
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux3 >saver) {
											randomizeraux3--; 
											if(villains.get(randomizeraux3).getPos() != randomizeraux3) 
												villains.get(randomizeraux3).setPos(villains.get(randomizeraux3).getPos() -1);
										}
									}
									if(villains.get(randomizeraux3).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux3).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux3).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes"); 
					if(villains.size() == 0) {
						break;
					}
					//blue 
					if(!blue.isCalled() && !blue.died()) {
						System.out.println("oque a ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(magic martial arts-2 inimigos)");  
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + blue.getWeapons().get(0).getName()); 
							System.out.println("2-" + blue.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							blue.attack(villains.get(randomizer), blue.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceblue == 2) {
							blue.call(); System.out.println("o animal " + blue.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(blue.isCalled() && !blue.died()) {
						System.out.println("oque o animal "+ blue.getAnimalType() +  " da ranger azul vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceblue=let.nextInt(); 
						if(choiceblue == 1) {
							randomizer=(int) (Math.random()* villains.size());
							blue.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 2) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								blue.BlueSpecial(villains.get(randomizer), villains.get(randomizeraux1));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 >saver) {
											randomizeraux1--;  
											if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
												villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
									} 
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					}
					//green
					if(!green.isCalled() && !green.died()) {
						System.out.println("oque o ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(greenish lightning arrows-3 inimigos)");  
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + green.getWeapons().get(0).getName()); 
							System.out.println("2-" + green.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							green.attack(villains.get(randomizer), green.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choicegreen == 2) {
							green.call(); System.out.println("o animal " + green.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(green.isCalled() && !green.died()) {
						System.out.println("oque o animal "+ green.getAnimalType() +  " do ranger verde vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choicegreen=let.nextInt(); 
						if(choicegreen == 1) {
							randomizer=(int) (Math.random()* villains.size());
							green.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								green.GreenSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");  
					if(villains.size() == 0) {
						break;
					} 
					//yellow  
					if(!yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-chamar o animal"); 
						System.out.println("3-usar especial(yellowish bright punches-3 inimigos)");  
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) { 
							System.out.println("escolha sua arma de ataque"); 
							System.out.println("1-" + yellow.getWeapons().get(0).getName()); 
							System.out.println("2-" + yellow.getWeapons().get(1).getName()); 
							int weaponchoice=let.nextInt(); 
							randomizer= (int) (Math.random() * villains.size());
							yellow.attack(villains.get(randomizer), yellow.getWeapons().get(weaponchoice-1)); 
							if(villains.get(randomizer).died()) { 
								System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
								villains.remove(villains.get(randomizer).getPos()); 
								for(int i=0; i< villains.size();i++) {
									villains.get(i).setPos(villains.indexOf(villains.get(i)));
								}
							}
						}else if(choiceyellow == 2) {
							yellow.call(); 
							System.out.println("o animal " + yellow.getAnimalType() + " ja esta pronto para ser usado");
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					} else if(yellow.isCalled() && !yellow.died()) {
						System.out.println("oque o animal "+ yellow.getAnimalType() +  " do ranger amarelo vai fazer?"); 
						System.out.println("1-atacar um vilao"); 
						System.out.println("2-usar especial"); 
						int choiceyellow=let.nextInt(); 
						if(choiceyellow == 1) {
							randomizer=(int) (Math.random()* villains.size());
							yellow.attack(villains.get(randomizer)); 
							if(villains.get(randomizer).died()) { 
								if(villains.get(randomizer).died()) { 
									System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
									villains.remove(villains.get(randomizer).getPos()); 
									for(int i=0; i< villains.size();i++) {
										villains.get(i).setPos(villains.indexOf(villains.get(i)));
									}
								}
							}
						} 
						else { 
							if(villains.size() >= 3) { 
								randomizer =(int) (Math.random() * villains.size()); 
								randomizeraux1=(int) (Math.random() * villains.size()); 
								while(randomizeraux1 == randomizer) {
									randomizeraux1=(int) (Math.random() * villains.size());
								}
								randomizeraux2=(int) (Math.random() * villains.size()); 
								while(randomizeraux2 == randomizer || randomizeraux2 == randomizeraux1) { 
									randomizeraux2=(int) (Math.random() * villains.size()); 
								}
							} 
							else {
								randomizer =-4;
							}   
							if(randomizer >= 0) {
								yellow.YellowSpecial(villains.get(randomizer), villains.get(randomizeraux1), villains.get(randomizeraux2));

								if(villains.get(randomizer).died() ||villains.get(randomizeraux1).died() || villains.get(randomizeraux2).died()) {
									if(villains.get(randomizer).died()) {
										System.out.println("o vilao numero " + villains.get(randomizer).getName() + " foi derrotado!");
										int saver=villains.get(randomizer).getPos();
										villains.remove(villains.get(randomizer).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux1 > saver || randomizeraux2 > saver) {
											if(randomizeraux1 >saver) {
												randomizeraux1--;  
												if(villains.get(randomizeraux1).getPos() != randomizeraux1) 
													villains.get(randomizeraux1).setPos(villains.get(randomizeraux1).getPos() -1);
											} 
											if(randomizeraux2 >saver) {
												randomizeraux2--;  
												if(villains.get(randomizeraux2).getPos() != randomizeraux2)
													villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
											} 
										}
									} 
									if(villains.get(randomizeraux1).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux1).getName() + " foi derrotado!");
										int saver=villains.get(randomizeraux1).getPos();
										villains.remove(villains.get(randomizeraux1).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 
										if(randomizeraux2 >saver) {
											randomizeraux2--; 
											if(villains.get(randomizeraux2).getPos() != randomizeraux2) 
												villains.get(randomizeraux2).setPos(villains.get(randomizeraux2).getPos() -1);
										} 
									} 
									if(villains.get(randomizeraux2).died()) {
										System.out.println("o vilao numero " + villains.get(randomizeraux2).getName() + " foi derrotado!");
										villains.remove(villains.get(randomizeraux2).getPos()); 
										for(int i=0; i< villains.size();i++) { 
											villains.get(i).setPos(villains.indexOf(villains.get(i))); 
										} 

									}
								}
							} 
							else {
								System.out.println("o especial nao pode ser usado pois nao ha inimigos suficientes");
							}
						}
					}  
					System.out.println("tem " + villains.size() + " viloes restantes");
					if(villains.size() == 0) {
						break;
					} 
					for(int i=0;i< villains.size();i++) {
						randomizer= (int) (Math.random() * r.size()); 
						Weapon t=new Weapon("villain weapon",(int) (Math.random() *40));
						villains.get(i).attack(r.get(randomizer), t); 
						if(r.get(randomizer).getAnimalHealth() <= 0) {
							r.get(randomizer).setAlreadyCalled(true); 
							r.get(randomizer).setCalled(false);
						}
						if(r.get(randomizer).died()) { 
							System.out.println("o ranger " + r.get(randomizer).getColor() + "," + r.get(randomizer).getName() + " foi derrotado!");
							r.remove(r.get(randomizer).getPos()); 
							if(r.size() != 0) {
								for(int j=0;j< r.size();j++) {
									r.get(j).setPos(r.indexOf(r.get(j)));
								}
							}
						} 
					}  
					if(r.size() == 0) {
						win= false; 
						end=true;
						break; 
					}
					for(int i=0;i< r.size();i++) {
						r.get(i).status();
					} 
					System.out.println("tem " + villains.size() + " viloes restantes");
				}  
				System.out.println("o super chefao HATSUBISHI Aparece"); 
				Weapon b=new Weapon("the fork of deaths", 700); 
				SuperBoss SUPERBOSS=new SuperBoss("HATSUBISHI",25000,4000,200,b); 
				System.out.println("ele e muito poderoso para os rangers normais e hora de formar um"); 
				System.out.println("megazord!"); 
				System.out.println(".___  __ /\\           _____                      .__    .__     /\\  ___________.__                 ._.\n" +
						"|   |/  |)/ ______   /     \\   _________________ |  |__ |__| ___)/  \\__    ___/|__| _____   ____   | |\n" +
						"|   \\   __\\/  ___/  /  \\ /  \\ /  _ \\_  __ \\____ \\|  |  \\|  |/    \\    |    |   |  |/     \\_/ __ \\  | |\n" +
						"|   ||  |  \\___ \\  /    Y    (  <_> )  | \\/  |_> >   Y  \\  |   |  \\   |    |   |  |  Y Y  \\  ___/   \\|\n" +
						"|___||__| /____  > \\____|__  /\\____/|__|  |   __/|___|  /__|___|  /   |____|   |__|__|_|  /\\___  >  __\n" +
						"               \\/          \\/             |__|        \\/        \\/                      \\/     \\/   \\/"); 
				System.out.println("0 _____\n" +
						"           X_____\\\n" +
						"   .-^-.  ||_| |_||  .-^-.\n" +
						"  /_\\_/_\\_|  |_|  |_/_\\_/_\\\n" +
						"  ||(_)| __\\_____/__ |(_)||\n" +
						"  \\/| | |::|\\```/|::| | |\\/\n" +
						"  /`---_|::|-+-+-|::|_---'\\\n" +
						" / /  \\ |::|-|-|-|::| /  \\ \\\n" +
						"/_/   /|`--'-+-+-`--'|\\   \\_\\\n" +
						"| \\  / |===/_\\ /_\\===| \\  / |\n" +
						"|  \\/  /---/-/-\\-\\  o\\  \\/  |\n" +
						"| ||| | O / /   \\ \\   | ||| |\n" +
						"| ||| ||-------------|o|||| |\n" +
						"| ||| ||----\\ | /----|o|||| |\n" +
						"| _|| ||-----|||-----|o|||_ |\n" +
						"\\/|\\/  |     |||     |o|\\/|\\/\n" +
						"\\_o/   |----|||||----|-' \\o_/\n" +
						"       |##  |   |  ##|\n" +
						"       |----|   |----|\n" +
						"       ||__ |   | __||\n" +
						"      [|'  `|] [|'  `|]\n" +
						"      [|`--'|] [|`--'|]\n" +
						"      /|__| |\\ /| |__|\\\n" +
						"      ||  | || || |  ||\n" +
						"      ||__|_|| ||_|__||\n" +
						"      ||    || ||    ||\n" +
						"      \\|----|/ \\|----|/    \n" +
						"      /______\\ /______\\\n" +
						"      |__||__| |__||__|");  
				System.out.println(" ______     ______     ______     ______     __  __     ______     ______   ______     __  __     ______     __     ______     __  __     __    \n" +
						"/\\  == \\   /\\  __ \\   /\\  ___\\   /\\  ___\\   /\\ \\_\\ \\   /\\  __ \\   /\\__  _\\ /\\  ___\\   /\\ \\/\\ \\   /\\  == \\   /\\ \\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   \n" +
						"\\ \\  __<   \\ \\ \\/\\ \\  \\ \\___  \\  \\ \\___  \\  \\ \\  __ \\  \\ \\  __ \\  \\/_/\\ \\/ \\ \\___  \\  \\ \\ \\_\\ \\  \\ \\  __<   \\ \\ \\  \\ \\___  \\  \\ \\  __ \\  \\ \\ \\  \n" +
						" \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \\_\\    \\ \\_\\  \\/\\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\ \n" +
						"  \\/_____/   \\/_____/   \\/_____/   \\/_____/   \\/_/\\/_/   \\/_/\\/_/     \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_/   \\/_____/   \\/_/\\/_/   \\/_/ \n" +
						"                                                                                                                                               ");
				Megazord m=new Megazord(); 
				while(SUPERBOSS.getHealth() >= 0) {
					System.out.println("oque o megazord vai fazer?");
					System.out.println("1- atacar super boss"); 
					if(m.getTurn() < 2) {
						System.out.println("2-usar especial " + (2-m.getTurn()) + " turnos para poder ser usado"); 
					} 
					else {
						System.out.println("2-usar especial - pronto para uso"); 
					} 
					int choicemega=let.nextInt(); 
					if(choicemega == 1) {
						m.attack(SUPERBOSS);
						if(SUPERBOSS.died()) {
							win=true; 
							end=true; 
							break;
						}
					} 
					else {
						m.SpecialExplosiveSword(SUPERBOSS);
						if(SUPERBOSS.died()) {
							end=true; 
							win=true; 
							break;
						}
					}  
					if(end) {
						break;
					}
					int chance=((int) (Math.random() * 100)) +1;
					if(chance <= 60) {
						SUPERBOSS.attack(m); 
						if(m.died()) {
							System.out.println("seu megazorde foi destruido e o mundo entrou em caos");
							end=true;
							win=false; 
							break;
						}
					} 
					else {
						SUPERBOSS.SuperBossSpecial(m); 
						if(m.died()) {
							System.out.println("seu megazorde foi destruido e o mundo entrou em caos");
							end=true;
							win=false;
							break;
						}
					} 
					m.status();
				} 
			}
		} 
		if(win) { 
			System.out.println("voce derrotou o chefe HATSUBISHI e venceu o jogo!");
			System.out.println("voce venceu o jogo, parabens voce e um mestre!");
		} 
		else {
			System.out.println("voce perdeu o jogo tente denovo");
		}
	}

}
