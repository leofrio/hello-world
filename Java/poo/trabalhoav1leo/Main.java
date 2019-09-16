package well;

import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner let=new Scanner(System.in);
		Cargo[] c=new Cargo[100]; 
		Funcionario[] f=new Funcionario[100];   
		Setor[] s=new Setor[100]; 
		int u=0; 
		int h=0; 
		int z=0;
		int p=0;
		double sumtotal=0; 
		Funcionario test;
		
		for(int i=0;true;i++) { 
			System.out.println("escolha uma das opcoes abaixo"); 
			System.out.println("1-Cadastrar novos cargos ");
			System.out.println("2-Excluir cargos"); 
			System.out.println("3-Listar cargos registrados");
			System.out.println("4-Modificar cargos(alterar salario,alterar nome,alterar id)");
			System.out.println("5-Cadastrar funcionario"); 
			System.out.println("6-Excluir funcionario"); 
			System.out.println("7-Listar funcionarios");
			System.out.println("8-Editar functionario(alterar nome,cpf,email,data de nacimento ou cargo)");
			System.out.println("9-Criar setor");
			System.out.println("10-Excluir setor");
			System.out.println("11-Adicionar funcionario a setor"); 
			System.out.println("12-Listar setores");
			System.out.println("13-Total de uma folha salarial de um setor");
			System.out.println("14-Total da folha salarial da empresa"); 
			System.out.println("15-Sair"); 
			int choice=let.nextInt(); 
			if(choice == 1) { 
				System.out.println("digite o nome do cargo que deseja cadastrar");  
				Cargo t=new Cargo();
				String nomeCargo = let.next();
				
				t.setNome(nomeCargo);
				System.out.println("Digite o valor do salario");
				
				double salario=let.nextDouble(); 
				t.setSalario(salario); 
				
				System.out.println("Qual o id do cargo");
				String id=let.next();
				t.setId(id); 
				c[u]=t;
				u++; 
			} 
			if(choice == 2) {
				System.out.println("digite o nome do cargo que voce quer excluir"); 
				String cargoex=let.next();
				Cargo t=new Cargo(); 
				for(int j=0;j < u;j++) {  
					if(c[j] != null) {
						if(cargoex.equals(c[j].getNome())) { 
							c[j]=null; 
						}
					}
				}
			}
			if(choice == 3) { 
				for(int j =0 ;j < 100;j++) { 
					if(c[j] != null) { 
						c[j].status();
						System.out.println("");
					}
				}
			} 
			if(choice == 4) { 
				System.out.println("digite o nome do cargo que quer alterar");
				String cargoname=let.next();
				for(int j=0;j < u;j++) { 
					if(c[j] != null ) { 
						if(c[j].getNome().equals(cargoname)) { 
							System.out.println("digite o novo nome para o cargo desejado" );
							c[j].setNome(let.next());
							System.out.println("digite o novo salario do cargo desejado");
							c[j].setSalario(let.nextDouble());
							System.out.println("digite o novo id do cargo desejado");
							c[j].setId(let.next());
						}
					}
				}
			} 
			if(choice == 5) { 
				Funcionario t=new Funcionario(); 
				int counter=0;
				System.out.println("digite o nome do seu funcionario");
				t.setNome(let.next());
				System.out.println("digite o cpf do seu funcionario");
				t.setCpf(let.next());
				System.out.println("digite o email do seu funcionario");
				t.setEmail(let.next());
				System.out.println("digite sua data de nasicimento(faca no formato dd/mm/yyyy)"); 
				t.setNascimento(let.next());
				System.out.println("digite o id do seu funcionario");
				t.setId(let.next());
				System.out.println("digite o nome do cargo que seu funcionario esta presente");
				String cargoname=let.next(); 
				for(int j=0;j< u;j++) {
					if(c[j] != null) { 
						if(c[j].getNome().equals(cargoname)) { 
							t.setCargo(c[j]); 
							sumtotal += t.getCargo().getSalario();
							counter++;
						}
					} 
				} 
				if(counter == 0) { 
					t=null;
					System.out.println("cargo nao existe,cadastre funcionario denovo");
				}
				f[h]=t;
				h++;
			} 
			if(choice == 6) {
				System.out.println("digite o nome do funcionario que deseja demitir");
				String fname=let.next();
				for(int j=0;j < h;j++) { 
					if(f[j] != null) {
						if(f[j].getNome().equals(fname)) { 
							sumtotal -= f[j].getCargo().getSalario();  
							if(f[j].getSetorname().equals(null)) { 
							
							} 
							else {
								
								for(int y=0;y < z;y++) { 
									if(s[y] != null) { 
										
										for(int d=0;d < p;d++) {
											if(s[y].func[p] != null) {
												if(s[y].func[d].getNome().equals(fname)) { 
													s[y].setSumsetor(s[y].getSumsetor() - f[j].getCargo().getSalario());  
													test=s[y].func[p];
													s[y].func[p].setNome(null);
													s[y].func[p]=null; 
												}
											}
										}
									}
								}
							} 
							f[j]=null; 
						} 
					}
				}
			} 
			if(choice == 7) { 
				for(int j =0;j < h;j++) { 
					if(f[j] != null) { 
						System.out.println(f[j]); 
						System.out.println("");
					}
				}
			} 
			if(choice == 8) { 
				System.out.println("digite o nome do funcionario que deseja alterar"); 
				String fname=let.next();
				int counter=0; 
				int saver;
				for(int j=0;j< h;j++) { 
					if(f[j] != null) { 
						if(f[j].getNome().equals(fname)) {
							saver=j;
							Funcionario t=new Funcionario();
							t.setNome(f[j].getNome()); 
							t.setCpf(f[j].getCpf()); 
							t.setEmail(f[j].getEmail()); 
							t.setNascimento(f[j].getNascimento()); 
							t.setCargo(f[j].getCargo()); 
							t.setId(f[j].getId()); 
							f[j].setCargo(null);
							System.out.println("digite o novo nome do seu funcionario");
							f[j].setNome(let.next());
							System.out.println("digite o novo  cpf do seu funcionario");
							f[j].setCpf(let.next());
							System.out.println("digite o novo email do seu funcionario");
							f[j].setEmail(let.next());
							System.out.println("digite a nova data de nasicimento(faca no formato dd/mm/yyyy)"); 
							f[j].setNascimento(let.next());
							System.out.println("digite o novo id do seu funcionario");
							f[j].setId(let.next()); 
							System.out.println("digite o novo cargo de seu functionario"); 
							String cargoname=let.next();
							for(int g=0;g< u;g++) {
								if(c[g] != null) { 
									if(c[g].getNome().equals(cargoname)) { 
										f[j].setCargo(c[g]); 
										counter++;
									}
								} 
							} 
							if(counter == 0) { 
								f[saver]=t;
								System.out.println("cargo nao existe,altere funcionario denovo");
							}
						} 
					}
				}
			} 
			if(choice == 9) { 
				Setor t=new Setor();
				System.out.println("digite o nome do setor que deseja criar "); 
				t.setNome(let.next());  
				s[z]=t; 
				z++;
			} 
			if(choice == 10) { 
				System.out.println("qual o nome do setor que voce deseja excluir"); 
				String sname=let.next();
				for(int j=0; j < z;j++) {
					if(s[j].getNome().equals(sname)) { 
						s[j]=null;
					}
				} 
			} 
			if(choice == 11) { 
				System.out.println("qual o nome do funcionario que voce deseja adicionar a um setor?");
				String fname=let.next(); 
				for(int j=0;j < h;j++) {
					if(f[j] != null) {
						if(f[j].getNome().equals(fname)) {
							System.out.println("qual o nome do setor que voce deseja adicionar o funcionario " + fname);
							String sname=let.next(); 
							for(int y=0;y < z;y++) { 
								if(s[y].getNome().equals(sname)) {  
									f[j].setSetorname(sname);;
									s[y].func[p]=f[j];
									s[y].setSumsetor(s[y].getSumsetor() + f[j].getCargo().getSalario());
									p++;
								}
							}
						}
					}
				}
			} 
			if(choice == 12) { 
				for(int j=0;j < z;j++) {
					if(s[j] != null) {
						System.out.println("setor: " + s[j].getNome()); 
						for(int y=0;y< p;y++) { 
							if(s[j].func[y].getNome().equals(null)) {
								System.out.println(s[j].func[y]);
							}
							else {
								System.out.println(s[j].func[y]);
							}
						}
					}
				}
			}
			if(choice == 13) { 
				System.out.println("escolha um setor para ver a folha salarial");
				String sname=let.next();
				for(int j=0;j < z;j++) {
					if(s[j] != null) { 
						if(s[j].getNome().equals(sname)) {
							System.out.println(" a folha salarial do setor " + sname + " e igual a " + s[j].getSumsetor() + "R$");
						}
					}
				}
			} 
			if(choice == 14) { 
				System.out.println("a folha salarial da empresa e igual a " + sumtotal + "R$");
			}
			if(choice == 15) { 
				
				System.out.println("voce saiu do programa");
				break;
			} 
			
		}

	}

}
