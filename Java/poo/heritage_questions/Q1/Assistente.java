
public abstract class Assistente extends Funcionario {
	protected String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	} 
	public void exibeDados() {
		System.out.println("o assistente tem nome de: " + name);
		System.out.println("o sistente tem salario igual a " + salary) ;
		System.out.println("o asistente tem um cpf de: " + cpf);
		System.out.println("o assistente tem um numero de matricula de: " + this.matricula);
	}
}
