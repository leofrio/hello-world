import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {

	public static void main(String[] args) throws IOException {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);
		long begin=System.currentTimeMillis();
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			FileReader fileReader = new FileReader(selectedFile);
			BufferedReader reader=new BufferedReader(fileReader);  
			String line = reader.readLine();
			ArrayList<String[]> values=new ArrayList<String[]>();
			for(int i=0;line != null;i++) {  
				if(i != 0) { 
					String svalues[]=line.split(" "); 
					values.add(svalues); 
				} 
				line = reader.readLine();
			}
			Scanner let= new Scanner(System.in);  
			while(true) {
				System.out.println("oque voce deseja fazer?0-para sair"); 
				System.out.println("1-escolher um fornecedor e ver seu contrato com valor mais barato"); 
				System.out.println("2-ver o contrato com valor mais barato do mercado");   
				System.out.println("3-ver qual contrato tem o menor valor referente ao mes 1 ate o mes n"); 
				System.out.println("4-ver quais contratos de energia devem ser contratados para os proximos n meses");
				int choice =let.nextInt(); 
				if(choice == 0) { 
					break; 
				} else if(choice == 1) {
					System.out.println("digite o do numero do fornecedor a checar os contratos"); 
					int f=let.nextInt(); 
					String[] contract=FornecedorContrato(f,values);  
					if(contract != null) {
						int bMonth=Integer.valueOf(contract[1]); 
						int eMonth=Integer.valueOf(contract[2]); 
						double value=Double.valueOf(contract[3]);
						System.out.println("o contrato de menor valor do fornecedor " + f + " e o que vai do mes " + bMonth +  
								" ate o mes " + eMonth + " com o valor de " + value);
					} 
					else { 
						System.out.println("este forncedor nao existe ");
					}
				} else if(choice == 2 ) { 
					String[] contract=contratoMenorValor(values);  
					if(contract != null) { 
						int fornecedor=Integer.valueOf(contract[0]);
						int bMonth=Integer.valueOf(contract[1]); 
						int eMonth=Integer.valueOf(contract[2]); 
						double value=Double.valueOf(contract[3]);
						System.out.println("o contrato de menor valor  e do fornecedor " + fornecedor + " e o que vai do mes " + bMonth +  
								" ate o mes " + eMonth + " com o valor de " + value);
					} 
					else { 
						System.out.println("nao ha dados");
					}
				} else if(choice == 3) { 
					System.out.println("digite o do numero do numero n de meses que sera comparado o melhor contrato"); 
					int n=let.nextInt(); 
					ArrayList<String[]> contracts=mesesContratoEficiente(n,values);  
					if(contracts != null) {  
						if(contracts.size() == 1) {
							int fornecedor=Integer.valueOf(contracts.get(0)[0]);
							int bMonth=Integer.valueOf(contracts.get(0)[1]); 
							int eMonth=Integer.valueOf(contracts.get(0)[2]); 
							double value=Double.valueOf(contracts.get(0)[3]);
							System.out.println("o contrato de menor valor e o do " + fornecedor + " e o que vai do mes " + bMonth +  
									" ate o mes " + eMonth + " com o valor de " + value); 
						} 
						else { 
							System.out.println("os contratos de melhor rendimento para do mes 1 ao mes n sao: "); 
							for(int i=0; i< contracts.size();i++) { 
								int fornecedor=Integer.valueOf(contracts.get(i)[0]);
								int bMonth=Integer.valueOf(contracts.get(i)[1]); 
								int eMonth=Integer.valueOf(contracts.get(i)[2]); 
								double value=Double.valueOf(contracts.get(i)[3]); 
								System.out.println("o contrato do fornecedor " + fornecedor + " que vai do mes " +  bMonth + " ao mes " + eMonth + " de valor " + value +"R$");
							}
						}
					} 
					else { 
						System.out.println("nao ha contratos para o tempo colocado");
					}
				} else if(choice == 4) { 
					System.out.println("digite o do numero n de proximos meses que serao mostrado os melhores contratos a partir do mes atual"); 
					int n=let.nextInt(); 
					ArrayList<String[]> contracts=nContratosEficiente(n,values);  
					if(contracts != null) {  
						if(contracts.size() == 1) {
							int fornecedor=Integer.valueOf(contracts.get(0)[0]);
							int bMonth=Integer.valueOf(contracts.get(0)[1]); 
							int eMonth=Integer.valueOf(contracts.get(0)[2]); 
							double value=Double.valueOf(contracts.get(0)[3]);
							System.out.println("o contrato de menor valor e o do fornecedor " + fornecedor + " e o que vai do mes " + bMonth +  
									" ate o mes " + eMonth + " com o valor de " + value); 
						} 
						else { 
							System.out.println("os contratos de melhor rendimento para do mes atual ao mes n sao: "); 
							for(int i=0; i< contracts.size();i++) { 
								int fornecedor=Integer.valueOf(contracts.get(i)[0]);
								int bMonth=Integer.valueOf(contracts.get(i)[1]); 
								int eMonth=Integer.valueOf(contracts.get(i)[2]); 
								double value=Double.valueOf(contracts.get(i)[3]); 
								System.out.println("o contrato do fornecedor " + fornecedor + " que vai do mes " +  bMonth + " ao mes " + eMonth + " de valor " + value +"R$");
							}
						}
					} 
					else { 
						System.out.println("nao ha contratos para o periodo colocado");
					}
				}
			}
		} 
	}
	public static String[] FornecedorContrato(int f,ArrayList<String[]> values) { 
		double currentValue;	 
		boolean exists=false;
		String[] smallestContract =values.get(0);
		for(int i=0; i < values.size();i++) {  
			if(values.get(i)[0].equals(Integer.toString(f))) { 
				if(!exists) { 
					smallestContract=values.get(i);
					exists=true;
				} 
				currentValue=Double.valueOf(values.get(i)[3]);
				if(currentValue  < Double.valueOf(smallestContract[3])) { 
					smallestContract=values.get(i); 
				} 
			}
		}  
		if(exists) {
			return smallestContract; 
		}
		else { 
			return null;
		}
	}
	public static String[] contratoMenorValor(ArrayList<String[]> values) { 
		double currentValue;	 
		String[] smallestContract =values.get(0);
		for(int i=0; i < values.size();i++) {   
			currentValue=Double.valueOf(values.get(i)[3]);
			if(currentValue  < Double.valueOf(smallestContract[3])) { 
				smallestContract=values.get(i); 
			} 
		}  
		if(values.size() != 0) {
			return smallestContract; 
		} 
		else {
			return null;
		}
	}
	/* neste metodo temos um que vai pegar todas as fomras mais eficientes de calcular os 
	 * contratos mais eficientes de 1 ate n primeira mente guardamos o mes inicla que e 1 
	 * depois guardamos o mes final que sera fornecido pelo o usuario 
	 * primeiramente no primeiro for vemos se ja existe um ja pronto, por exemplo se colocarmos 
	 * 3 ja tiver um pronto que mostra 1 para 3 ai ja pegamos esse 
	 * por isso checamos se o finalsolutions esta vazio dps pq esse caso que seria os contratos que ja tem tudo pronto 
	 * se haver apenas fazemos um calculo para ver qual destes tem o menor valor, e dps jogamos a um arraylist e depois  
	 * retornamos o arraylsit com apenas um contrato mais barato 
	 * se esse n for o caso iremos retornar mais de um contrato entramos no else onde o finalsolutions nao esta vazio
	 * logo de cara temos 3 variaveis: numberOfContracts que guardara os contratos que serao os resultaods, aqueles mais eficientes,
	 * temporaryContracts que guardara todos os contratos que no momento contem o mesmo comeco de mes que esta igual o currentmonthindex
	 * ou seja o mes que atualmente estamos percorrendo, e tb temos a variavel booleana samone que basicamente diz se o numero que passou e um 
	 * duplo por exemplo 1 3 3 120.0 , pois como no final o currentmonthindex se iguala ao mes final do contrato mais eficiente se o contrato for
	 * desse tipo e necessario que aumente 1 para que comecarmos a percorrer a partir do proximo mes, logo dps temos um loop que diz que enquanto o 
	 * currentmothindex for menor igual ao mes inserido pelo o usuario ele continuarar rodando, fazemos isso porque queremos percorrer todos os contratos
	 * que podem fazer se agrupados de 1 ate n 
	 * */
	public static ArrayList<String[]> mesesContratoEficiente(int n,ArrayList<String[]> values) {  
		int currentMonthIndex=1; 
		int finalMonthIndex=n;
		ArrayList<String[]> finalSolutions=new ArrayList<String[]>(); 
		for(int i=0;i < values.size();i++) { 
			if(values.get(i)[1].equals("1") && values.get(i)[2].equals(Integer.toString(n))) {
				finalSolutions.add(values.get(i));
			}
		} 
		if(!finalSolutions.isEmpty()) { 
			double currentValue;	 
			String[] smallestContract =finalSolutions.get(0);
			for(int i=0; i < finalSolutions.size();i++) {   
				currentValue=Double.valueOf(finalSolutions.get(i)[3]);
				if(currentValue  < Double.valueOf(smallestContract[3])) { 
					smallestContract=finalSolutions.get(i); 
				} 
			} 
			ArrayList<String[]> numberOfContracts=new ArrayList<String[]>(); 
			numberOfContracts.add(smallestContract);
			return numberOfContracts;
		} 
		else { 
			ArrayList<String[]> numberOfContracts=new ArrayList<String[]>();  
			ArrayList<String[]> temporaryContracts=new ArrayList<String[]>();
			boolean sameone=false;
			while(currentMonthIndex <= finalMonthIndex) {  
				//aqui fazemos com que o month index for igual e n for duplo ele termine, pois ja chegou ao final
				if(currentMonthIndex == finalMonthIndex && !sameone) { 
					break;
				}
				//aqui pegamos todos os contratos que estao no currentmonthindex ou seja no mes que estamos atualmente percorrendo
				//quando digo percorrendo quero dizer, se fomos de um mes 1 3 agora estamos no current month index 3, ee por isso 
				// vamos pegar todos que comecam do 3 para podermos gerar assim o proximo contrato para o mes que desejamos
				for(int i=0;i< values.size();i++) { 
					if(Integer.valueOf(values.get(i)[1]) == currentMonthIndex) { 
						temporaryContracts.add(values.get(i)); 
					} 
				}  
				//se nao houber nenhum e impossivel trazer os contratos por isso retornamos null
				if(temporaryContracts.isEmpty()) { 
					return null;
				}  
				double[] realValues=new double[temporaryContracts.size()]; 
				//neste loop basicamentes guardamos os reais valores de cada um dos contratos 
				//fazemos isso pegando a diferenca do mes final e o mes inicial do contrato 
				//dividindo o valor que ele tem por essa diferenca, assim conseguimos o valor real 
				//a diferenca for 0 apenas guardamos o valor normal
				for(int i=0;i < temporaryContracts.size();i++) { 
					int bmonth= Integer.valueOf(temporaryContracts.get(i)[1]);
					int emonth =Integer.valueOf(temporaryContracts.get(i)[2]); 
					double value=Double.valueOf(temporaryContracts.get(i)[3]); 
					double realValue;
					int difference= emonth - bmonth;  
					if(difference != 0) { 
						realValue=value/difference;
					} 
					else { 
						realValue=value; 
					} 
					realValues[i]=realValue; 
				}  
				double smallestValue=realValues[0];
				int pos=0;
				sameone=false;
				//aqui pegamos o menor valor real desses para saber qual o contrato mais eficiente para um periodo de mes x 
				for(int i=0; i < realValues.length;i++) { 
					if(realValues[i] < smallestValue) { 
						smallestValue=realValues[i]; 
						pos=i;
					}
				}   
				//aqui verificamos se e um mes duplo(ex: 1 1 1 30.0) ou nao 
				//dentro disso adicionamos o contrato optimizado ao array list de contratos e dps igualamos 
				//o currentmonthindex com o mes final do contrato optimizado,qnd o mes e duplo adicionamos mais 1 
				//para ele pode ir ao proximo, 
				if(temporaryContracts.get(pos)[1].equals(temporaryContracts.get(pos)[2])) { 
					numberOfContracts.add(temporaryContracts.get(pos));  
					currentMonthIndex= Integer.valueOf(temporaryContracts.get(pos)[2]) +1; 
					temporaryContracts.clear();  
					sameone=true;
				} 
				else  { 
					if(currentMonthIndex == finalMonthIndex) {
						break;
					}
					numberOfContracts.add(temporaryContracts.get(pos));  
					currentMonthIndex= Integer.valueOf(temporaryContracts.get(pos)[2]); 
					temporaryContracts.clear(); 
				}
			} 
			//aqui termina o loop e retornamos o arraylist com os contratos optimizados para o periodo x de contratos
			return numberOfContracts;
		}
	} 
	/*no segundo metodo e muito parecido com o rpimeiro e que fazemos uma matematica com o k para podermos ter meses que passam do ano
	 * por exemplo vai do mes 11 ao mes 2 precisamos tratar isso , ent dizemos que somamos o mes inicial com o final e tiramos 12 caso o mes
	 * final seja maior que o inicial assim conseguimos  a verdadeira diferenca, tb n temos o finalsolution pois neste caso ele nuna vai mostrar apenas 
	 *um contrato ,,usamos o k para que o currentmonth possa ir de ele ate ele mesmo por exemplo de 3 de um ano para o 3 do proximo, por isso 
	 *antes do proximo loop comecar e mudado o k para 0 para voltar ao normal, assim fazemos com que ele possa ir ate ele mesmo o resto e basicamente igaul ao metodo passado
	 * */
	public static ArrayList<String[]> nContratosEficiente(int n,ArrayList<String[]> values) {   
		//seconddddddddddddddddddddddddddddddddddddddddddddddddddd 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String[] wholeDateTime=dtf.format(now).split(" "); 
		String[] wholeDate=wholeDateTime[0].split("/"); 
		int month=Integer.valueOf(wholeDate[1]);
		int currentMonthIndex=month; 
		int amountOfMonths=n;  
		int sum= month + n;
		if(sum > 12) { 
			sum -= 12;
		} 
		ArrayList<String[]> numberOfContracts=new ArrayList<String[]>();  
		ArrayList<String[]> temporaryContracts=new ArrayList<String[]>(); 
		int k=1;
		if(sum == 12) { 
			k=-11;
		}
		while(currentMonthIndex != sum + k) { 
			if(k != 0) { 
				k=0;
			}
			for(int i=0;i< values.size();i++) { 
				if(Integer.valueOf(values.get(i)[1]) == currentMonthIndex) { 
					temporaryContracts.add(values.get(i)); 
				} 
			} 
			if(temporaryContracts.isEmpty()) { 
				return null;
			}  
			double[] realValues=new double[temporaryContracts.size()]; 
			for(int i=0;i < temporaryContracts.size();i++) { 
				int bmonth= Integer.valueOf(temporaryContracts.get(i)[1]);
				int emonth =Integer.valueOf(temporaryContracts.get(i)[2]); 
				double value=Double.valueOf(temporaryContracts.get(i)[3]); 
				double realValue;
				int difference= 0; 
				if(emonth > bmonth) { 
					difference=emonth -bmonth;
				} 
				else  {
					difference=(emonth+bmonth)-12;
				}

				if(difference != 0) { 
					realValue=value/difference;
				} 
				else { 
					realValue=value; 
				} 
				realValues[i]=realValue; 
			}  
			double smallestValue=realValues[0];
			int pos=0;
			for(int i=0; i < realValues.length;i++) { 
				if(realValues[i] < smallestValue) { 
					smallestValue=realValues[i]; 
					pos=i;
				}
			}   

			if(temporaryContracts.get(pos)[1].equals(temporaryContracts.get(pos)[2])) { 
				numberOfContracts.add(temporaryContracts.get(pos));  
				currentMonthIndex= Integer.valueOf(temporaryContracts.get(pos)[2]) +1; 
				temporaryContracts.clear();  
			} 
			else  { 
				numberOfContracts.add(temporaryContracts.get(pos));  
				currentMonthIndex= Integer.valueOf(temporaryContracts.get(pos)[2]); 
				temporaryContracts.clear(); 
			}
		} 
		return numberOfContracts;
	}
} 

