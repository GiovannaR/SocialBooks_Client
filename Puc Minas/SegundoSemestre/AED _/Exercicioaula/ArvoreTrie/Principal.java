class Principal {
	public static void main (String[] args) throws Exception {
		ArvoreTrie arv = new ArvoreTrie( );
		ArvoreTrie arvore = new ArvoreTrie( );

		String array[] = new String[2];
		array[0] = "ABACAXI";
		array[1] = "BALA";

		String palavras[] = new String[2];
		palavras[0] = "NOME";
		palavras[1] = "ANA";

		for(int i = 0; i < array.length; i++){
			arv.inserir(array[i]);
		}

		for(int i = 0; i < array.length; i++){
			arvore.inserir(palavras[i]);
		}
		
		ArvoreTrie resp = ArvoreTrie.merge(arv, arvore);
		resp.mostrar( );
	}
}
