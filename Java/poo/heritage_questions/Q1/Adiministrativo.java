
public class Adiministrativo extends Assistente{
	private String turno;
	private double noturno;
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public double getNoturno() {
		return noturno;
	}
	public void setNoturno(double noturno) {
		this.noturno = noturno;
	}
	
	public void exibeDados() {
		System.out.println("o assistente tem nome de: " + name);
		System.out.println("o sistente tem salario igual a " + salary) ;
		System.out.println("o asistente tem um cpf de: " + cpf);
		System.out.println("o assistente tem um numero de matricula de: " + this.matricula); 
		System.out.println("o assistente tem um turno de " + turno);
	}
	public Adiministrativo(double salary,double noturno) {
		this.noturno = noturno; 
		this.salary=salary;
		this.salary += noturno;
	} 
	
	
}
