
public class TheTool implements Ferramentas {

	@Override
	public Animal[] filtraEspecie(Animal[] completo, String especieFiltrar) {
		Animal[] a = null;
		int p=0; 
		for(int i=0;i < completo.length;i++) {
			if(especieFiltrar.equals(completo[i].getNomeEspecie())) {
					a[p]=completo[i]; 
					p++; 
			} 
		} 
		return a;
	}

	@Override
	public String[] classificaEspecies(Animal[] completo) { 
		String[] a=null;
		int p=0;
		for(int i=0;i < completo.length;i++) { 
			int counter=0;
			String specie=completo[i].getNomeEspecie();
			for(int j=0;j < a.length;j++) {
				if(a[j].equals(specie)) { 
					counter++;
				}
			} 
			if(counter == 0) { 
				a[p]=specie;
				p++;
			}
		} 
		return a;
	}

}
