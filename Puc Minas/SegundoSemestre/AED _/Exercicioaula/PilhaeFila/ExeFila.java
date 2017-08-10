class ExeFila {

	private Pilha p_entrada,p_saida;

	public ExeFila ( ){
		p_entrada = new Pilha ( );
		p_saida = new Pilha ( );
	}

	public ExeFila (int tamanho){
		p_entrada = new Pilha (tamanho);
		p_saida = new Pilha (tamanho);
	}

	public void inserir (int x) throws Exception {
		p_entrada.inserir(x);
	}

	public int removerF ( ) throws Esception {
		int removido = 0;
		int resp = 0;
		while ( p_entrada.isVazia( ) == false ){
			removido = p_entrada.remover( );
			p_saida.inserir(removido);
		}
		resp = p_saida.remover( );
		return resp;
	}

	public static void main ( String [ ] args ){
		ExeFila f = new ExeFila (5);
		try{
		f.inserir(1);
		f.inserir(2);
		f.inserir(3);
		f.inserir(4);
		MyIO.println( f.removerF( ) );
		}catch ( Exception es ){
			MyIO.println("Erro");
		}
	}
}

