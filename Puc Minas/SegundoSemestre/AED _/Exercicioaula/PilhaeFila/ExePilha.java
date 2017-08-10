class ExePilha {
	private Fila f_entrada, f_saida;

	public ExePilha ( ){
		f_entrada = new Fila ( );
		f_saida = new Fila ( );
	}

	public ExePilha (int tamanho0, int tamanho1 ){
		this.f_entrada = new Fila (tamanho0);
		this.f_saida = new Fila (tamanho1);
	}

	public void inserire (int x) throws Exception{
		f_entrada.inserir(x);
	}

	public int remover1 ( )throws Exception {
		int i = 0;
		int removido = 0;
		int removido2 = 0;
		while ( f_entrada.isVazia( ) == false ){
			removido = f_entrada.remover( );
			f_saida.inserir(removido);
			i++;
		}
		while ( i - 1 > 0 ){
			removido2 = f_saida.remover( );
			f_entrada.inserir(removido2);
			i--;
		}
		return f_saida.remover( );
	}
 
	public static void main ( String [ ] args ){
		ExePilha f = new ExePilha (5,5);
		try{		
		f.inserire(1);
		f.inserire(2);
		f.inserire(3);
		f.inserire(4);
		MyIO.println( f.remover1( ) );
		}catch( Exception ex ){
			MyIO.println("Eroo!");
		}
				
	}	

	
}
