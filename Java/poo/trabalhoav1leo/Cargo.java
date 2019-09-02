
public class Cargo {
	private String nome; 
	private double salario; 
	private String id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void status() { 
		System.out.print("nome do cargo:" + this.nome + " salario: " + this.salario + " id: " + this.id);
	}
}
