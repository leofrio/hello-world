package TabloGreat;

import java.util.ArrayList;
import java.util.Scanner;

public class TheSuperMain {
	public static void main(String[] args) {
		Scanner let=new Scanner(System.in);
		//here we have an erray list that will keep all the expressions
		ArrayList<Expression> exps=new ArrayList(); 
		//here we have an arraylist that will get all the atomic statements
		ArrayList<Expression> atomic=new ArrayList();
		//here we creat an arraylist of bifurcations so that we can do them later 
		ArrayList<Bifurcation> later=new ArrayList();
		//symbols:^,v,->,<>,¬
		System.out.println("simbolos:^,v,->,<>,¬");
		System.out.println("digite a expressao para vermos se e uma tautologia"); 
		System.out.println("porfavor nao use espaco");
		//here we get the first expression
		String first=let.nextLine();  
		//here we have an index that will be the size of the expressions arraylist
		int p=0; 
		//here we have the index that will be the size of the bifurcations array
		int bsize=0;
		//this will be the saver index of how much we will move
		int saver=0; 
		//this will be the index size of the atomic ray 
		int atomicsize=0;
		//this will determine if its a tautologia or not
		boolean answer=false; 
		
		for(int j=0;true;j++) {
			//here we see if its the first time the loop occurs, if thats the case, the sequence typed will be the expression 
			Rules r=new Rules(); 
			if(j ==0) {
				Expression e=new Expression();
				e.setExpression(first);
				//we set it to false because we want to see if its a tautologia
				e.setVerification(false);
				//here we call the static function that sets the priority signal
				e=setSignal(e,j);
				exps.add(e); 
				p++;
			} 
			else {
				//here we have an index that will tell how many new expressions were added into the expressions array
				//up to this point we ve been only working with porlongations,so if the index remains zero that means that
				//are only bifurcations left
				int index=0;
				//here we see how many expressions were added, if there are none, that means only bifurcations are left
				Expression[] howmuch=new Expression[saver];
				int g=0;
				//here we save all those that were added on the last iteraction into the howmuch array so that we can use it
				for(int i=p-saver; i < p;i++) {
					howmuch[g]=exps.get(i);
					g++;
				}
				//here we go to the first use of the tablo method,because its the first time we use the rules
				//its the only time there will be only 1 exprsseion instead of more than 1, so we must separate it
				if(j == 1) {
					//here we have an indicator that the operations are over,if this becomes true the loop wll end
					boolean breaker=false;
					//here we get the first expression added
					Expression prev=exps.get(p-1);
					//we see if the signal is different than not, because it is a different treatment
					if(prev.getLowestSignal().equals("¬") == false) { 
						breaker=false;
						//here we apply the rules of the tablo on whether was the furthest indicator
						Expression aplly=r.appllyRule(prev); 
						//here we see if it was a prolongation or a bifurcation
						if(aplly instanceof Bifurcation) {
							//if it was a bifurcation we will save it on an array so that we can work with them later,
							//so that we can do the prolongations first
							Bifurcation b=(Bifurcation) aplly; 
							//first we create two auxiliar array lists to set as the expressions later
							//then we set the signal of the expression,then we remove the unaltered arraylist
							//and add the new one
							ArrayList<Expression> a=b.getExp1(); 
							ArrayList<Expression> aArray=new ArrayList<Expression>();
							b.setBifuArrayExp1(aArray); 
							aArray=b.getBifuArrayExp1();
							for(int u=0;u < a.size();u++) {
								if(a.get(u).getExpression().length() != 1) {
									Expression aux=a.get(u);
									aux=setSignal(aux,j);  
									a.remove(u);
									a.add(aux);
								} 
								else {
									aArray.add(a.get(u)); 
								}
							}
							ArrayList<Expression> c=b.getExp2();  
							ArrayList<Expression> cArray=new ArrayList<Expression>();
							b.setBifuArrayExp2(cArray);
							cArray=b.getBifuArrayExp2();
							for(int u=0;u < c.size();u++) {
								if(c.get(u).getExpression().length() != 1) {
									Expression aux=c.get(u);
									aux=setSignal(aux,j);  
									c.remove(u);
									c.add(aux);
								} 
								else {
									cArray.add(c.get(u)); 
								}
							}
							b.setExp1(a); 
							b.setBifuArrayExp1(aArray);
							b.setExp2(c);
							b.setBifuArrayExp2(cArray);
							later.add(b);
							bsize++;
						}
						else {
							//if its a prolongation we save the 2 expressions in 2 variables
							Prolongation q=(Prolongation) aplly; 
							Expression a=q.getExp1();
							Expression b=q.getExp2();
							//if it only has 1 of length, we save it to an array of atomic formulas, so that we can check it later
							if(a.getExpression().length() == 1) {
								atomic.add(a); 
								atomicsize++;
							} 
							//here we also save it in the atomic array, but as this branch only implements the first ever use of the rules
							//of the tablo, the "a" could not be equal to any of the expressions on the atomic array, because he would be the first one
							//but the b here could be equal to the a but with a different validation, so we create a for to check that
							if(b.getExpression().length() == 1) {
								atomic.add(b); 
								atomicsize++; 
								for(int i=0; i < atomicsize;i++) {
									//a for that checks if the expression is the same
									//but the verification is different, because that causes an absurd and causes the flow
									//of the expressions to stop
									if(b.getExpression().equals(atomic.get(i).getExpression()) && b.isVerification() != atomic.get(i).isVerification()) {
										b.setCloses(true);
										break;
									}
								}
							}
							//here we we use the static function setsignal to set the priority signal of the expression if
							//it has a length different than 1, if thats the case however, we add the expression to the atomic 
							//arraylist
							if(a.getExpression().length() != 1) {
								a=setSignal(a,j);
								exps.add(a);
							} 
							if(b.getExpression().length() != 1) { 
								b=setSignal(b,j);
								exps.add(b);
							} 
							if(b.getExpression().length() == 1 && a.getExpression().length() != 1 || a.getExpression().length() == 1 && b.getExpression().length() != 1) {
								index=1;
							} else if(a.getExpression().length() == 1 && b.getExpression().length() == 1  ) {
								index=0;
							} 
							else {
								index=2;
							}
							//we save the variable index so that we can use for the variable saver later
							p +=index;
						} 
					}  
					else { 
						//if its a not we apply th rule of the not
						breaker=false; 
						Expression apply=r.apllyRuleNot(prev); 
						// we check if after the first alteration the expression is already atomic,
						//because if thars the case theres only one variable, so the tablo will be false
						//and it wont be a tautologia
						if(apply.getExpression().length() == 1) { 
							breaker=true;
						} 
						if(breaker == true) {
							answer=false; 
							break;
						}
						setSignal(apply,j);
						exps.add(apply);
						index=1;
						p += index;
					}
					//since its the first, here we just equal the saver to the index
					saver=index;
				}
				else {
					//here we restart the saver so that after every iteration we can see how many  expressions were added and work with them
					saver=0;
					if(howmuch.length == 0) {
						//now we will start the bifurcation process
						//before we will check one last time to see if none of the prolongations close themselfs 
						boolean breaker=false;
						for(int i=0;i < atomicsize;i++) {
							//here we create a for to see if any of the previous expressions have already been closed
							//if thats the case the tablo found that the answer is true, that yes it is a tautologia or a contradicao
							Expression current =atomic.get(i); 
							if(current.isCloses()) {
								breaker=true;
							}
						} 
						if(breaker) {
							answer=true;
							break;
						} 
						//here we check something else:if there arent any bifurcations, and  nothing is closed there, that means that 
						//there arent enough absurds, so the tablo is false
						if(later.isEmpty()) {
							answer=false; 
							break;
						}
						else { 
							//here we go to the bifurcation round
							//first we set two breakers to tell which branch closed
							boolean breaker2=false;
							boolean breaker3=false;
							//this will be the current vifurcation in use
							Bifurcation current=null; 
							int bindex=0; 
							int oldindex=0;
							for(int i=0;i < bsize;i++) {
								breaker2=false;
								breaker3=false;
								//here we get the bifurcation in order of addition
								current=later.get(i);
								//we create 2 arraylists that repreent both of the branches of the bifrucation
								ArrayList<Expression> a=current.getExp1(); 
								ArrayList<Expression> b=current.getExp2();  
								for(int u=0;u < a.size();u++) {
									//here we check if it is already an atomic formula or not, if it is, we check it with the atomics array
									//and see if there are any absurds, if thats case we set the expression to close
									if(a.get(u).getExpression().length() == 1) {
										for(int y=0;y< atomic.size();y++) {
											if(a.get(u).getExpression().equals(atomic.get(y).getExpression()) && a.get(u).isVerification() != atomic.get(y).isVerification()) {
												a.get(u).setCloses(true);
											}
										}
										for(int y=0;y< current.getBifuArrayExp1().size();y++) {
											if(a.get(u).getExpression().equals(current.getBifuArrayExp1().get(y).getExpression()) && a.get(u).isVerification() != current.getBifuArrayExp1().get(y).isVerification()) {
												a.get(u).setCloses(true);
											}
										}
									} 
									else { 
										//in case not we will make the expression smaller until it is atomic
										Expression newer=setSignal(a.get(u),j); 
										a.remove(u);
										a.add(u, newer);
										if(a.size() != 1) {
											ArrayList<Expression> aux33=new ArrayList<Expression>();
											aux33=ToBifurcate(a.get(u),1.0,1.0); 
											for(int c=0;c< aux33.size();c++) {  
												a.add(aux33.get(c)); 
											} 
											if(u != a.size()-1) {
												continue;
											}
										} 
										else {
											a=ToBifurcate(a.get(u),1.0,1.0);
										} 
										for(int c=0;c < a.size();c++) {
											String labelcurrent=String.valueOf(a.get(c).getLabel());
											for(int y=0;y< atomic.size();y++) {
												if(a.get(c).getExpression().equals(atomic.get(y).getExpression()) && a.get(c).isVerification() != atomic.get(y).isVerification()) {
													a.get(c).setCloses(true);
												}
											} 
											for(int y=0;y< current.getBifuArrayExp1().size();y++) {
												if(a.get(c).getExpression().equals(current.getBifuArrayExp1().get(y).getExpression()) && a.get(c).isVerification() != current.getBifuArrayExp1().get(y).isVerification()) {
													a.get(c).setCloses(true);
												}
											} 
											for(int y=0; y < a.size();y++) {
												String labelchecked=String.valueOf(a.get(y).getLabel());
												int finalPosChecked;
												if(labelchecked.length() < labelcurrent.length()) {
													finalPosChecked=labelchecked.length();
												}
												else {
													finalPosChecked=0;
												}
												if(labelcurrent.substring(0,finalPosChecked).equals(labelchecked))  {
													if(a.get(c).getExpression().equals(a.get(y).getExpression()) && a.get(c).isVerification() != a.get(y).isVerification()) {
														a.get(c).setCloses(true);
													}
												}
											}
										} 
										break;
									}
								} 
								//here we do the same thing for b
								for(int u=0;u < b.size();u++) {
									if(b.get(u).getExpression().length() == 1) {
										for(int y=0;y< atomic.size();y++) {
											if(b.get(u).getExpression().equals(atomic.get(y).getExpression()) && b.get(u).isVerification() != atomic.get(y).isVerification()) {
												b.get(u).setCloses(true);
											}
										}
										for(int y=0;y< current.getBifuArrayExp2().size();y++) {
											if(b.get(u).getExpression().equals(current.getBifuArrayExp2().get(y).getExpression()) && b.get(u).isVerification() != current.getBifuArrayExp2().get(y).isVerification()) {
												b.get(u).setCloses(true);
											}
										}
									} 
									else { 
										Expression newer=setSignal(b.get(u),j); 
										b.remove(u);
										b.add(u, newer);
										if(b.size() != 1) {
											ArrayList<Expression> aux33=new ArrayList<Expression>();
											aux33=ToBifurcate(b.get(u),100.0,1.0); 
											for(int c=0;c< aux33.size();c++) {
												b.add(aux33.get(c));
											} 
											if(u != b.size()-1) {
												continue;
											}
										} 
										else {
											b=ToBifurcate(b.get(u),100.0,1.0);
										} 
										for(int c=0;c < b.size();c++) {
											String labelcurrent=String.valueOf(b.get(c).getLabel());
											for(int y=0;y< atomic.size();y++) {
												if(b.get(c).getExpression().equals(atomic.get(y).getExpression()) && b.get(c).isVerification() != atomic.get(y).isVerification()) {
													b.get(c).setCloses(true);
												}
											} 
											for(int y=0;y< current.getBifuArrayExp2().size();y++) {
												if(b.get(c).getExpression().equals(current.getBifuArrayExp2().get(y).getExpression()) && b.get(c).isVerification() != current.getBifuArrayExp1().get(y).isVerification()) {
													b.get(c).setCloses(true);
												}
											} 
											for(int y=0; y < b.size();y++) {
												String labelchecked=String.valueOf(b.get(y).getLabel());
												int finalPosChecked;
												if(labelchecked.length() < labelcurrent.length()) {
													finalPosChecked=labelchecked.length();
												}
												else {
													finalPosChecked=0;
												}
												if(labelcurrent.substring(0,finalPosChecked).equals(labelchecked))  {
													if(b.get(c).getExpression().equals(b.get(y).getExpression()) && b.get(c).isVerification() != b.get(y).isVerification()) {
														b.get(c).setCloses(true);
													}
												}
											}
										} 
										break;
									}
								} 
								if(current != null) { 
									//here, we will check if any of the expressions from any of the arraylists  have closed branches
									//if they do, we set the respetive break to true
									for(int u=0;u < current.getExp1().size();u++) {
										if(current.getExp1().get(u).getExpression().length() == 1 && current.getExp1().get(u).isCloses()) {
											breaker2=true; 
											break;
										} 
									} 
									for(int u=0;u < current.getExp2().size();u++) {
										if(current.getExp2().get(u).getExpression().length() == 1 && current.getExp2().get(u).isCloses()) {
											breaker3=true; 
											break;
										} 
									}
									//if both are closed, the answer is true so we can leave the loop
									if(breaker2 && breaker3) {
										break;
									}  
									//aqui se o ramo de a fechar(quando breaker2 e verdadeira),mas o ramo de b
									//ainda esta aberto(!breaker3),adicionamos os elementos de b para a lista de 
									//expressoes atomicas,pois trabalharemos agora em cima do ramo b
									if(breaker2 && !breaker3) {
										for(int u=0;u < b.size();u++) {
												atomic.add(b.get(u));
												atomicsize++; 
												break;
										}
									} 
									//aqui se o ramo de b fechar(quando breaker3 e verdadeira),mas o ramo de a
									//ainda esta aberto(!breaker2),adicionamos os elementos de a para a lista de 
									//expressoes atomicas,pois trabalharemos agora em cima do ramo a
									if(!breaker2 && breaker3) {
										for(int u=0;u < a.size();u++) {
												atomic.add(b.get(u));
												atomicsize++; 
												break;
										}
									} 
								}
							}
							//if both of them are true we set the answer to true
							if(breaker2 && breaker3) {
								answer=true;
								break;
							} 
							//if up until this point none have been closed that means that some are still open so the asnwer is false
							else {
								answer=false;
								break;
							}
						} 
					}
					else {
						//here we have a branch that covers all the possibilities after the first and the second
						boolean breaker=false; 
						int aux=p;
						for(int y=aux-(howmuch.length);y< aux;y++) {
							//here we have a for that checks every expression that was added in the previous iteration
							//and checks if they are a prolongation or not, if not they go into the bifurcation array, if yes
							//it does some operations on them
							Expression current=exps.get(y);
							if(current.isCloses()) {
								breaker=true;
								break;
							}
							//here it checks if the priority signal is a not or not
							if(current.getLowestSignal().equals("¬") == false) {
								//here it apply the rules of the tablo on the current expression
								Expression apply=r.appllyRule(current);
								//here it sees if its a bifurcation or not
								if(apply instanceof Bifurcation) {
									//if it was a bifurcation we will save it on an array so that we can work with them later,
									//so that we can do the prolongations first
									Bifurcation b=(Bifurcation) apply; 
									//first we create two auxiliar array lists to set as the expressions later
									//then we set the signal of the expression,then we remove the unaltered arraylist
									//and add the new one
									ArrayList<Expression> a=b.getExp1(); 
									ArrayList<Expression> aArray=new ArrayList<Expression>();
									b.setBifuArrayExp1(aArray); 
									aArray=b.getBifuArrayExp1();
									for(int u=0;u < a.size();u++) {
										if(a.get(u).getExpression().length() != 1) {
											Expression auxiliar=a.get(u);
											auxiliar=setSignal(auxiliar,j);  
											a.remove(u);
											a.add(auxiliar);
										} 
										else {
											aArray.add(a.get(u)); 
										}
									}
									ArrayList<Expression> c=b.getExp2();  
									ArrayList<Expression> cArray=new ArrayList<Expression>();
									b.setBifuArrayExp2(cArray);
									cArray=b.getBifuArrayExp2();
									for(int u=0;u < c.size();u++) {
										if(c.get(u).getExpression().length() != 1) {
											Expression auxiliar=c.get(u);
											auxiliar=setSignal(auxiliar,j);  
											c.remove(u);
											c.add(auxiliar);
										} 
										else {
											cArray.add(c.get(u)); 
										}
									}
									b.setExp1(a); 
									b.setBifuArrayExp1(aArray);
									b.setExp2(c);
									b.setBifuArrayExp2(cArray);
									later.add(b);
									bsize++;
								} 
								else {
									//here if its a prolongation we save the 2 expressions in 2 variables
									Prolongation q=(Prolongation) apply;
									Expression a=q.getExp1();
									Expression b=q.getExp2(); 
									///here we see if its  an atomic expression already
									if(a.getExpression().length() == 1) {
										atomic.add(a);
										atomicsize++;
										for(int i=0; i < atomicsize;i++) {
											//we cehck to see if there are any absurds(same expression different validation) if there are
											//we set the the close to the expression to true, and that will stop the tablo and make the answer true;
											if(a.getExpression().equals(atomic.get(i).getExpression()) && a.isVerification() != atomic.get(i).isVerification()) {
												a.setCloses(true); 
												break;
											}
										}
									} 
									//same thing here
									if(b.getExpression().length() == 1) {
										atomic.add(b); 
										atomicsize++; 
										for(int i=0; i < atomicsize;i++) {
											if(b.getExpression().equals(atomic.get(i).getExpression()) && b.isVerification() != atomic.get(i).isVerification()) {
												b.setCloses(true);
												break;
											}
										}
									}   
									if(a.getExpression().length() != 1) {
										a=setSignal(a,j);
										exps.add(a); 
									} 
									if(b.getExpression().length() != 1) {
										b=setSignal(b,j);  
										exps.add(b); 
									} 
									if(a.getExpression().length() == 1 || b.getExpression().length() == 1) {
										if(a.getExpression().length() == 1 && b.getExpression().length() != 1 || b.getExpression().length() == 1 && a.getExpression().length() != 1 ) {
											index=1;
										} 
										else { 
											index=0;
										}
									} 
									else {
										index=2; 
									}
									p +=index;
								}
							} 
							else {
								//here we just apply the rule for the not and check for any absurds
								//then add it up
								Expression apply=r.apllyRuleNot(current);
								if(apply.getExpression().length() == 1) {
									atomic.add(apply);
									atomicsize++;
									for(int i=0; i < atomicsize;i++) {
										if(apply.getExpression().equals(atomic.get(i).getExpression()) && apply.isVerification() != atomic.get(i).isVerification()) {
											apply.setCloses(true);
											break;
										}
									} 
								}  
								else {
									apply=setSignal(apply,j); 
									exps.add(apply);
									index=1; 
									p += index;
								}
							}
							//and since this an array of expressions we used the saver keeps adding up so that on the next
							//iteration it has the exact number of expressions we added
							saver += index;	
						}//here the breaker see if its true and sets the answer to true
						if(breaker == true) {
							answer=true;
							break;
						}
					}
				}
			}
			
		}
		if(answer == true) {
			System.out.println("sim a expressao e uma tautologia");
		}
		else {
			System.out.println("nao e a expressao nao e uma tautologia");
		}
	} 
	public static Expression setSignal(Expression e,int j) { 
		//aqui checamos se ha a parenteses no comeco e no final da expressao ex:(a ^ b),
		//pois como estes sao ignoraveis apenas o removemos da operacao 
		//we also have a j indicator to see if the expression, is the first iterator, cuz if it is
		//this process cannot be done, because all except the first one will have extra parenthesis
		if(e.getExpression().charAt(0) =='(' && e.getExpression().charAt(e.getExpression().length()-1) == ')' && j !=0) {
			String newword=""; 
			for(int i=1;i < e.getExpression().length()-1;i++) {
				String aux=Character.toString(e.getExpression().charAt(i)); 
				newword+=aux;
			} 
			e.setExpression(newword);
		}
		Stack s=new Stack();
		// the only case in which the ¬ is priority if its everything is inside a big
		//parenthesis and a ¬ comes before, so we check that case, if thats the case and it doesnt change while
		//we go though the rest of the expression,then the not is priority and it gets a especial treatment
		if(e.getExpression().charAt(0) == '¬' && s.isEmpty()) {
			e.setLowestSignal("¬");
		}
		String logicSymbols[]= {"^","v","->","<>","¬"};
		for(int i=0;i< e.getExpression().length();i++) {
			char letter=e.getExpression().charAt(i);
			//we add to the stack to see if it has a parenthesis or not
			s.push(letter);
			// here we have an aux because since the implica is more than one char we need to check all of the possibilities
			char aux=' ';
			//we make sure that its not possible to check the last one bcause an implica is not there
			if(i != e.getExpression().length()-1) {
				aux=e.getExpression().charAt(i+1);
			} 
			//we have 2 caucatenations of strings, one of one char and one 2 chars, to see if they correspond to a logic symbol
			String cau1=Character.toString(letter);
			String cau2=Character.toString(letter) + Character.toString(aux);
			//here we check if they belong to a logic symbol
			for(int h=0;h < logicSymbols.length-1;h++) {
				//here we check if it equals one of the logic symbols and if the stack is emprty,because
				//if the stack is empty that menas there are no parenthesis envolved, and that indicates the place of the priority symbol
				if(cau1.equals(logicSymbols[h]) && s.isEmpty() ||cau2.equals(logicSymbols[h]) && s.isEmpty()) {
					//since pos 0 and 1 are AND and OR the other are implica and dupla implica so we separate them here
					if(h > 1) { 
						if(h != 5) {
							//we also save their priority and beggining and end pos cuz it will be useful later
							e.setLowestSignal(logicSymbols[h]);  
							e.setSignalBPos(i);
							e.setSignalEPos(i+1); 
							e.setSignalPriority(2); 
						}
					}
					else {
						e.setLowestSignal(logicSymbols[h]); 
						e.setSignalBPos(i);
						e.setSignalEPos(e.getSignalBPos());
						e.setSignalPriority(1);
					}
				} 
				// the only case in which the ¬ is priority if its everything is inside a big
				//parenthesis and a ¬ comes before, so we check that case, if thats the case and it doesnt change while
				//we go though the rest of the expression,then the not is priority and it gets a especial treatment 
			}  
		} 
		return e;
	} 
	public static ArrayList<Expression> ToBifurcate(Expression e,double label,double multiplier) {
		Rules r=new Rules(); 
		ArrayList<Expression> array=new ArrayList<Expression>(); 
		e.setLabel(label);
		if(e.getLowestSignal().equals("¬") == false) {
			Expression apply=r.appllyRule(e); 
			if(apply instanceof Bifurcation) {
				Bifurcation x=(Bifurcation) apply;
				ArrayList<Expression> array1=x.getExp1(); 
				for(int i=0;i< array1.size();i++) {
					Expression a=array1.get(i); 
					a.setLabel(Math.round((e.getLabel()+0.1/multiplier) * 100.0) / 100.0);
					a=setSignal(a,111111);
					if(a.getExpression().length() != 1) {
						ArrayList<Expression> aux=new ArrayList<Expression>();
						aux=ToBifurcate(a,a.getLabel(),multiplier*10.0); 
						for(int g=0;g < aux.size();g++) {
							array.add(aux.get(g));
						}
					} 
					else {
						array.add(a);
					}
				}  
				ArrayList<Expression> array2=x.getExp2();
				for(int i=0;i< array2.size();i++) {
					Expression b=array2.get(i);   
					b=setSignal(b,11111);
					b.setLabel(Math.round(((e.getLabel()+1)+0.1/multiplier) * 100.0) / 100.0);
					if(b.getExpression().length() != 1) {
						ArrayList<Expression> aux=new ArrayList<Expression>();
						aux=ToBifurcate(b,b.getLabel(),multiplier * 10.0); 
						for(int g=0;g < aux.size();g++) {
							array.add(aux.get(g));
						}
					}
					else {
						array.add(b);
					}
				}
			}
			else {
				Prolongation x=(Prolongation) apply; 
				Expression a=x.getExp1();
				a.setLabel(e.getLabel());
				a=setSignal(a,111111);
				Expression b=x.getExp2(); 
				b=setSignal(b,1111); 
				b.setLabel(e.getLabel());
				if(a.getExpression().length() != 1) {
					ArrayList<Expression> aux=new ArrayList<Expression>();
					aux=ToBifurcate(a,a.getLabel(),multiplier); 
					for(int i=0;i < aux.size();i++) {
						array.add(aux.get(i));
					}
				} 
				else {
					array.add(a);
				} 
				if(b.getExpression().length() != 1) {
					ArrayList<Expression> aux=new ArrayList<Expression>();
					aux=ToBifurcate(b,b.getLabel(),multiplier ); 
					for(int i=0;i < aux.size();i++) {
						array.add(aux.get(i));
					}
				} 
				else {
					array.add(e);
				}
			}
		} 
		else {
			Expression apply=r.apllyRuleNot(e); 
			if(apply.getExpression().length() == 1) {
				array.add(apply);
			}
			else { 
				apply=setSignal(apply,323232);
				apply.setLabel(e.getLabel());
				ArrayList<Expression> aux=ToBifurcate(apply,apply.getLabel(),multiplier ); 
				for(int i=0;i < aux.size();i++) {
					array.add(aux.get(i));
				}
			}
			
		}
		return array;
	}
}
