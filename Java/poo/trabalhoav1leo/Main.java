import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner let=new Scanner(System.in);
		Cargo[] c=new Cargo[100]; 
		Funcionario[] f=new Funcionario[100];  
		for(int i=0;i < 100;i++) { 
			c[i]=new Cargo(); 
			f[i]=new Funcionario(); 
		} 
		int u=0;
		for(int i=0;true;i++) { 
			System.out.println("escolha uma das opcoes abaixo"); 
			System.out.println("1-Cadastrar novos cargos ");
			System.out.println("2-Excluir cargos"); 
			System.out.println("3-Listar cargos registrados");
			System.out.println("4-Modificar cargos(alterar salario,alterar nome)");
			System.out.println("5-Cadastrar funcionario"); 
			System.out.println("6-Excluir funcionario"); 
			System.out.println("7-Listar funcionarios");
			System.out.println("8-Editar functionario(alterar nome,cpf,email,data de nacimento ou cargo)");
			System.out.println("9-Criar setor");
			System.out.println("10-Excluir setor");
			System.out.println("11-Listar setores");
			System.out.println("12-Adicionar funcionario a setor");
			System.out.println("13-Total de uma folha salarial de um setor");
			System.out.println("14-Total da folha salarial da empresa"); 
			System.out.println("15-Sair"); 
			int choice=let.nextInt(); 
			if(choice == 1) { 
				System.out.println("digite o nome do cargo que deseja cadastrar"); 
				String nomeCargo = let.next();
				
				c[u].setNome(nomeCargo);
				System.out.println("Digite o valor do salario");
				
				double salario=let.nextDouble();
				c[u].setSalario(salario); 
				
				System.out.println("Qual o id do cargo");
				String id=let.next();
				c[u].setId(id); 
				u++;
				
			} 
			if(choice == 2) {
				System.out.println("digite o nome do cargo que voce quer excluir"); 
				String cargoex=let.next();
				for(int j=0;j <100;j++) { 
					if(cargoex.equals(c[j].getNome())) { 
						c[j]=null;
					}
				}
			}
			if(choice == 3) { 
				for(int j =0 ;j < 100;j++) { 
					if(c[j].getId() != null) { 
						System.out.println("nome do cargo:" + c[j].getNome()  + " salario: " + c[j].getSalario() + " id: " + c[j].getId());
						System.out.println("");
					}
				}
			}
			if(choice == 15) { 
				
				System.out.println("voce saiu do programa");
				break;
			}
		}

	}

}
