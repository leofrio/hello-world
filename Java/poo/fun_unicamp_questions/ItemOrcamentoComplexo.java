//question 2
public class ItemOrcamentoComplexo extends ItemOrcamento {
	ItemOrcamento[] it;

	public ItemOrcamentoComplexo(String historico, float valor, ItemOrcamento[] it) {
		super(historico, valor);
		this.it = it;
	} 
	public float getValor() {
		float sum=0;  
		for(int i=0;i < it.length;i++) {
			sum += it[i].getValor();
		}
		return sum;
	}  
	public ItemOrcamento encontraItem(String h) {
		ItemOrcamento item; 
		for(int i=0;i< it.length;i++) {
			if(h.equals(it[i].getHistorico())) {
				return it[i];
			}
		}
		return null;
	}
}
