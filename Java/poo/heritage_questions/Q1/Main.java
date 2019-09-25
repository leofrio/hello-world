
public class Main {

	public static void main(String[] args) {
		Tecnico t =new Tecnico(3000,300); 
		t.cpf="232.234.432-53";
		t.matricula="1123123";
		t.name="araujo";
		Adiministrativo a=new Adiministrativo(3000,554);
		a.cpf="235.645.656-78"; 
		a.matricula="3232323";
		a.name="arnaldo";
		t.exibeDados(); 
		System.out.println("");
		System.out.println("");
		a.exibeDados();

	}

}
