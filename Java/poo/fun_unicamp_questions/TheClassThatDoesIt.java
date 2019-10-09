
public class TheClassThatDoesIt {
	public Resultado[] mainMethod(Theanimal[] A,TheTool t) {
		Resultado[] r=null;  
		int p=0;
		for(int i=0;i < A.length;i++) { 
			String species=A[i].getNomeEspecie(); 
			int amount=0;  
			for(int j=0;j < A.length;j++) {
				if(A[j].getNomeEspecie().equals(species) ) { 
					amount++;
				}
			}
			Resultado raux=new Resultado(species,amount); 
			int counter=0;
			for(int j=0; j < r.length;j++) {
				if(r[j].getNomeEspecie().equals(species)) {
					counter++;
				}
			} 
			if(counter == 0) {
				r[p]=raux;
				p++; 
			}
		}
		return r; 
	}
}
