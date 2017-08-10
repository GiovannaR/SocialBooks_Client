class ArvoreFila{

	public static void main ( String [ ] args ) throws Exception{
		ArvoreBinaria arvore = new ArvoreBinaria ( );
		arvore.inserir(6);
		arvore.inserir(4);
		arvore.inserir(8);
		arvore.inserir(3);
        	arvore.inserir(5);
        	arvore.inserir(7);
		arvore.inserir(9);

		Celula primeiro = arvore.ToFila (arvore.raiz);

		ArvoreBinaria.mostrarFila(primeiro); 
	}
}
