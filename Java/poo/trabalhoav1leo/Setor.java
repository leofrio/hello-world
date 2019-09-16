package well;

public class Setor {
	private String nome;
	private int qtdfunc; 
	public Funcionario[] func=new Funcionario[100];
	private double sumsetor=0;
	
	
	
	public double getSumsetor() {
		return sumsetor;
	}
	public void setSumsetor(double sumsetor) {
		this.sumsetor = sumsetor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdfunc() {
		return qtdfunc;
	}
	public void setQtdfunc(int qtdfunc) {
		this.qtdfunc = qtdfunc;
	} 
	
	
}
