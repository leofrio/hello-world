
package well;

public class Funcionario {
	private String nome; 
	private String cpf;
	private String email; 
	private String nascimento; 
	private Cargo cargo;
	private String  id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}  
	
	@Override
	public String toString() {
		return "Funcionario nome:" + nome + ", cpf:" + cpf + ", email:" + email + ", nascimento:" + nascimento
				+ ", cargo:" + cargo.getNome() + ", id:" + id;
	}
	
}
